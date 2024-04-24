package com.example.custom_exception;

@SuppressWarnings("serial")
public class CustomException extends RuntimeException {

	public CustomException(String msg) {

		super(msg);
	}

}
