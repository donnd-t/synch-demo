package com.donnd.synchdemo.integration.customer.endpoint.file;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.util.StreamUtils;

import com.donnd.synchdemo.integration.customer.domain.Customer;
import com.donnd.synchdemo.integration.customer.service.CustomerService;

@MessageEndpoint
public class FileEndpoint {
	
	@Autowired
	private CustomerService customerService;

	@ServiceActivator
	public void process(File input) throws Exception {
		FileInputStream in = new FileInputStream(input);
		String name = new String(StreamUtils.copyToByteArray(in));
		in.close();
		customerService.create(new Customer(name));
	}

}
