package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yaksha.assignment.Customer;
import com.yaksha.assignment.Order;
import com.yaksha.assignment.Product;
import com.yaksha.assignment.config.AppConfig;

public class ECommerceJavaConfigControllerTest {

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testApplicationContextLoads() throws IOException {
		// Load the context using Java-based configuration
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Retrieve beans from the context
		Product product = context.getBean(Product.class);
		Customer customer = context.getBean(Customer.class);
		Order order = context.getBean(Order.class);

		// Assert that beans are created
		boolean productLoaded = product != null;
		boolean customerLoaded = customer != null;
		boolean orderLoaded = order != null;

		// Log the checks
		System.out.println("Product bean loaded: " + productLoaded);
		System.out.println("Customer bean loaded: " + customerLoaded);
		System.out.println("Order bean loaded: " + orderLoaded);

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(), productLoaded && customerLoaded && orderLoaded, businessTestFile);
	}

	@Test
	public void testPropertyInjectionWithValueAnnotation() throws IOException {
		// Load the context using Java-based configuration
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Retrieve beans from the context
		Product product = context.getBean(Product.class);
		Customer customer = context.getBean(Customer.class);
		Order order = context.getBean(Order.class);

		// Assert that the property values are injected correctly
		boolean productNameCorrect = "Sample Product".equals(product.getName());
		boolean productPriceCorrect = product.getPrice() == 1000.0;
		boolean customerNameCorrect = "John Doe".equals(customer.getName());
		boolean orderIdCorrect = "ORD1001".equals(order.getOrderId());

		// Log the checks
		System.out.println("Product Name: " + product.getName());
		System.out.println("Product Price: " + product.getPrice());
		System.out.println("Customer Name: " + customer.getName());
		System.out.println("Order ID: " + order.getOrderId());

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(), productNameCorrect && productPriceCorrect && customerNameCorrect && orderIdCorrect,
				businessTestFile);
	}

	@Test
	public void testDefaultPropertyValues() throws IOException {
		// Load the context with default profile
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Retrieve the Product bean from the context
		Product product = context.getBean(Product.class);

		// Assert that the default product price is injected
		boolean productPriceDefault = 1000.0 == product.getPrice(); // Assuming default price is 1000.0

		// Log the result
		System.out.println("Product Price (Default Profile): " + product.getPrice());

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(), productPriceDefault, businessTestFile);
	}

	@Test
	public void testProfileSpecificBeansCreation() throws IOException {
		// Load the context with the active profile (e.g., dev or prod)
		System.setProperty("spring.profiles.active", "dev"); // or "prod"
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Retrieve a profile-specific bean from the context
		Product product = context.getBean(Product.class);

		// Assert that the correct product is injected based on the active profile
		boolean correctProduct = "Sample Product".equals(product.getName()); // Assuming dev profile sets this value

		// Log the result
		System.out.println("Profile-specific Product Name: " + product.getName());

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(), correctProduct, businessTestFile);
	}

	@Test
	public void testActiveProfile() throws IOException {
		// Load the context with the active profile
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Retrieve active profile from the environment
		String activeProfile = context.getEnvironment().getActiveProfiles()[0]; // Assuming only one profile is active

		// Assert that the correct profile is active
		boolean profileCorrect = "dev".equals(activeProfile); // Change this based on the profile set

		// Log the result
		System.out.println("Active Profile: " + activeProfile);

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(), profileCorrect, businessTestFile);
	}

	// Test case to check if the properties are defined in
	// application-dev.properties
	@Test
	public void testApplicationDevProperties() throws IOException {
		// Load the properties file for the 'dev' profile
		FileInputStream fis = new FileInputStream("src/main/resources/application-dev.properties");
		Properties properties = new Properties();
		properties.load(fis);

		// Check if required properties exist
		boolean productNameDefined = properties.containsKey("product.name");
		boolean productPriceDefined = properties.containsKey("product.price");
		boolean customerNameDefined = properties.containsKey("customer.name");
		boolean orderIdDefined = properties.containsKey("order.id");

		// Log the result for debugging
		System.out.println("Product Name Defined: " + productNameDefined);
		System.out.println("Product Price Defined: " + productPriceDefined);
		System.out.println("Customer Name Defined: " + customerNameDefined);
		System.out.println("Order ID Defined: " + orderIdDefined);

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(), productNameDefined && productPriceDefined && customerNameDefined && orderIdDefined,
				businessTestFile);
	}

	@Test
	public void testApplicationProdProperties() throws IOException {
		// Load the properties file for the 'prod' profile
		FileInputStream fis = new FileInputStream("src/main/resources/application-prod.properties");
		Properties properties = new Properties();
		properties.load(fis);

		// Check if required properties exist
		boolean productNameDefined = properties.containsKey("product.name");
		boolean productPriceDefined = properties.containsKey("product.price");
		boolean customerNameDefined = properties.containsKey("customer.name");
		boolean orderIdDefined = properties.containsKey("order.id");

		// Log the result for debugging
		System.out.println("Product Name Defined: " + productNameDefined);
		System.out.println("Product Price Defined: " + productPriceDefined);
		System.out.println("Customer Name Defined: " + customerNameDefined);
		System.out.println("Order ID Defined: " + orderIdDefined);

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(), productNameDefined && productPriceDefined && customerNameDefined && orderIdDefined,
				businessTestFile);
	}

}
