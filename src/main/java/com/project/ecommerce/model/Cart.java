package com.project.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private Integer cartId;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="product_quantity")
	private Integer productQuantity;

	

	public Integer getCartId() {
		return cartId;
	}



	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Integer getProductQuantity() {
		return productQuantity;
	}



	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}



	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", product=" + product + ", user=" + user + ", productQuantity="
				+ productQuantity + "]";
	}

}