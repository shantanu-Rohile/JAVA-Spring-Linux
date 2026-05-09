package com.shantanu.spring.validationdemo.Model;

import com.shantanu.spring.validationdemo.Annotation.CourseCode;
import jakarta.validation.constraints.*;

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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    @NotNull(message = "is required")
    @Min(value=0, message = "Value must be greater than 0")
    @Max(value=10, message = "Value must be less than or equal to 10")
    private Integer freePasses;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 characters/digits")
    private String postalCode;


    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @CourseCode(value="LUV", message = "Must start with LUV")
    private String courseCode;
}
