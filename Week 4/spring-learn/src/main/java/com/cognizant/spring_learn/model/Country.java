package com.cognizant.spring_learn.model;

public class Country {
    private String code;
    private String name;

    // Default Constructor is important for Spring and JSON serialization
    public Country() {
        // Default constructor
    }

    // Getters and Setters are crucial for JSON serialization (Jackson library)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Optional: toString() for better logging/debugging
    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
