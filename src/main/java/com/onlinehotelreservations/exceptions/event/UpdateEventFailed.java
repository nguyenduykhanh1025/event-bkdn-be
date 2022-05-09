package com.onlinehotelreservations.exceptions.event;

public class UpdateEventFailed extends RuntimeException {
    public UpdateEventFailed() {
        super("Update event failed");
    }
}