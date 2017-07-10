package com.ShoesKart.ShoesKartBackend.Dao;

import java.util.List;

import com.ShoesKart.ShoesKartBackend.model.Cart;


public interface CartDao {
	public boolean insertUpdate(Cart cart);

	public Cart getById(int id);

	
	public List<Cart> getAll(String username);
	
	public void delete(Cart cart);
}
