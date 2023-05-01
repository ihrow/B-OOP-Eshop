package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;

    // ============================
    @Override
    public List<Cart> getAllCarts() {
        return this.cartRepository.findAll();
    }
    // ============================

    @Override
    public Cart createCart() {
        return this.cartRepository.save(new Cart());
    }

    @Override
    public Cart getCartById(Long id) {
        return this.cartRepository.findCartById(id);
    }

    @Override
    public void deleteCartById(Long id) {
        this.cartRepository.deleteById(id);
    }


}
