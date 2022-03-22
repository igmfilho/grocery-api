package com.github.igmfilho.construo.challenge.api;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.igmfilho.construo.challenge.api.handler.ResourceNotFoundException;
import com.github.igmfilho.construo.challenge.model.Category;
import com.github.igmfilho.construo.challenge.model.Product;
import com.github.igmfilho.construo.challenge.repository.CategoryRepository;
import com.github.igmfilho.construo.challenge.repository.ProductRepository;

/**
 * Customizing Product resource to handle behavior of operations 
 * 
 * @author ivan.filho
 *
 */
@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/{productId}")
    public ResponseEntity<?> getById(@PathVariable Long productId) {
		Product product = productRepository.findById(productId).orElseThrow(ResourceNotFoundException::new);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@PostMapping("/{productId}/category/{categoryId}")
	@Transactional
	public ResponseEntity<?> save(@PathVariable Long productId, @PathVariable Long categoryId) {
		Product product = productRepository.findById(productId).orElseThrow(ResourceNotFoundException::new);
		Category category = categoryRepository.findById(categoryId).orElseThrow(ResourceNotFoundException::new);

		// Linking product to category
		category.getBooks().add(product);
		Category saved = categoryRepository.save(category);

		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
}