package com.onlinehotelreservations.exceptions.event;

public class EventDoesNotExist extends RuntimeException {
    public EventDoesNotExist() {
        super("Event does not exist");
    }
}
