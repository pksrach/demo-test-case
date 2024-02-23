package com.samrach.demo.testcase.persistence.request;

public abstract class BaseRequest<E> {
    public abstract E toEntity();
}
