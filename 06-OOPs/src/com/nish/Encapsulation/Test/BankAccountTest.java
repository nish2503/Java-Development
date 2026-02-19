package com.nish.Encapsulation.Test;

import java.util.Scanner;

import com.nish.Encapsulation.Model.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String accountHolder;
		double initialAmount;

		while (true) {
			System.out.println("Enter Account Holder Name : ");
			accountHolder = scanner.nextLine().trim();

			if (accountHolder == null) {
				System.out.println("Name cannot be null!");
				continue;
			}
			if (accountHolder.isEmpty()) {
				System.out.println("Name cannot be empty!");
				continue;
			}

			if (!isAlphabetic(accountHolder)) {
				System.out.println("Name must be alphabetic!");
				continue;
			} else {
				break;
			}
		}

		while (true) {
			System.out.println("Enter initial amount : ");
			if(!scanner.hasNextDouble()) {
				System.out.println("Invalid input type!");
				scanner.next();
				continue;
			}
			initialAmount = scanner.nextDouble();
			scanner.nextLine();

			if (initialAmount <= 0) {
				System.out.println("Initial amount must be positive!");
				continue;
			} else {
				break;
			}
		}

		BankAccount b = new BankAccount(accountHolder, initialAmount);

		boolean running = true;

		while (running) {
			System.out.println();
			System.out.println("-------WELCOME TO THE BANK-------");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Exit");
			System.out.println("Choose your operation : ");
			
			if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!");
                scanner.next();
                continue;
            }

			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Current Balance : " + b.getBalance());
				break;

			case 2:
				while (true) {
					System.out.println("Enter deposit amount : ");
					double depositAmount = scanner.nextDouble();
					boolean depositSuccess = b.depositMoney(depositAmount);
					if (depositSuccess) {
						System.out.println("Money deposited. Updated balance : " + b.getBalance());
						break;
					}
				}
				break;

			case 3:
				while (true) {
					System.out.println("Enter withdraw amount : ");
					double withdrawAmount = scanner.nextDouble();
					boolean withdrawSuccess = b.withdrawMoney(withdrawAmount);
					if (withdrawSuccess) {
						System.out.println("Money withdrawed. Updated balance : " + b.getBalance());
						break;
					}
				}
				break;

			case 4:
				System.out.println("Thank you for visiting!");
				scanner.close();
				running = false;
				break;

			default:
				System.out.println("Invalid input!");
			}
		}
	}

	public static boolean isAlphabetic(String name) {

		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i))) {
				return false;
			}
		}

		return true;
	}

}
