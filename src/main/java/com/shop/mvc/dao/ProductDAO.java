package com.shop.mvc.dao;

import java.util.List;

import com.shop.mvc.model.Product;

/**
 * @author Bhautik Bhanani
 *
 */
public interface ProductDAO {
	/**
	 * @param productId
	 * @return product
	 */
	public abstract Product getProductById(int productId);

	/**
	 * @return product list
	 */
	public abstract List<Product> getProductList();

	/**
	 * @param product
	 * @return boolean added
	 */
	public abstract boolean addProduct(Product product);

	/**
	 * @param product
	 * @param productId
	 * @return product updated
	 */
	public abstract Product updateProduct(Product product, int productId);

	/**
	 * @param productId
	 * @return boolean deleted
	 */
	public abstract boolean removeProduct(int productId);
}
