package com.cognizant.truyum.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cart is empty")

public class CartEmptyException extends Exception {

}
