package com.tesco.card.payments.dao.beans;

public class EnrollmentDaoResp {
	
	private String resCode;
	private String respMsg;
	
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnrollmentDaoResp [resCode=");
		builder.append(resCode);
		builder.append(", respMsg=");
		builder.append(respMsg);
		builder.append("]");
		return builder.toString();
	}
	
	
}
