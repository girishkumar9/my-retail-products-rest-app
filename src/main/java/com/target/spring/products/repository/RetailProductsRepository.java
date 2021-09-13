package com.target.spring.products.repository;

import com.target.spring.products.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RetailProductsRepository extends MongoRepository<Product, Long> {
}
