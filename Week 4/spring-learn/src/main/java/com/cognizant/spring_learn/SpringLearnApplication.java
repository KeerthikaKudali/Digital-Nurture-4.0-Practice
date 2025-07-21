package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

@SpringBootApplication
public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("SpringLearnApplication started successfully!");

        displayDate();
    }

    private static void displayDate() {
        LOGGER.info("START");

        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        String dateString = "31/12/2018";
        try {
            Date parsedDate = format.parse(dateString);
            System.out.println("Parsed Date: " + parsedDate);
            LOGGER.debug("Parsed Date: {}", parsedDate);
        } catch (ParseException e) {
            LOGGER.error("Error parsing date: {}", dateString, e);
            System.err.println("Error parsing date: " + dateString + " - " + e.getMessage());
        }
        LOGGER.info("END");
    }
}