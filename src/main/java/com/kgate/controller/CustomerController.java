package com.kgate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kgate.entity.Customer;
import com.kgate.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger logger=LoggerFactory.getLogger((CustomerController.class));
	@Autowired
	private CustomerService service;

	@GetMapping("/list")
	public String list(Model model) {
		List<Customer> list = service.getCustomers();
		model.addAttribute("list", list);
		return "cust_list";
	}

	@GetMapping("/showForm")
	public String showForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "cust_form";
	}

	@PostMapping("/saveCustomer")
	public String save(@ModelAttribute("customer") Customer customer) {
		service.save(customer);
		return "redirect:/customer/list";
	}
}
