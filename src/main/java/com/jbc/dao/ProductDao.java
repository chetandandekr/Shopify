package com.jbc.dao;

import java.util.List;

import com.jbc.entity.ProductEntity;



public interface ProductDao {

	public boolean addProduct(ProductEntity productEntity);
	
	public ProductEntity getProducutById(long productId);
	
    public boolean deleteProductById(long productId);
    
    public boolean updateProduct(ProductEntity productEntity);
    
	public double getMaxPrice();
	
	public List<ProductEntity> getAllProduct() ;
	
	public List<ProductEntity> getSortedProduct(String orderType,String properties) ;
	
	public List<ProductEntity> getMaxProduct();
	
	public ProductEntity getProductByName(String productName);
	
} 
