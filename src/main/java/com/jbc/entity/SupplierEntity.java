package com.jbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name= "supplier")
public class SupplierEntity {
	
	@Id
	@Column(unique = true,nullable=false)
	
	private long supplierId;
	
	@Pattern(regexp="^[a-zA-Z ]+$",message ="should not content any no" )
	@NotEmpty(message="supplier name should not be blank")
	@NotBlank(message="supplier name should not be blank")
	private String supplierName;

	@NotNull(message="supplier name should not be blank")
	@NotBlank(message="supplier name should not be blank")
	private String city;
	
	private int postalCode;
	
	private String country;
	
	@Size(min = 10 ,max = 10 , message="mobile no. should be 10digit")
	@Pattern(regexp="^[0-9]+$",message ="should not content any no" )
	@Column(unique = true,nullable=false)
	private String mobile;
	
	public SupplierEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SupplierEntity(long supplierId, String supplierName, String city, int postalCode, String country,
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
	

}
