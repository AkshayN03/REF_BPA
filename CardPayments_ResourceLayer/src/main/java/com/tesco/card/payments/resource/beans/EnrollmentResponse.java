package com.tesco.card.payments.resource.beans;

public class EnrollmentResponse {

	private StatusBlock statusBlock;
	private BillDetails billDetails;
	private BankDetails bankDetails;

	public StatusBlock getStatusBlock() {
		return statusBlock;
	}

	public void setStatusBlock(StatusBlock statusBlock) {
		this.statusBlock = statusBlock;
	}

	public BillDetails getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(BillDetails billDetails) {
		this.billDetails = billDetails;
	}

	public BankDetails getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnrollmentResponse [statusBlock=");
		builder.append(statusBlock);
		builder.append(", billDetails=");
		builder.append(billDetails);
		builder.append(", bankDetails=");
		builder.append(bankDetails);
		builder.append("]");
		return builder.toString();
	}

}
