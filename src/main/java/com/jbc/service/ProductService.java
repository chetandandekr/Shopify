package com.jbc.service;

import java.util.List;

import com.jbc.entity.ProductEntity;
import com.jbc.model.ProductModel;

public interface ProductService {

	public boolean addProduct(ProductModel product);

	public ProductModel getProductById(long productId);

	public boolean deleteProductById(long productId);

	public boolean updateProduct(ProductModel product);

	public double getMaxPrice();
	
	public List<ProductModel> getAllProduct();
	
	public List<ProductModel> getSortedProduct(String orderType,String properties) ;
	
	public  List<ProductModel> getMaxProduct();
	
	public ProductModel getProductByName(String productName);

}
