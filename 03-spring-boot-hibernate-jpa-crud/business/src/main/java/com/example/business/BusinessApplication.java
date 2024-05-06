package com.example.business;

import com.example.business.dao.CustomerDAO;
import com.example.business.dao.ProductDAO;
import com.example.business.entity.Customer;
import com.example.business.enums.Gender;
import com.example.business.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class BusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(CustomerDAO customerDAO,ProductDAO productDAO){
		return runner ->{
		//	createCustomer(customerDAO);
		//	createProduct(productDAO);
		//	createMultipleCustomers(customerDAO);
		//	readCustomer(customerDAO);
		//	readProduct(productDAO);
		//	queryForCustomers(customerDAO);
		//	queryForProducts(productDAO);
		//	queryForCustomersByLastName(customerDAO);
		//	queryForProductsByOrigin(productDAO);
		//	updateCustomer(customerDAO);
		//	updateProduct(productDAO);
		//	deleteCustomer(customerDAO);
		//	deleteProduct(productDAO);
		//	deleteAllCustomers(customerDAO);
		//	deleteAllProducts(productDAO);

		};
	}

	private void deleteAllProducts(ProductDAO productDAO) {
		System.out.println("Deleting all products");
		int numRowsDeleted_p = productDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDeleted_p);
	}

	private void deleteAllCustomers(CustomerDAO customerDAO) {
		System.out.println("Deleting all customers");
		int numRowsDeleted_c = customerDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDeleted_c);
		
	}

	private void deleteProduct(ProductDAO productDAO) {
		int productId = 3;
		System.out.println("Deleting product is : " + productId);
		productDAO.delete(productId);
	}

	private void deleteCustomer(CustomerDAO customerDAO) {
		int customerId = 3;
		System.out.println("Deleting customer id: "+ customerId);
		customerDAO.delete(customerId);
	}

	private void updateProduct(ProductDAO productDAO) {
		int productId = 1;
		System.out.println("Getting product with id: " + productId);
		Product myProduct = productDAO.findById(productId);
		System.out.println("Updating product...");
		myProduct.setOrigin("Korea");
		productDAO.update(myProduct);
		System.out.println("Updated product: "+ myProduct);
	}

	private void updateCustomer(CustomerDAO customerDAO) {
		int customerId = 1;
		System.out.println("Getting customer with id: " + customerId);
		Customer myCustomer = customerDAO.findById(customerId);
		System.out.println("Updating customer...");
		myCustomer.setFirstName("Scooby");
		customerDAO.update(myCustomer);
		System.out.println("Updated customer: "+ myCustomer);


	}

	private void queryForProductsByOrigin(ProductDAO productDAO) {
		List<Product> theProducts = productDAO.findByLastOrigin("Vietnam");

		for(Product tempProduct: theProducts){
			System.out.println(tempProduct);
		}
	}

	private void queryForCustomersByLastName(CustomerDAO customerDAO) {
		List<Customer> theCustomers = customerDAO.findByLastName("Duck");

		for(Customer tempCustomer: theCustomers){
			System.out.println(tempCustomer);
		}
	}





	private void queryForProducts(ProductDAO productDAO) {
		List<Product> theProducts = productDAO.findAll();
		for (Product tempProduct: theProducts){
			System.out.println(tempProduct);
		}
	}

	private void queryForCustomers(CustomerDAO customerDAO) {
		List<Customer> theCustomers= customerDAO.findAll();
		for (Customer tempCustomer : theCustomers){
			System.out.println(tempCustomer);
		}
		
	}

	private void readCustomer(CustomerDAO customerDAO) {
		System.out.println("Creating 3 customer objects");
		Customer tempCustomer = new Customer("Daffy","Duck","enes3901@gmail.com", Gender.male);
		System.out.println("Saving the customer...");
		customerDAO.save(tempCustomer);

		System.out.println("Saved customer. Generated id: " + tempCustomer.getCustomer_id());
		int c_id = tempCustomer.getCustomer_id();
		///////////////////////////////////////////
		System.out.println("The retrieving costumer with id: " + c_id);
		Customer myCostumer = customerDAO.findById(c_id);
		System.out.println("Found the costumer: " + myCostumer);


	}
	private void readProduct(ProductDAO productDAO) {
		System.out.println("Creating 3 product objects");
		Product tempProduct = new Product("Vietnam",10);
		System.out.println("Saving the product...");
		productDAO.save(tempProduct);
		System.out.println("Saved product. Generated id: " + tempProduct.getProduct_id());
		int p_id = tempProduct.getProduct_id();
		System.out.println("The retrieving product with id: "+ p_id);
		Product myProduct= productDAO.findById(p_id);
		System.out.println("Found the product: " + myProduct);

	}

	private void createMultipleCustomers(CustomerDAO customerDAO) {
		System.out.println("Creating 3 customer objects");
		Customer Customer1 = new Customer("Enes","Muderris","enes3901@gmail.com", Gender.male);
		System.out.println("Saving the customer...");
		customerDAO.save(Customer1);
		System.out.println("Saved customer. Generated id: " + Customer1.getCustomer_id());

		System.out.println("Creating 3 customer objects");
		Customer Customer2 = new Customer("Talha","Muderris","talha0605@gmail.com", Gender.male);
		System.out.println("Saving the customer...");
		customerDAO.save(Customer2);
		System.out.println("Saved customer. Generated id: " + Customer2.getCustomer_id());

		System.out.println("Creating 3 customer objects");
		Customer Customer3 = new Customer("Furkan","Muderris","furkanm@gmail.com", Gender.male);
		System.out.println("Saving the customer...");
		customerDAO.save(Customer3);
		System.out.println("Saved customer. Generated id: " + Customer3.getCustomer_id());
	}

	private void createCustomer(CustomerDAO customerDAO) {
		System.out.println("Creating new customer object");
		Customer tempCustomer = new Customer("Enes","Muderris","enes3901@gmail.com", Gender.male);
		System.out.println("Saving the customer...");
		customerDAO.save(tempCustomer);
		System.out.println("Saved customer. Generated id: " + tempCustomer.getCustomer_id());


	}

	private void createProduct(ProductDAO productDAO) {
		//create
		System.out.println("Creating new product object");
		Product tempProduct = new Product("China",15);
		// save
		System.out.println("Saving the product...");
		productDAO.save(tempProduct);

		//display
		System.out.println("Saved product. Generated id: " + tempProduct.getProduct_id());

	}



}
