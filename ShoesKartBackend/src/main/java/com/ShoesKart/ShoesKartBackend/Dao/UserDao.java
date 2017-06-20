package com.ShoesKart.ShoesKartBackend.Dao;

import java.util.List;

import com.ShoesKart.ShoesKartBackend.model.User;

public interface UserDao {
	
	public void insertUpdate(User user);
	public void delete(User user);
	public User getById(String id);
	public List<User> getAll();
	
}
