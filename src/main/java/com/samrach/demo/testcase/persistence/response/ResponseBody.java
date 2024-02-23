package com.samrach.demo.testcase.persistence.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBody<T> {
    private T data;
    private String message;

    public ResponseBody(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public ResponseBody(T data) {
        this.data = data;
    }

    public ResponseBody(String message) {
        this.message = message;
    }
}
