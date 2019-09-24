/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.resource.beans;

/**
 * @author : Sandilya Anisetty
 * @date   : 06-May-2019
 * @description:
 */
public class ClientInfo {
	
	private String clientId;
	private String channelId;
	private String correlationId;
	private String messageTs;
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
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return correlationId;
	}
	/**
	 * @param correlationId the correlationId to set
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	/**
	 * @return the messageTs
	 */
	public String getMessageTs() {
		return messageTs;
	}
	/**
	 * @param messageTs the messageTs to set
	 */
	public void setMessageTs(String messageTs) {
		this.messageTs = messageTs;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientInfo [clientId=");
		builder.append(clientId);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append(", correlationId=");
		builder.append(correlationId);
		builder.append(", messageTs=");
		builder.append(messageTs);
		builder.append("]");
		return builder.toString();
	}

}
