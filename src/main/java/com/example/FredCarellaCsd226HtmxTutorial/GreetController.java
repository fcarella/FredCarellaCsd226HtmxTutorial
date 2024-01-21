package com.example.FredCarellaCsd226HtmxTutorial;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
@RestController
public class GreetController {

    @GetMapping("/user")
    public String user() {
        return "Fred";
    }

    @PostMapping("/greet")
    public String greet(@ModelAttribute Greeting values) {
        return "Hello " + values.getValue() + "!";
    }


    static class Greeting {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}