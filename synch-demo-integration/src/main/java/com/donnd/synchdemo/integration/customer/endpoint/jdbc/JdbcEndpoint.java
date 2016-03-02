package com.donnd.synchdemo.integration.customer.endpoint.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.donnd.synchdemo.integration.customer.domain.Customer;
import com.donnd.synchdemo.integration.customer.service.CustomerService;

@MessageEndpoint
public class JdbcEndpoint {  
	
	@Autowired
	private CustomerService customerService;

	@ServiceActivator
	public void process(List<Customer> customers) throws Exception {		
		for (Customer customer : customers) {
			customerService.create(customer);
		}
	}

}
