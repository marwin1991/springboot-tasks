package com.codecool.spingboot_tasks.request_counter.controller;

import com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@SessionScope
@RestController
public class RequestCounterController {

    private final List<String> shoppingCart;

    private final RequestCountStatsService service;

    @Autowired
    public RequestCounterController(RequestCountStatsService service) throws InterruptedException {
        //Thread.sleep(10000);
        this.shoppingCart = new ArrayList<>();
        this.service = service;
    }

    @PostConstruct
    public void init() {
        System.out.println("RequestCounterController has bean created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("RequestCounterController will be deleted");
    }

    @GetMapping("/api/requests")
    public ResponseEntity<Void> get() throws InterruptedException {
//        System.out.println("GET REQUEST");
//        service.increaseCounter(GET);
        Thread.sleep(5000);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/requests")
    public ResponseEntity<Void> post() {
//        service.increaseCounter(POST);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/requests")
    public ResponseEntity<Void> put() {
//        service.increaseCounter(PUT);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/requests")
    public ResponseEntity<Void> delete() {
//        service.increaseCounter(DELETE);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/api/requests")
    public ResponseEntity<Void> patch() {
//        service.increaseCounter(PATCH);
        return ResponseEntity.ok().build();
    }

}