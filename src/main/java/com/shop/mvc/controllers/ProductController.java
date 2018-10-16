package com.shop.mvc.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.mvc.model.Product;
import com.shop.mvc.model.User;
import com.shop.mvc.services.ProductService;
import com.shop.mvc.services.UserService;

/**
 * @author Bhautik Bhanani
 *
 */
@Controller
public class ProductController {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	@Qualifier("ProductServiceImpl")
	ProductService productService;
	@Autowired
	UserService userService;

	/**
	 * @param productId
	 * @param model
	 * @param request
	 * @return cart list
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addToCart/{productId}", method = RequestMethod.GET)
	public String addToCart(@PathVariable("productId") int productId, Model model, HttpServletRequest request) {
		Product product = productService.getProductById(productId);
		if (product != null) {
			User user = (User) request.getSession().getAttribute("loginUser");
			if (request.getSession().getAttribute("cart") != null) {
				Map<Integer, List<Product>> cart = (Map<Integer, List<Product>>) request.getSession()
						.getAttribute("cart");
				if (cart.containsKey(user.getUserId())) {
					for (Product p : cart.get(user.getUserId())) {
						if (p.getProductId() == productId) {
							return "redirect:/cartlist";
						}
					}
					cart.get(user.getUserId()).add(product);
				} else {
					List<Product> cartList = new ArrayList<Product>();
					cartList.add(product);
					cart.put(user.getUserId(), cartList);
				}
				request.getSession().setAttribute("cart", cart);
			} else {
				List<Product> cartList = new ArrayList<Product>();
				cartList.add(product);
				Map<Integer, List<Product>> cart = new HashMap<Integer, List<Product>>();
				cart.put(user.getUserId(), cartList);
				request.getSession().setAttribute("cart", cart);
			}
			return "redirect:/cartlist";
		} else {
			model.addAttribute("errorMsg", "Product is not available!!!");
			return "error";
		}
	}

	/**
	 * @param model
	 * @return cart list
	 */
	@RequestMapping(value = "/cartlist")
	public String cartList(Model model) {
		return "cart";
	}

	/**
	 * @param productId
	 * @param model
	 * @param request
	 * @return cart list
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/removecart/{productId}", method = RequestMethod.GET)
	public String removeCart(@PathVariable("productId") int productId, Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("loginUser");
		if (request.getSession().getAttribute("cart") != null) {
			Map<Integer, List<Product>> cart = (Map<Integer, List<Product>>) request.getSession().getAttribute("cart");
			if (cart.containsKey(user.getUserId())) {
				Iterator<Product> iterator = cart.get(user.getUserId()).iterator();
				while (iterator.hasNext()) {
					Product p = iterator.next();
					if (p.getProductId() == productId) {
						iterator.remove();
						break;
					}
				}
				request.getSession().setAttribute("cart", cart);
			}
		}
		return "redirect:/cartlist";
	}

	/**
	 * @param productId
	 * @param model
	 * @param request
	 * @return wishlist
	 */
	@RequestMapping(value = "/addToWishlist/{productId}", method = RequestMethod.GET)
	public String addToWishlist(@PathVariable("productId") int productId, Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("loginUser");
		if (userService.addWishlist(user.getUserId(), productId)) {
			return "redirect:/wishlist";
		}
		model.addAttribute("errorMsg", "Couldn't able to add to Wish List!!!");
		return "error";
	}

	/**
	 * @param model
	 * @param request
	 * @return wishlist
	 */
	@RequestMapping(value = "/wishlist")
	public String wishlist(Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("loginUser");
		Set<Product> wishlist = userService.getUserById(user.getUserId()).getWishlist();
		model.addAttribute("wishlist", wishlist);
		return "wishlist";
	}

	/**
	 * @param productId
	 * @param model
	 * @param request
	 * @return wishlist
	 */
	@RequestMapping(value = "/removewishlist/{productId}", method = RequestMethod.GET)
	public String removeWishlist(@PathVariable("productId") int productId, Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("loginUser");
		if (userService.removeWishlist(user.getUserId(), productId)) {
			return "redirect:/wishlist";
		}
		model.addAttribute("errorMsg", "Could not able to remove product from Wish List!!!s");
		return "error";
	}

	/**
	 * @param productId
	 * @param model
	 * @param request
	 * @return cartlist
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/movetocart/{productId}", method = RequestMethod.GET)
	public String moveToCart(@PathVariable("productId") int productId, Model model, HttpServletRequest request) {
		Product product = productService.getProductById(productId);
		if (product != null) {
			User user = (User) request.getSession().getAttribute("loginUser");
			if (request.getSession().getAttribute("cart") != null) {
				Map<Integer, List<Product>> cart = (Map<Integer, List<Product>>) request.getSession()
						.getAttribute("cart");
				if (cart.containsKey(user.getUserId())) {
					for (Product p : cart.get(user.getUserId())) {
						if (p.getProductId() == productId) {
							userService.removeWishlist(user.getUserId(), productId);
							return "redirect:/cartlist";
						}
					}
					cart.get(user.getUserId()).add(product);
				} else {
					List<Product> cartList = new ArrayList<Product>();
					cartList.add(product);
					cart.put(user.getUserId(), cartList);
				}
				userService.removeWishlist(user.getUserId(), productId);
				request.getSession().setAttribute("cart", cart);
			} else {
				List<Product> cartList = new ArrayList<Product>();
				cartList.add(product);
				Map<Integer, List<Product>> cart = new HashMap<Integer, List<Product>>();
				cart.put(user.getUserId(), cartList);
				userService.removeWishlist(user.getUserId(), productId);
				request.getSession().setAttribute("cart", cart);
			}
			return "redirect:/cartlist";
		} else {
			model.addAttribute("errorMsg", "Product is not available!!!");
			return "error";
		}
	}

	/**
	 * @param productId
	 * @param model
	 * @param request
	 * @return wishlist
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/movetowishlist/{productId}", method = RequestMethod.GET)
	public String moveToWishlist(@PathVariable("productId") int productId, Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("loginUser");
		if (request.getSession().getAttribute("cart") != null) {
			Map<Integer, List<Product>> cart = (Map<Integer, List<Product>>) request.getSession().getAttribute("cart");
			if (cart.containsKey(user.getUserId())) {
				Iterator<Product> iterator = cart.get(user.getUserId()).iterator();
				while (iterator.hasNext()) {
					Product p = iterator.next();
					if (p.getProductId() == productId) {
						iterator.remove();
						break;
					}
				}
				request.getSession().setAttribute("cart", cart);
				userService.addWishlist(user.getUserId(), productId);
				return "redirect:/wishlist";
			} else {
				model.addAttribute("errorMsg", "Your cart is empty!!!");
			}
		} else {
			model.addAttribute("errorMsg", "Your cart is empty!!!");
		}
		return "errror";
	}
}
