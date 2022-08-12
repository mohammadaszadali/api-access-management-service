package com.dtag.bmp.service.api.access_management.services;

import org.springframework.stereotype.Service;

import com.dtag.bmp.service.api.access_management.model.ApiAccess;
@Service
public interface ApiAccessManagementSevice {

	ApiAccess createUser(ApiAccess apiAccess) throws Exception;

	ApiAccess getUserByEmailId(String emailId);

	

}
