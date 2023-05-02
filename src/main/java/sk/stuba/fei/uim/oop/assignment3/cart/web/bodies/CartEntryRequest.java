package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartEntryRequest {
    private Long productId;
    private int amount;
}
