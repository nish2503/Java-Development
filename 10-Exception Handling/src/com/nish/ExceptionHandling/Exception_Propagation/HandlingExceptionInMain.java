package com.nish.ExceptionHandling.Exception_Propagation;

import java.util.Scanner;

public class HandlingExceptionInMain {

    // Scanner declared static so it can be accessed inside all static methods
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // We are calling method1() inside a try block.
        // If any ArithmeticException occurs in the call chain,
        // it will propagate back here and be caught.
        try {
            method1();
        } catch (ArithmeticException e) {
            // This block executes ONLY if division by zero happens.
            // The exception propagates from method3 → method2 → method1 → main.
            System.out.println("Handled in main");
        }

        // This line executes in both cases:
        // 1. If no exception occurs.
        // 2. If exception occurs but is caught above.
        System.out.println("Program continues");
    }

    static void method3() {

        System.out.println("Enter numerator: ");
        int numerator = scanner.nextInt();

        System.out.println("Enter denominator: ");
        int denominator = scanner.nextInt();

        // If denominator is 0, ArithmeticException occurs here.
        // Since there is NO try-catch inside this method,
        // the exception is not handled here and propagates upward.
        int divide = numerator / denominator;

        // This line executes ONLY if no exception occurs above.
        System.out.println("Answer is: " + divide);
    }

    static void method2() {

        // method2 does not handle the exception.
        // If method3 throws an exception,
        // it automatically propagates to method2 and then further up.
        method3();
    }

    static void method1() {

        // method1 also does not handle the exception.
        // So propagation continues upward to main().
        method2();
    }
}