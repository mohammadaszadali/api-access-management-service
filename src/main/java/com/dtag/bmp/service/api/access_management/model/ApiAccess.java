package com.dtag.bmp.service.api.access_management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="ApiAccess")
public class ApiAccess {
	
	@Id
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("customerId")
	private String customerId;
	
	@JsonProperty("bssAccessForAllCustomers")
	private Boolean bssAccessForAllCustomers=false;
	
	@JsonProperty("apiType")
    private String apiType;



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public Boolean getBssAccessForAllCustomers() {
		return bssAccessForAllCustomers;
	}


	public void setBssAccessForAllCustomers(Boolean bssAccessForAllCustomers) {
		this.bssAccessForAllCustomers = bssAccessForAllCustomers;
	}

    public String getApiType() {
           return apiType;
    }


    public void setApiType(String apiType) {
           this.apiType = apiType;
    }


	@Override
	public String toString() {
		return "ApiAccess [email=" + email + ", customerId=" + customerId + ", bssAccessForAllCustomers="
				+ bssAccessForAllCustomers + "]";
	}

	
}
