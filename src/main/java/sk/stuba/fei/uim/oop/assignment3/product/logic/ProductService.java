package sk.stuba.fei.uim.oop.assignment3.product.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Product getProductById(Long id) {
        return this.productRepository.findProductById(id);
    }

    @Override
    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long id, ProductRequest productRequest) {
        Product p = this.productRepository.findProductById(id);
        if (productRequest.getName() != null) {
            p.setName(productRequest.getName());
        }
        if (productRequest.getDescription() != null) {
            p.setDescription(productRequest.getDescription());
        }
        return this.productRepository.save(p);
    }
}
