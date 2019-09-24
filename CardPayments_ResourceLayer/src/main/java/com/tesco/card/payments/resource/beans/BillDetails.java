package com.tesco.card.payments.resource.beans;

public class BillDetails {

	private String billDate;
	private String billPaymentDate;

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getBillPaymentDate() {
		return billPaymentDate;
	}

	public void setBillPaymentDate(String billPaymentDate) {
		this.billPaymentDate = billPaymentDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BillDetails [billDate=");
		builder.append(billDate);
		builder.append(", billPaymentDate=");
		builder.append(billPaymentDate);
		builder.append("]");
		return builder.toString();
	}

}
