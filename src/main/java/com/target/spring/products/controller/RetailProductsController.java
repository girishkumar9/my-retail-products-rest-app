package com.target.spring.products.controller;

import com.target.spring.products.model.Product;
import com.target.spring.products.repository.RetailProductsRepository;
import com.target.spring.products.utils.RetailProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class RetailProductsController {
    @Autowired
    RetailProductsRepository repository;

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id){
        if(!RetailProductUtils.isGetRequestValid(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Product> productData = repository.findById(Long.valueOf(id));
        if(productData.isPresent()) {
            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> putProductById(@PathVariable("id") String id, @RequestBody Product product){
        if(!RetailProductUtils.isPutRequestValid(id, product)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Product> productData = repository.findById(Long.valueOf(id));
        if(productData.isPresent()){
            Product updatedProduct = productData.get();
            updatedProduct.setPrice(product.getPrice());
            return new ResponseEntity<>(repository.save(updatedProduct), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> saveProducts(@RequestBody Product product){
        try{
            Product newProduct = repository.save(new Product(product.getId(), product.getName(), product.getPrice()));
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
