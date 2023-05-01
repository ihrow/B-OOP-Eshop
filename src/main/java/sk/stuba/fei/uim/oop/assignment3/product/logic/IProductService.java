package sk.stuba.fei.uim.oop.assignment3.product.logic;

import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product createProduct(ProductRequest productRequest);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(Long id, ProductRequest productRequest);
}
