package com.cognizant.spring_learn.controller; // <-- Make sure it's spring_learn here
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cognizant.spring_learn.model.Country;
@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    // Using @RequestMapping as requested, specifying GET method
    @RequestMapping(value="/country", method=RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia()"); // Log entry point

        // 1. Load the Spring ApplicationContext from country.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // 2. Retrieve the "in" bean (which is a Country object)
        Country country = context.getBean("in", Country.class);

        LOGGER.debug("Country details: {}", country); // Log the retrieved Country object
        LOGGER.info("END - getCountryIndia()");   // Log exit point

        return country; 
        }
}