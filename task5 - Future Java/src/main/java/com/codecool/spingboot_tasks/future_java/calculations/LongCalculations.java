package com.codecool.spingboot_tasks.future_java.calculations;

public class LongCalculations {

    public int firstLongCalculation(){
        try {
            Thread.sleep(3000);
            return 5;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 5;
        }
    }

    public int secondLongCalculation(){
        try {
            Thread.sleep(6000);
            return 9;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 9;
        }
    }
}
