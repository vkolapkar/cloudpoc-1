package com.newscape.product.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	private int productId;
	private String name;
	private double price;
	private int reviewId;
	private String reviewBy;
	private String review;
	private Date reviewDate;
	
}
