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

    private static final int I = 1000;

    private ExecutorService executor = Executors.newFixedThreadPool(I);

    private final Logger log = LoggerFactory.getLogger(LongCalculationsService.class);

    public BigInteger calc(){
        log.info("Rozpoczęcie obliczeń");
        LongCalculations longCalculations = new LongCalculations();

        List<Future<BigInteger>> futures = new LinkedList<>();
        for(int i = 0; i < I; i++){
            int finalI = i;
            futures.add(executor.submit(() -> {
                log.info("Rozpoczęto " + finalI + " obliczenie");
                BigInteger aRes = longCalculations.firstLongCalculation();
                log.info("Zakończono " + finalI + " obliczenie");
                return aRes;
            }));
        }

        log.info("Przed try");

        try {
            BigInteger sum = BigInteger.ZERO;
            for(int i = 0; i < I; i++) {
                sum = sum.add(futures.get(0).get());
            }

            log.info("Zakończono obliczenia");
            return sum;

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
