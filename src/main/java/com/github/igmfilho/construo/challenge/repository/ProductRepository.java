package com.github.igmfilho.construo.challenge.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.igmfilho.construo.challenge.model.Product;

/**
 * Product repository to support CRUD operation data.
 * @author ivan.filho
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

	Product findById(long id);
    Product findByName(String name);
    List<Product> findAllByCategoryId(long categoryId);

}
