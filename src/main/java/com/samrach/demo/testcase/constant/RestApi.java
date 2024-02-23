package com.samrach.demo.testcase.constant;

public record RestApi() {
    public static final String API = "/api";

    public record Backend() {
        public static final String BACKEND = API + "/backend";
        public static final String CATEGORY = BACKEND + "/category";
    }
}
