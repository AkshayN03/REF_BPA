package com.tesco.card.payments.resource.beans;

public class VendorDetails {

	private String vendor_name;
	private String mobile_number;

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VendorDetails [vendor_name=");
		builder.append(vendor_name);
		builder.append(", mobile_number=");
		builder.append(mobile_number);
		builder.append("]");
		return builder.toString();
	}
}
