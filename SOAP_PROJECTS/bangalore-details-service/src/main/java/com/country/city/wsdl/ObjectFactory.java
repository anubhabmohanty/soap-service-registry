//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.04.22 at 01:54:52 AM IST 
//


package com.country.city.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.country.city.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LocationResponse_QNAME = new QName("http://xmlns.example.com/location/details", "LocationResponse");
    private final static QName _LocationRequest_QNAME = new QName("http://xmlns.example.com/location/details", "LocationRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.country.city.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LocationRequest }
     * 
     */
    public LocationRequest createLocationRequest() {
        return new LocationRequest();
    }

    /**
     * Create an instance of {@link LocationResponse }
     * 
     */
    public LocationResponse createLocationResponse() {
        return new LocationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.example.com/location/details", name = "LocationResponse")
    public JAXBElement<LocationResponse> createLocationResponse(LocationResponse value) {
        return new JAXBElement<LocationResponse>(_LocationResponse_QNAME, LocationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.example.com/location/details", name = "LocationRequest")
    public JAXBElement<LocationRequest> createLocationRequest(LocationRequest value) {
        return new JAXBElement<LocationRequest>(_LocationRequest_QNAME, LocationRequest.class, null, value);
    }

}
