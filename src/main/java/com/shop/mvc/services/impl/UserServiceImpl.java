package com.shop.mvc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.mvc.dao.UserDAO;
import com.shop.mvc.model.User;
import com.shop.mvc.services.UserService;

/**
 * @author Bhautik Bhanani
 *
 */
@Service(value = "UserServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("UserDAOImpl")
	UserDAO userDAO;

	@Override
	public User getUserByUsernamePassword(String username, String password) {
		return userDAO.getUserByUsernamePassword(username, password);
	}

	@Override
	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}

	@Override
	public boolean addWishlist(int userId, int productId) {
		return userDAO.addWishlist(userId, productId);
	}

	@Override
	public boolean removeWishlist(int userId, int productId) {
		return userDAO.removeWishlist(userId, productId);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDAO.getUserByUsername(username);
	}
}
