package com.yaksha.assignment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // Mark this as a Spring bean
public class Order {

	@Value("${order.id}") // Inject value from the properties file
	private String orderId;

	// Default constructor for Spring's bean instantiation
	public Order() {
	}

	// Constructor injection (Optional)
	public Order(@Value("${order.id}") String orderId) {
		this.orderId = orderId;
	}

	// Getters and Setters
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
