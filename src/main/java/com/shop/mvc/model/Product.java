/**
 * 
 */
package com.shop.mvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Bhautik Bhanani
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "shopping_product")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private int productId;
	@NotEmpty
	@Column(name = "productName")
	private String productName;
	@NotEmpty
	@Column(name = "productType")
	private String productType;
	@NotEmpty
	@Column(name = "productDesc")
	private String productDesc;
	@NotEmpty
	@Column(name = "productImg")
	private String productImg;
	@NotEmpty
	@Column(name = "productPrice")
	private double productPrice;
	// @ManyToOne
	// @JoinTable(name = "shopping_wishlist", joinColumns = @JoinColumn(name =
	// "productId", referencedColumnName = "productId"), inverseJoinColumns =
	// @JoinColumn(name = "userId", referencedColumnName = "userId"))
	// private User user;

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType
	 *            the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}

	/**
	 * @param productDesc
	 *            the productDesc to set
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	/**
	 * @return the productImg
	 */
	public String getProductImg() {
		return productImg;
	}

	/**
	 * @param productImg
	 *            the productImg to set
	 */
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 *            the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the user
	 */
	// public User getUser() {
	// return user;
	// }

	/**
	 * @param user
	 *            the user to set
	 */
	// public void setUser(User user) {
	// this.user = user;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", productDesc=" + productDesc + ", productImg=" + productImg + ", productPrice=" + productPrice
				+ "]";
	}
}
