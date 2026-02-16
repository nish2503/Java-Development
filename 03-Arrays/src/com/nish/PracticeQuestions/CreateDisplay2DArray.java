package com.nish.PracticeQuestions;

import java.util.Scanner;

public class CreateDisplay2DArray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of rows : ");
		int rows = scanner.nextInt();

		System.out.println("Enter number of columns : ");
		int cols = scanner.nextInt();

		if (rows > 0 && cols > 0) {

			int[][] matrix = new int[rows][cols];

			System.out.println("Enter elements of 2D array : ");

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}

			System.out.println("2D Array is : ");
			
			for (int i = 0; i < matrix.length; i++) {

				for (int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}

				System.out.println();
			}

		} else {
			System.out.println("Enter valid rows and columns!");
		}

		scanner.close();
	}
}
