package com.ShoesKart.ShoesKartBackend.DaoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ShoesKart.ShoesKartBackend.Dao.SupplierDao;
import com.ShoesKart.ShoesKartBackend.model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao{
	@Autowired
	SessionFactory sessionFactory;
	public void insertUpdate(Supplier supplier) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(supplier);
		
	}

	public void delete(Supplier supplier) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(supplier);
		
	}

	public Supplier getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Supplier)session.get(Supplier.class,id);
		
	}

	public List<Supplier> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = (Query) session.createQuery("from Supplier").list();
		return (List<Supplier>) query;
	}
	

}
