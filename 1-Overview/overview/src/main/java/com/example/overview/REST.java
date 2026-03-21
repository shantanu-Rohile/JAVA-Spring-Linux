package com.example.overview;


import com.example.overview.constructor_Injection.Uncharted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class REST {
    @Autowired
    private final Uncharted uncharted;

    public REST(Uncharted uncharted) {
        this.uncharted=uncharted;
    }

    @GetMapping("/home")
    public String home() {
        return uncharted.device();
    }
}
