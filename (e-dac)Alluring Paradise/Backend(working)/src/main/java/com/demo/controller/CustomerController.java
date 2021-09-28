package com.demo.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Customer;
import com.demo.dto.ResponseDTO;
import com.demo.services.CustomerService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getCustomer() {
		return ResponseEntity.ok(new ResponseDTO<>(customerService.getAllCustomer()));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> addCustomer(@RequestBody Customer c) {
		String cname=c.getUname();
		System.out.println(cname);
		return new ResponseEntity<>(new ResponseDTO<>(customerService.save(c)), HttpStatus.CREATED);
	}
	
	@GetMapping("/login/{uname}/{upass}")
	public ResponseEntity<?> authenticateLogin(@PathVariable String uname,@PathVariable String upass) {
		System.out.println(uname+ "   "+upass);
		Customer c1= customerService.authenticateCustomer(uname,upass);
		if(c1!=null){
		return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/update/{uname}")
	public ResponseEntity<?> updateUser(@PathVariable String uname,  @RequestBody  Customer c) {
		System.out.println(c);
		return ResponseEntity.ok(new ResponseDTO<>(customerService.update(c,uname)));
	}
	
	@PutMapping("/upass/{uname}")
	public ResponseEntity<?> updatePassword(@PathVariable String uname, @RequestBody Customer c) {
		System.out.println(c.getUpass());
		
		return ResponseEntity.ok(new ResponseDTO<>(customerService.updatePassword(uname, c.getUpass())));
		
	}
	
	

	
}


