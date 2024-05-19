package com.jbc.conntroller;


import javax.validation.Valid;

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
import com.jbc.model.CatagoryModel;
import com.jbc.model.SupplierModel;
import com.jbc.service.CatagoryService;
import com.jbc.service.SupplierService;

@RestController
@RequestMapping("catagory")
public class CatagoryController {
	
	@Autowired
	private CatagoryService service;
	// ADD Suplier

	@PostMapping("/add-Catagory")
	public ResponseEntity<String> addSupplier(@RequestBody @Valid CatagoryModel catagory) {
		System.out.println("done" + catagory);
		service.addCatagory(catagory);

		return ResponseEntity.ok("added!!");

	}

	@GetMapping("get-catagory-by-id/{catagoryId}")
	public ResponseEntity<CatagoryModel> getCatagoryById(@PathVariable long catagoryId) {

		CatagoryModel catagoryModel = service.getCatagoryById(catagoryId);

		return ResponseEntity.ok(catagoryModel);
	}
    @DeleteMapping("delete-catagory-by-Id/{catagoryId}")
	public ResponseEntity<String> deleteCatagoryById(@PathVariable long catagoryId){
		service.deleteCatagoryById(catagoryId);
		return ResponseEntity.ok("deleted completely!!");
	}
	
	@PutMapping("update-catagory")
	public ResponseEntity<String> updateCatagory(@RequestBody CatagoryModel catagoryModel){
		boolean updateCatagoryById = service.updateCatagoryById(catagoryModel);
		if (updateCatagoryById) {
			return ResponseEntity.ok("Updated successfully!!" + " "+ catagoryModel);
		} else {
			throw new ResourceNotExistsException("Supplier not exits"+" "+ catagoryModel);
		}
		
		
	}

}
