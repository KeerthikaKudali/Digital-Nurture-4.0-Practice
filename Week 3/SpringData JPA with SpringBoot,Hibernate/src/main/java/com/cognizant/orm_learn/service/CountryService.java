package com.cognizant.orm_learn.service;

import java.util.List; // For List

import org.springframework.beans.factory.annotation.Autowired; // For @Autowired
import org.springframework.stereotype.Service; // For @Service
import org.springframework.transaction.annotation.Transactional; // For @Transactional

import com.cognizant.orm_learn.model.Country; // For Country entity
import com.cognizant.orm_learn.repository.CountryRepository; // For CountryRepository

// @Service indicates that this class is a Spring service component.
// It holds business logic and is typically used by controllers or other services.
@Service
public class CountryService {

    // @Autowired automatically injects an instance of CountryRepository.
    // Spring's IoC container manages the creation and lifecycle of this bean.
    @Autowired
    private CountryRepository countryRepository;

    // @Transactional ensures that the entire method runs within a single database transaction.
    // If any part of the method fails, the entire transaction is rolled back.
    // This is crucial for data integrity.
    @Transactional
    public List<Country> getAllCountries() {
        // Invokes the findAll() method provided by JpaRepository.
        // This method fetches all Country entities from the database.
        return countryRepository.findAll();
    }
}

