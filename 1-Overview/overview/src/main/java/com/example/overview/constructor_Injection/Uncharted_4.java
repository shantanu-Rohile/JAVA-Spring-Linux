package com.example.overview.constructor_Injection;


import org.springframework.stereotype.Component;

@Component
public class Uncharted_4 implements Uncharted {

    @Override
    public String device() {
        return("CAn be played on pc, ps4, ps5");
    }
}
