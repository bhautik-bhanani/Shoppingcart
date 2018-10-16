/**
 * 
 */
package com.shop.mvc.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.shop.mvc.model.Product;
import com.shop.mvc.services.ProductService;

/**
 * @author Bhautik Bhanani
 *
 */
@Path("/product")
public class ProductRestHadler {

	@Autowired
	@Qualifier("ProductServiceImpl")
	ProductService productService;

	/**
	 * @return product list
	 */
	@GET
	@Path("/all")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Product> getProducts() {
		return this.productService.getProductList();
	}

	/**
	 * @param id
	 * @return product
	 */
	@GET
	@Path("/p/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Product getProductById(@PathParam("id") int id) {
		return this.productService.getProductById(id);
	}
}
