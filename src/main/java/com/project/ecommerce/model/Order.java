package com.project.ecommerce.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer OrderId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_category")
	private String productCategory;
	
	@Column(name = "product_price")
	private Double productPrice;
	
	@Column(name = "product_image")
	private String productImage;
	
	@Column(name = "product_quantity")
	private Integer productQuantity;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@CreationTimestamp
	@Column(name = "order_date")
	private LocalDateTime orderDate;
	
	@UpdateTimestamp
	@Column(name = "cancel_date")
	private LocalDateTime cancelDate;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	@Column(name = "payment_mode")
	private String paymentMode;

	@Column(name="user_name")
	private String orderUserName;
	
	@Column(name = "user_email")
	private String orderUserEmail;
	
	@Column(name = "user_phone")
	private String orderUserPhone;
	
	@Column(name = "order_address")
	private String orderAddress;
	
	
	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDateTime getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(LocalDateTime cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getOrderUserName() {
		return orderUserName;
	}

	public void setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
	}

	public String getOrderUserEmail() {
		return orderUserEmail;
	}

	public void setOrderUserEmail(String orderUserEmail) {
		this.orderUserEmail = orderUserEmail;
	}

	public String getOrderUserPhone() {
		return orderUserPhone;
	}

	public void setOrderUserPhone(String orderUserPhone) {
		this.orderUserPhone = orderUserPhone;
	}

	@Override
	public String toString() {
		return "Order [OrderId=" + OrderId + ", productName=" + productName + ", productCategory=" + productCategory
				+ ", productPrice=" + productPrice + ", productImage=" + productImage + ", productQuantity="
				+ productQuantity + ", user=" + user + ", orderDate=" + orderDate + ", cancelDate=" + cancelDate
				+ ", orderStatus=" + orderStatus + ", paymentMode=" + paymentMode + ", orderUserName=" + orderUserName
				+ ", orderUserEmail=" + orderUserEmail + ", orderUserPhone=" + orderUserPhone + ", orderAddress="
				+ orderAddress + "]";
	}
	
	 
}
