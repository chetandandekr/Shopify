package com.jbc.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbc.dao.CatagoryDao;
import com.jbc.entity.CatagoryEntity;
import com.jbc.entity.SupplierEntity;
import com.jbc.exception.ResourceAlreadyExistsException;
import com.jbc.exception.ResourceNotExistsException;
import com.jbc.model.CatagoryModel;
import com.jbc.model.SupplierModel;
import com.jbc.service.CatagoryService;

@Service
public class CatagoryServiceImpl implements CatagoryService {
	
	@Autowired
	private CatagoryDao dao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public boolean addCatagory(CatagoryModel catagoryModel) {
		// TODO Auto-generated method stub
		CatagoryEntity catagoryEntity = mapper.map(catagoryModel, CatagoryEntity.class);
		boolean addCatagory = dao.AddCatagory(catagoryEntity);     
		if (addCatagory==true) {
			return addCatagory;
		} else {
			throw new ResourceAlreadyExistsException("Catagory already exits"+ " ");

		}
		
		
	}

	@Override
	public CatagoryModel getCatagoryById(long catagoryId) {
		// TODO Auto-generated method stub
	CatagoryEntity catagoryEntity= dao.getCatagoryById(catagoryId);
		
		if (catagoryEntity!=null) {
			CatagoryModel catagoryModel=mapper.map(catagoryEntity,CatagoryModel.class);
		  return catagoryModel;
		}
		else {
			throw new ResourceNotExistsException("Catagory not Exists:  "+catagoryId);
		}
		
		
		
	}

	@Override
	public boolean deleteCatagoryById(long catagoryId) {
		// TODO Auto-generated method stub
		return  dao.deleteCatagoryById(catagoryId);
		
	}

	@Override
	public boolean updateCatagoryById(CatagoryModel catagoryModel) {
		// TODO Auto-generated method stub
		CatagoryEntity catagoryEntity = mapper.map(catagoryModel, CatagoryEntity.class);
		return dao.updateCatagory(catagoryEntity);
		
	}

	
}
