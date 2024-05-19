package com.jbc.dao;

import org.hibernate.HibernateException;

import com.jbc.entity.SupplierEntity;

public interface SupplierDao  {

	public boolean AddSupplier(SupplierEntity supplierEntity) ;
 
	public  SupplierEntity getSupplierById(long SupplierId) throws HibernateException; ////IIIIMMMMPPPP example

	public boolean deleteSupplierById (long supplierId);
	
	public boolean updateSupplier(SupplierEntity supplierEntity);
}
