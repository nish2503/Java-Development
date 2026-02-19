package com.nish.Encapsulation.Test;
import com.nish.Encapsulation.Model.ClaimStatus;
import com.nish.Encapsulation.Model.InsuranceClaim;
import java.util.Scanner;

public class InsuranceClaimTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String policyNumber;
		double claimAmount;

		while (true) {
			System.out.println("Enter policy number : ");
			policyNumber = scanner.nextLine().trim();

			if (policyNumber == null) {
				System.out.println("Policy Number cant be null!");
				continue;
			}

			if (policyNumber.isEmpty()) {
				System.out.println("Policy Number cant be empty!");
				continue;
			}
			break;
		}

		while (true) {
			System.out.println("Enter claim amount : ");

			if (!scanner.hasNextDouble()) {
				System.out.println("Invalid input type!");
				scanner.next();
				continue;
			}

			claimAmount = scanner.nextDouble();

			if (claimAmount <= 0) {
				System.out.println("Invalid claim amount!");
				continue;
			} else {
				break;
			}
		}

		InsuranceClaim i = new InsuranceClaim(policyNumber, claimAmount);

		boolean running = true;

		while (running) {
			System.out.println();
			System.out.println("-------WELCOME TO INSURANCE CLAIM-------");
			System.out.println("1. Claim Status");
			System.out.println("2. Approve Claim");
			System.out.println("3. Reject Claim");
			System.out.println("4. Settle Claim");
			System.out.println("5. Exit");
			System.out.println("Choose your operation : ");
			
			if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!");
                scanner.next();
                continue;
            }

			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Claim Status : " + i.getStatus());
				break;

			case 2:
				if (i.getStatus() != ClaimStatus.FILED) {
			        System.out.println("Only filed claims can be approved!");
			        break;
			    }
				while (true) {
					System.out.println("Enter approval amount : ");
					double approvalAmount = scanner.nextDouble();
					boolean approvalSuccess = i.approveClaim(approvalAmount);
					if (approvalSuccess) {
						System.out.println("Claim Approved!");
						break;
					}
				}
				break;

			case 3:
				if (i.rejectClaim()) {
					System.out.println("Claim Rejected!");
				}
				break;

			case 4:
				if (i.settleClaim()) {
					System.out.println("Claim Settled!");
				}
				break;

			case 5:
				System.out.println("Thank you for visiting!");
				scanner.close();
				running = false;
				break;

			default:
				System.out.println("Invalid input!");
			}
		}
	}
}
