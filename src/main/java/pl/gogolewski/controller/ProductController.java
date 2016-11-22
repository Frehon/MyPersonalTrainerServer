package pl.gogolewski.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import pl.gogolewski.dto.ProductDTO;
import pl.gogolewski.entity.Product;
import pl.gogolewski.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(@NotNull ProductService productService){
        this.productService = productService;
    }

    @RequestMapping(
            value = "/api/product",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createNewProduct(@RequestBody ProductDTO p){
        Product newProduct = new Product();
        newProduct.setProductName(p.productName);
        newProduct.setCaloriesAmount(p.caloriesAmount);
        newProduct.setProteinAmount(p.proteinAmount);
        newProduct.setCarbsAmount(p.carbsAmount);
        newProduct.setFatAmount(p.fatAmount);
        try {
            newProduct = productService.saveProduct(newProduct);
            return new ResponseEntity<Product>(newProduct, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/api/product/{product_name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> findProductByName(@PathVariable(name = "product_name") String productName){
        if(productName == null){
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Product soughtProduct = productService.getProductByName(productName);
        if(soughtProduct == null){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(soughtProduct , HttpStatus.OK);
    }

    @RequestMapping(
            value = "api/product/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        Product productToDelete = productService.getProductById(id);
        if (productToDelete != null){
            productService.deleteProduct(productToDelete.getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
