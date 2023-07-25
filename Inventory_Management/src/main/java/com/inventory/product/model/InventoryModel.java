package com.inventory.product.model;

import java.util.Date;

import lombok.Data;

@Data
public class InventoryModel {

	private int productId;

	private String productName;

	private String modelName;
	
	private Double price;

	private Float gst;

	private Integer inventoryStock;

	private Date updatedOn;

	private Date createdOn;
}
