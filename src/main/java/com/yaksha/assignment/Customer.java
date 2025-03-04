package com.yaksha.assignment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // Mark this as a Spring bean
public class Customer {

	@Value("${customer.name}") // Inject value from the properties file
	private String name;

	// Default constructor for Spring's bean instantiation
	public Customer() {
	}

	// Constructor injection (Optional)
	public Customer(@Value("${customer.name}") String name) {
		this.name = name;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
