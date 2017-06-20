package com.ShoesKart.ShoesKartBackend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ShoesKart.ShoesKartBackend.Dao.UserDao;
import com.ShoesKart.ShoesKartBackend.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void insertUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}

	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
		
	}

	public User getById(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class,id);
		
	}

	public List<User> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	
}
