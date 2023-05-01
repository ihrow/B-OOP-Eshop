package sk.stuba.fei.uim.oop.assignment3.product.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        return this.productRepository.save(new Product(productRequest));
    }

    @Override
    public Product getProductById(Long id) throws NotFoundException {
        Product p = this.productRepository.findProductById(id);
        if (p == null) {
            throw new NotFoundException();
        }
        return this.productRepository.findProductById(id);
    }

    @Override
    public void deleteProductById(Long id) throws NotFoundException {
        Product p = this.getProductById(id);
        this.productRepository.delete(p);
    }

    @Override
    public Product updateProduct(Long id, ProductRequest productRequest) throws NotFoundException {
        Product p = this.getProductById(id);
        if (productRequest.getName() != null) {
            p.setName(productRequest.getName());
        }
        if (productRequest.getDescription() != null) {
            p.setDescription(productRequest.getDescription());
        }
        return this.productRepository.save(p);
    }

    @Override
    public int getProductAmount(Long id) throws NotFoundException {
        Product p = this.getProductById(id);
        return p.getAmount();
    }

    @Override
    public int addProductAmount(Long id, int amount) throws NotFoundException {
        Product p = this.getProductById(id);
        p.setAmount(p.getAmount() + amount);
        return this.productRepository.save(p).getAmount();
    }
}
