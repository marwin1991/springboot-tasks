package com.codecool.spingboot_tasks.future_java.service;

import com.codecool.spingboot_tasks.future_java.calculations.LongCalculations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class LongCalculationsService {


    public int calc(){
        LongCalculations longCalculations = new LongCalculations();
        return longCalculations.firstLongCalculation() + longCalculations.secondLongCalculation();
    }
}
