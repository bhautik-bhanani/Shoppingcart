/**
 * 
 */
package com.shop.mvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.mvc.controllers.HomeController;
import com.shop.mvc.dao.ProductDAO;
import com.shop.mvc.model.Product;

/**
 * @author Bhautik Bhanani
 *
 */
@Repository("ProductDAOImpl")
public class ProductDAOImpl implements ProductDAO {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * @param sf
	 */
	// public void setSessionFactory(SessionFactory sf) {
	// this.sessionFactory = sf;
	// }

	@Override
	public Product getProductById(int productId) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, productId);
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductList() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("From Product").list();
		return products;
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product updateProduct(Product product, int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeProduct(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

}
