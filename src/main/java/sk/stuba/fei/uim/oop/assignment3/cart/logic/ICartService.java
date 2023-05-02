package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartEntryRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

public interface ICartService {
    Cart createCart();
    Cart getCartById(Long id) throws NotFoundException;
    void deleteCartById(Long id) throws NotFoundException;
    double payForCart(Long id) throws NotFoundException, IllegalOperationException;
    Cart addItemToCart(Long cartId, CartEntryRequest cartEntry) throws NotFoundException, IllegalOperationException;
}
