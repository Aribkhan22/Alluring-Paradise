package com.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="Customer")
public class Customer
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	int id;
	String uname;
	String upass;
	String name;
	String email;
	long mobno;
	char gender;
	String Address;
	int pincode;
	
	
	public Customer() {
		super();
	}
	
	
	public Customer(String uname, String upass) {
		super();
		this.uname = uname;
		this.upass = upass;
	}


	public Customer(int id, String uname, String upass, String name, String email, long mobno, char gender,
			String address, int pincode) {
		super();
		this.id = id;
		this.uname = uname;
		this.upass = upass;
		this.name = name;
		this.email = email;
		this.mobno = mobno;
		this.gender = gender;
		Address = address;
		this.pincode = pincode;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobno() {
		return mobno;
	}
	public void setMobno(long mobno) {
		this.mobno = mobno;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", uname=" + uname + ", upass=" + upass + ", name=" + name + ", email=" + email
				+ ", mobno=" + mobno + ", gender=" + gender + ", Address=" + Address + ", pincode=" + pincode + "]";
	}
	
	}

	