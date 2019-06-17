package com.kgate.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgate.entity.Customer;
import com.kgate.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	@Transactional
	public Customer saveCustomer(Customer entity) {
		return customerRepo.save(entity);

	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

}
