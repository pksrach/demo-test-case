package com.samrach.demo.testcase.persistence.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
public class ResponseBody<T> {
    private T data;
    private String message;
    private Pageable page;

    public ResponseBody(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public ResponseBody(Page<T> page, String message) {
        @SuppressWarnings("unchecked")
        var data = (T) page.getContent();
        this.data = data;
        this.page = page.getPageable();
        this.message = message;
    }

    public ResponseBody(T data) {
        this.data = data;
    }

    public ResponseBody(String message) {
        this.message = message;
    }

    public static <T> ResponseBody<T> success(T data, String message) {
        return new ResponseBody<>(data, message);
    }

    public static <T> ResponseBody<T> success(Page<T> page, String message) {
        return new ResponseBody<>(page, message);
    }

    public static <T> ResponseBody<T> error(String message) {
        return new ResponseBody<>(message);
    }
}
