package com.ShoesKart.ShoesKartBackend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ShoesKart.ShoesKartBackend.Dao.ProductDao;
import com.ShoesKart.ShoesKartBackend.model.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	public SessionFactory sessionFactory;

	public boolean insertUpdate(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public Product getById(int id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}


	public List<Product> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
	public void delete(Product product){
		sessionFactory.getCurrentSession().delete(product);
	}

}
