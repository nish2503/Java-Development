package com.nish.Assignment;

import java.util.Scanner;

public class InsuranceRiskPortfolioAnalyser {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = scanner.nextInt();

        int[] ages = new int[n];
        int[] riskScores = new int[n];

        System.out.println("Enter ages of customers:");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }

        System.out.println("Enter risk scores of customers:");
        for (int i = 0; i < n; i++) {
            riskScores[i] = scanner.nextInt();
        }

        int highRiskYouth = 0;
        int seniorRisk = 0;
        int veryHighRisk = 0;
        int normalRisk = 0;

        int totalRisk = 0;
        int maxRisk = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < n; i++) {

            int age = ages[i];
            int score = riskScores[i];

            totalRisk += score;

            if (score > maxRisk) {
                maxRisk = score;
                maxIndex = i;
            }

            if (score >= 85) {
                System.out.println("Customer " + i + ": Very High Risk");
                veryHighRisk++;
            }
            else if (age < 25 && score > 70) {
                System.out.println("Customer " + i + ": High Risk Youth");
                highRiskYouth++;
            }
            else if (age >= 60) {
                System.out.println("Customer " + i + ": Senior Risk");
                seniorRisk++;
            }
            else {
                System.out.println("Customer " + i + ": Normal Risk");
                normalRisk++;
            }
        }

        double averageRisk = (double) totalRisk / n;

        System.out.println();
        System.out.println("Results:");
        System.out.println("Very High Risk: " + veryHighRisk);
        System.out.println("High Risk Youth: " + highRiskYouth);
        System.out.println("Senior Risk: " + seniorRisk);
        System.out.println("Normal Risk: " + normalRisk);
        System.out.println("Average Risk Score: " + averageRisk);
        System.out.println("Highest Risk Customer Index: " + maxIndex);

        scanner.close();
    }
}
