package com.jbc.service;

import com.jbc.model.CatagoryModel;

public interface CatagoryService {
	public boolean addCatagory(CatagoryModel catagoryModel);

	public CatagoryModel getCatagoryById(long catagoryId);

	public boolean deleteCatagoryById(long catagoryId);

	public boolean updateCatagoryById(CatagoryModel catagoryModel);

}
