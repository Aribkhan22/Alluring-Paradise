package com.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.beans.Customer;

@Repository
public interface CustomerDao  extends JpaRepository<Customer,Integer>{
//@Query(value="select * from customer where username=UserName and password=password",nativeQuery=true)
//Optional<Customer> getByUserName(String UserName,String password);
	
	Optional<Customer> findByUname(String uname);

	@Query(value="select * from customer where uname=:uname and upass=:upass",nativeQuery=true)
	Optional<Customer> findByCustomernamePassword(String uname, String upass);

	
	

}
