package com.cognizant.orm_learn.model;

// Changed imports from javax.persistence to jakarta.persistence for Spring Boot 3.x and Java 17+ compatibility
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity indicates that this class is a JPA entity and maps to a database table.
@Entity
// @Table specifies the name of the database table that this entity maps to.
// If not specified, the table name defaults to the entity class name.
@Table(name = "country")
public class Country {

    // @Id marks the primary key field of the entity.
    // @Column specifies the mapping to a database column.
    // 'name' attribute defines the column name in the database.
    @Id
    @Column(name = "co_code") // Maps to the 'co_code' column in the 'country' table
    private String code;

    @Column(name = "co_name") // Maps to the 'co_name' column in the 'country' table
    private String name;

    // Default constructor is required by JPA
    public Country() {
    }

    // Parameterized constructor (optional, but good practice)
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getter for 'code'
    public String getCode() {
        return code;
    }

    // Setter for 'code'
    public void setCode(String code) {
        this.code = code;
    }

    // Getter for 'name'
    public String getName() {
        return name;
    }

    // Setter for 'name'
    public void setName(String name) {
        this.name = name;
    }

    // toString() method for easy logging and debugging
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
