/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.creditscore.client.impl;

import com.tesco.card.creditscore.client.CreditCheckServiceClient;
import com.tesco.card.creditscore.client.beans.CreditCheckServiceRequest;
import com.tesco.card.creditscore.client.beans.CreditCheckServiceResponse;

/**
 * @author : Sandilya Anisetty
 * @date : 10-May-2019
 * @description:
 */
public class CreditCheckServiceClientImpl implements CreditCheckServiceClient {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tesco.card.creditscore.client.CreditCheckServiceClient#getCreditScore(com
	 * .tesco.card.creditscore.client.beans.CreditCheckServiceRequest)
	 */
	public CreditCheckServiceResponse getCreditScore(CreditCheckServiceRequest req) {

		// prepare the req for credit check services
		// call the service and get the response.
		CreditCheckServiceResponse res = new CreditCheckServiceResponse();
		res.setResCode("0");
		res.setResMsg("Success");
		res.setScorepercent(65);
		return res;
	}

}
