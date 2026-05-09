package com.thymeleaf.thymeleafdemo.Model;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    private String language;

    public void setCountry(String country) {
        this.country = country;
    }

    private String country;

    public Student() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
