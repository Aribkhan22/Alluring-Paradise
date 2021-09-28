package com.demo.controller;

import java.util.HashMap;
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
import com.demo.beans.Products;
import com.demo.dto.ResponseDTO;

import com.demo.services.ProductService;


	@CrossOrigin(origins="http://localhost:3000")
	@RestController
	@RequestMapping("/products")
	public class ProductController {
		@Autowired
	ProductService productService;
		
		@GetMapping("/all")
		public ResponseEntity<?> getProduct() {
			return ResponseEntity.ok(new ResponseDTO<>(productService.getAllProducts()));
		}
		
		/*
		@GetMapping("/all")
		public ResponseEntity<?> getProductsByCategory() {
			return ResponseEntity.ok(new ResponseDTO<>(productService.getByCategoryId()));
		}
		
		*/
		
		

		
		
	}



	
	






