package com.samrach.demo.testcase.controller;

import com.samrach.demo.testcase.persistence.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandlerController {
    @ExceptionHandler(value = Exception.class)
    public BaseResponse<Object> handleException(Exception e) {
        return new BaseResponse<>(
                Map.of("message", e.getMessage()),
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity<Object> handleNoResourceFoundException(NoResourceFoundException e) {
        return new ResponseEntity<>(
                Map.of("message", "Resource not found: " + e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = UnsupportedOperationException.class)
    public ResponseEntity<Object> handleUnsupportedOperationException(UnsupportedOperationException e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity<Object> handleNumberFormatException(NumberFormatException e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Object> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<Object> handleIndexOutOfBoundsException(IndexOutOfBoundsException e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = StringIndexOutOfBoundsException.class)
    public ResponseEntity<Object> handleStringIndexOutOfBoundsException(StringIndexOutOfBoundsException e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = ClassCastException.class)
    public ResponseEntity<Object> handleClassCastException(ClassCastException e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = SQLDataException.class)
    public ResponseEntity<Object> handleSQLDataException(SQLDataException e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = SQLException.class)
    public ResponseEntity<Object> handleSQLException(SQLException e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
