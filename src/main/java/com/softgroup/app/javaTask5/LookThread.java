package com.softgroup.app.javaTask5;

/**
 * Created by inna on 09.03.17.
 */
public class LookThread implements Runnable {

    long n;

    public LookThread(long n) {
        this.n = n;
    }

    @Override
    public void run() {
        fibonacci(n);
    }

    private static void fibonacci(long n) {
        long x = 1;
        long y = 1;

        for (long i = 2; i < n; i++) {
            y += x;
            x = y - x;
        }
        System.out.println(" The n-th number in the Fibonacci sequence = " + y + ".");
    }
}
