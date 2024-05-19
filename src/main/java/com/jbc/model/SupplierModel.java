package com.jbc.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class SupplierModel {
	
	@Min(value=1, message = "invalid supplier id")
	private long supplierId;
	
	@NotBlank(message="Supplier Name Should Not Be Blank")
	private String supplierName;
	
	@NotBlank(message="City Name Should Not Be Blank")
	private String city;
	
	@Min(value = 100000,message="Invalid postal code")
	@Max(value = 999999,message="Invalid postal code")
	private int postalCode;
	
	@NotBlank(message="Country Name Should Not Be Blank")
	private String country;
	
	@NotBlank(message="Mobile Name Should Not Be Blank")
	private String mobile;
	
	public SupplierModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SupplierModel(long supplierId, String supplierName, String city, int postalCode, String country,
			String mobile) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.mobile = mobile;
	}
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "SupplierModel [supplierId=" + supplierId + ", supplierName=" + supplierName + ", city=" + city
				+ ", postalCode=" + postalCode + ", country=" + country + ", mobile=" + mobile + "]";
	}
	

}
