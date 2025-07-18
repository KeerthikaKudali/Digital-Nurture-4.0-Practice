package com.cognizant.orm_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.model.Country;

// @Repository indicates that this interface is a Spring Data JPA repository.
// It enables Spring's component scanning to find and configure this repository.
@Repository
// JpaRepository<T, ID> provides standard CRUD operations.
// T: The entity type (Country in this case).
// ID: The type of the primary key of the entity (String for Country's 'code').
public interface CountryRepository extends JpaRepository<Country, String> {
    // Spring Data JPA automatically provides implementations for methods like
    // save(), findById(), findAll(), deleteById(), etc.
    // You can also define custom query methods here, e.g.,
    // List<Country> findByNameStartingWith(String prefix);
}
