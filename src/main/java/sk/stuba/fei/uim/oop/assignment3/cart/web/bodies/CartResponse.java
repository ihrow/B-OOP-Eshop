package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;

@Getter
public class CartResponse {
    private final Long id;
    private final boolean payed;

    public CartResponse(Cart c) {
        this.id = c.getId();
        this.payed = c.isPayed();
    }
}
