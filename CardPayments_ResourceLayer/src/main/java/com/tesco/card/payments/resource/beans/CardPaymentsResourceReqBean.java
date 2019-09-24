/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.resource.beans;

/**
 * @author : Sandilya Anisetty
 * @date : 30-Apr-2019
 * @description:
 */
public class CardPaymentsResourceReqBean {

	private ClientInfo clientInfo;
	private CustomerInfo customerInfo;
	private ServiceInfo serviceInfo;

	/**
	 * @return the clientInfo
	 */
	public ClientInfo getClientInfo() {
		return clientInfo;
	}

	/**
	 * @param clientInfo the clientInfo to set
	 */
	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}

	/**
	 * @return the customerInfo
	 */
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	/**
	 * @param customerInfo the customerInfo to set
	 */
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	/**
	 * @return the serviceInfo
	 */
	public ServiceInfo getServiceInfo() {
		return serviceInfo;
	}

	/**
	 * @param serviceInfo the serviceInfo to set
	 */
	public void setServiceInfo(ServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cardPaymentsResourceReqBean [clientInfo=");
		builder.append(clientInfo);
		builder.append(", customerInfo=");
		builder.append(customerInfo);
		builder.append(", serviceInfo=");
		builder.append(serviceInfo);
		builder.append("]");
		return builder.toString();
	}

}
