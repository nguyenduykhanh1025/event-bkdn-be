package com.onlinehotelreservations.exceptions.authentication;

public class PasswordLoginFailedException extends RuntimeException {
    public PasswordLoginFailedException() {
        super("Password login failed");
    }
}
