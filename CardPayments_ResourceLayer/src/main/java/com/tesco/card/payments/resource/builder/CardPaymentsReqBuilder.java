/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.resource.builder;

import org.apache.log4j.Logger;

import com.tesco.card.payments.process.beans.CardPaymentsProcessReqBean;
import com.tesco.card.payments.process.beans.EnrollmentProcessReq;
import com.tesco.card.payments.resource.api.impl.CardPaymentsResourceImpl;
import com.tesco.card.payments.resource.beans.CardPaymentsResourceReqBean;
import com.tesco.card.payments.resource.beans.EnrollmentRequest;

/**
 * @author : Sandilya Anisetty
 * @date   : 30-Apr-2019
 * @description:
 */
public class CardPaymentsReqBuilder {

	/**
	 * @param req
	 * @return
	 */
	private Logger logger= Logger.getLogger(CardPaymentsReqBuilder.class);
	
	public CardPaymentsProcessReqBean reqBuild(CardPaymentsResourceReqBean req) {
		logger.debug("Entered into request builder method");
		CardPaymentsProcessReqBean processReq = new CardPaymentsProcessReqBean();
		processReq.setClientId(req.getClientInfo().getClientId());
		processReq.setChannelId(req.getClientInfo().getChannelId());
		processReq.setCardNumber(req.getCustomerInfo().getCardNumber());
		processReq.setCvvNumber(req.getCustomerInfo().getCvvNumber());
		processReq.setNameOnCard(req.getCustomerInfo().getNameOnCard());
		processReq.setExpDate(req.getCustomerInfo().getExpDate());
		logger.info("Exit from request builder method" +processReq);
		return processReq;
	}

	public EnrollmentProcessReq buildEnrollProcessReq(EnrollmentRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
