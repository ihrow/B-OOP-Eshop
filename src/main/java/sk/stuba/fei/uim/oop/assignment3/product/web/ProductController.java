package sk.stuba.fei.uim.oop.assignment3.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.logic.ProductService;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.AmountResponse;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductResponse> getAll() {
        return this.productService.getAllProducts().stream().map(product -> new ProductResponse(product)).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>(new ProductResponse(this.productService.createProduct(productRequest)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) throws NotFoundException {
        return new ProductResponse(this.productService.getProductById(id));
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @RequestBody ProductRequest productRequest) throws NotFoundException {
        return new ProductResponse(this.productService.updateProduct(id, productRequest));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws NotFoundException {
        this.productService.deleteProductById(id);
    }

    @GetMapping("/{id}/amount")
    public AmountResponse getAmount(@PathVariable Long id) throws NotFoundException {
        return new AmountResponse(this.productService.getProductAmount(id));
    }

    @PostMapping("/{id}/amount")
    public AmountResponse addAmount(@PathVariable Long id, @RequestBody AmountResponse amountResponse) throws NotFoundException {
        return new AmountResponse(this.productService.addProductAmount(id, amountResponse.getAmount()));
    }
}
