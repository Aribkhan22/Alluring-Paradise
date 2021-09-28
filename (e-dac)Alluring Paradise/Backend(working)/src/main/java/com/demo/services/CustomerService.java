package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.demo.beans.Customer;


public interface CustomerService {

	List<Customer> getAllCustomer();

	public Customer save(Customer c);

	Customer authenticateCustomer(String uname, String upass);


	 Customer update(Customer c, String uname);

	Customer updatePassword(String uname, String upass);


	
}
