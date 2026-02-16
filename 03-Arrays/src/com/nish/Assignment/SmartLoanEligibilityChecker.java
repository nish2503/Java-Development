package com.nish.Assignment;

import java.util.Scanner;

public class SmartLoanEligibilityChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of applicants: ");
        int n = scanner.nextInt();

        int[] creditScores = new int[n];
        int[] monthlyIncomes = new int[n];
        int[] existingLoans = new int[n];

        System.out.println("Enter credit scores:");
        for (int i = 0; i < n; i++) {
            creditScores[i] = scanner.nextInt();
        }

        System.out.println("Enter monthly incomes:");
        for (int i = 0; i < n; i++) {
            monthlyIncomes[i] = scanner.nextInt();
        }

        System.out.println("Enter number of existing loans:");
        for (int i = 0; i < n; i++) {
            existingLoans[i] = scanner.nextInt();
        }

        int totalApprovals = 0;
        int totalRejections = 0;

        int bestIndex = -1;
        int bestScore = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int score = creditScores[i];
            int income = monthlyIncomes[i];
            int loans = existingLoans[i];

            // Rejection Conditions
            if (score < 600 || income < 25000 || loans >= 3) {
                System.out.println("Applicant " + i + ": Rejected");
                totalRejections++;
            }
            else {

                totalApprovals++;

                if (score >= 800 && income > 100000) {
                    System.out.println("Applicant " + i + ": Instant Approval");
                }
                else {
                    System.out.println("Applicant " + i + ": Standard Review");
                }

                // Tracking best approval profile
                // Prioritize highest credit score
                if (score > bestScore) {
                    bestScore = score;
                    bestIndex = i;
                }
            }
        }

        System.out.println("Results : ");
        System.out.println("Total Approvals: " + totalApprovals);
        System.out.println("Total Rejections: " + totalRejections);
        System.out.println("Best Approval Profile Index: " + bestIndex);

        scanner.close();
    }
}
