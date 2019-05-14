package com.kgate.service;

import java.util.List;

import javax.transaction.Transactional;

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
	public void save(Customer entity) {
		customerRepo.save(entity);

	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

}
