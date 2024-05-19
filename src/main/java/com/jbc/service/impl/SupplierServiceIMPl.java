package com.jbc.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.jbc.dao.SupplierDao;
import com.jbc.entity.SupplierEntity;
import com.jbc.exception.ResourceAlreadyExistsException;
import com.jbc.exception.ResourceNotExistsException;
import com.jbc.model.SupplierModel;
import com.jbc.service.SupplierService;

@Service
public class SupplierServiceIMPl implements SupplierService {

	@Autowired
	private SupplierDao dao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public boolean addSuplier(SupplierModel supplierModel) {
	
		SupplierEntity supplierEntity = mapper.map(supplierModel, SupplierEntity.class);
		boolean addSupplier = dao.AddSupplier(supplierEntity);     
		if (addSupplier==true) {
			return addSupplier;
		} else {
			throw new ResourceAlreadyExistsException("Supplier already exits"+ " ");

		}
		
	
	}

	@Override
	public SupplierModel getSupplierById( long supplierId) {
		SupplierEntity supplierEntity= dao.getSupplierById(supplierId);
		
		if (supplierEntity!=null) {
			SupplierModel supplierModel=mapper.map(supplierEntity,SupplierModel.class);
		  return supplierModel;
		}
		else {
			throw new ResourceNotExistsException("Supplier not Exists:  "+supplierId);
		}
		
		
	}

	@Override
	public boolean deleteSupplierById(long supplierId) {
		return  dao.deleteSupplierById(supplierId);
		 
}

	@Override
	public boolean updateSupplierById(SupplierModel supplierModel) {
		SupplierEntity supplierEntity = mapper.map(supplierModel, SupplierEntity.class);
		return dao.updateSupplier(supplierEntity);
	}
	

}
