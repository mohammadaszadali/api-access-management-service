package com.dtag.bmp.service.api.access_management.errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ErrorResponse {

	private String reasonCode;
	private String message;
	private String messageDetail;
	private String timestamp;
	
	public ErrorResponse() {
		super();
	}
	
	public ErrorResponse(String reasonCode, String message, String messageDetail, String timestamp) {
		super();
		this.reasonCode = reasonCode;
		this.message = message;
		this.messageDetail = messageDetail;
		this.timestamp = timestamp;
	}
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageDetail() {
		return messageDetail;
	}
	public void setMessageDetail(String messageDetail) {
		this.messageDetail = messageDetail;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "{ErrorResponse: {reasonCode:" + reasonCode + ", message:" + message + ", messageDetail:" + messageDetail
				+ ", timestamp:" + timestamp + "}}";
	}
		
}
