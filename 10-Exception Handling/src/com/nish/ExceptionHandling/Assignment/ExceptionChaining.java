package com.nish.ExceptionHandling.Assignment;

public class ExceptionChaining {

    public static void main(String[] args) {

        try {
            processPayment();
        }
        catch (RuntimeException e) {

            System.out.println("Final Exception: " + e);
            System.out.println("Cause: " + e.getCause());

            System.out.println("\nFull Stack Trace:");
            e.printStackTrace();
        }
    }

    public static void processPayment() {

        try {
            String paymentId = null;
            System.out.println(paymentId.length());

        }
        catch (NullPointerException e) {
            throw new RuntimeException("Payment processing failed.", e);
        }
    }
}