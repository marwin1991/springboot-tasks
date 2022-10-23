package com.codecool.spingboot_tasks.request_counter.controller;

import com.codecool.spingboot_tasks.request_counter.model.Statistics;
import com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatsController {

    private final RequestCountStatsService service;

    public StatsController(@Qualifier("requestCountStatsService") RequestCountStatsService service) {
        this.service = service;
    }

    @GetMapping("/api/statistics")
    public List<Statistics> get(){
        return service.getStatistics();
    }
}
