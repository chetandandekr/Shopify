package com.jbc.service;

import com.jbc.model.SupplierModel;

public interface SupplierService {

	public boolean addSuplier(SupplierModel supplierModel);
	
    public SupplierModel getSupplierById(long supplierId);
    
	public boolean deleteSupplierById(long supplierId);
	
	public boolean updateSupplierById(SupplierModel supplierModel);
}
