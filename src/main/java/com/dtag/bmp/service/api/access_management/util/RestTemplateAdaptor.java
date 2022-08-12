/*
 * package com.dtag.bmp.service.api.access_management.util;
 * 
 * import java.io.IOException; import java.util.List; import
 * java.util.concurrent.TimeUnit;
 * 
 * import org.slf4j.Logger; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.boot.web.client.RestTemplateBuilder; import
 * org.springframework.http.HttpEntity; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.http.MediaType; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Component; import
 * org.springframework.web.client.ResourceAccessException; import
 * org.springframework.web.client.RestClientException; import
 * org.springframework.web.client.RestTemplate; import
 * org.springframework.web.util.UriComponentsBuilder;
 * 
 * import
 * com.dtag.bmp.service.api.access_management.model.billing.order.OrderInfo;
 * import
 * com.dtag.bmp.service.api.access_management.model.billing.order.OrderWS;
 * import
 * com.dtag.bmp.service.api.access_management.model.billing_customer_response.
 * UserWSResponse; import
 * com.dtag.bmp.service.api.access_management.model.customer.
 * CustomerManagementReq; import
 * com.dtag.bmp.service.api.access_management.model.plans.PlanWS; import
 * com.dtag.bmp.service.api.access_management.model.poduct_catalog.
 * OfferPlanMapping; import
 * com.dtag.bmp.service.api.access_management.model.product_item.ItemDTOEx;
 * import
 * com.dtag.bmp.service.api.access_management.model.user.CustomerResponse;
 * import
 * com.dtag.bmp.service.api.access_management.model.user.JbillingIdRequest;
 * import com.dtag.bmp.service.api.access_management.model.user.UserWS; import
 * com.fasterxml.jackson.core.JsonParseException; import
 * com.fasterxml.jackson.core.JsonProcessingException; import
 * com.fasterxml.jackson.core.type.TypeReference; import
 * com.fasterxml.jackson.databind.JsonMappingException; import
 * com.fasterxml.jackson.databind.ObjectMapper; import
 * com.google.common.base.Stopwatch;
 * 
 * @Component public class RestTemplateAdaptor {
 * 
 * private final Logger logger =
 * org.slf4j.LoggerFactory.getLogger(this.getClass());
 * 
 * @Value("${getUserById.url}") private String getUserByIdURL;
 * 
 * @Value("${billing.username}") private String billingUsername;
 * 
 * @Value("${billing.pwd}") private String billingPWD;
 * 
 * @Value("${jbillingbaseUrl}") private String jbillingbaseUrl;
 * 
 * @Value("${jbillingCreateUserEndPoint}") private String
 * jbillingCreateUserEndPoint;
 * 
 * @Value("${dtagGetCustomerUrl}") private String dtagGetCustomerUrl;
 * 
 * @Value("${dtagCustomerBaseUrl}") private String dtagCustomerBaseUrl;
 * 
 * @Value("${dtagCustomerUpdateEndPoint}") private String
 * dtagCustomerUpdateEndPoint;
 * 
 * @Value("${jbillingCreateProductEndPoint}") private String
 * jbillingCreateProductEndPoint;
 * 
 * @Value("${jbillingCreatePlanEndPoint}") private String
 * jbillingCreatePlanEndPoint;
 * 
 * @Value("${getPalnByIdPoint}") private String getPalnByIdURL;
 * 
 * @Value("${getItemDetailsByIdPoint}") private String getItemyIdURL;
 * 
 * @Value("${jbillingCreateOrderEndPoint}") private String
 * jbillingCreateOrderEndPoint;
 * 
 * @Value("${updatePlanUrl}") private String updatePlanUrl;
 * 
 * 
 * @Value("${getOrderByIdPoint}") private String getOrderByIdPoint;
 * 
 * 
 * @Value("${updateItemUrl}") private String updateItemUrl;
 * 
 * 
 * @Value("${getOfferPlanMappingUrl}") private String getOfferPlanMappingUrl;
 * 
 * @Value("${getCustomerManagementReqByIdgUrl}") private String
 * getCustomerManagementReqByIdgUrl;
 * 
 * @Autowired RestTemplate restTemplate;
 * 
 * 
 * public ResponseEntity<UserWS> createCustomerInJbilling(UserWS request) {
 * ResponseEntity<UserWS> userWS = null; try {
 * logger.info("jbilling create request%% " + new
 * ObjectMapper().writeValueAsString(request)); } catch (JsonProcessingException
 * e1) { // TODO Auto-generated catch block e1.printStackTrace(); } String url =
 * jbillingbaseUrl+ jbillingCreateUserEndPoint ; try {
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON); RestTemplateBuilder
 * restTemplateBuilder = new RestTemplateBuilder();
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(request,headers); RestTemplate
 * restTemplateBasic =
 * restTemplateBuilder.basicAuthorization(billingUsername,billingPWD).build();
 * userWS = restTemplateBasic.postForEntity(url, entity, UserWS.class);
 * logger.info("response of jbilling " + new
 * ObjectMapper().writeValueAsString(userWS.getBody()));
 * logger.info("calling POST API for URL: " + url +
 * " completed successfully.."); } catch (ResourceAccessException
 * accessException) { logger.error("Error calling POST API for URL:" + url +
 * " got error: " + accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " + url); } catch
 * (RestClientException restClientException) {
 * logger.error("Error calling POST API for URL:" + url + " got error: " +
 * restClientException.getMessage()); throw new
 * RestClientException("Error calling POST API for URL:" + url); } catch
 * (Exception e) { e.printStackTrace(); }
 * 
 * return userWS; }
 * 
 * public UserWS getJbillingUserById(String jbillingid) throws Exception {
 * UserWS user = null; try { HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON); RestTemplateBuilder
 * restTemplateBuilder = new RestTemplateBuilder();
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(headers); RestTemplate
 * restTemplateBasic =
 * restTemplateBuilder.basicAuthorization(billingUsername,billingPWD).build();
 * ResponseEntity<UserWS>
 * respEntity=restTemplateBasic.exchange(jbillingbaseUrl+getUserByIdURL +
 * jbillingid,HttpMethod.GET, entity, UserWS.class); user =
 * respEntity.getBody(); logger.info("response of jbilling " + new
 * ObjectMapper().writeValueAsString(user));
 * logger.info("calling GET API for URL: " + jbillingbaseUrl+getUserByIdURL +
 * " completed successfully.."); } catch (ResourceAccessException
 * accessException) { logger.error("Error calling GET API for URL:" +
 * jbillingbaseUrl+getUserByIdURL + jbillingid + "got error: " +
 * accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " +
 * jbillingbaseUrl+getUserByIdURL + jbillingid); } catch (RestClientException
 * restClientException) { logger.error("Error calling GET API for URL:" +
 * jbillingbaseUrl+getUserByIdURL + jbillingid + " got error: " +
 * restClientException.getMessage()); throw new
 * RestClientException("Error calling GET API for URL:" +
 * jbillingbaseUrl+getUserByIdURL); } catch (Exception e) { e.printStackTrace();
 * throw new Exception(); }
 * 
 * return user;
 * 
 * }
 * 
 * public String updateCustomerInJbilling(UserWSResponse jbillingUserWS) { try {
 * logger.info("jbilling update request%% " + new
 * ObjectMapper().writeValueAsString(jbillingUserWS)); } catch
 * (JsonProcessingException e1) { // TODO Auto-generated catch block
 * e1.printStackTrace(); } String url = jbillingbaseUrl+getUserByIdURL +
 * jbillingUserWS.getId(); String response = "Not updated"; try {
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON); RestTemplateBuilder
 * restTemplateBuilder = new RestTemplateBuilder();
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(jbillingUserWS, headers); RestTemplate
 * restTemplateBasic =
 * restTemplateBuilder.basicAuthorization(billingUsername,billingPWD).build();
 * restTemplateBasic.put(url, entity); response = "Successfully updated";
 * 
 * logger.info("calling put API for URL: " + url + " completed successfully..");
 * } catch (ResourceAccessException accessException) {
 * logger.error("Error calling put API for URL:" + url + " got error: " +
 * accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " + url); } catch
 * (RestClientException restClientException) {
 * logger.error("Error calling put API for URL:" + url + " got error: " +
 * restClientException.getMessage()); throw new
 * RestClientException("Error calling put API for URL:" + url); } catch
 * (Exception e) { e.printStackTrace(); }
 * 
 * logger.info("Update custmer response  " + response); return response; }
 * 
 * public String updateBillingAccountId(CustomerResponse response) { HttpHeaders
 * headers = new HttpHeaders(); JbillingIdRequest jbillingreq = new
 * JbillingIdRequest(); Object uid = response.getId();
 * jbillingreq.setjBillingId(uid.toString()); HttpEntity<JbillingIdRequest>
 * entity1 = new HttpEntity<JbillingIdRequest>(jbillingreq, headers);
 * ResponseEntity<String> customerPatchResponse = restTemplate.postForEntity(
 * dtagCustomerBaseUrl+dtagCustomerUpdateEndPoint + response.getCustomerId(),
 * entity1, String.class); logger.info(String.
 * format("#### ->jbilling Id updated in customre mgt status -> %s",
 * customerPatchResponse.toString())); return
 * customerPatchResponse.getBody().toString(); }
 * 
 * public List<CustomerManagementReq> getAllCustomers() {
 * List<CustomerManagementReq> customerCreationResponseList =null; HttpHeaders
 * header = new HttpHeaders();
 * 
 * header.setContentType(MediaType.APPLICATION_JSON); HttpEntity<Object> entity
 * = new HttpEntity<>(header);
 * logger.info(dtagCustomerBaseUrl+dtagGetCustomerUrl +entity);
 * ResponseEntity<?> respEntity =
 * restTemplate.exchange(dtagCustomerBaseUrl+dtagGetCustomerUrl, HttpMethod.GET,
 * entity, List.class); customerCreationResponseList =
 * getModelCustomerResponse(customerCreationResponseList, (List<Object>)
 * respEntity.getBody()); //sorting by name
 * customerCreationResponseList.sort((CustomerManagementReq customer1,
 * CustomerManagementReq customer2) ->
 * customer1.getCustomerManagementRequest().getContactDetails().get(0).
 * getFirstName().compareTo
 * (customer2.getCustomerManagementRequest().getContactDetails().get(0).
 * getFirstName())); //logger.info("\n\nResponse"+customerCreationResponseList);
 * return customerCreationResponseList; } private List<CustomerManagementReq>
 * getModelCustomerResponse( List<CustomerManagementReq>
 * customerCreationResponseList, List<Object> customerCreationList) {
 * ObjectMapper objectMapper = new ObjectMapper(); String modelCustomerResponse
 * = null; try { modelCustomerResponse =
 * objectMapper.writeValueAsString(customerCreationList);
 * 
 * } catch (JsonProcessingException e1) { e1.getMessage(); } try {
 * customerCreationResponseList = objectMapper.readValue(modelCustomerResponse,
 * new TypeReference<List<CustomerManagementReq>>() { }); } catch
 * (JsonParseException e) { e.getMessage(); } catch (JsonMappingException e) {
 * e.getMessage(); } catch (IOException e) { e.getStackTrace(); } return
 * customerCreationResponseList; }
 * 
 * public ItemDTOEx createProductInJbilling(ItemDTOEx itemDTOEx) { ItemDTOEx
 * itemDTOExEntity = null; try { logger.info("jbilling create request%% " + new
 * ObjectMapper().writeValueAsString(itemDTOEx)); } catch
 * (JsonProcessingException e1) { // TODO Auto-generated catch block
 * e1.printStackTrace(); } String url = jbillingbaseUrl+
 * jbillingCreateProductEndPoint ; try { HttpHeaders headers = new
 * HttpHeaders(); headers.setContentType(MediaType.APPLICATION_JSON);
 * RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(itemDTOEx, headers); RestTemplate
 * restTemplateBasic =
 * restTemplateBuilder.basicAuthorization(billingUsername,billingPWD).build();
 * Stopwatch stopwatch = Stopwatch.createStarted();
 * logger.info("calling POST API createItemInJbilling start time....");
 * itemDTOExEntity =
 * restTemplateBasic.postForObject(url,entity,ItemDTOEx.class);
 * 
 * Long mlsecond= stopwatch.elapsed(TimeUnit.MILLISECONDS); String mlseconds =
 * Long.toString(mlsecond);
 * logger.info("##createItemInJbilling EndTime"+mlseconds);
 * 
 * logger.info("response of jbilling " + new
 * ObjectMapper().writeValueAsString(itemDTOExEntity));
 * logger.info("calling POST API for URL: " + url +
 * " completed successfully.."); } catch (ResourceAccessException
 * accessException) { logger.error("Error calling POST API for URL:" + url +
 * " got error: " + accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " + url); } catch
 * (RestClientException restClientException) {
 * logger.error("Error calling POST API for URL:" + url + " got error: " +
 * restClientException.getMessage()); throw new
 * RestClientException("Error calling POST API for URL:" + url); } catch
 * (Exception e) { e.printStackTrace(); }
 * 
 * return itemDTOExEntity; }
 * 
 * public PlanWS planInJbilling(PlanWS planWS) { PlanWS planWSEntity = null; try
 * { logger.info("jbilling create request%% " + new
 * ObjectMapper().writeValueAsString(planWS)); } catch (JsonProcessingException
 * e1) { // TODO Auto-generated catch block e1.printStackTrace(); } String url =
 * jbillingbaseUrl+ jbillingCreatePlanEndPoint ; try {
 * 
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON); RestTemplateBuilder
 * restTemplateBuilder = new RestTemplateBuilder();
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(planWS, headers); RestTemplate
 * restTemplateBasic =
 * restTemplateBuilder.basicAuthorization(billingUsername,billingPWD).build();
 * 
 * Stopwatch stopwatch = Stopwatch.createStarted();
 * logger.info("calling POST API  createPlanInJbilling Start Time....");
 * planWSEntity = restTemplateBasic.postForObject(url,entity,PlanWS.class);
 * 
 * Long mlsecond= stopwatch.elapsed(TimeUnit.MILLISECONDS); String mlseconds =
 * Long.toString(mlsecond);
 * logger.info("##createPlanInJbilling End Time.."+mlseconds+"ms");
 * 
 * logger.info("response of jbilling " + new
 * ObjectMapper().writeValueAsString(planWSEntity));
 * logger.info("calling POST API for URL: " + url +
 * " completed successfully.."); } catch (ResourceAccessException
 * accessException) { logger.error("Error calling POST API for URL:" + url +
 * " got error: " + accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " + url); } catch
 * (RestClientException restClientException) {
 * logger.error("Error calling POST API for URL:" + url + " got error: " +
 * restClientException.getMessage()); throw new
 * RestClientException("Error calling POST API for URL:" + url); } catch
 * (Exception e) { e.printStackTrace(); }
 * 
 * 
 * return planWSEntity; }
 * 
 * public PlanWS planInJbilling(int jbillingId) throws Exception {
 * 
 * PlanWS planWS = null; try {
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON); RestTemplateBuilder
 * restTemplateBuilder = new RestTemplateBuilder();
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(headers); RestTemplate
 * restTemplateBasic =
 * restTemplateBuilder.basicAuthorization(billingUsername,billingPWD).build();
 * Stopwatch stopwatch = Stopwatch.createStarted();
 * logger.info("calling GET API  getPlanFromJbilling Start Time....");
 * ResponseEntity<PlanWS> respEntity =
 * restTemplateBasic.exchange(jbillingbaseUrl+getPalnByIdURL +
 * jbillingId,HttpMethod.GET, entity, PlanWS.class);
 * 
 * Long mlsecond= stopwatch.elapsed(TimeUnit.MILLISECONDS); String mlseconds =
 * Long.toString(mlsecond);
 * logger.info("##getPlanFromJbilling End Time.."+mlseconds+"ms"); planWS =
 * respEntity.getBody(); logger.info("response of jbilling " + new
 * ObjectMapper().writeValueAsString(planWS));
 * logger.info("calling GET API for URL: " + jbillingbaseUrl+getPalnByIdURL +
 * " completed successfully.."); } catch (ResourceAccessException
 * accessException) { logger.error("Error calling GET API for URL:" +
 * jbillingbaseUrl+getPalnByIdURL + jbillingId + "got error: " +
 * accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " +
 * jbillingbaseUrl+getPalnByIdURL + jbillingId); } catch (RestClientException
 * restClientException) { logger.error("Error calling GET API for URL:" +
 * jbillingbaseUrl+getPalnByIdURL + jbillingId + " got error: " +
 * restClientException.getMessage()); throw new
 * RestClientException("Error calling GET API for URL:" +
 * jbillingbaseUrl+getPalnByIdURL); } catch (Exception e) { e.printStackTrace();
 * throw new Exception(); }
 * 
 * return planWS;
 * 
 * }
 * 
 * public ItemDTOEx getItemDetailsById(String jbillingId) throws Exception {
 * 
 * ItemDTOEx itemDTOEx = null; try {
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON); RestTemplateBuilder
 * restTemplateBuilder = new RestTemplateBuilder();
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(headers); RestTemplate
 * restTemplateBasic =
 * restTemplateBuilder.basicAuthorization(billingUsername,billingPWD).build();
 * Stopwatch stopwatch = Stopwatch.createStarted();
 * logger.info("calling GET API  getItemFromJbilling Start Time....");
 * ResponseEntity<ItemDTOEx> respEntity =
 * restTemplateBasic.exchange(jbillingbaseUrl+getItemyIdURL+jbillingId,
 * HttpMethod.GET, entity, ItemDTOEx.class);
 * 
 * 
 * Long mlsecond= stopwatch.elapsed(TimeUnit.MILLISECONDS); String mlseconds =
 * Long.toString(mlsecond);
 * logger.info("##getItemFromJbilling End Time.."+mlseconds+"ms"); itemDTOEx =
 * respEntity.getBody(); logger.info("response of jbilling " + new
 * ObjectMapper().writeValueAsString(itemDTOEx));
 * logger.info("calling GET API for URL: " + jbillingbaseUrl+getItemyIdURL +
 * " completed successfully.."); } catch (ResourceAccessException
 * accessException) { logger.error("Error calling GET API for URL:" +
 * jbillingbaseUrl+getItemyIdURL + jbillingId + "got error: " +
 * accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " +
 * jbillingbaseUrl+getItemyIdURL + jbillingId); } catch (RestClientException
 * restClientException) { logger.error("Error calling GET API for URL:" +
 * jbillingbaseUrl+getItemyIdURL + jbillingId + " got error: " +
 * restClientException.getMessage()); throw new
 * RestClientException("Error calling GET API for URL:" +
 * jbillingbaseUrl+getItemyIdURL); } catch (Exception e) { e.printStackTrace();
 * throw new Exception(); }
 * 
 * return itemDTOEx;
 * 
 * }
 * 
 * public String updatePlanInJbilling(PlanWS existingPlanWS) { try {
 * logger.info("jbilling update request%% " + new
 * ObjectMapper().writeValueAsString(existingPlanWS)); } catch
 * (JsonProcessingException e1) { // TODO Auto-generated catch block
 * e1.printStackTrace(); } String url = jbillingbaseUrl+getPalnByIdURL +
 * existingPlanWS.getId(); String response = "Not updated"; try {
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON); RestTemplateBuilder
 * restTemplateBuilder = new RestTemplateBuilder();
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(existingPlanWS,headers); RestTemplate
 * restTemplateBasic =
 * restTemplateBuilder.basicAuthorization(billingUsername,billingPWD).build();
 * // restTemplateBasic.put(url, entity); Stopwatch stopwatch =
 * Stopwatch.createStarted();
 * logger.info("calling GET API  updatePlanInJbilling Start Time....");
 * restTemplateBasic.exchange(url,HttpMethod.PUT, entity, PlanWS.class);
 * 
 * Long mlsecond= stopwatch.elapsed(TimeUnit.MILLISECONDS); String mlseconds =
 * Long.toString(mlsecond);
 * logger.info("##updatePlanJbilling End Time.."+mlseconds+"ms"); response =
 * "Successfully updated";
 * 
 * logger.info("calling put API for URL: " + url + " completed successfully..");
 * } catch (ResourceAccessException accessException) {
 * logger.error("Error calling put API for URL:" + url + " got error: " +
 * accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " + url); } catch
 * (RestClientException restClientException) {
 * logger.error("Error calling put API for URL:" + url + " got error: " +
 * restClientException.getMessage()); throw new
 * RestClientException("Error calling put API for URL:" + url); } catch
 * (Exception e) { e.printStackTrace(); }
 * 
 * logger.info("Update PlanWS response  " + response); return response;
 * 
 * }
 * 
 * 
 * public String updateItemInJbilling(ItemDTOEx itemex) { try {
 * logger.info("jbilling update request%% " + new
 * ObjectMapper().writeValueAsString(itemex)); } catch (JsonProcessingException
 * e1) { e1.printStackTrace(); } String url =
 * jbillingbaseUrl+getItemyIdURL+itemex.getId(); String response =
 * "Not updated"; try {
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON); RestTemplateBuilder
 * restTemplateBuilder = new RestTemplateBuilder();
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(itemex,headers); RestTemplate
 * restTemplateBasic =
 * restTemplateBuilder.basicAuthorization(billingUsername,billingPWD).build();
 * // restTemplateBasic.put(url, entity); Stopwatch stopwatch =
 * Stopwatch.createStarted();
 * logger.info("calling GET API for updateItemInJbilling Start Time....");
 * restTemplateBasic.exchange(url,HttpMethod.PUT, entity, ItemDTOEx.class); Long
 * mlsecond= stopwatch.elapsed(TimeUnit.MILLISECONDS); String mlseconds =
 * Long.toString(mlsecond);
 * logger.info("##updateItemJbilling End Time.."+mlseconds+"ms"); response =
 * "Successfully updated";
 * 
 * logger.info("calling put API for URL: " + url + " completed successfully..");
 * } catch (ResourceAccessException accessException) {
 * logger.error("Error calling put API for URL:" + url + " got error: " +
 * accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " + url); } catch
 * (RestClientException restClientException) {
 * logger.error("Error calling put API for URL:" + url + " got error: " +
 * restClientException.getMessage()); throw new
 * RestClientException("Error calling put API for URL:" + url); }
 * 
 * catch (Exception e) { e.printStackTrace(); }
 * 
 * logger.info("Update Item response  " + response); return response;
 * 
 * 
 * }
 * 
 * public CustomerManagementReq getById(String custId) {
 * 
 * CustomerManagementReq result = null;
 * 
 * String url = getCustomerManagementReqByIdgUrl + custId; java.net.URI
 * targetUrl = UriComponentsBuilder.fromUriString(url).build().toUri(); try {
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON);
 * 
 * HttpEntity<Object> entity = new HttpEntity<Object>(headers);
 * 
 * 
 * ResponseEntity<CustomerManagementReq> response =
 * restTemplate.exchange(targetUrl, HttpMethod.GET, entity,
 * CustomerManagementReq.class);
 * 
 * result = response.getBody(); logger.info("response of customer service " +
 * new ObjectMapper().writeValueAsString(result));
 * logger.info("calling GET API for URL: " + targetUrl +
 * " completed successfully..");
 * 
 * } catch (ResourceAccessException accessException) {
 * logger.error("Error calling GET API for URL:" + targetUrl + " got error: " +
 * accessException.getMessage());
 * 
 * throw new ResourceAccessException("calling Resource not avaialble: " + url);
 * } catch (RestClientException restClientException) {
 * logger.error("Error calling GET API for URL:" + targetUrl + " got error: " +
 * restClientException.getMessage()); throw new
 * RestClientException("Error calling GET API for URL:" + targetUrl); } catch
 * (Exception e) { e.printStackTrace(); } return result;
 * 
 * }
 * 
 * public OfferPlanMapping getOfferPlanMapping(String offercode) {
 * OfferPlanMapping offerPlanMapping = null;
 * 
 * String url = getOfferPlanMappingUrl + offercode; java.net.URI targetUrl =
 * UriComponentsBuilder.fromUriString(url).build().toUri(); try {
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON); HttpEntity<Object> entity
 * = new HttpEntity<Object>(headers);
 * 
 * ResponseEntity<OfferPlanMapping> response = restTemplate.exchange(targetUrl,
 * HttpMethod.GET, entity, OfferPlanMapping.class);
 * 
 * offerPlanMapping = response.getBody();
 * logger.info("response of offer plan mapping=  " + new
 * ObjectMapper().writeValueAsString(offerPlanMapping));
 * logger.info("calling GET API for URL: " + targetUrl +
 * " completed successfully.."); } catch (ResourceAccessException
 * accessException) { logger.error("Error calling GET API for URL:" + targetUrl
 * + " got error: " + accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " + targetUrl); }
 * catch (RestClientException restClientException) {
 * logger.error("Error calling GET API for URL:" + targetUrl + " got error: " +
 * restClientException.getMessage()); throw new
 * RestClientException("Error calling GET API for URL:" + targetUrl); } catch
 * (Exception e) { e.printStackTrace(); }
 * 
 * return offerPlanMapping; }
 * 
 * 
 * public String createOrderInJbilling(OrderInfo orderInfo) {
 * ResponseEntity<OrderInfo> orderInfoEntity = null; //OrderInfo
 * orderInfoResponse= null; String JbillingOrderId = null; try {
 * logger.info("jbilling create request%% " + new
 * ObjectMapper().writeValueAsString(orderInfo)); } catch
 * (JsonProcessingException e1) { // TODO Auto-generated catch block
 * e1.printStackTrace(); } StringBuffer url = new StringBuffer(jbillingbaseUrl);
 * url.append(jbillingCreateOrderEndPoint); try {
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON); RestTemplateBuilder
 * restTemplateBuilder = new RestTemplateBuilder();
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(orderInfo,headers); RestTemplate
 * restTemplateBasic =
 * restTemplateBuilder.basicAuthorization(billingUsername,billingPWD).build();
 * orderInfoEntity =restTemplateBasic.postForEntity(url.toString(), entity,
 * OrderInfo.class); logger.info("orderInfoEntity : "+orderInfoEntity);
 * logger.info("orderInfoEntity.getStatusCodeValue() : "+orderInfoEntity.
 * getStatusCodeValue() + " and " +"orderInfoEntity.getStatusCode() "
 * +orderInfoEntity.getStatusCode()); if( orderInfoEntity.getStatusCodeValue()
 * == 201 || orderInfoEntity.getStatusCodeValue() == 200 ) { String
 * LocationURIString = orderInfoEntity.getHeaders().getLocation().toString();
 * logger.info("LocationURIString : "+LocationURIString);
 * 
 * JbillingOrderId = getLastToken(LocationURIString,
 * "http://10.211.1.42:8186/api/orders/");
 * logger.info(" JbillingOrderId  : "+JbillingOrderId);
 * 
 * }
 * 
 * //orderInfo=orderInfoEntity.getBody(); logger.info("response of Jbilling=  "
 * + new ObjectMapper().writeValueAsString(orderInfoEntity.getBody()));
 * logger.info("calling POST API for URL: " + url.toString() +
 * " completed successfully.."); } catch (ResourceAccessException
 * accessException) { logger.error("Error calling POST API for URL:" +
 * url.toString() + " got error: " + accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " + url); } catch
 * (RestClientException restClientException) {
 * logger.error("Error calling POST API for URL:" + url.toString() +
 * " got error: " + restClientException.getMessage()); throw new
 * RestClientException("Error calling POST API for URL:" + url.toString()); }
 * catch (Exception e) { e.printStackTrace(); }
 * 
 * return JbillingOrderId; }
 * 
 * 
 * private static String getLastToken(String strValue, String splitter ) {
 * String[] strArray = strValue.split(splitter); return strArray[strArray.length
 * -1]; }
 * 
 * public OrderWS getJbillingOrderById(String jbillingid) throws Exception {
 * 
 * try { logger.info("calling getJbillingOrderById for id :" + jbillingid); }
 * catch (Exception e) { e.printStackTrace(); }
 * 
 * OrderWS orderWS = null;
 * 
 * StringBuffer url = new StringBuffer(jbillingbaseUrl);
 * url.append(getOrderByIdPoint); url.append(jbillingid); try { HttpHeaders
 * headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON);
 * 
 * RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
 * 
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(headers);
 * 
 * RestTemplate restTemplateBasic =
 * restTemplateBuilder.basicAuthorization(billingUsername, billingPWD) .build();
 * ResponseEntity<OrderWS> respEntity =
 * restTemplateBasic.exchange(url.toString(), HttpMethod.GET, entity,
 * OrderWS.class); logger.info(" respEntity :" + respEntity); orderWS =
 * respEntity.getBody();
 * logger.info("response of jbilling orderWS for getJbillingOrderById " + new
 * ObjectMapper().writeValueAsString(orderWS));
 * logger.info("calling getJbillingOrderById API for URL: " + url.toString() +
 * " completed successfully.."); } catch (ResourceAccessException
 * accessException) {
 * logger.error("Error calling getJbillingOrderById API for URL:" +
 * url.toString() + jbillingid + "got error: " + accessException.getMessage());
 * throw new ResourceAccessException("calling Resource not avaialble: " +
 * url.toString() + jbillingid); } catch (RestClientException
 * restClientException) {
 * logger.error("Error calling getJbillingOrderById API for URL:" +
 * url.toString() + " got error: " + restClientException.getMessage()); throw
 * new RestClientException("Error calling getJbillingOrderById API for URL:" +
 * url.toString()); } catch (Exception e) { e.printStackTrace(); throw new
 * Exception(); }
 * 
 * return orderWS;
 * 
 * }
 * 
 * public String updateOrderJbilling(OrderInfo orderInfo ) { try {
 * logger.info("jbilling update request%% " + new
 * ObjectMapper().writeValueAsString(orderInfo)); } catch
 * (JsonProcessingException e1) { e1.printStackTrace(); } String url =
 * jbillingbaseUrl + getOrderByIdPoint + orderInfo.getOrder().getId(); String
 * response = "Not updated"; try {
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON);
 * 
 * RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
 * 
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(orderInfo, headers);
 * 
 * RestTemplate restTemplateBasic =
 * restTemplateBuilder.basicAuthorization(billingUsername, billingPWD) .build();
 * 
 * // restTemplateBasic.put(url, entity);
 * 
 * restTemplateBasic.exchange(url, HttpMethod.PUT, entity, OrderInfo.class);
 * 
 * response = "Successfully updated";
 * 
 * logger.info("calling put API for URL: " + url + " completed successfully..");
 * } catch (ResourceAccessException accessException) {
 * logger.error("Error calling put API for URL:" + url + " got error: " +
 * accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " + url); } catch
 * (RestClientException restClientException) {
 * logger.error("Error calling put API for URL:" + url + " got error: " +
 * restClientException.getMessage()); throw new
 * RestClientException("Error calling put API for URL:" + url); }
 * 
 * catch (Exception e) { e.printStackTrace(); }
 * 
 * logger.info("Update order response  " + response); return response;
 * 
 * }
 * 
 * public String createOrderAndInvoiceInJbilling(OrderInfo orderInfo) {
 * 
 * ResponseEntity<OrderInfo> orderInfoEntity = null; // OrderInfo
 * orderInfoResponse= null; String JbillingOrderId = null; try {
 * logger.info("OrderAndInvoiceInJbilling create request%% " + new
 * ObjectMapper().writeValueAsString(orderInfo)); } catch
 * (JsonProcessingException e1) { // TODO Auto-generated catch block
 * e1.printStackTrace(); } StringBuffer url = new
 * StringBuffer("http://10.211.1.42:8186/api/orders/createorderandinvoice");
 * 
 * try {
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON); RestTemplateBuilder
 * restTemplateBuilder = new RestTemplateBuilder();
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(orderInfo, headers); RestTemplate
 * restTemplateBasic = restTemplateBuilder.basicAuthorization(billingUsername,
 * billingPWD) .build(); orderInfoEntity =
 * restTemplateBasic.postForEntity(url.toString(), entity, OrderInfo.class);
 * logger.info("orderInfoEntity : " + orderInfoEntity);
 * logger.info("orderInfoEntity.getStatusCodeValue() : " +
 * orderInfoEntity.getStatusCodeValue() + " and " +
 * "orderInfoEntity.getStatusCode() " + orderInfoEntity.getStatusCode()); if
 * (orderInfoEntity.getStatusCodeValue() == 201 ||
 * orderInfoEntity.getStatusCodeValue() == 200) { String LocationURIString =
 * orderInfoEntity.getHeaders().getLocation().toString();
 * 
 * 
 * JbillingOrderId = getLastToken(LocationURIString,
 * "http://10.211.1.42:8186/api/orders/"); logger.info(" JbillingOrderId  : " +
 * JbillingOrderId);
 * 
 * }
 * 
 * // orderInfo=orderInfoEntity.getBody(); logger.info("response of Jbilling=  "
 * + new ObjectMapper().writeValueAsString(orderInfoEntity.getBody()));
 * logger.info("calling POST API for OrderAndInvoiceInJbilling URL: " +
 * url.toString() + " completed successfully.."); } catch
 * (ResourceAccessException accessException) { logger.error(
 * "Error calling POST API for OrderAndInvoiceInJbilling URL:" + url.toString()
 * + " got error: " + accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " + url); } catch
 * (RestClientException restClientException) {
 * logger.error("Error calling POST API for OrderAndInvoiceInJbilling URL:" +
 * url.toString() + " got error: " + restClientException.getMessage()); throw
 * new
 * RestClientException("Error calling POST API for OrderAndInvoiceInJbilling URL:"
 * + url.toString()); } catch (Exception e) { e.printStackTrace(); }
 * 
 * return JbillingOrderId;
 * 
 * }
 * 
 * public UserWSResponse getJbillingResponseUserById(String jbillingid) {
 * UserWSResponse user = null; try { HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON); RestTemplateBuilder
 * restTemplateBuilder = new RestTemplateBuilder();
 * org.springframework.http.HttpEntity<Object> entity = new
 * org.springframework.http.HttpEntity<>(headers); RestTemplate
 * restTemplateBasic =
 * restTemplateBuilder.basicAuthorization(billingUsername,billingPWD).build();
 * ResponseEntity<UserWSResponse>
 * respEntity=restTemplateBasic.exchange(jbillingbaseUrl+getUserByIdURL +
 * jbillingid,HttpMethod.GET, entity, UserWSResponse.class); user =
 * respEntity.getBody(); logger.info("response of jbilling " + new
 * ObjectMapper().writeValueAsString(user));
 * logger.info("calling GET API for URL: " + jbillingbaseUrl+getUserByIdURL +
 * " completed successfully.."); } catch (ResourceAccessException
 * accessException) { logger.error("Error calling GET API for URL:" +
 * jbillingbaseUrl+getUserByIdURL + jbillingid + "got error: " +
 * accessException.getMessage()); throw new
 * ResourceAccessException("calling Resource not avaialble: " +
 * jbillingbaseUrl+getUserByIdURL + jbillingid); } catch (RestClientException
 * restClientException) { logger.error("Error calling GET API for URL:" +
 * jbillingbaseUrl+getUserByIdURL + jbillingid + " got error: " +
 * restClientException.getMessage()); throw new
 * RestClientException("Error calling GET API for URL:" +
 * jbillingbaseUrl+getUserByIdURL); } catch (Exception e) { e.printStackTrace();
 * }
 * 
 * return user; }
 * 
 * }
 * 
 * 
 * 
 */