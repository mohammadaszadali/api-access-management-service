package com.dtag.bmp.service.api.access_management.errors;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value={"statusCode"})
public class ServiceErrorResponse {
	private List<ErrorResponse> errorResponse = new ArrayList<>();
	@JsonIgnore
	private int statusCode;

	public List<ErrorResponse> getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(List<ErrorResponse> errorResponse) {
		this.errorResponse = errorResponse;
	}

	public ServiceErrorResponse() {
		super();
	}

	public ServiceErrorResponse(List<ErrorResponse> errorResponse) {
		super();
		this.errorResponse = errorResponse;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ServiceErrorResponse [errorResponse=" + errorResponse + ", statusCode=" + statusCode + "]";
	}

	
}
