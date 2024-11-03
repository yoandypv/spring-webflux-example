package com.sacavix.hellospringwebflux;

public class SleepUtils {
    public static void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
    }
}
