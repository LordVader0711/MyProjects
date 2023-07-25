package com.inventory.product.exception;

import com.inventory.product.constant.ExceptionMessageConstant;

public class ProductIDAlreadyExist extends Exception {

	private static final long serialVersionUID = 8622089666066350489L;

	public ProductIDAlreadyExist() {
		super(ExceptionMessageConstant.PRODUCT_ALREADY_EXIST);
	}
}
