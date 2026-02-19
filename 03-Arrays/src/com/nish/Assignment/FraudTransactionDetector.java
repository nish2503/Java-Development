package com.nish.Assignment;

import java.util.*;

public class FraudTransactionDetector {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = scanner.nextInt();

        double[] transactions = new double[n];

        System.out.println("Enter transaction amounts:");

        for (int i = 0; i < n; i++) {
            transactions[i] = scanner.nextDouble();
        }

        List<Integer> suspiciousIndices = new ArrayList<>();

        boolean fraudDetected = false;
        int consecutiveSuspicious = 0;
        double total = 0;

        for (int i = 0; i < n; i++) {

            double amount = transactions[i];
            total += amount;

            if (amount > 50000) {

                System.out.println("Transaction " + i + " flagged as suspicious.");
                suspiciousIndices.add(i);
                consecutiveSuspicious++;

                if (consecutiveSuspicious == 2) {
                    fraudDetected = true;
                }
            }
            else {
                consecutiveSuspicious = 0;
            }
        }

        double average = total / n;

        System.out.println("Results : ");

        System.out.println("Suspicious Transaction Indices: " + suspiciousIndices);

        if (fraudDetected) {
            System.out.println("Potential Fraud Detected (2 consecutive suspicious transactions)");
        } else {
            System.out.println("No Fraud Pattern Detected");
        }

        System.out.println("Average Transaction Value: " + average);

        if (average > 40000) {
            System.out.println("High Value Account");
        }

        scanner.close();
    }
}
