/**
 * 
 */
package com.shop.mvc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.mvc.dao.ProductDAO;
import com.shop.mvc.model.Product;
import com.shop.mvc.services.ProductService;

/**
 * @author Bhautik Bhanani
 *
 */
@Service(value = "ProductServiceImpl")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	@Qualifier("ProductDAOImpl")
	ProductDAO productDAO;

	/**
	 * @param productDAO
	 */
	// public void setProductDAO(ProductDAO productDAO) {
	// this.productDAO = productDAO;
	// }

	/**
	 * @return product list
	 */
	@Override
	public List<Product> getProductList() {
		return productDAO.getProductList();
	}

	@Override
	public Product getProductById(int productId) {
		return productDAO.getProductById(productId);
	}
}
