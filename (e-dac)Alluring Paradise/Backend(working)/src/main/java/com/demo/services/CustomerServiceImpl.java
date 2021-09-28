package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.beans.Customer;
import com.demo.dao.CustomerDao;
import com.demo.exception.CustomerAuthorizationExeception;
import com.demo.exception.CustomerException;

import com.demo.exception.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao custDao;

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> clist= custDao.findAll();
		clist.forEach((c) -> c.getUname());
		return clist;
	}

	@Override
	public Customer save(Customer c) {
		Optional<Customer> op = custDao.findByUname(c.getUname());
		if(op.isPresent()) {
			throw new CustomerException("Customer Exists Excpetion");
		}
		return custDao.save(c);
	}

	public Customer authenticateCustomer1(String uname, String upass) {
		Customer customer = custDao.findByCustomernamePassword(uname,upass)
				.orElseThrow(() -> new CustomerAuthorizationExeception("Invalid Username & Password"));
		System.out.println(customer);
		//customer.getUsername();
		//customer.getPassword();
		return customer;
		
		
	}

	@Override
	public Customer update(Customer c,String username) {
		Customer customer = custDao.findByUname(username)
				.orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));
		if(username!=null) {
			customer.setUname(c.getUname());
			customer.setUpass(c.getUpass());	
			customer.setMobno(c.getMobno());
			customer.setGender(c.getGender());
			customer.setEmail(c.getEmail());
			customer.setPincode(c.getPincode());
			customer.setAddress(c.getAddress());
			
		}
		return custDao.save(customer);
	}

	@Override
	public Customer updatePassword(String uname, String upass) {
		Customer c1=null;
		if(!upass.isEmpty()) {
			c1=custDao.findByUname(uname)
					.orElseThrow(() -> new CustomerNotFoundException("Customer Not Found" +uname));
			c1.setUpass(upass);
			return custDao.save(c1);
		}
		
		return null;
	}

	@Override
	public Customer authenticateCustomer(String uname, String upass) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	
	


}

