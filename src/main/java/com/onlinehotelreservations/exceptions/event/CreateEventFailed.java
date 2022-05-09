package com.onlinehotelreservations.exceptions.event;

public class CreateEventFailed extends RuntimeException {
    public CreateEventFailed() {
        super("Create event failed");
    }
}
