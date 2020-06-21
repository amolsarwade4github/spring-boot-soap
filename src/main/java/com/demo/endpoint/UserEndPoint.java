package com.demo.endpoint;

import com.demo.service.UserService;
import com.demo.spring_boot_soap_example.GetUserRequest;
import com.demo.spring_boot_soap_example.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndPoint {

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = "http://demo.com/spring-boot-soap-example", localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {

        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUser(request.getName()));
        return response;
    }
}
