package com.inventory.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.product.entity.Inventory;
import com.inventory.product.exception.ProductDetailsInvalid;
import com.inventory.product.exception.ProductDoesNotExist;
import com.inventory.product.exception.ProductIDAlreadyExist;
import com.inventory.product.model.InventoryModel;
import com.inventory.product.service.InventoryService;

import jakarta.validation.Valid;

@RequestMapping("inventory")
@RestController
public class InventoryController {

	@Autowired
	private InventoryService service;

	@GetMapping("products")
	public List<Inventory> getAllproducts() {
		return service.getInventory();
	}

	@GetMapping("product/product-id/{productId}")
	public Inventory getProduct(@PathVariable("productId") int productId) {
		return service.getProduct(productId);
	}

	@PutMapping("product")
	public Inventory updateProductbyproductid(@Valid @RequestBody InventoryModel inventoryModel)
			throws ProductDoesNotExist, ProductDetailsInvalid {
		return service.updateProduct(inventoryModel);
	}

	@PostMapping("product")
	public ResponseEntity<Object> createProductbyproductid(@RequestBody InventoryModel inventoryModel)
			throws ProductIDAlreadyExist, ProductDetailsInvalid {
		
		service.createProduct(inventoryModel);
		return ResponseEntity.status(HttpStatus.CREATED).body("Product Created Successfully!");
	}

	@DeleteMapping("product/product-id/{productId}")
	public ResponseEntity<Object> deleteProductbyproductid(@PathVariable("productId") int productId)
			throws ProductDetailsInvalid {
		service.deleteProduct(productId);

		return ResponseEntity.ok("Product Deleted Successfully!");
	}
}
