package com.shantanu.spring.validationdemo.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {
    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    private String firstname;

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastname;

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }


    @Min(value=0, message = "Value must be greater than 0")
    @Max(value=10, message = "Value must be less than or equal to 10")
    private int freePasses;
}
