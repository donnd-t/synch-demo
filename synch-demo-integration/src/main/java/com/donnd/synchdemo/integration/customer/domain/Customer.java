package com.donnd.synchdemo.integration.customer.domain;

public class Customer {
	
	private String name;
	
	public Customer() {
	}
	
	public Customer(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	

}
