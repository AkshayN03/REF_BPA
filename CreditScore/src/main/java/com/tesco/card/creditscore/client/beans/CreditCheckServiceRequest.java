/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.creditscore.client.beans;

/**
 * @author : Sandilya Anisetty
 * @date : 10-May-2019
 * @description:
 */
public class CreditCheckServiceRequest {

	private String clientId;
	private String channelId;
	private String cardNumber;
	private String cvvNumber;
	private String nameOnCard;
	private String expDate;

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the cvvNumber
	 */
	public String getCvvNumber() {
		return cvvNumber;
	}

	/**
	 * @param cvvNumber the cvvNumber to set
	 */
	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}

	/**
	 * @return the nameOnCard
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}

	/**
	 * @param nameOnCard the nameOnCard to set
	 */
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	/**
	 * @return the expDate
	 */
	public String getExpDate() {
		return expDate;
	}

	/**
	 * @param expDate the expDate to set
	 */
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cardPaymentsProcessReqBean [clientId=");
		builder.append(clientId);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append(", cardNumber=");
		builder.append(cardNumber);
		builder.append(", cvvNumber=");
		builder.append(cvvNumber);
		builder.append(", nameOnCard=");
		builder.append(nameOnCard);
		builder.append(", expDate=");
		builder.append(expDate);
		builder.append("]");
		return builder.toString();
	}

}
