package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.beans.Products;
@Repository
public interface ProductDao extends JpaRepository<Products, Long> {
	@Query("Select pro FROM Products pro WHERE pro.pid=:pid")
	List<Products> getByCategoryId(@Param("pid")String pid);
}