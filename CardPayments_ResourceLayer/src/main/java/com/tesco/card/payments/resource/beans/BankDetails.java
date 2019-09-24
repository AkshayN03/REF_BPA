package com.tesco.card.payments.resource.beans;

public class BankDetails {

	private String backNumber;
	private String sortCode;
	private String mobile_number;
	private String fName;
	private String lName;

	public String getBackNumber() {
		return backNumber;
	}

	public void setBackNumber(String backNumber) {
		this.backNumber = backNumber;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BankDetails [backNumber=");
		builder.append(backNumber);
		builder.append(", sortCode=");
		builder.append(sortCode);
		builder.append(", mobile_number=");
		builder.append(mobile_number);
		builder.append(", fName=");
		builder.append(fName);
		builder.append(", lName=");
		builder.append(lName);
		builder.append("]");
		return builder.toString();
	}

}
