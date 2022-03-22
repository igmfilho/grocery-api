package com.github.igmfilho.construo.challenge.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.igmfilho.construo.challenge.model.Category;

/**
 * Category repository to support CRUD operation data.
 * @author ivan.filho
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

	Category findByName(String name);
}
