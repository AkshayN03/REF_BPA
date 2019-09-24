package com.tesco.card.payments.dao.beans;

public class EnrollmentDaoReq {

	private String clientId;
	private String channelId;
	private String cardNumber;
	private String cvvNumber;
	private String Mobile;
	private String expDate;
	private String accountNumber;
	private String nameOnCard;
	
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getClientId() {
		return clientId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnrollmentDaoReq [clientId=");
		builder.append(clientId);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append(", cardNumber=");
		builder.append(cardNumber);
		builder.append(", cvvNumber=");
		builder.append(cvvNumber);
		builder.append(", Mobile=");
		builder.append(Mobile);
		builder.append(", expDate=");
		builder.append(expDate);
		builder.append(", accountNumber=");
		builder.append(accountNumber);
		builder.append("]");
		return builder.toString();
	}
		
		
}
