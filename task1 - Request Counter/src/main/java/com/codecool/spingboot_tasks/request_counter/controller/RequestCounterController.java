package com.codecool.spingboot_tasks.request_counter.controller;

import com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RequestCounterController {

    private final List<String> shoppingCart;

    private final RequestCountStatsService service;

    @Autowired
    public RequestCounterController(RequestCountStatsService service) throws InterruptedException {
        this.shoppingCart = new ArrayList<>();
        this.service = service;
    }

    @GetMapping("/api/requests")
    public ResponseEntity<Void> get() throws Exception {
        service.increaseCounter(RequestCountStatsService.GET);
        System.out.println(service.getStatistics().get(1));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/requests")
    public ResponseEntity<Void> post() throws Exception {
        service.increaseCounter(RequestCountStatsService.POST);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/requests")
    public ResponseEntity<Void> put() {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/requests")
    public ResponseEntity<Void> delete() {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/api/requests")
    public ResponseEntity<Void> patch() {
        return ResponseEntity.ok().build();
    }

}