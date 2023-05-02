package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;


import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartEntry;

@Getter
public class CartEntryResponse {
    private final Long productId;
    private final int amount;

    public CartEntryResponse(CartEntry entry) {
        this.productId = entry.getProductId();
        this.amount = entry.getAmount();
    }
}
