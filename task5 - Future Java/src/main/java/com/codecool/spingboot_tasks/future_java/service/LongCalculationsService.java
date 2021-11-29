package com.codecool.spingboot_tasks.future_java.service;

import com.codecool.spingboot_tasks.future_java.calculations.LongCalculations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class LongCalculationsService {

    private final Logger log = LoggerFactory.getLogger(LongCalculationsService.class);

    private static final int N = 1000;

    private ExecutorService executor = Executors.newFixedThreadPool(N);

    public BigInteger longCalc() throws ExecutionException, InterruptedException {
        log.info("Stared calculations");
        LongCalculations longCalculations = new LongCalculations();
        List<Future<BigInteger>> futures = new LinkedList<>();

        for(int i = 0; i < N; i++){
            int finalI = i;
            futures.add(executor.submit(() -> longCalculations.longCalc(finalI)));
        }

        BigInteger sum = BigInteger.ZERO;

        for(int i = 0; i < N; i++){
            sum = sum.add(futures.get(i).get());
        }


        log.info("finieshed calculations");

        return sum;
    }

    public int calc() throws ExecutionException, InterruptedException {
        log.info("Stared calculations");
        LongCalculations longCalculations = new LongCalculations();

        //FutureTask,
        //jak wystartować nowy wątek w javie
        //popularne problemy wielatkowe
        Future<Integer> future1 = executor.submit(() -> longCalculations.firstLongCalculation());
        Future<Integer> future2 = executor.submit(() -> longCalculations.secondLongCalculation());
        Future<Integer> future3 = executor.submit(() -> longCalculations.firstLongCalculation());
        Future<Integer> future4 = executor.submit(() -> longCalculations.secondLongCalculation());

        int f = future1.get() + future2.get() + future3.get() + future4.get();
        log.info("finieshed calculations");
        return f;
    }
}
