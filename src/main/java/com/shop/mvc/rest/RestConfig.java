/**
 * 
 */
package com.shop.mvc.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Bhautik Bhanani
 *
 */
@ApplicationPath("/")
public class RestConfig extends Application {
	private Set<Class<?>> restClasses = new HashSet<Class<?>>();

	/**
	 * constructor
	 */
	public RestConfig() {
		restClasses.add(ProductRestHadler.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return this.restClasses;
	}
}
