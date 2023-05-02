package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CartResponse {
    private final Long id;
    private final List<CartEntryResponse> shoppingList;
    private final boolean payed;

    public CartResponse(Cart c) {
        this.id = c.getId();
        this.payed = c.isPayed();
        this.shoppingList = c.getShoppingList().stream().map(CartEntryResponse::new).collect(Collectors.toList());
    }
}
