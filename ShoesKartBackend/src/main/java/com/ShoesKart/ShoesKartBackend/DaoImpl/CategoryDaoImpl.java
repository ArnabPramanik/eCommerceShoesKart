package com.ShoesKart.ShoesKartBackend.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ShoesKart.ShoesKartBackend.Dao.CategoryDao;
import com.ShoesKart.ShoesKartBackend.model.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	public SessionFactory sessionFactory;

	public boolean insertUpdate(Category cat) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cat);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public Category getById(int id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}


	public List<Category> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public void delete(Category category){
		sessionFactory.getCurrentSession().delete(category);
	}

}
