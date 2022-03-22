package com.github.igmfilho.construo.challenge;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.igmfilho.construo.challenge.model.Category;
import com.github.igmfilho.construo.challenge.model.Product;
import com.github.igmfilho.construo.challenge.repository.CategoryRepository;
import com.github.igmfilho.construo.challenge.repository.ProductRepository;



@Component
public class StartupData implements CommandLineRunner {

	private static final String VEGETABLE = "vegetable";
	private static final String FRUIT = "fruit";
	private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(StartupData.class);
	
    public StartupData(ProductRepository productRepository, CategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("loading categories and products ...");
		loadCategories();
		loadProducts();
		logger.info("categories and products is loaded");
	}
	
    private void loadCategories(){
        Category category1 = new Category();
        Category category2 = new Category();
        category1.setId(1L);
        category1.setName(FRUIT);
        category2.setId(2L);
        category2.setName(VEGETABLE);

        categoryRepository.save(category1);
        categoryRepository.save(category2);
    }

    
    private void loadProducts(){
        final BigDecimal PRICE = BigDecimal.valueOf(22);

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product1.setName("apple");
        product1.setCategory(categoryRepository.findByName(FRUIT));
        product1.setPrice(PRICE);

        product2.setName("banana");
        product2.setCategory(categoryRepository.findByName(FRUIT));
        product2.setPrice(PRICE);

        product3.setName("spinach");
        product3.setCategory(categoryRepository.findByName(VEGETABLE));
        product3.setPrice(PRICE);

        product4.setName("broccoli");
        product4.setCategory(categoryRepository.findByName(VEGETABLE));
        product4.setPrice(PRICE);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
    }
}