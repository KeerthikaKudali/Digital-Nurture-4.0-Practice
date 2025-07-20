package com.cognizant.spring_learn.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException; 
import org.springframework.http.HttpStatus; 

import com.cognizant.spring_learn.model.Country;
import jakarta.annotation.PostConstruct; 

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    private List<Country> countries;
    @PostConstruct
    public void init() {
        LOGGER.info("START - CountryService init()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        this.countries = (List<Country>) context.getBean("countryList");
        LOGGER.debug("Loaded countries: {}", countries);
        LOGGER.info("END - CountryService init()");
    }
    public Country getCountry(String code) {
        LOGGER.info("START - getCountry(code: {})", code);
        Country foundCountry = countries.stream()
                                        .filter(country -> country.getCode().equalsIgnoreCase(code))
                                        .findFirst()
                                        .orElse(null);
        if (foundCountry == null) {
            LOGGER.warn("Country with code {} not found.", code);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found with code: " + code);
        }
        LOGGER.debug("Found country: {}", foundCountry);
        LOGGER.info("END - getCountry()");
        return foundCountry;
    }
}