package com.country.city.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.country.city.common.constants.Constants;


@EnableWs
@Configuration
public class WebServiceConfig {
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet, "/find/*");
	}
	
	@Bean(name="getBangaloreLocationDetails")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema carrierStatusSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName(Constants.TARGET_PORT);
		definition.setTargetNamespace(Constants.TARGET_NAME_SPACE);
		definition.setLocationUri(Constants.TARGET_PATH);
		definition.setSchema(carrierStatusSchema);
		return definition;
	}

	@Bean (name = "bangalore")
	public XsdSchema filSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/bangalore.xsd"));
	}

}
