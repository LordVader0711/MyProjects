package com.inventory.product.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", updatable = false)
	private int productId;

	@Column(name = "product_name", nullable = false, updatable = false)
	private String productName;

	@Column(name = "model_name")
	private String modelName;

	@Column(name = "price")
	private Double price;

	@Column(name = "gst", nullable = false)
	private Float gst;

	@Column(name = "inventory_stock", nullable = false)
	private Integer inventoryStock;

	@Column(name = "updated_on", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	@Column(name = "created_on", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
}
