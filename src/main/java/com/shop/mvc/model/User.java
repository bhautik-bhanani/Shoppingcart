/**
 * 
 */
package com.shop.mvc.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Bhautik Bhanani
 *
 */
@SuppressWarnings("serial")
@Entity
@XmlRootElement(name = "user")
@Table(name = "shopping_user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private int userId;
	@NotEmpty
	@Column(name = "username")
	private String username;
	@NotEmpty
	@Column(name = "password")
	private String password;
	@NotEmpty
	@Column(name = "full_name")
	private String full_name;
	@NotEmpty
	@Column(name = "address")
	private String address;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "shopping_wishlist", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "productId", referencedColumnName = "productId"))
	private Set<Product> wishlist;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the wishlist
	 */
	public Set<Product> getWishlist() {
		return wishlist;
	}

	/**
	 * @param wishlist
	 *            the wishlist to set
	 */
	public void setWishlist(Set<Product> wishlist) {
		this.wishlist = wishlist;
	}

	/**
	 * @return the full_name
	 */
	public String getFull_name() {
		return full_name;
	}

	/**
	 * @param full_name
	 *            the full_name to set
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", full_name="
				+ full_name + ", address=" + address + "]";
	}
}
