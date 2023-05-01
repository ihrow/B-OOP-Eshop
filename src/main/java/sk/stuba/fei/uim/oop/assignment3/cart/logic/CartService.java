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

    @Override
    public Cart createCart() {
        return this.cartRepository.save(new Cart());
    }
}
