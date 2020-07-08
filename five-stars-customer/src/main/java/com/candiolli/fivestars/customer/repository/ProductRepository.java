package com.candiolli.fivestars.customer.repository;

import com.candiolli.fivestars.customer.model.Product;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface ProductRepository extends CrudRepository<Product, String> {

    Optional<Product> findById(String id);

}
