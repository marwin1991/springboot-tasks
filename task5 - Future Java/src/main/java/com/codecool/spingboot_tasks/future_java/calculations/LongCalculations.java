package com.codecool.spingboot_tasks.future_java.calculations;

import com.codecool.spingboot_tasks.future_java.service.LongCalculationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Random;

public class LongCalculations {

    private final Logger log = LoggerFactory.getLogger(LongCalculations.class);

    public BigInteger longCalc(int i){
        log.info("Started " + i);
        BigInteger veryBig = new BigInteger(4000, new Random());
        BigInteger bigInteger = veryBig.nextProbablePrime();
        log.info("Finished " + i);

        return bigInteger;
    }

    public int firstLongCalculation() {
//        BigInteger veryBig = new BigInteger(2000, new Random());
//        return veryBig.nextProbablePrime();
        try {
            log.info("Started 1 calc");
            Thread.sleep(10000);
            log.info("Finished 1 calc");
            return 10;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 9;
        }
    }

    public int secondLongCalculation() {
        try {
            log.info("Started 2 calc");
            Thread.sleep(17000);
            log.info("Finished 2 calc");
            return 17;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 9;
        }
    }
}
