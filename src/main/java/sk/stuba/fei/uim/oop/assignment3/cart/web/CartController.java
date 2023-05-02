package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.CartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartEntryRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;


@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping()
    public ResponseEntity<CartResponse> createCart() {
        return new ResponseEntity<>(new CartResponse(this.cartService.createCart()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> getCartById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(new CartResponse(this.cartService.getCartById(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCartById(@PathVariable Long id) throws NotFoundException {
        this.cartService.deleteCartById(id);
    }

    @GetMapping(value = "/{id}/pay")
    public String payForCart(@PathVariable Long id) throws NotFoundException, IllegalOperationException {
        return Double.toString(this.cartService.payForCart(id));
    }

    @PostMapping("/{id}/add")
    public ResponseEntity<CartResponse> addItemToCart(@PathVariable Long id, @RequestBody CartEntryRequest product) throws NotFoundException, IllegalOperationException {
        return new ResponseEntity<>(new CartResponse(this.cartService.addItemToCart(id, product)), HttpStatus.OK);
    }

}
