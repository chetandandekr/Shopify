package com.jbc.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductModel {
    @NotNull @NotEmpty @Min (value = 0)
	private long productcatagory;
	@NotBlank (message = "Product not be be blank")
	private String productName;
	@Min(value = 0)
	private SupplierModel supplier;
	
	@Min(value = 0)
	
	private CatagoryModel catagory;
	
	@Min(value = 0)
	private int productQty;
	
	@Min(value = 0)
	private double productPrice;
	
	@Min(value = 0)
	private int deliveryCharges;
	
	
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public ProductModel(@NotNull @NotEmpty @Min(1) long productcatagory,
			@NotBlank(message = "Product not be be blank") String productName, @Min(1) SupplierModel supplierID,
			@Min(1) CatagoryModel catagory, @Min(1) int productQty, @Min(0) double productPrice,
			@Min(0) int deliveryCharges) {
		super();
		this.productcatagory = productcatagory;
		this.productName = productName;
		this.supplier = supplierID;
		this.catagory = catagory;
		this.productQty = productQty;
		this.productPrice = productPrice;
		this.deliveryCharges = deliveryCharges;
	}




	public long getProductcatagory() {
		return productcatagory;
	}


	public void setProductcatagory(long productcatagory) {
		this.productcatagory = productcatagory;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}



	public SupplierModel getSupplierID() {
		return supplier;
	}




	public void setSupplierID(SupplierModel supplierID) {
		this.supplier = supplierID;
	}




	public CatagoryModel getCategorycatagory() {
		return catagory;
	}




	public void setCategorycatagory(CatagoryModel catagory) {
		this.catagory = catagory;
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
		return "Product [productcatagory=" + productcatagory + ", productName=" + productName + ", supplierID=" + supplier
				+ ", catagory=" + catagory + ", productQty=" + productQty + ", productPrice=" + productPrice
				+ ", deliveryCharges=" + deliveryCharges + "]";
	}
	
	
	
}
