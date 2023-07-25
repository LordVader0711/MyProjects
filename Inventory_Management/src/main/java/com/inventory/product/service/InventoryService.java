package com.inventory.product.service;

import java.util.List;

import com.inventory.product.entity.Inventory;
import com.inventory.product.exception.ProductDetailsInvalid;
import com.inventory.product.exception.ProductDoesNotExist;
import com.inventory.product.exception.ProductIDAlreadyExist;
import com.inventory.product.model.InventoryModel;

public interface InventoryService {

	List<Inventory> getInventory();

	Inventory getProduct(int productId);

	Inventory updateProduct(InventoryModel inventoryModel) throws ProductDoesNotExist, ProductDetailsInvalid;

	Inventory createProduct(InventoryModel inventoryModel) throws ProductIDAlreadyExist, ProductDetailsInvalid;

	void deleteProduct(int productId) throws ProductDetailsInvalid;
}
