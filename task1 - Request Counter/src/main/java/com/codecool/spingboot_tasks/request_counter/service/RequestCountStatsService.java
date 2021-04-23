package com.codecool.spingboot_tasks.request_counter.service;

import com.codecool.spingboot_tasks.request_counter.model.Statistics;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RequestCountStatsService {

    /*
     * Map holding statistics of methods execution. key is method name: GET,PUT etc.
     * value is and integer number representing number of executions
     */
    private Map<String, Integer> stats = new HashMap<>();

    public void increaseCounter(String method){

    }

    public Statistics getStatistics(){
        return null;
    }
}
