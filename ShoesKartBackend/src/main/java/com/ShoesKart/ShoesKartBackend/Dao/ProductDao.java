package com.ShoesKart.ShoesKartBackend.Dao;

import java.util.List;

import com.ShoesKart.ShoesKartBackend.model.Product;

public interface ProductDao {
	public boolean insertUpdate(Product product);

	public Product getById(int id);


	public List<Product> getAll();
	
	public void delete(Product product);
}
