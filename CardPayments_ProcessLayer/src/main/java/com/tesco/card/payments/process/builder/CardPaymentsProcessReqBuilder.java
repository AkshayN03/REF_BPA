/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.process.builder;

import org.apache.log4j.Logger;

import com.o2.service.beans.O2serviceReq;
import com.tesco.card.payments.dao.beans.CardPaymentsDAOReq;
import com.tesco.card.payments.dao.beans.EnrollmentDaoReq;
import com.tesco.card.payments.process.beans.CardPaymentsProcessReqBean;
import com.tesco.card.payments.process.beans.EnrollmentProcessReq;
import com.tesco.card.payments.process.impl.CardPaymentsProcessImpl;

/**
 * @author : Sandilya Anisetty
 * @date   : 30-Apr-2019
 * @description:
 */
public class CardPaymentsProcessReqBuilder {

	/**
	 * @param req
	 * @return
	 */
	private Logger logger= Logger.getLogger(CardPaymentsProcessImpl.class);
	
	public CardPaymentsDAOReq build(CardPaymentsProcessReqBean req) {
		logger.debug("Entered into process req builder");
		CardPaymentsDAOReq cardPaymentsDAOReq=new CardPaymentsDAOReq();
		cardPaymentsDAOReq.setClientId(req.getClientId());
		cardPaymentsDAOReq.setChannelId(req.getChannelId());
		cardPaymentsDAOReq.setCardNumber(req.getCardNumber());
		cardPaymentsDAOReq.setExpDate(req.getExpDate());
		cardPaymentsDAOReq.setCvvNumber(req.getCvvNumber());
		cardPaymentsDAOReq.setNameOnCard(req.getNameOnCard());
		logger.info("Exit from process req builder"+cardPaymentsDAOReq);
		return cardPaymentsDAOReq;
	}

	public EnrollmentDaoReq buildDaoEnrollReq(EnrollmentProcessReq req) {

		EnrollmentDaoReq daoreq=new EnrollmentDaoReq();
		daoreq.setAccountNumber(req.getAccountNumber());
		daoreq.setCardNumber(req.getCardNumber());
		daoreq.setChannelId(req.getChannelID());
		daoreq.setClientId(req.getClientId());
		daoreq.setCvvNumber(req.getCvvNumber());
		daoreq.setExpDate(req.getExpDate());
		daoreq.setMobile(req.getMobile());
		daoreq.setNameOnCard(req.getNameOnCard());
		
		return daoreq;
	}

	public O2serviceReq buildO2ServiceReq(EnrollmentProcessReq req) {

		O2serviceReq o2req = new O2serviceReq();
		o2req.setMob_number(req.getMobile());
		o2req.setVendor(req.getVendor());
		return o2req;
	}

}
