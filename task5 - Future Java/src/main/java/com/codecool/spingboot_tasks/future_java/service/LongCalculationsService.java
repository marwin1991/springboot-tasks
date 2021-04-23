package com.codecool.spingboot_tasks.future_java.service;

import com.codecool.spingboot_tasks.future_java.calculations.LongCalculations;
import org.springframework.stereotype.Service;

@Service
public class LongCalculationsService {

    public int calc(){
        LongCalculations longCalculations = new LongCalculations();
        int a = longCalculations.firstLongCalculation();
        int b = longCalculations.secondLongCalculation();
        return a + b;
    }
}
