package com.cognizant.account.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
    @GetMapping("/accounts/{number}")
    public Map<String, Object> getAccountDetails(@PathVariable String number) {
        LOGGER.info("START - getAccountDetails for account number: {}", number);
        Map<String, Object> accountDetails = new HashMap<>();
        accountDetails.put("number", number);
        accountDetails.put("type", "savings");
        accountDetails.put("balance", new BigDecimal("234343.00"));
        LOGGER.info("END - getAccountDetails. Returning: {}", accountDetails);
        return accountDetails;
    }
}