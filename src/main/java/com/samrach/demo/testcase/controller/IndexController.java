package com.samrach.demo.testcase.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Hidden
@RestController
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public ResponseEntity<Object> index() {
        return ResponseEntity.ok(
                Map.of("health", "good")
        );
    }

    @GetMapping(value = {"/api-doc", "/api-docs"})
    public RedirectView apiDoc() {
        return new RedirectView("/swagger-ui.html");
    }

    @GetMapping("/info")
    public ResponseEntity<Object> info() {
        return ResponseEntity.ok(
                Map.of(
                        "application", "Test Case Application",
                        "version", "1.0.0",
                        "description", "This is a simple application for testing purposes",
                        "author", "Samrach"
                )
        );
    }
}
