package com.jbc.conntroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jbc.exception.ResourceAlreadyExistsException;
import com.jbc.exception.ResourceNotExistsException;
import com.jbc.model.ProductModel;
import com.jbc.model.ProductModel;
import com.jbc.service.ProductService;
import com.jbc.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("Product")
public class ProductController {
	
@Autowired
	private ProductService service;

	@PostMapping("/add-product")
	public ResponseEntity<String> addProduct(@RequestBody @Valid ProductModel product)
	{ System.out.println("done" + product);
	  service.addProduct(product);

	   return ResponseEntity.ok("added!!");
		
    }
	
	@GetMapping("get-product-by-id/{productId}")
	public ResponseEntity<ProductModel> getProductById(@PathVariable long productId) {

		ProductModel productModel = service.getProductById(productId);

		return ResponseEntity.ok(productModel);
	}
	 @DeleteMapping("delete-product-by-Id/{productId}")
		public ResponseEntity<String> deleteProductById(@PathVariable long productId){
			service.deleteProductById(productId);
			return ResponseEntity.ok("deleted completely!!");
		}

		@PutMapping("update-product")
		public ResponseEntity<String> updateProduct(@RequestBody ProductModel suppilerModel){
			boolean updateProductById = service.updateProduct(suppilerModel);
			if (updateProductById) {
				return ResponseEntity.ok("Updated successfully!!" + " "+ suppilerModel);
			} else {
				throw new ResourceNotExistsException("Product not exits"+" "+ suppilerModel);
			}
			
			
		}
		
		@GetMapping("get-all-Product")
		public ResponseEntity<List<ProductModel>> getAllProduct(){
			
			return ResponseEntity.ok(service.getAllProduct());
		}

		@GetMapping("get-sort-product")
		public ResponseEntity<List<ProductModel>> getSortedProduct(@RequestParam String orderType,@RequestParam  String proprties){
			
			return ResponseEntity.ok(service.getSortedProduct(orderType,proprties));
		}
		@GetMapping("get-max-price")
	 public ResponseEntity<Double> getMaxPrice(){
		 return ResponseEntity.ok(service.getMaxPrice());
		 
	 }
		@GetMapping("get-max-product")
		 public ResponseEntity<List<ProductModel>> getMaxProduct(){
			 return ResponseEntity.ok(service.getMaxProduct());
			 
		 }
		@GetMapping("get-product-by-name")
		 public ResponseEntity<ProductModel> getProductByName(@PathVariable String productName){
			 return ResponseEntity.ok(service.getProductByName(productName));
			 
		 }
	 @PostMapping("upload_file")
	 public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		 return null;
	 }
}