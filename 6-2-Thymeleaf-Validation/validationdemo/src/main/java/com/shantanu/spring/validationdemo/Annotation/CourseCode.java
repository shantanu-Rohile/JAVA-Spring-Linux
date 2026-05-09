package com.shantanu.spring.validationdemo.Annotation;


import com.shantanu.spring.validationdemo.Validation.CourseCodeConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    public String value() default "Learn";
    public String message() default "Always Start with Learn";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
