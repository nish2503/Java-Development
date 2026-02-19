package com.nish.Assignment;

import java.util.Scanner;

public class ElectricityUsagePatternDetector {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = 30;
        int[] usage = new int[days];

        System.out.println("Enter electricity usage for 30 days:");

        for (int i = 0; i < days; i++) {
            usage[i] = scanner.nextInt();
        }

        int highConsumptionCount = 0;
        int totalUsage = 0;
        boolean overloadWarning = false;

        int consecutiveHighDays = 0;

        for (int i = 0; i < days; i++) {

            int currentUsage = usage[i];
            totalUsage += currentUsage;

            // Daily Classification
            if (currentUsage > 500) {
                System.out.println("Day " + (i + 1) + ": High Consumption");
                highConsumptionCount++;
                consecutiveHighDays++;
            }
            else if (currentUsage < 100) {
                System.out.println("Day " + (i + 1) + ": Low Usage Alert");
                consecutiveHighDays = 0;
            }
            else {
                System.out.println("Day " + (i + 1) + ": Normal Usage");
                consecutiveHighDays = 0;
            }

            // Check overload condition
            if (consecutiveHighDays == 3) {
                overloadWarning = true;
            }
        }

        double averageUsage = (double) totalUsage / days;

        System.out.println("Results : ");
        System.out.println("High Consumption Days: " + highConsumptionCount);
        System.out.println("Monthly Average Usage: " + averageUsage);

        if (overloadWarning) {
            System.out.println("Overload Warning Detected (3 consecutive high usage days)");
        } else {
            System.out.println("No Overload Warning");
        }

        if (averageUsage > 400) {
            System.out.println("Heavy Month");
        }

        scanner.close();
    }
}
