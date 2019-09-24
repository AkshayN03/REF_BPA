package com.tesco.card.payments.resource.beans;

public class EnrollmentRequest {

	private ClientInfo clientInfo;
	private CustomerInfo customerInfo;
	private VendorDetails vendordetails;
	private ServiceDetails serviceDetails;

	public ClientInfo getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public VendorDetails getVendordetails() {
		return vendordetails;
	}

	public void setVendordetails(VendorDetails vendordetails) {
		this.vendordetails = vendordetails;
	}

	public ServiceDetails getServiceDetails() {
		return serviceDetails;
	}

	public void setServiceDetails(ServiceDetails serviceDetails) {
		this.serviceDetails = serviceDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnrollmentRequest [clientInfo=");
		builder.append(clientInfo);
		builder.append(", customerInfo=");
		builder.append(customerInfo);
		builder.append(", vendordetails=");
		builder.append(vendordetails);
		builder.append(", serviceDetails=");
		builder.append(serviceDetails);
		builder.append("]");
		return builder.toString();
	}
}
