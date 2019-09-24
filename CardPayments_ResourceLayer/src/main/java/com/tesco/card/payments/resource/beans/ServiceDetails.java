package com.tesco.card.payments.resource.beans;

public class ServiceDetails {
	
	private String service_Name;
	private String api_Name;
	private String version;
	public String getService_Name() {
		return service_Name;
	}
	public void setService_Name(String service_Name) {
		this.service_Name = service_Name;
	}
	public String getApi_Name() {
		return api_Name;
	}
	public void setApi_Name(String api_Name) {
		this.api_Name = api_Name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceDetails [service_Name=");
		builder.append(service_Name);
		builder.append(", api_Name=");
		builder.append(api_Name);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}
}
