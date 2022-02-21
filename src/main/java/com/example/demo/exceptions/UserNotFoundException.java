package com.example.demo.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int userId) {
        super("user " + userId + " not found");
    }
}
