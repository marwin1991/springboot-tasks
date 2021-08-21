package com.codecool.spingboot_tasks.future_java.calculations;

import java.math.BigInteger;
import java.util.Random;

public class LongCalculations {

    public int firstLongCalculation() {
//        BigInteger veryBig = new BigInteger(2000, new Random());
//        return veryBig.nextProbablePrime();
        try {
            Thread.sleep(10000);
            return 10;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 9;
        }
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
