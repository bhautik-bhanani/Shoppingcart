/**
 * 
 */
package com.shop.mvc.services;

import java.util.List;

import com.shop.mvc.model.Product;

/**
 * @author Bhautik Bhanani
 *
 */
public interface ProductService {

	/**
	 * @return product list
	 */
	public abstract List<Product> getProductList();

	/**
	 * @param productId
	 * @return product
	 */
	public abstract Product getProductById(int productId);
}
