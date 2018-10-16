/**
 * 
 */
package com.shop.mvc.restOut;

/**
 * @author Bhautik Bhanani
 *
 */
public class RestOutDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProductRestTemplate template = new ProductRestTemplate();
		System.out.println(template.getProductById(1234));
	}

}
