package com.inventory.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inventory.product.entity.Inventory;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

}
