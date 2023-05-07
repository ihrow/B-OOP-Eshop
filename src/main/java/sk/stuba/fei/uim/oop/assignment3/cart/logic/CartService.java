package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartEntry;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartEntryRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;

import java.util.Objects;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private IProductService productService;

    @Override
    public Cart createCart(){
        return this.cartRepository.save(new Cart());
    }

    @Override
    public Cart getCartById(Long id) throws NotFoundException {
        Cart c = this.cartRepository.findCartById(id);
        if (c == null) {
            throw new NotFoundException();
        }
        return c;
    }

    @Override
    public void deleteCartById(Long id) throws NotFoundException {
        Cart c = this.getCartById(id);
        this.cartRepository.delete(c);
    }

    @Override
    public double payForCart(Long id) throws NotFoundException, IllegalOperationException {
        Cart c = this.getCartById(id);
        if (c.isPayed()) {
            throw new IllegalOperationException();
        }
        c.setPayed(true);
        this.cartRepository.save(c);

        double totalPrice = 0;
        for (CartEntry entry : c.getShoppingList()) {
            Product p = this.productService.getProductById(entry.getProductId());
            totalPrice += p.getPrice() * entry.getAmount();
        }
        return totalPrice;
    }

    @Override
    public Cart addItemToCart(Long cartId, CartEntryRequest entry) throws NotFoundException, IllegalOperationException {
        Cart c = this.getCartById(cartId);
        if (c.isPayed()) {
            throw new IllegalOperationException();
        }
        Product p = this.productService.getProductById(entry.getProductId());
        if (p == null) {
            throw new NotFoundException();
        }
        int amountToAdd = entry.getAmount();
        if (amountToAdd < 1 || amountToAdd > p.getAmount()) {
            throw new IllegalOperationException();
        }
        this.productService.decreaseProductAmount(p, amountToAdd);

        for (CartEntry e : c.getShoppingList()) {
            if (Objects.equals(e.getProductId(), entry.getProductId())) {
                e.setAmount(e.getAmount() + amountToAdd);
                return this.cartRepository.save(c);
            }
        }
        c.getShoppingList().add(new CartEntry(entry));

        return this.cartRepository.save(c);
    }


}
