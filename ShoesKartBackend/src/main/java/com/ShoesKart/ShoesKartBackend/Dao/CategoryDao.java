package com.ShoesKart.ShoesKartBackend.Dao;

import java.util.List;

import com.ShoesKart.ShoesKartBackend.model.Category;

public interface CategoryDao {
	public boolean insertUpdate(Category cat);

	public Category getById(int id);

	
	public List<Category> getAll();
	
	public void delete(Category category);
}
