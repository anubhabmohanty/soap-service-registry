package com.it.rest.client.controller;

import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;
import com.it.rest.client.common.RestServiceClientConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Anubhab_Mohanty
 *
 */

@RestController
@RequestMapping(RestServiceClientConstants.SERVICE_URI)
@Api(tags= RestServiceClientConstants.SERVICE_TAG, value = RestServiceClientConstants.SERVICE_TITLE)
public class RestServiceClientController {

	@Autowired
	@LoadBalanced
	private WebServiceTemplate webServiceTemplate;

	private Logger logger = LoggerFactory.getLogger(RestServiceClientController.class);

	public static String request = "<det:LocationRequest xmlns:det=\"http://xmlns.example.com/location/details\">\r\n" + 
			"         <det:uniqueId>12</det:uniqueId>\r\n" + 
			"         <det:locationKey>FGFF</det:locationKey>\r\n" + 
			"      </det:LocationRequest>";


	@SuppressWarnings("unchecked")
	@ApiOperation(value = "Test Service Registry for SOAP", httpMethod = "GET")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Service Registry working Properly for SOAP", response = String.class)})
	@GetMapping(path = "/soap", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<JSONObject> checkServiceRegistrySOAP() {
		logger.info("Calling SOAP service for Service Registry check.........");
		JSONObject jsonObject = new JSONObject();
		try {
			StringResult responseResult = new StringResult();
			webServiceTemplate.sendSourceAndReceiveToResult(new StringSource(request), responseResult);
			jsonObject.put("Response", responseResult.toString());
			return new ResponseEntity<>(jsonObject, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error in Service call : ", e);
			e.printStackTrace();
			jsonObject.put("Error_Msg", e.getMessage());
		}
		return new ResponseEntity<>(jsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}