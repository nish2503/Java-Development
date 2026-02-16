package com.nish.PracticeQuestions;

import java.util.Scanner;

public class Dynamic2DArray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of rows : ");
		int rows = scanner.nextInt();

		if (rows > 0) {

			int[][] matrix = new int[rows][];

			for (int i = 0; i < rows; i++) {

				System.out.println("Enter number of columns for row " + i + " : ");
				int cols = scanner.nextInt();

				if (cols > 0) {

					matrix[i] = new int[cols];

					System.out.println("Enter elements for row " + i + " : ");

					for (int j = 0; j < cols; j++) {
						matrix[i][j] = scanner.nextInt();
					}

				} else {
					System.out.println("Invalid column size for row " + i);
					return;
				}
			}

			System.out.println("Dynamic 2D Array is : ");
			for (int i = 0; i < matrix.length; i++) {

				for (int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j] + " ");
				}

				System.out.println();
			}

		} else {
			System.out.println("Enter valid number of rows!");
		}

		scanner.close();
	}
}
