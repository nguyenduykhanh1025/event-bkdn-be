package com.onlinehotelreservations.exceptions.event;

import com.onlinehotelreservations.exceptions.authentication.EmailLoginFailedException;
import com.onlinehotelreservations.shared.Response;
import com.onlinehotelreservations.shared.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EventException {
    @ExceptionHandler(value = CreateEventFailed.class)
    public ResponseEntity<Object> exception(CreateEventFailed exception) {
        return Response.buildResponseError(new ApiError(HttpStatus.NOT_IMPLEMENTED, exception));
    }

    @ExceptionHandler(value = EventDoesNotExist.class)
    public ResponseEntity<Object> exception(EventDoesNotExist exception) {
        return Response.buildResponseError(new ApiError(HttpStatus.NOT_IMPLEMENTED, exception));
    }

    @ExceptionHandler(value = UpdateEventFailed.class)
    public ResponseEntity<Object> exception(UpdateEventFailed exception) {
        return Response.buildResponseError(new ApiError(HttpStatus.NOT_IMPLEMENTED, exception));
    }
}
