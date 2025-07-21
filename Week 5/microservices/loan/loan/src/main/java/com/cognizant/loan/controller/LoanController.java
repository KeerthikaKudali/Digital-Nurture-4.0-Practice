package com.cognizant.loan.controller;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LoanController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);
    @GetMapping("/loans/{number}")
    public Map<String, Object> getLoanDetails(@PathVariable String number) {
        LOGGER.info("START - getLoanDetails for loan number: {}", number);
        Map<String, Object> loanDetails = new HashMap<>();
        loanDetails.put("number", number);
        loanDetails.put("type", "car");
        loanDetails.put("loan", new BigDecimal("800000.00"));
        loanDetails.put("emi", new BigDecimal("3258.00"));
        loanDetails.put("tenure", 18);
        LOGGER.info("END - getLoanDetails. Returning: {}", loanDetails);
        return loanDetails;
    }
}