/**
 * 
 */
package com.shop.mvc.rest;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.shop.mvc.services.UserService;

/**
 * @author Bhautik Bhanani
 *
 */
@Path("/user")
public class UserRestHandler {

	@Autowired
	UserService userService;
}
