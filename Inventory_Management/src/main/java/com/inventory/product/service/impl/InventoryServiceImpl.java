package com.inventory.product.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.entity.Inventory;
import com.inventory.product.exception.ProductDetailsInvalid;
import com.inventory.product.exception.ProductDoesNotExist;
import com.inventory.product.exception.ProductIDAlreadyExist;
import com.inventory.product.model.InventoryModel;
import com.inventory.product.repository.InventoryRepository;
import com.inventory.product.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository repository;

	private DozerBeanMapper mapper = new DozerBeanMapper();

	@Override
	public List<Inventory> getInventory() {
		return (List<Inventory>) repository.findAll();
	}

	@Override
	public Inventory getProduct(int productId) {
		Optional<Inventory> product = repository.findById(productId);
		return product.orElse(new Inventory());
	}

	@Override
	public Inventory updateProduct(InventoryModel inventoryModel) throws ProductDoesNotExist, ProductDetailsInvalid {

		if (Objects.nonNull(inventoryModel)) {

			boolean existsByproductid = repository.existsById(inventoryModel.getProductId());

			if (existsByproductid) {
				Inventory inventory = mapper.map(inventoryModel, Inventory.class);

				System.out.println("Mapped Entity: " + inventory);
				return repository.save(inventory);
			}

			throw new ProductDoesNotExist();

		}

		throw new ProductDetailsInvalid();
	}

	@Override
	public Inventory createProduct(InventoryModel inventoryModel) throws ProductIDAlreadyExist, ProductDetailsInvalid {

		if (Objects.nonNull(inventoryModel)) {

			boolean existsByproductid = repository.existsById(inventoryModel.getProductId());

			if (!existsByproductid) {
				Inventory inventory = mapper.map(inventoryModel, Inventory.class);
				return repository.save(inventory);
			}

			throw new ProductIDAlreadyExist();

		}

		throw new ProductDetailsInvalid();
	}

	@Override
	public void deleteProduct(int productId) throws ProductDetailsInvalid {
		repository.deleteById(productId);
	}

}
