package com.donnd.synchdemo.integration.customer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.donnd.synchdemo.integration.customer.domain.Customer;

@Service
public class CustomerService {
	
	@Value("${customer-microservice-endpoint}")
	private String customerMicroServiceEndpoint;
	
	public void create(Customer customer) {
		System.out.print("create customer with name " + customer.getName());
		RestTemplate template = new RestTemplate();
		
		// TODO - check response!
		template.postForObject(customerMicroServiceEndpoint, customer, Customer.class);
	}

}
