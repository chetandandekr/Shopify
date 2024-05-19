package com.jbc.dao;

import com.jbc.entity.CatagoryEntity;
import com.jbc.entity.SupplierEntity;

public interface CatagoryDao
{

	public boolean AddCatagory(CatagoryEntity catagoryEntity);

	

	public CatagoryEntity getCatagoryById(long catagoryId);



	public boolean deleteCatagoryById(long catagoryId);



	public boolean updateCatagory(CatagoryEntity catagoryEntity);

}
