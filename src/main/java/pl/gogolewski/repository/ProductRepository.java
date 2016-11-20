package pl.gogolewski.repository;


import org.springframework.data.repository.CrudRepository;
import pl.gogolewski.entity.Product;

public interface ProductRepository extends CrudRepository<Product , Long>{

    Product save(Product newProduct);
    Product findOne(Long productId);
    Product findByproductName(String productName);
    void delete(Long productId);

}
