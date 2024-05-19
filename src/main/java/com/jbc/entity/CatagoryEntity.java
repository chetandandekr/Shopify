package com.jbc.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="category")
public class CatagoryEntity {
	@Id
	@Column(unique = true,nullable=false)
	private long categoryID;
	private String categoryName;
	private String description;
	private int discount;
	private int gst;
	public CatagoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CatagoryEntity(long categoryID, String categoryName, String description, int discount, int gst) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.description = description;
		this.discount = discount;
		this.gst = gst;
	}
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getGst() {
		return gst;
	}
	public void setGst(int gst) {
		this.gst = gst;
	}
	@Override
	public String toString() {
		return "CatagoryModel [categoryID=" + categoryID + ", categoryName=" + categoryName + ", description="
				+ description + ", discount=" + discount + ", gst=" + gst + "]";
	}
	
	

}
