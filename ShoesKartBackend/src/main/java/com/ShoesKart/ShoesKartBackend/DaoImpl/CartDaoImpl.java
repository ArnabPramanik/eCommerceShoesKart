package com.ShoesKart.ShoesKartBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ShoesKart.ShoesKartBackend.Dao.CartDao;
import com.ShoesKart.ShoesKartBackend.model.Cart;


@Repository("CartDao")
@Transactional
public class CartDaoImpl implements CartDao {
	@Autowired
	public SessionFactory sessionFactory;
	public boolean insertUpdate(Cart cart) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Cart getById(int id) {
		// TODO Auto-generated method stub
		return (Cart) sessionFactory.getCurrentSession().get(Cart.class, id);
	}

	public List<Cart> getAll(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where username=:username and status='N'");
		query.setParameter("username", username);
		@SuppressWarnings("unchecked")
		List<Cart> list=query.list();
		session.close();
		return list;
	}

	public void delete(Cart cart) {
		sessionFactory.getCurrentSession().delete(cart);
		
	}

	public List<Cart> getMaxcartid() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart ORDER BY CARTID");
		
		List<Cart> list=query.list();
		session.close();
		return list;
	}

}
