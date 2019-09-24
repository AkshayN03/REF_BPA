package com.tesco.card.payments.process.beans;

public class EnrollmentProcessReq {

	private String clientId;
	private String channelID;
	private String accountNumber;
	private String cardNumber;
	private String cvvNumber;
	private String Mobile;
	private String expDate;
	private String NameOnCard;
	private String billDate;
	private String vendor;

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getChannelID() {
		return channelID;
	}

	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getNameOnCard() {
		return NameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		NameOnCard = nameOnCard;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnrollmentProcessReq [clientId=");
		builder.append(clientId);
		builder.append(", channelID=");
		builder.append(channelID);
		builder.append(", cardNumber=");
		builder.append(cardNumber);
		builder.append(", cvvNumber=");
		builder.append(cvvNumber);
		builder.append(", Mobile=");
		builder.append(Mobile);
		builder.append(", expDate=");
		builder.append(expDate);
		builder.append(", NameOnCard=");
		builder.append(NameOnCard);
		builder.append(", billDate=");
		builder.append(billDate);
		builder.append("]");
		return builder.toString();
	}

}
