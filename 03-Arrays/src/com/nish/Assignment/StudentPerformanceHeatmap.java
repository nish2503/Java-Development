package com.nish.Assignment;

import java.util.Scanner;

public class StudentPerformanceHeatmap {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[][] marks = new int[n][5];

        System.out.println("Enter marks for each student (5 subjects each):");

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            for (int j = 0; j < 5; j++) {
                marks[i][j] = scanner.nextInt();
            }
        }

        int distinctionCount = 0;

        // subject wise average
        int[] subjectTotals = new int[5];

        for (int i = 0; i < n; i++) {

            int total = 0;
            boolean hasFailed = false;

            for (int j = 0; j < 5; j++) {

                int score = marks[i][j];

                if (score < 35) {
                    hasFailed = true;
                }

                total += score;

                subjectTotals[j] += score;
            }

            double average = (double) total / 5;

            System.out.print("Student " + (i + 1) + ": ");

            if (hasFailed) {
                System.out.println("Fail");
            }
            else if (average >= 85) {
                System.out.println("Distinction");
                distinctionCount++;
            }
            else if (average >= 60) {
                System.out.println("First Class");
            }
            else if (average >= 50) {
                System.out.println("Second Class");
            }
            else {
                System.out.println("Pass");
            }
        }

        // subject with highest average
        double highestAvg = 0;
        int bestSubjectIndex = -1;

        for (int j = 0; j < 5; j++) {

            double subjectAvg = (double) subjectTotals[j] / n;

            if (subjectAvg > highestAvg) {
                highestAvg = subjectAvg;
                bestSubjectIndex = j;
            }
        }

        System.out.println("Results : ");
        System.out.println("Number of Distinctions: " + distinctionCount);
        System.out.println("Subject with Highest Average: Subject " + (bestSubjectIndex + 1));
        System.out.println("Highest Subject Average: " + highestAvg);

        scanner.close();
    }
}
