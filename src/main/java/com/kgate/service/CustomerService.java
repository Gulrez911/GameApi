package com.kgate.service;

import java.util.List;

import com.kgate.entity.Customer;

public interface CustomerService {
	Customer saveCustomer(Customer customer);

	List<Customer> getCustomers();

}
