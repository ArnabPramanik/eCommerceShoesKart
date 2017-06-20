package com.ShoesKart.ShoesKartBackend.Dao;

import java.util.List;

import com.ShoesKart.ShoesKartBackend.model.Supplier;

public interface SupplierDao {
	public void insertUpdate(Supplier supplier);
	public void delete(Supplier supplier);
	public Supplier getById(int id);
	public List<Supplier> getAll();
	
}
