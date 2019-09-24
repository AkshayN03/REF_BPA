package com.tesco.card.payments.process.beans;

public class EnrollmentProcessResp {
	
	private String respCode;
	private String respMsg;
	private String enrollStatus;
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public String getEnrollStatus() {
		return enrollStatus;
	}
	public void setEnrollStatus(String enrollStatus) {
		this.enrollStatus = enrollStatus;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnrollmentProcessResp [respCode=");
		builder.append(respCode);
		builder.append(", respMsg=");
		builder.append(respMsg);
		builder.append(", enrollStatus=");
		builder.append(enrollStatus);
		builder.append("]");
		return builder.toString();
	}
	
}
