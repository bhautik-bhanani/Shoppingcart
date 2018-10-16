/**
 * 
 */
package com.shop.mvc.restOut;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.shop.mvc.model.Product;

/**
 * @author Bhautik Bhanani
 *
 */
public class ProductRestTemplate {

	RestTemplate restTemplate = new RestTemplate();
	final String REQUEST_URL = "http://localhost:8080/cart/rest/product";

	/**
	 * @return product list
	 */
	public List<Product> getAllProducts() {
		ResponseEntity<Product[]> list = restTemplate.getForEntity(REQUEST_URL + "/all", Product[].class);
		return Arrays.asList(list.getBody());
	}

	/**
	 * @param id
	 * @return product
	 */
	public Product getProductById(int id) {
		Product product = restTemplate.getForObject(REQUEST_URL + "/p/" + id, Product.class);
		return product;
	}
}
