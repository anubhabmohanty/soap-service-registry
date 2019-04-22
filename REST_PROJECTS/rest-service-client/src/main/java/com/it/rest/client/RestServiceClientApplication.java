/**
 * 
 */
package com.it.rest.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author Anubhab_Mohanty
 *
 */


@EnableEurekaClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RestServiceClientApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(RestServiceClientApplication.class);
	
	public static void main (String [] args) {
		logger.info("Main class for Rest service to call the client");
		SpringApplication.run(RestServiceClientApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public WebServiceTemplate webServiceTemplate() {
		
		 WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		 webServiceTemplate.setDefaultUri("http://bangalore-details-service/find/getBangaloreLocationDetails.wsdl");
		 webServiceTemplate.setCheckConnectionForFault(true);
		 return webServiceTemplate;
	}

}
