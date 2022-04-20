package com.onlinehotelreservations.controller.user.exception;

public class UserIsNotExistsException extends RuntimeException {
    public UserIsNotExistsException(int id) {
        super("User is n exist with id: " + id);
    }
}