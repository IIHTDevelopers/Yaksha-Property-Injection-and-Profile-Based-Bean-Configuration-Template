package com.yaksha.assignment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // This annotation makes the class a Spring-managed bean
public class Product {

	@Value("${product.name}") // Injecting the value of 'product.name' from the properties file
	private String name;

	@Value("${product.price}") // Injecting the value of 'product.price' from the properties file
	private double price;

	// Default constructor for Spring to instantiate
	public Product() {
	}

	// Constructor injection (Optional, if you want to use constructor-based DI)
	public Product(@Value("${product.name}") String name, @Value("${product.price}") double price) {
		this.name = name;
		this.price = price;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
