package com.nish.ExceptionHandling.Exception_Propagation;

import java.util.Scanner;

public class PropagationDemo {

    // Scanner is declared static so all static methods can access it
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        // Execution starts here
        // main() calls method1()
        method1();
        
        // IMPORTANT:
        // This line will execute ONLY IF no exception occurs.
        // If ArithmeticException happens in method3() and is not caught,
        // the exception propagates to JVM and program terminates.
        System.out.println("End of program");
    }

    static void method3() {
        
        // Taking input from user
        System.out.println("Enter numerator: ");
        int numerator = scanner.nextInt();

        System.out.println("Enter denominator: ");
        int denominator = scanner.nextInt();

        // If denominator is 0, ArithmeticException occurs here.
        // Since there is no try-catch in this method,
        // exception is not handled here.
        int divide = numerator / denominator;

        // This line will not execute if exception occurs above.
        System.out.println("Answer is: " + divide);
    }

    static void method2() {
        
        // method2 does not handle exception.
        // So if method3 throws exception,
        // it propagates to method2 and then further up.
        method3();
    }

    static void method1() {
        
        // method1 also does not handle exception.
        // So propagation continues upward to main().
        method2();
    }
}