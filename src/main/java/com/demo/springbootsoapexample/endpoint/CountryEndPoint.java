package com.demo.springbootsoapexample.endpoint;

import com.demo.spring_boot_soap_example.Country;
import com.demo.spring_boot_soap_example.GetCountryRequest;
import com.demo.spring_boot_soap_example.GetCountryResponse;
import com.demo.springbootsoapexample.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndPoint {

    @Autowired
    private CountryService service;

    @PayloadRoot(namespace = "http://demo.com/spring-boot-soap-example", localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountryRequest(@RequestPayload GetCountryRequest request) {

        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(service.getCountry(request.getName()));

        return response;

    }

}
