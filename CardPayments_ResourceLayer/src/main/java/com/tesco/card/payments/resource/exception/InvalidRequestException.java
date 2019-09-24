/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.resource.exception;

/**
 * @author : Sandilya Anisetty
 * @date : 08-May-2019
 * @description:
 */
public class InvalidRequestException extends Exception {

	private String responseCode;
	private String responseMsg;

	/**
	 * @param responseCode
	 * @param responseMsg
	 */
	public InvalidRequestException(String responseCode, String responseMsg) {
		super();
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
	}

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @return the responseMsg
	 */
	public String getResponseMsg() {
		return responseMsg;
	}

}
