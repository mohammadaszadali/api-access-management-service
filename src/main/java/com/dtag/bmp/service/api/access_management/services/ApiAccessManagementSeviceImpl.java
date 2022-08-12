package com.dtag.bmp.service.api.access_management.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dtag.bmp.service.api.access_management.model.ApiAccess;
import com.dtag.bmp.service.api.access_management.model.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiAccessManagementSeviceImpl implements ApiAccessManagementSevice {
	private static Logger logger = LoggerFactory.getLogger(ApiAccessManagementSeviceImpl.class);
	@Autowired
	private MongoTemplate mongoTemplate;

	@Value("${keycloakApiUserUrl}")
	private String keycloakApiUserUrl;

	@Autowired
	private RestTemplate template;

	// @Autowired private RestTemplateAdaptor restTemplateAdaptor;

	@Override
	public ApiAccess createUser(ApiAccess apiAccess) throws Exception {
		try {
			if (null != apiAccess.getEmail() && null != apiAccess.getCustomerId()) {
				UserDTO userdto = new UserDTO();
				userdto.setEmailId(apiAccess.getEmail());
				userdto.setGivenName("API");
				userdto.setFamilyName("API");
				userdto.setUserName(apiAccess.getEmail());
				userdto.setPassword("NA");

				// keycloak call
				logger.info("Calling keycloak api URL-" + keycloakApiUserUrl);

				Integer userId = template.postForObject(keycloakApiUserUrl, userdto, Integer.class);
				logger.info("Response of keycloak " + userId);

				if (userId == 409) {
					throw new Exception("User already present in keycloak");
				} else if(userId == 201){
					logger.info("Saving data in the DB " + userId);
					mongoTemplate.save(apiAccess);
				}else {
					throw new Exception("Unknown exception occoured ");
				}
			} else {
				throw new Exception("Incorrect Request");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return apiAccess;
	}

	@Override
	public ApiAccess getUserByEmailId(String emailId) {
		ApiAccess apiAccess = null;
		try {
			logger.info("Get by email Id :" + emailId);
			apiAccess = mongoTemplate.findById(emailId, ApiAccess.class);

			logger.info("response :" + new ObjectMapper().writeValueAsString(apiAccess));
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		return apiAccess;
	}

}