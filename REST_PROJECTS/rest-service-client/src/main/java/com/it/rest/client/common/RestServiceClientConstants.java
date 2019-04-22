/**
 * 
 */
package com.it.rest.client.common;

/**
 * @author Anubhab_Mohanty
 *
 */
public class RestServiceClientConstants {
	
	public static final String API_VERSION_1 = "v1";
	public static final String SEPERATOR = "/";
	public static final String  DOMAIN_NAME = "common";
	public static final String  SEGMENT_NAME = "eureka";
	public static final String  SERVICE_NAME = "test";
	public static final String  SERVICE_URI= DOMAIN_NAME + SEPERATOR + SEGMENT_NAME + SEPERATOR + API_VERSION_1;
	public static final String  SERVICE_TAG = "RestClientService";
	public static final String  SERVICE_TITLE = "Services to Test Eureka Service Registry";
	public static final String REST_API_PACKAGE = "com.it.rest.client.controller";
	public static final String SWAGGER_TITLE = "Eureka Service Registry Test API - Service Version : ";
	public static final String SWAGGER_DESC = "API's for Eureka Service Registry Test";
	public static final String SWAGGER_VERSION = "1.0";
	public static final String SWAGGER_PATH = "/*.*";

}