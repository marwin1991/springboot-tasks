package com.codecool.spingboot_tasks.future_java.controller;

import com.codecool.spingboot_tasks.future_java.service.LongCalculationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class LongCalculationsController {

    private final LongCalculationsService service;

    public LongCalculationsController(LongCalculationsService service) {
        this.service = service;
    }

    @GetMapping("/calc")
    public BigInteger calc(){
        return service.calc();
    }
}
