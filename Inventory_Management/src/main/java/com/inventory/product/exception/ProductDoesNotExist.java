package com.inventory.product.exception;

import com.inventory.product.constant.ExceptionMessageConstant;

public class ProductDoesNotExist extends Exception {
	private static final long serialVersionUID = 6581182517806939727L;

	public ProductDoesNotExist() {
		super(ExceptionMessageConstant.PRODUCT_DOES_NOT_EXIST);
	}

}
