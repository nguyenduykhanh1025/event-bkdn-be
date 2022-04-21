package com.onlinehotelreservations.exceptions.authentication;

public class InActiveStatusUserException extends RuntimeException {
    public InActiveStatusUserException(String username) {
        super("Status user " + username + " inActive status");
    }
}
