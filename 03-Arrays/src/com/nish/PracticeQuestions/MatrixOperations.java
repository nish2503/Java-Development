package com.nish.PracticeQuestions;

import java.util.Scanner;

public class MatrixOperations {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter rows and columns for first matrix : ");
		int r1 = scanner.nextInt();
		int c1 = scanner.nextInt();

		System.out.println("Enter rows and columns for second matrix : ");
		int r2 = scanner.nextInt();
		int c2 = scanner.nextInt();

		if (r1 > 0 && c1 > 0 && r2 > 0 && c2 > 0) {

			int[][] mat1 = new int[r1][c1];
			int[][] mat2 = new int[r2][c2];

			System.out.println("Enter elements of first matrix : ");
			inputMatrix(scanner, mat1);

			System.out.println("Enter elements of second matrix : ");
			inputMatrix(scanner, mat2);

			// Addition
			if (r1 == r2 && c1 == c2) {
				int[][] sum = addMatrices(mat1, mat2);
				System.out.println("Matrix Addition : ");
				display(sum);
			} else {
				System.out.println("Addition not possible (dimensions must match).");
			}

			// Multiplication
			if (c1 == r2) {
				int[][] product = multiplyMatrices(mat1, mat2);
				System.out.println("Matrix Multiplication : ");
				display(product);
			} else {
				System.out.println("Multiplication not possible (c1 must equal r2).");
			}

			// Transpose of first matrix
			System.out.println("Transpose of First Matrix : ");
			int[][] transpose = transposeMatrix(mat1);
			display(transpose);

		} else {
			System.out.println("Enter valid dimensions!");
		}

		scanner.close();
	}

	// Input
	public static void inputMatrix(Scanner scanner, int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
	}

	// Display
	public static void display(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Addition
	public static int[][] addMatrices(int[][] a, int[][] b) {

		int rows = a.length;
		int cols = a[0].length;

		int[][] result = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}

		return result;
	}

	// Multiplication
	public static int[][] multiplyMatrices(int[][] a, int[][] b) {

		int rows = a.length;
		int cols = b[0].length;
		int common = b.length;

		int[][] result = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				for (int k = 0; k < common; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		return result;
	}

	// Transpose
	public static int[][] transposeMatrix(int[][] matrix) {

		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] result = new int[cols][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[j][i] = matrix[i][j];
			}
		}

		return result;
	}
}
