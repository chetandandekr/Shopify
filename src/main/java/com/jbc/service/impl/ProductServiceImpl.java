package com.jbc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbc.dao.ProductDao;
import com.jbc.dao.impl.ProductDaoImpl;
import com.jbc.entity.ProductEntity;
import com.jbc.entity.ProductEntity;
import com.jbc.exception.ResourceAlreadyExistsException;
import com.jbc.exception.ResourceNotExistsException;
import com.jbc.model.ProductModel;
import com.jbc.model.ProductModel;
import com.jbc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public boolean addProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		ProductEntity productEntity = mapper.map(productModel, ProductEntity.class);
		boolean addProduct = dao.addProduct(productEntity);
		if (addProduct == true) {
			return addProduct;
		} else {
			throw new ResourceAlreadyExistsException("Product already exits" + " ");

		}

	}

	@Override
	public ProductModel getProductById(long productId) {
		// TODO Auto-generated method stub
		ProductEntity productEntity = dao.getProducutById(productId);

		if (productEntity != null) {
			ProductModel productModel = mapper.map(productEntity, ProductModel.class);
			return productModel;
		} else {
			throw new ResourceNotExistsException("Product not Exists:  " + productId);
		}

	}

	@Override
	public boolean deleteProductById(long productId) {
		// TODO Auto-generated method stub
		return dao.deleteProductById(productId);

	}

	@Override
	public boolean updateProduct(ProductModel productModel) {
		ProductEntity productEntity = mapper.map(productModel, ProductEntity.class);
		return dao.updateProduct(productEntity);
	}

	@Override
	public double getMaxPrice() {
		double maxProduct = dao.getMaxPrice();
		if (maxProduct > 0) {
			return maxProduct;
		} else {
			throw new ResourceNotExistsException("Product not Exists:  ");
		}

	}

	@Override
	public List<ProductModel> getAllProduct() {
		List<ProductEntity> allProduct = dao.getAllProduct();
		List<ProductModel> list = new ArrayList<>();

		if (!allProduct.isEmpty()) {
			for (ProductEntity productEntity : allProduct) {

				ProductModel productModel = mapper.map(productEntity, ProductModel.class);
				list.add(productModel);
			}
			return list;

		} else {
			throw new ResourceNotExistsException("Product not Exists:  ");
		}

	}

	@Override
	public List<ProductModel> getSortedProduct(String orderType, String properties) {
		List<ProductEntity> allProduct = dao.getSortedProduct(orderType, properties);
		List<ProductModel> list = new ArrayList<>();

		if (!allProduct.isEmpty()) {
			for (ProductEntity productEntity : allProduct) {

				ProductModel productModel = mapper.map(productEntity, ProductModel.class);
				list.add(productModel);
			}
			return list;

		} else {
			throw new ResourceNotExistsException("Product not Exists:  ");
		}

	}

	@Override
	public List<ProductModel> getMaxProduct() {
		// TODO Auto-generated method stub
		List<ProductEntity> maxProduct = dao.getMaxProduct();
		List<ProductModel> list = new ArrayList<>();

//		for (ProductEntity productEntity : maxProduct) {
//
//			ProductModel productModel = mapper.map(productEntity, ProductModel.class);
//			list.add(productModel);
//		}
          list= list.stream().map(productEntity->mapper.map(productEntity, ProductModel.class)).collect(Collectors.toList());
		return list;
	}

	@Override
	public ProductModel getProductByName(String productName) {
		// TODO Auto-generated method stub
		ProductEntity productEntity =dao.getProductByName(productName);
		ProductModel productModel = mapper.map(productEntity, ProductModel.class);
		
		return productModel;
	}

}
