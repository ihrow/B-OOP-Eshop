package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;

public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;


}
