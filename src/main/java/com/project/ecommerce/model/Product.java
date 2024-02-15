package com.project.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_product")
public class Product {
    
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@Column(name = "product_name")
	private String productName ;
	
	@Column(name = "product_category")
	private String  productCategory;
	
	@Column(name = "product_price")
	private Double productPrice;
	
	@Column(name="product_stock")
    private Integer	productStock ;
	
	@Column(name = "product_description")
	private String productDescription ;
	
	@Column(name = "product_image")
	private String productImage;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	public Integer getProductStock() {
		return productStock;
	}
	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + ", productStock=" + productStock
				+ ", productDescription=" + productDescription + ", productImage=" + productImage + "]";
	}
	
	
}
