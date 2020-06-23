package com.demo.springbootsoapexample.service;

import com.demo.spring_boot_soap_example.Country;
import com.demo.spring_boot_soap_example.Currency;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class CountryService {

    private static Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void init() {
        Country india = new Country();
        india.setName("India");
        india.setCapital("Delhi");
        india.setCurrency(Currency.INR);
        india.setPopulation(14000000);

        Country uae = new Country();
        uae.setName("UAE");
        uae.setCapital("Abu Dhabi");
        uae.setCurrency(Currency.AED);
        uae.setPopulation(100000);

        countries.put(india.getName(), india);
        countries.put(uae.getName(), uae);
    }


    public Country getCountry(String name) {
        return countries.get(name);
    }
}
