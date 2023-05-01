package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.CartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    // ============================
    @GetMapping
    public ResponseEntity<List<CartResponse>> getAllCarts() {
        return new ResponseEntity<>(this.cartService.getAllCarts().stream().map(CartResponse::new).collect(Collectors.toList()), HttpStatus.OK);
    }
    // ============================

    @PostMapping()
    public ResponseEntity<CartResponse> createCart() {
        return new ResponseEntity<>(new CartResponse(this.cartService.createCart()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> getCartById(@PathVariable Long id) {
        return new ResponseEntity<>(new CartResponse(this.cartService.getCartById(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCartById(@PathVariable Long id) {
        this.cartService.deleteCartById(id);
    }

}
