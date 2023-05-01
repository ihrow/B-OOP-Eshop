package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;

import java.util.List;

public interface ICartService {
    List<Cart> getAllCarts();
    Cart createCart();
    Cart getCartById(Long id);
    void deleteCartById(Long id);
}
