package com.dtag.bmp.service.api.access_management.exceptions;

public class ServiceTimeOutException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String serviceCode;
	
	public ServiceTimeOutException(String message) {
		super(message);
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
}
