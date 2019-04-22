package com.country.city;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Anubhab Mohanty
 */
@EnableEurekaClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BangaloreDetailsApplication {

    private static final Logger logger = LoggerFactory.getLogger(BangaloreDetailsApplication.class);
    public static void main(String[] args) {
        logger.info("Main class for bangalore details service");
        Class[] configurations = {BangaloreDetailsApplication.class};
        SpringApplication.run(configurations, args);
    }
    
    
}
