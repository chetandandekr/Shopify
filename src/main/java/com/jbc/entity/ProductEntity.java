package com.jbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="product")
public class ProductEntity {
    @Id
	private long productId;
    
    
	@Column(unique = true,nullable=false)
	private String productName;
	
	@OneToOne
	@JoinColumn(name="supplier_id")
	private SupplierEntity supplier;
	
	
	 @OneToOne
	 @JoinColumn(name="categpory_id")
	private CatagoryEntity category;
	
	
	private int productQty;
	
	
	private double productPrice;
	
	private int deliveryCharges;
	
	
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public ProductEntity(@NotNull @NotEmpty @Min(1) long productId,
			@NotBlank(message = "Product not be be blank") String productName, @Min(1) SupplierEntity supplierID,
			@Min(1) CatagoryEntity categoryId, @Min(1) int productQty, @Min(0) double productPrice,
			@Min(0) int deliveryCharges) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplier = supplierID;
		this.category = categoryId;
		this.productQty = productQty;
		this.productPrice = productPrice;
		this.deliveryCharges = deliveryCharges;
	}




	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}



	public SupplierEntity getSupplierID() {
		return supplier;
	}




	public void setSupplierID(SupplierEntity supplierID) {
		this.supplier = supplierID;
	}




	public CatagoryEntity getCategoryId() {
		return category;
	}




	public void setCategoryId(CatagoryEntity categoryId) {
		this.category = categoryId;
	}




	public int getProductQty() {
		return productQty;
	}


	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public int getDeliveryCharges() {
		return deliveryCharges;
	}


	public void setDeliveryCharges(int deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplierID=" + supplier
				+ ", categoryId=" + category + ", productQty=" + productQty + ", productPrice=" + productPrice
				+ ", deliveryCharges=" + deliveryCharges + "]";
	}
	
	
	
}
