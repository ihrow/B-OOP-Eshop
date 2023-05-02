package sk.stuba.fei.uim.oop.assignment3.product.logic;

import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product createProduct(ProductRequest productRequest) throws NotFoundException;
    Product getProductById(Long id) throws NotFoundException;
    void deleteProductById(Long id) throws NotFoundException;
    Product updateProduct(Long id, ProductRequest productRequest) throws NotFoundException;
    int getProductAmount(Long id) throws NotFoundException;
    int addProductAmount(Long id, int amount) throws NotFoundException;
    void decreaseProductAmount(Product p, int amount) throws IllegalOperationException;
}
