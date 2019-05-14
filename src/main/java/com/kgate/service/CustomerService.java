package com.kgate.service;

import java.util.List;

import com.kgate.entity.Customer;

public interface CustomerService {
	void save(Customer customer);

	List<Customer> getCustomers();

}
