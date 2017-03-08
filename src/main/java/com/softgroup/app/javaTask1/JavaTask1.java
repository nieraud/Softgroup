package com.softgroup.app.javaTask1;

import java.util.Scanner;


/**
 * Created by inna on 05.03.17.
 */
public class JavaTask1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str;

        while (true) {
            str = scanner.nextLine().replaceAll("\\W", "");
            if (isPalindrome(str))
                System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
    }
}
