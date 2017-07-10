package com.ShoesKart.ShoesKartBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {
	@Id
	@GeneratedValue
    int cartitemid;
    int  prodid,quantity = 1,price;
	
	
	String username;
	
	
	String prodname,status;
	
	public int getCartitemid() {
		return cartitemid;
	}


	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
	}


	public int getProdid() {
		return prodid;
	}


	public void setProdid(int prodid) {
		this.prodid = prodid;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getProdname() {
		return prodname;
	}


	public void setProdname(String prodname) {
		this.prodname = prodname;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	
	
}
