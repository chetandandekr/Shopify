package com.jbc.dao.impl;

import javax.persistence.RollbackException;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbc.dao.SupplierDao;
import com.jbc.entity.SupplierEntity;
import com.jbc.exception.ResourceAlreadyExistsException;
import com.jbc.exception.ResourceNotExistsException;
import com.jbc.exception.SomethingWentWrong;

@Repository
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	private SessionFactory sessionFactroy;

	@Override
	public  boolean AddSupplier(SupplierEntity supplierEntity) {
		// TODO Auto-generated method stub
		boolean isAdded= false;
		
	
		try {
			Session session = sessionFactroy.openSession();
			SupplierEntity supplier = getSupplierById(supplierEntity.getSupplierId());
			if (supplier==null) {
				session.save(supplierEntity);
				session.beginTransaction().commit();
				isAdded=true;
			} else {
				//throw new ResourceAlreadyExistsException("Supplier already exits"+ " " +supplier);
				isAdded=false;

			}
		}
			

//		catch ( Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			throw new SomethingWentWrong("somthing went wrong");
//		}
		finally {
			return isAdded;
		}
              
}

	

	@Override
	public SupplierEntity getSupplierById(long SupplierId) throws HibernateException{
		SupplierEntity supplierEntity=null;
		Session session=null;
		try {
			 
			 session = sessionFactroy.openSession();
			
			
		supplierEntity=session.get(SupplierEntity.class, SupplierId); }
			
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			throw new SomethingWentWrong("connection lost");
//		}
		finally {
			session.close();//resource clsed wich is use for memory,
			return supplierEntity;
		}
		
	}



	@Override
	public boolean deleteSupplierById (long supplierId) {
	      boolean isDeleted=false;
	      SupplierEntity supplierEntity=null;
		try {
			Session openSession = sessionFactroy.openSession();
			supplierEntity=openSession.get(SupplierEntity.class, supplierId);
			
			if (supplierEntity!=null) {
				openSession.delete(supplierEntity);
				openSession.beginTransaction().commit();
				isDeleted=true;
			} else {
              throw new ResourceNotExistsException("Supplier not exits"+" "+supplierId);
			}
			
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SomethingWentWrong("connection lost");
		}
		return isDeleted;
	}



	@Override
	public boolean updateSupplier(SupplierEntity supplierEntity) {
		 boolean isUpdate=false;
		 try {
				Session openSession = sessionFactroy.openSession();
				SupplierEntity supplier = getSupplierById(supplierEntity.getSupplierId());				
				if ( supplierEntity!=null) {
					openSession.update( supplierEntity);
					openSession.beginTransaction().commit();
					isUpdate=true;
				} else {
					 //throw new ResourceNotExistsException("Supplier not exits"+" "+supplierEntity);
	              isUpdate=false;
				}
				
			} catch (IllegalArgumentException e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new SomethingWentWrong("connection lost");
			}
		return isUpdate;
	}

	
}
