package com.samrach.demo.testcase.persistence.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Getter
public class BaseResponse<T> {

    private final ResponseEntity<ResponseBody<T>> responseEntity;

    public BaseResponse(T data, String message, HttpStatus status) {
        this.responseEntity = new ResponseEntity<>(new ResponseBody<>(data, message), status);
    }

    public BaseResponse(T data, HttpStatus status) {
        this.responseEntity = new ResponseEntity<>(new ResponseBody<>(data), status);
    }

    public BaseResponse(String message, HttpStatus status) {
        this.responseEntity = new ResponseEntity<>(new ResponseBody<>(message), status);
    }
}

