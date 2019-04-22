package com.country.city.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.country.city.common.constants.Constants;
import com.country.city.wsdl.LocationRequest;
import com.country.city.wsdl.LocationResponse;
import com.country.city.wsdl.ReturnMessageType;

@Endpoint
public class BangaloreLocationDetails {

	private Logger logger = LoggerFactory.getLogger(BangaloreLocationDetails.class);
	

	@PayloadRoot(namespace = Constants.TARGET_NAME_SPACE, localPart = "LocationRequest")
	@ResponsePayload
	public JAXBElement<LocationResponse> processlocationDetailsRequest(
			@RequestPayload LocationRequest request) {

		logger.info("---> LocationDetails request " + request.getUniqueId() + " Location Key -- " + request.getLocationKey());
		LocationResponse locationResponse = new LocationResponse();
		if ("BLR".equalsIgnoreCase(request.getLocationKey())) {
			locationResponse.setCode("0");
			locationResponse.setMessage("Bangalore City details are mentioned");
			locationResponse.setType(ReturnMessageType.SUCCESS);
			locationResponse.setDetails("Pincodes present are : 576001, 576024");
		} else {
			locationResponse.setCode("1");
			locationResponse.setMessage("City code is not Bangalore");
			locationResponse.setType(ReturnMessageType.NON_FATAL_ERROR);
			locationResponse.setDetails("Pincodes of the city are not present");
		}
		return constructResponse(locationResponse);	
	}

	public static JAXBElement<LocationResponse> constructResponse(LocationResponse locationResponse){

		LocationResponse response = new LocationResponse();
		if (null == locationResponse) {
			response.setType(ReturnMessageType.FATAL_ERROR);
			response.setCode("404");
			response.setMessage("Error");
			response.setDetails("Unknown");
		}
		else {
			response = locationResponse;
		}
		return new JAXBElement<LocationResponse>(
				new QName(LocationResponse.class.getSimpleName()), LocationResponse.class, response);
	}

}
