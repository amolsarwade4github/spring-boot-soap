package com.demo.springbootsoapexample.service;

import com.demo.spring_boot_soap_example.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void init() {
        User peter = new User();
        peter.setEmpId(111);
        peter.setName("Peter");
        peter.setSalary(10000);
        users.put(peter.getName(), peter);

        User sam = new User();
        sam.setEmpId(112);
        sam.setName("Sam");
        sam.setSalary(11000);
        users.put(sam.getName(), sam);

        User ryan = new User();
        ryan.setEmpId(113);
        ryan.setName("Ryan");
        ryan.setSalary(12000);
        users.put(ryan.getName(), ryan);
    }

    public User getUser(String name) {
        return users.get(name);
    }
}
