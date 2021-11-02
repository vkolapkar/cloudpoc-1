package com.newscape.product.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private static List<Product> prods = new ArrayList<>();
	
	static {
		prods.add(new Product(1, "Laptop", 85000.00, 0, "", "", null));
		prods.add(new Product(2, "Office Chair", 5500.00, 0, "", "", null));
		prods.add(new Product(3, "Desktop", 95000.00, 0, "", "", null));
		prods.add(new Product(4, "CPU", 15000.00, 0, "", "", null));
	}
	
	public List<Product> getAll() {
		return prods;
	}
	
	public Product findById(int id) {
		for(Product prod:prods) {
			if(prod.getProductId() == id) {
				return prod;
			}
		}
		return null;
	}

}
