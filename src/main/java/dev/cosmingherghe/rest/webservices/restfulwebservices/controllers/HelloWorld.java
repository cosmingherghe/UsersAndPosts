package dev.cosmingherghe.rest.webservices.restfulwebservices.controllers;

import dev.cosmingherghe.rest.webservices.restfulwebservices.users.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorld {

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello world");
    }

    @GetMapping(path = "/hello-world-bean/{message}")
    public HelloWorldBean helloWorldBean(@PathVariable String message) {
        return new HelloWorldBean(String.format("Hello world %s", message ));
    }
}