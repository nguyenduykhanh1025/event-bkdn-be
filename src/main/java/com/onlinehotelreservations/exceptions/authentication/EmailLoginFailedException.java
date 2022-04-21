package com.onlinehotelreservations.exceptions.authentication;

public class EmailLoginFailedException extends RuntimeException {
    public EmailLoginFailedException() {
        super("Email login failed");
    }
}
