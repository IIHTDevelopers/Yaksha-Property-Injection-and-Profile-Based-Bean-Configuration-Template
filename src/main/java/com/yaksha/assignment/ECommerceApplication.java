package com.yaksha.assignment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yaksha.assignment.config.AppConfig;

public class ECommerceApplication {

	public static void main(String[] args) {
		// Load the Spring context using Java-based configuration
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Get the beans from the context
		Product product = context.getBean(Product.class);
		Customer customer = context.getBean(Customer.class);
		Order order = context.getBean(Order.class);

		// Display bean details
		System.out.println("Product Name: " + product.getName());
		System.out.println("Product Price: " + product.getPrice());
		System.out.println("Customer Name: " + customer.getName());
		System.out.println("Order ID: " + order.getOrderId());

		// Display active profile
		String profile = context.getEnvironment().getActiveProfiles()[0];
		System.out.println("Active Profile: " + profile);
	}
}
