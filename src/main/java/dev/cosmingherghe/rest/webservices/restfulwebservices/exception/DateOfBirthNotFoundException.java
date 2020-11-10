package dev.cosmingherghe.rest.webservices.restfulwebservices.exception;

public class DateOfBirthNotFoundException extends RuntimeException {

    public DateOfBirthNotFoundException() {
        super("Date of birth not found!");
    }
}
