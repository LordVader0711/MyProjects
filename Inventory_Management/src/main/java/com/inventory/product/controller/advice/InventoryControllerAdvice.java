package com.inventory.product.controller.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import com.inventory.product.constant.ExceptionMessageConstant;
import com.inventory.product.exception.ProductDetailsInvalid;
import com.inventory.product.exception.ProductDoesNotExist;
import com.inventory.product.exception.ProductIDAlreadyExist;

@RestControllerAdvice
public class InventoryControllerAdvice {

	private static final Logger LOGGER = LogManager.getLogger(InventoryControllerAdvice.class);

	@ExceptionHandler({ ProductDoesNotExist.class })
	public void handleProductDoesnotExist(ProductDoesNotExist e, WebRequest request) {
		LOGGER.error("Product Does Not Exist: {}, With Request Parameters: {}", e, request);
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ExceptionMessageConstant.PRODUCT_DOES_NOT_EXIST, e);
	}

	@ExceptionHandler({ ProductIDAlreadyExist.class })
	public void handleProductAlreadyExists(ProductIDAlreadyExist e, WebRequest request) {
		LOGGER.error("Product Already Exist: {}, With Request Parameters: {}", e, request);
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ExceptionMessageConstant.PRODUCT_ALREADY_EXIST, e);
	}

	@ExceptionHandler({ ProductDetailsInvalid.class })
	public void handleInvalidProductDetails(ProductDetailsInvalid e, WebRequest request) {
		LOGGER.error("Invalid Product Details: {}, With Request Parameters: {}", e, request);
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ExceptionMessageConstant.INVALID_PRODUCT_DETAILS, e);
	}

	@ExceptionHandler({ Exception.class })
	public void handleExceptions(Exception e, WebRequest request) {
		e.printStackTrace();
		LOGGER.error("Critical Exception: {}, With Request Parameters: {}", e, request);
		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception Occured ", e);
	}
}
