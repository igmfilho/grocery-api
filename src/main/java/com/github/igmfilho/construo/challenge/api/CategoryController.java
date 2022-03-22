package com.github.igmfilho.construo.challenge.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.igmfilho.construo.challenge.api.handler.ResourceNotFoundException;
import com.github.igmfilho.construo.challenge.model.Category;
import com.github.igmfilho.construo.challenge.repository.CategoryRepository;


/**
 * Customizing category resource to support requests for linked relationship with product.
 * 
 * @author ivan.filho
 *
 */
@RestController
@RequestMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/{categoryId}")
    public ResponseEntity<?> getById(@PathVariable Long categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(ResourceNotFoundException::new);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

}
