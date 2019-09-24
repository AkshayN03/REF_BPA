/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.creditscore.client.beans;

/**
 * @author : Sandilya Anisetty
 * @date   : 10-May-2019
 * @description:
 */
public class CreditCheckServiceResponse {
	
	private String resCode;
	private String resMsg;
	private float scorepercent;
	/**
	 * @return the resCode
	 */
	public String getResCode() {
		return resCode;
	}
	/**
	 * @param resCode the resCode to set
	 */
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	/**
	 * @return the resMsg
	 */
	public String getResMsg() {
		return resMsg;
	}
	/**
	 * @param resMsg the resMsg to set
	 */
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	/**
	 * @return the scorepercent
	 */
	public float getScorepercent() {
		return scorepercent;
	}
	/**
	 * @param scorepercent the scorepercent to set
	 */
	public void setScorepercent(float scorepercent) {
		this.scorepercent = scorepercent;
	}
	
	

}
