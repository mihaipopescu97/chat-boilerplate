package com.travelin.travelinchat.controllers.advices;

import com.mongodb.MongoException;
import com.travelin.travelinchat.controllers.UserController;
import com.travelin.travelinchat.dtos.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 4/14/2023, Fri
 **/

@ControllerAdvice(assignableTypes = UserController.class)
public class UserControllerAdvice {

    @ExceptionHandler(value = MongoException.class)
    public ResponseEntity<?> handleMongoException(final MongoException exception, final HttpServletRequest request) {
        switch (exception.getCode()) {
            case 121 -> {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            case 11000 -> {
                return new ResponseEntity<>(createErrorResponse(exception.getMessage(), request, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
            }
            default -> {
                return new ResponseEntity<>(createErrorResponse("Uncached error", request, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    private ErrorResponse createErrorResponse(final String message,
                                              final HttpServletRequest request,
                                              final HttpStatus httpStatus) {

        final ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(httpStatus);
        errorResponse.setUri(request.getRequestURI());
        errorResponse.setMessage(message);

        return errorResponse;
    }
}
