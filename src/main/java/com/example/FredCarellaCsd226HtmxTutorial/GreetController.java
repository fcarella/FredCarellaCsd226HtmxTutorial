package com.example.FredCarellaCsd226HtmxTutorial;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import org.springframework.web.reactive.result.view.Rendering;


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

    @GetMapping(path = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Rendering> stream() {
        return Flux.interval(Duration.ofSeconds(5)).map(value -> Rendering.view("time")
                .modelAttribute("value", value)
                .modelAttribute("time", System.currentTimeMillis()).build());
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