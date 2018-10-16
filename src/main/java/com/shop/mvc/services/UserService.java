/**
 * 
 */
package com.shop.mvc.services;

import com.shop.mvc.model.User;

/**
 * @author Bhautik Bhanani
 *
 */
public interface UserService {
	/**
	 * @param username
	 * @param password
	 * @return User
	 */
	public abstract User getUserByUsernamePassword(String username, String password);

	/**
	 * @param userId
	 * @return user
	 */
	public abstract User getUserById(int userId);

	/**
	 * @param username
	 * @return user
	 */
	public abstract User getUserByUsername(String username);

	/**
	 * @param userId
	 * @param productId
	 * @param user
	 * @param product
	 * @return boolean
	 */
	public abstract boolean addWishlist(int userId, int productId);

	/**
	 * @param userId
	 * @param productId
	 * @return boolean
	 */
	public abstract boolean removeWishlist(int userId, int productId);
}
