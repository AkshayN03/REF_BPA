/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.resource.beans;

/**
 * @author : Sandilya Anisetty
 * @date : 06-May-2019
 * @description:
 */
public class ServiceInfo {

	private String svcName;
	private String apiName;
	private String version;

	/**
	 * @return the svcName
	 */
	public String getSvcName() {
		return svcName;
	}

	/**
	 * @param svcName the svcName to set
	 */
	public void setSvcName(String svcName) {
		this.svcName = svcName;
	}

	/**
	 * @return the apiName
	 */
	public String getApiName() {
		return apiName;
	}

	/**
	 * @param apiName the apiName to set
	 */
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceInfo [svcName=");
		builder.append(svcName);
		builder.append(", apiName=");
		builder.append(apiName);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}

}
