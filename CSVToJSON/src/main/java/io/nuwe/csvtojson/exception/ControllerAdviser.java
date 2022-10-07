package io.nuwe.csvtojson.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdviser {

    private static final String TIMESTAMP = "timestamp";
    private static final String MESSAGE = "message";

    @ExceptionHandler(MissingServletRequestPartException.class)
    public ResponseEntity<Object> handleMissingFile(MissingServletRequestPartException ex) {
        Map<String, Object> errors = new HashMap<>();

        errors.put(TIMESTAMP, LocalDateTime.now());
        errors.put(MESSAGE, "Error: no file found");

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<Object> handleMissingFile(MultipartException ex) {
        Map<String, Object> errors = new HashMap<>();

        errors.put(TIMESTAMP, LocalDateTime.now());
        errors.put(MESSAGE, "Error: no file found or bad file type");

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<Object> handleBadFileType(InvalidFormatException ex) {
        Map<String, Object> errors = new HashMap<>();

        errors.put(TIMESTAMP, LocalDateTime.now());
        errors.put(MESSAGE, ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        Map<String, Object> errors = new HashMap<>();

        errors.put(TIMESTAMP, LocalDateTime.now());
        errors.put(MESSAGE, ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}