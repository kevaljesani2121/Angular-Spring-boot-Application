package com.example.demo.custome.exception;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String errorMessage;
	private  String errorStatusCode;

	public BusinessException() {
		this.errorMessage = "";
		this.errorStatusCode = "";

	}

	public BusinessException(String errorMessage, String errorStatusCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorStatusCode = errorStatusCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorStatusCode() {
		return errorStatusCode;
	}

	public void setErrorStatusCode(String errorStatusCode) {
		this.errorStatusCode = errorStatusCode;
	}

}
