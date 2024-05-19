package com.jbc.conntroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbc.exception.ResourceNotExistsException;
import com.jbc.model.SupplierModel;
import com.jbc.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService service;
	// ADD Suplier

	@PostMapping("/add-supplier")
	public ResponseEntity<String> addSupplier(@RequestBody @Valid SupplierModel supplier) {
		System.out.println("done" + supplier);
		service.addSuplier(supplier);

		return ResponseEntity.ok("added!!");

	}

	@GetMapping("get-supplier-by-id/{supplierId}")
	public ResponseEntity<SupplierModel> getSupplierById(@PathVariable long supplierId) {

		SupplierModel supplierModel = service.getSupplierById(supplierId);

		return ResponseEntity.ok(supplierModel);
	}
    @DeleteMapping("delete-supplier-by-Id/{supplierId}")
	public ResponseEntity<String> deleteSupplierById(@PathVariable long supplierId){
		service.deleteSupplierById(supplierId);
		return ResponseEntity.ok("deleted completely!!");
	}
	
	@PutMapping("update-supplier")
	public ResponseEntity<String> updateSupplier(@RequestBody SupplierModel suppilerModel){
		boolean updateSupplierById = service.updateSupplierById(suppilerModel);
		if (updateSupplierById) {
			return ResponseEntity.ok("Updated successfully!!" + " "+ suppilerModel);
		} else {
			throw new ResourceNotExistsException("Supplier not exits"+" "+ suppilerModel);
		}
		
		
	}
	 
}
