package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.CategoryDao;
import com.demo.dao.ProductDao;
import com.demo.beans.Category;
import com.demo.beans.Products;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	@Autowired
	CategoryDao cateDao;
	
	public List<Products>getAllProducts(){
		return productDao.findAll();
	}
	public List<Products>getProductsByCategory(String pid){
		return productDao.getByCategoryId(pid);
	}
	
	public List<Category>getAllCategory(){
		return cateDao.findAll();
	}
	
	
}