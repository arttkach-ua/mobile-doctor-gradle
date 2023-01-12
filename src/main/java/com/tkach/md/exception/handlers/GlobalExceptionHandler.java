package com.tkach.md.exception.handlers;

import com.tkach.md.util.ErrorResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(EntityNotFoundException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        setCommonData(exception, errorResponse, request);
        log.error("exception type is {}, message = {}, description {}" , exception.getClass().getSimpleName(),exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EntityExistsException.class})
    protected ResponseEntity<Object> handleEntityExists(EntityExistsException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        setCommonData(exception, errorResponse, request);
        log.error("exception type is {}, message = {}, description {}" , exception.getClass().getSimpleName(),exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    private void setCommonData(Exception exception, ErrorResponse errorResponse, WebRequest request) {
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        errorResponse.setException(exception.getClass().getName());
        errorResponse.setDetails(request.getDescription(false));
    }
}
