package dev.cosmingherghe.rest.webservices.restfulwebservices.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
