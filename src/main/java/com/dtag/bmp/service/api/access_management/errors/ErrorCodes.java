package com.dtag.bmp.service.api.access_management.errors;

public enum ErrorCodes {

	CATALOG_BUSINESS_DB_ERROR("CATALOG_BUSINESS_DB_ERROR","The server is unable to process the request due to a database error","There was an issue with the server. Please resubmit your request after some time"),
	SERVER_ERROR ("SERVER_ERROR", "An internal Error occurred","There was an issue with the server. Please resubmit your request after some time"),
	BM_CATALOG_SERVER_ERROR("BM_CATALOG_SERVER_ERROR", " is unable to process this request at this time","There was an issue with the server. Please resubmit your request after some time"),
	SERVICE_UNAVAILABLE("SERVICE_UNAVAILABLE","Service Unavailable","There was an issue with the server. Please resubmit your request after some time."),
	MANDATORY_INPUT_MISSING("MANDATORY_INPUT_MISSING", "Mandatory Inputs Missing","Please input mandatory fields for this operation."),
	
	NOT_FOUND("NOT_FOUND","No Data Found","No data found for the given criteria"),
	NOT_CATALOG_ITEMS_FOUND("NOT_CATALOG_ITEMS_FOUND","No product offering found for the given criteria","No product offerings available"),
	PRODUCT_OFFERING_NOT_FOUND("PRODUCT_OFFERING_NOT_FOUND","No product offering found for the given criteria","No product offerings available"),
	PRODUCT_CATALOG_SPEC_NOT_FOUND("PRODUCT_CATALOG_SPEC_NOT_FOUND","No data found for the given input critiera. Geography, customerType and SalesChannel and customer segment combination is invalid.","Something went wrong with the request. Please try again after sometime."),
	CATALOG_ITEM_RULE_NOT_FOUND("CATALOG_ITEM_RULE_NOT_FOUND","No CatalogItem Rules Found in database","There was an issue with the server. Please resubmit your request after some time"),
	
	SPEED_NOT_FOUND("SPEED_NOT_FOUND","No faster speed found for the given criteria","No faster speed available"),
	OTT_DISCOUNT_NOT_FOUND("OTT_DISCOUNT_NOT_FOUND","No OTT discount found for the given criteria","No OTT discount found available"),
	
	SERVER_TIMEOUT_ERROR("SERVER_TIMEOUT_ERROR","The server cannot handle the request and is timing out","There was an issue with the server. Please resubmit your request after some time"),
	PRODUCT_OFFER_ATTRIBUTE_NOT_FOUND("PRODUCT_OFFER_ATTRIBUTE_NOT_FOUND","No Data Found","There was an issue with the server. Please resubmit your request after some time"),
	BAD_REQUEST("BAD_REQUEST","Bad Request","Something went wrong with the request. Please try again after sometime."),
	/**
	 * CatalogSpec
	 */
	INVALID_CATALOG_SPEC_REQUEST("INVALID_CATALOG_SPEC_REQUEST","Request may not be null or empty.","Something went wrong with the request. Please try again after sometime."),
	INVALID_CATALOG_SPEC_NAME("INVALID_CATALOG_SPEC_NAME","Catalog spec name may not be null or empty.","Something went wrong with the request. Please try again after sometime."),
	INVALID_CATALOG_SPEC_ID("INVALID_CATALOG_SPEC_ID","Catalog spec name or id may not be null or empty.","Something went wrong with the request. Please try again after sometime."),
	INVALID_CATALOG_NAME("INVALID_CATALOG_NAME","Catalog name may not be null or empty.","Something went wrong with the request. Please try again after sometime."),
	/**
	 * Edit create List<ProductOffering>
	 */
	INVALID_OFFER_LIST("INVALID_OFFER_LIST","Request may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_OFFER_LIST_PRODUCT("INVALID_PRODUCT_LIST","Products may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	/**
	 * OfferAvailabiltyRequest
	 */
	INVALID_OFFER_AVAILABILTY_REQUEST("INVALID_OFFER_AVAILABILTY_REQUEST","Request may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_OFFER_AVAILABILTY_REQUEST_OFFER_CATEGORY_INFO("INVALID_OFFER_CATEGORY_INFO","Offer category info may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	/**
	 * OfferCategoryRequest
	 */
	INVALID_OFFER_CATEGORY_SCHEDULED_RESPONSE("INVALID_OFFER_CATEGORY_SCHEDULED_RESPONSE","Scheduled response may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	/**
	 * AddonOfferCatalogRequest
	 */
	INVALID_ADDON_REQUEST("INVALID_ADDON_REQUEST","Request may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_ADDON_REQUEST_CATALOGS("INVALID_CATALOGS","Catalogs may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_ADDON_REQUEST_CATALOG_SPEC_ID("INVALID_CATALOG_SPEC_ID","Catalogspec id may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_ADDON_REQUEST_PRODUCT_OFFERINGS("INVALID_PRODUCT_OFFERINGS","Product offerings may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_ADDON_REQUEST_PRODUCT_OFFERING_ID("INVALID_PRODUCT_OFFERING_ID","Product offering id may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_ADDON_REQUEST_CATALOG_ID("INVALID_CATALOG_ID","Catalog id may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	/**
	 * ServiceAttributesRequest
	 */
	INVALID_SERVICE_ATTRIBUTE("INVALID_SERVICE_ATTRIBUTE","Request may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_GEOGRAPHY("INVALID_GEOGRAPHY","Geography may not be null or empty.", "Something went wrong with the request. Please try again after sometime.."),
	INVALID_CITY("INVALID_CITY","City may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_STATE("INVALID_STATE","State may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_WIRECENTER("INVALID_WIRECENTER","Wirecenter may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_SALES_CHANNEL("INVALID_SALES_CHANNEL","Sales channel may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_CUSTOMER_TYPE("INVALID_CUSTOMER_TYPE","Customer type may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_CUSTOMER_SEGMENT("INVALID_CUSTOMER_SEGMENT","Customer segment may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_QUALIFIED_SERVICE("INVALID_QUALIFIED_SERVICE","Qualified service may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_SERVICE_CATEGORY("INVALID_SERVICE_CATEGORY","Service category service may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_UPSPEED("INVALID_UPSPEED","Upspeed may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_DOWNSPEED("INVALID_DOWNSPEED","Downspeed may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_TECHNOLOGY("INVALID_TECHNOLOGY","Technology may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	
	/**
	 * ProductCatalogSpecification
	 */
	INVALID_PRODUCT_CATALOG_SPECIFICATION("INVALID_PRODUCT_CATALOG_SPECIFICATION","Catalog specification may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	
	/**
	 * CallReferralRequest
	 */
	INVALID_CALL_REFERRAL("INVALID_CALL_REFERRAL","Call Referral request may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_OFFER_INFO("INVALID_OFFER_INFO","Offer Info may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_ATTRIBUTE_NAME("INVALID_ATTRIBUTE_NAME","Attribute Name may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_ATTRIBUTE_VALUE("INVALID_ATTRIBUTE_VALUE","Attribute value  may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_PRODUCT_INFO("INVALID_PRODUCT_INFO","Product info may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_OFFERATTRB_INFO("INVALID_OFFERATTRB_INFO","Offer attribute info may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	
	
	/**
	 * ProductCatalog
	 */
	INVALID_PRODUCT_CATALOG("INVALID_PRODUCT_CATALOG","Catalog may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_PRODUCT_CATALOG_NAME("INVALID_PRODUCT_CATALOG_NAME","Catalog name may not be null or empty.", "Something went wrong with the request. Please try again after sometime."),
	INVALID_PRODUCT_CATALOG_ITEMS("INVALID_PRODUCT_CATALOG_ITEMS","Catalog items may not be null or empty.", "Something went wrong with the request. Please try again after sometime.");
	
	
	private final String reasonCode;
	private final String message;
	private final String messageDetail;
	public String getReasonCode() {
		return reasonCode;
	}
	public String getMessage() {
		return message;
	}
	public String getMessageDetail() {
		return messageDetail;
	}
	private ErrorCodes(String reasonCode, String message, String messageDetail) {
		this.reasonCode = reasonCode;
		this.message = message;
		this.messageDetail = messageDetail;
	}
	
	
}
