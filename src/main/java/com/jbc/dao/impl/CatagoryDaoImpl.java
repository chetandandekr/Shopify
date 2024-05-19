package com.jbc.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbc.dao.CatagoryDao;
import com.jbc.entity.CatagoryEntity;
import com.jbc.entity.SupplierEntity;
import com.jbc.exception.ResourceNotExistsException;
import com.jbc.exception.SomethingWentWrong;

@Repository
public class CatagoryDaoImpl implements CatagoryDao {

	@Autowired
	private SessionFactory sessionFactroy;
	@Override
	public boolean AddCatagory(CatagoryEntity catagoryEntity) {
		// TODO Auto-generated method stub
		boolean isAdded= false;
		
		
		try {
			Session session = sessionFactroy.openSession();
			CatagoryEntity catagory = getCatagoryById(catagoryEntity.getCategoryID());
			if (catagory==null) {
				session.save(catagoryEntity);
				session.beginTransaction().commit();
				isAdded=true;
			} else {
				//throw new ResourceAlreadyExistsException("Supplier already exits"+ " " +supplier);
				isAdded=false;

			}
		}finally {
			return isAdded;
		}
          
		
	}

	@Override
	public CatagoryEntity getCatagoryById(long catagoryId) throws NullPointerException {
		// TODO Auto-generated method stub
		CatagoryEntity catagoryEntity=null;
		Session session=null;
		try {
			 
			 session = sessionFactroy.openSession();
			
			
			 catagoryEntity=session.get(CatagoryEntity.class, catagoryId);
		}
		finally {
			session.close();//resource clsed wich is use for memory,
			return catagoryEntity;
		}
		
		
	}

	@Override
	public boolean deleteCatagoryById(long catagoryId) {
		// TODO Auto-generated method stub
		boolean isDeleted=false;
		CatagoryEntity catagoryEntity=null;
		try {
			Session openSession = sessionFactroy.openSession();
			catagoryEntity=openSession.get(CatagoryEntity.class, catagoryId);
			
			if (catagoryEntity!=null) {
				openSession.delete(catagoryEntity);
				openSession.beginTransaction().commit();
				isDeleted=true;
			} else {
            throw new ResourceNotExistsException("Supplier not exits"+" "+catagoryId);
			}
			
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SomethingWentWrong("connection lost");
		}
		return isDeleted;
		
	}

	@Override
	public boolean updateCatagory(CatagoryEntity catagoryEntity) {
		// TODO Auto-generated method stub
		 boolean isUpdate=false;
		 try {
				Session openSession = sessionFactroy.openSession();
				CatagoryEntity catagory = getCatagoryById(catagoryEntity.getCategoryID());				
				if (catagoryEntity!=null) {
					openSession.update(catagoryEntity);
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
