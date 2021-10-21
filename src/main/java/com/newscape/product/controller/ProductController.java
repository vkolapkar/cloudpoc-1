package com.newscape.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

import com.newscape.product.model.Product;
import com.newscape.product.model.ProductService;

@RestController
public class ProductController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService prodService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@GetMapping("/product")
	public List<Product> getAllproducts() {
		return prodService.getAll();
	}
	
	@GetMapping("product/{prodId}")
	public Product pReview(@PathVariable int prodId) {
		log.info("In prod review call...");
		Product res = restTemplate.getForObject("http://review:8080/review/"+prodId, Product.class);
		res.setName(prodService.findById(prodId).getName());
		res.setPrice(prodService.findById(prodId).getPrice());
		log.info("Response from review service",res);
		return res;
	}
}
