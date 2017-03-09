package com.softgroup.app.javaTask5;

import java.util.Scanner;

/**
 * Created by inna on 08.03.17.
 */
public class JavaTask5 {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("The complexity of the algorithm O(N), where  where N - is a number in the Fibonacci sequence.");
        System.out.print(" N = ");

        long n = new Scanner(System.in).nextLong();
        new Thread(new LookThread(n)).start();
    }
}
