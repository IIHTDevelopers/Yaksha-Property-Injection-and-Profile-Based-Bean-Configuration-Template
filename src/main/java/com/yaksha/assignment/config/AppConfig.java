package com.yaksha.assignment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.yaksha.assignment.Customer;
import com.yaksha.assignment.Order;
import com.yaksha.assignment.Product;

@Configuration
@ComponentScan(basePackages = "com.yaksha.assignment") // Scans your beans (e.g., Product, Order, etc.)
@PropertySource("classpath:application.properties")
public class AppConfig {

	// Property injected using @Value
	@Value("${product.name}")
	private String productName;

	@Value("${product.price}")
	private double productPrice;

	@Value("${customer.name}")
	private String customerName;

	@Value("${order.id}")
	private String orderId;

	// Bean for Product
	@Bean
	public Product product() {
		return new Product(productName, productPrice);
	}

	// Bean for Customer
	@Bean
	public Customer customer() {
		return new Customer(customerName);
	}

	// Bean for Order
	@Bean
	public Order order() {
		return new Order(orderId);
	}

	// Profile-specific bean for development environment
	@Bean
	@Profile("dev")
	public String devProfile() {
		return "Development Profile Active!";
	}

	// Profile-specific bean for production environment
	@Bean
	@Profile("prod")
	public String prodProfile() {
		return "Production Profile Active!";
	}
}
