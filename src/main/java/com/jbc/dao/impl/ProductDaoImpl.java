package com.jbc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.AggregateProjection;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbc.dao.ProductDao;
import com.jbc.entity.ProductEntity;
import com.jbc.entity.ProductEntity;
import com.jbc.exception.ResourceNotExistsException;
import com.jbc.exception.SomethingWentWrong;
import com.jbc.entity.ProductEntity;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactroy;

	@Override
	public boolean addProduct(ProductEntity productEntity) {

		// TODO Auto-generated method stub
		boolean isAdded = false;

		try {
			Session session = sessionFactroy.openSession();
			ProductEntity product = getProducutById(productEntity.getProductId());
			if (product == null) {
				session.save(productEntity);
				session.beginTransaction().commit();
				isAdded = true;
			} else {
				// throw new ResourceAlreadyExistsException("Product already exits"+ " "
				// +product);
				isAdded = false;

			}
		}

//			catch ( Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				throw new SomethingWentWrong("somthing went wrong");
//			}
		finally {
			return isAdded;
		}

	}

	@Override
	public ProductEntity getProducutById(long productId) {
		// TODO Auto-generated method stub
		ProductEntity productEntity = null;
		Session session = null;
		try {

			session = sessionFactroy.openSession();

			productEntity = session.get(ProductEntity.class, productId);
		}

//		} catch (HibernateException e) {
//			// TODO: handle exception
//			throw new SomethingWentWrong("connection lost");
//		}
		finally {
			session.close();// resource clsed wich is use for memory,
			return productEntity;
		}

	}

	@Override
	public boolean deleteProductById(long productId) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		ProductEntity productEntity = null;
		try {
			Session openSession = sessionFactroy.openSession();
			productEntity = openSession.get(ProductEntity.class, productId);

			if (productEntity != null) {
				openSession.delete(productEntity);
				openSession.beginTransaction().commit();
				isDeleted = true;
			} else {
				throw new ResourceNotExistsException("Product not exits" + " " + productId);
			}

		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SomethingWentWrong("connection lost");
		}
		return isDeleted;

	}

	@Override
	public boolean updateProduct(ProductEntity productEntity) {
		// TODO Auto-generated method stub
		boolean isUpdate = false;
		try {
			Session openSession = sessionFactroy.openSession();
			ProductEntity product = getProducutById(productEntity.getProductId());
			if (productEntity != null) {
				openSession.update(productEntity);
				openSession.beginTransaction().commit();
				isUpdate = true;
			} else {
				// throw new ResourceNotExistsException("Product not exits"+" "+productEntity);
				isUpdate = false;
			}

		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SomethingWentWrong("connection lost");
		}
		return isUpdate;
	}

	@Override
	public double getMaxPrice() {
		// TODO Auto-generated method stub
		double maxPrice = 0;

		try {
			Session openSession = sessionFactroy.openSession();
			Criteria criteria = openSession.createCriteria(ProductEntity.class);
		AggregateProjection	productPriceProjection = Projections.max("productPrice");
		criteria.setProjection(productPriceProjection);
        List list= criteria.list(); 
        if (!list.isEmpty()) {
        	 maxPrice =(double)list.get(0);
		}
        
       
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return  maxPrice;
	}

	@Override
	public List<ProductEntity> getAllProduct() {
		List<ProductEntity> list = null;
		try {

			Session openSession = sessionFactroy.openSession();
			Criteria criteria = openSession.createCriteria(ProductEntity.class);
			// criteria.addOrder(Order.asc("productPrice")); for asending order
			list = criteria.list();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductEntity> getSortedProduct(String orderType, String properties) {

		List<ProductEntity> list = null;
		try {

			Session openSession = sessionFactroy.openSession();
			Criteria criteria = openSession.createCriteria(ProductEntity.class);
			if (!orderType.equalsIgnoreCase("desc")) {
				criteria.addOrder(Order.asc(properties));
			} else {
				criteria.addOrder(Order.desc(properties));
			}
			// criteria.addOrder(Order.asc("productPrice")); for asending order
			list = criteria.list();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductEntity> getMaxProduct() {
		double maxPrice = getMaxPrice();
		List list =null;
		if(maxPrice>0) {
			Session openSession = sessionFactroy.openSession();
			Criteria criteria = openSession.createCriteria(ProductEntity.class);
			criteria.add(Restrictions.eq("productPrice", maxPrice));
			list = criteria.list();
		}else {
			throw new ResourceNotExistsException("Product not exits");
		}
		return list;
	}

	@Override
	public ProductEntity getProductByName(String productName) {
		// TODO Auto-generated method stub
		
		List<ProductEntity> list = null;
		ProductEntity productEntity=null;
		try {
			Session openSession = sessionFactroy.openSession();
			Query<ProductEntity> query = openSession.createQuery("FROM ProductEntity WHERE ProductName=:name");
			query.setParameter("name",productName);
			list=query.list();
			if (!list.isEmpty()) {
				 productEntity = list.get(0);
			} else {
				throw new ResourceNotExistsException("Product not exits");
			}
			
			} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
				
		}
		return  productEntity;
	}

}
