package com.softgroup.app.javaTask2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by inna on 05.03.17.
 */
public class JavaTask2 {
    public static void main(String[] args) {

        System.out.print("Length: ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        int cnt = 1;
        int index = 0;

        while (length > 0) {
            System.out.print("[" + cnt + "] = ");
            array[index] = scanner.nextInt();
            index++;
            cnt++;
            length--;
        }

        System.out.print("Int K = ");
        int k = scanner.nextInt();

        printPairSums(array, k);

    }

     private static void printPairSums(int[] array, int k) {
        Arrays.sort(array);

        int first = 0;
        int last = array.length - 1;

        while (first < last) {
            int s = array[first] + array[last];
            if (s == k) {
                System.out.println("Array[" + array[first] + "][" + array[last] + "] = " + k);
                first++;
                last--;
            } else {
                if (s < k) first++;
                else last--;
            }
        }
    }
}
