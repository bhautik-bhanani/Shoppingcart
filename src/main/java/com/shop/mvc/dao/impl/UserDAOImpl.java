/**
 * 
 */
package com.shop.mvc.dao.impl;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.mvc.controllers.HomeController;
import com.shop.mvc.dao.UserDAO;
import com.shop.mvc.model.Product;
import com.shop.mvc.model.User;

/**
 * @author Bhautik Bhanani
 *
 */
@Repository("UserDAOImpl")
public class UserDAOImpl implements UserDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User getUserByUsernamePassword(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM User WHERE username=? AND password=?");
		query.setString(0, username);
		query.setString(1, password);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	public User getUserById(int userId) {
		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class, userId);
	}

	@Override
	public boolean addWishlist(int userId, int productId) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, userId);
		Product product = (Product) session.get(Product.class, productId);
		user.getWishlist().add(product);
		int id = (int) session.save(user);
		if (id > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean removeWishlist(int userId, int productId) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, userId);
		// Product product = (Product) session.get(Product.class, productId);
		Iterator<Product> iterator = user.getWishlist().iterator();
		while (iterator.hasNext()) {
			Product p = iterator.next();
			if (p.getProductId() == productId) {
				iterator.remove();
				break;
			}
		}
		int id = (int) session.save(user);
		if (id > 0)
			return true;
		else
			return false;
	}

	@Override
	public User getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM User WHERE username=?");
		q.setString(0, username);
		User user = (User) q.uniqueResult();
		return user;
	}
}
