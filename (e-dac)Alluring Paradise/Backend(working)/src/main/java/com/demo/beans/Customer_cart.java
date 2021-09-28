package com.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




 
   @Entity
    public class Customer_cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Cart_id",updatable=false,nullable=false)
	int Cart_id;
	
	
	
	public int getCart_id() {
		return Cart_id;
	}

	public void setCart_id(int cart_id) {
		Cart_id = cart_id;
	}

		
	

}