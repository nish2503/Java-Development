package com.nish.Encapsulation.Model;

public class InsuranceClaim {
	private final String claimID = "CLID12654";
	private String policyNumber;
	private double claimAmount;
	private ClaimStatus status;
	private double approvedAmount;

	public InsuranceClaim(String policyNumber, double claimAmount) {
			this.claimAmount = claimAmount;
			this.status = ClaimStatus.FILED;
			this.policyNumber = policyNumber;
			
			System.out.println("Claim filed successfully");
			System.out.println("Policy Number : " + policyNumber);
			System.out.println("Claim Amount : " + claimAmount);
	}

	public boolean approveClaim(double approvalAmount) {

		if (status == ClaimStatus.FILED) {
			if (approvalAmount > 0 && approvalAmount < claimAmount) {
				this.approvedAmount = approvalAmount;
				this.status = ClaimStatus.APPROVED;
				return true;
			} else {
				System.out.println("Invalid approved amount");
				return false;
			}
		} else {
			System.out.println("Only filed claims can be approved!");
			return false;
		}
	}
	
	public boolean rejectClaim() {
		if(status == ClaimStatus.FILED) {
			this.status = ClaimStatus.REJECTED;
			return true;
		}
		else {
			System.out.println("Only filed claims can be rejected!");
			return false;
		}
	}
	
	public boolean settleClaim() {
		if(status == ClaimStatus.APPROVED) {
			this.status = ClaimStatus.SETTLED;
			return true;
		}
		else {
			System.out.println("Only approved claims can be settled!");
			return false;
		}
	}
	
	public ClaimStatus getStatus() {
		return status;
	}

}
