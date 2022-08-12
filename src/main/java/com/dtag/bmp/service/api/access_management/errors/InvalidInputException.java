package com.dtag.bmp.service.api.access_management.errors;

public class InvalidInputException extends Exception {

	private String exceptionMsg;

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public InvalidInputException(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}

}
