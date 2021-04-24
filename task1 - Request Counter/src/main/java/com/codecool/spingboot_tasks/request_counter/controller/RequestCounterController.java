package com.codecool.spingboot_tasks.request_counter.controller;

import com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService.*;

@RestController
public class RequestCounterController {

    private final RequestCountStatsService service;

    @Autowired
    public RequestCounterController(RequestCountStatsService service) {
        this.service = service;
    }

    @GetMapping("/api/requests")
    public ResponseEntity<Void> get() {
        service.increaseCounter(GET);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/requests")
    public ResponseEntity<Void> post() {
        service.increaseCounter(POST);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/requests")
    public ResponseEntity<Void> put() {
        service.increaseCounter(PUT);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/requests")
    public ResponseEntity<Void> delete() {
        service.increaseCounter(DELETE);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/api/requests")
    public ResponseEntity<Void> patch() {
        service.increaseCounter(PATCH);
        return ResponseEntity.ok().build();
    }

}