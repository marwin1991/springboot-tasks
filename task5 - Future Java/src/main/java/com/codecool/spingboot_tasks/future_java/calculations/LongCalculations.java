package com.codecool.spingboot_tasks.future_java.calculations;

import java.math.BigInteger;
import java.util.Random;

public class LongCalculations {

    public BigInteger firstLongCalculation() {
        BigInteger veryBig = new BigInteger(2000, new Random());
        return veryBig.nextProbablePrime();
    }

    public int secondLongCalculation() {
        try {
            Thread.sleep(17000);
            return 17;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 9;
        }
    }
}
