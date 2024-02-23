package com.samrach.demo.testcase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public ResponseEntity<Object> index() {
        return ResponseEntity.ok(
                Map.of("health", "good")
        );
    }
}
