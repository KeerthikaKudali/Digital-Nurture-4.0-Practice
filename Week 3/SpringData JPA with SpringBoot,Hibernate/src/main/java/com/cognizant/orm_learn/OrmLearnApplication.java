package com.cognizant.orm_learn;

import java.util.List; // For List
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext; // For ApplicationContext

import com.cognizant.orm_learn.model.Country; // For Country entity
import com.cognizant.orm_learn.service.CountryService; // For CountryService

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args) {
		LOGGER.info("Inside main - Application Starting...");

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);

		testGetAllCountries();

		LOGGER.info("Application finished.");
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start testGetAllCountries()");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("Countries retrieved: {}", countries);

		LOGGER.info("End testGetAllCountries()");
	}
}
    