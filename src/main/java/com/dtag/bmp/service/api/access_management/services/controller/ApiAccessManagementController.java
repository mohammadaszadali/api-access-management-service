package com.dtag.bmp.service.api.access_management.services.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtag.bmp.service.api.access_management.model.ApiAccess;
import com.dtag.bmp.service.api.access_management.services.ApiAccessManagementSevice;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 *
 * @author TechMahindra
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apiaccess/v1")
public class ApiAccessManagementController {
	private static Logger logger = LoggerFactory.getLogger(ApiAccessManagementController.class);
	@Autowired
	private ApiAccessManagementSevice service;

	private final String className = this.getClass().getSimpleName();

	/**
	 * This Method will create new api access user
	 * 
	 * @param list
	 * @return
	 * @throws com.fasterxml.jackson.core.JsonProcessingException
	 * @throws BMException
	 */
	@ApiOperation(value = "Create New api access user", notes = "Create New  api access user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Created new user successfully"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = { "/createApiAccessUser" }, method = RequestMethod.POST, consumes = { "application/json" })
	public ResponseEntity<?> createApiAccessUser(@RequestBody ApiAccess apiAccess)
			throws com.fasterxml.jackson.core.JsonProcessingException {
		ResponseEntity<?> responseEntity = null;

		logger.info("Api access Request : " + new ObjectMapper().writeValueAsString(apiAccess));
		final String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(null != apiAccess.getApiType() && apiAccess.getApiType().equalsIgnoreCase("BSS secure API")) {
				ApiAccess respone = service.createUser(apiAccess);
				responseEntity = new ResponseEntity<>(respone, HttpStatus.CREATED);
			}else {
				responseEntity = new ResponseEntity<>("Success", HttpStatus.CREATED);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		return responseEntity;
	}

	/**
	 * This Method will get customer by ID
	 * 
	 * @param customer
	 * @return
	 * @throws com.fasterxml.jackson.core.JsonProcessingException
	 * @throws BMException
	 */
	@ApiOperation(value = " get user by emailid", notes = "get user By emailId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "get user by email id successfully"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = { "/getByEmail" }, method = RequestMethod.POST, consumes = { "application/json" })
	public ResponseEntity<?> getByEmail(@RequestBody String emailId)
			throws com.fasterxml.jackson.core.JsonProcessingException {
		ResponseEntity<?> responseEntity = null;
		final String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			ApiAccess apiAccess = service.getUserByEmailId(emailId.trim());
			if (apiAccess != null) {
				responseEntity = new ResponseEntity<>(apiAccess, HttpStatus.OK);

			} else {
				responseEntity = new ResponseEntity<>("User with email Id " + emailId + " not  found ",
						HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseEntity;

	}

	
}
