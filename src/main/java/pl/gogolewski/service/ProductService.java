package pl.gogolewski.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pl.gogolewski.entity.Product;
import pl.gogolewski.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product newProduct) {
       return productRepository.save(newProduct);
    }

    public Product getProductById(Long id) {
        return productRepository.findOne(id);
    }

    public void deleteProduct(Long productToDeleteId) {
        productRepository.delete(productToDeleteId);
    }
}
