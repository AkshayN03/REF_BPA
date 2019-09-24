/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.process.impl;

import org.apache.log4j.Logger;

import com.o2.service.O2Service;
import com.o2.service.beans.O2serviceReq;
import com.o2.service.beans.O2serviceResp;
import com.o2.service.impl.O2ServiceImpl;
import com.tesco.card.creditscore.client.CreditCheckServiceClient;
import com.tesco.card.creditscore.client.beans.CreditCheckServiceRequest;
import com.tesco.card.creditscore.client.beans.CreditCheckServiceResponse;
import com.tesco.card.creditscore.client.impl.CreditCheckServiceClientImpl;
import com.tesco.card.payments.dao.CardPaymentsDAO;
import com.tesco.card.payments.dao.beans.CardPaymentsDAOReq;
import com.tesco.card.payments.dao.beans.CardPaymentsDAORes;
import com.tesco.card.payments.dao.beans.EnrollmentDaoReq;
import com.tesco.card.payments.dao.beans.EnrollmentDaoResp;
import com.tesco.card.payments.dao.impl.CardPaymentsDAOImpl;
import com.tesco.card.payments.exceptions.BusinessException;
import com.tesco.card.payments.exceptions.SystemException;
import com.tesco.card.payments.process.CardPaymentsProcess;
import com.tesco.card.payments.process.beans.CardPaymentsProcessReqBean;
import com.tesco.card.payments.process.beans.CardPaymentsProcessResBean;
import com.tesco.card.payments.process.beans.EnrollmentProcessReq;
import com.tesco.card.payments.process.beans.EnrollmentProcessResp;
import com.tesco.card.payments.process.builder.CardPaymentsProcessReqBuilder;
import com.tesco.card.payments.process.builder.CardPaymentsProcessResBuilder;

/**
 * @author : Sandilya Anisetty
 * @date : 30-Apr-2019
 * @description:
 */
public class CardPaymentsProcessImpl implements CardPaymentsProcess {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tesco.card.payments.process.cardPaymentsProcess#dopayments(com.tesco.card
	 * .payments.process.beans.cardPaymentsProcessReqBean)
	 */

	private Logger logger = Logger.getLogger(CardPaymentsProcessImpl.class);

	public EnrollmentProcessResp doEnroll(EnrollmentProcessReq req) throws BusinessException, SystemException {

		// get the request from resource layer

		// prepare credit score request.
		CreditCheckServiceRequest creditReq = new CreditCheckServiceRequest();
		creditReq.setCardNumber(req.getCardNumber());
		creditReq.setCvvNumber(req.getCvvNumber());
		creditReq.setExpDate(req.getExpDate());
		creditReq.setNameOnCard(req.getNameOnCard());

		// call credit score service
		CreditCheckServiceClient checkServiceClient = new CreditCheckServiceClientImpl();
		CreditCheckServiceResponse creditResp = checkServiceClient.getCreditScore(creditReq);

		if(creditResp.getScorepercent()>60) {
			
		//prepare o2service req
		CardPaymentsProcessReqBuilder builder = new CardPaymentsProcessReqBuilder(); 	
		O2serviceReq o2Req 	= builder.buildO2ServiceReq(req);
		
		//call o2 service to validate the mobile number
		O2Service service=new O2ServiceImpl();
		O2serviceResp o2resp=service.validate(o2Req);
		
		if(o2resp.getRespCode()=="10000")
			System.out.println(o2resp.getRespMsg());
		
		// prepare the request for DAO
		
		EnrollmentDaoReq daoreq = builder.buildDaoEnrollReq(req);

		// call the DAO and get the DAO response
		CardPaymentsDAO daoImpl = new CardPaymentsDAOImpl();
		EnrollmentDaoResp daoresp = daoImpl.doEnroll(daoreq);

		// prepare the process response
		EnrollmentProcessResp procResp = new EnrollmentProcessResp();
		procResp.setRespCode(daoresp.getResCode());
		procResp.setRespMsg(daoresp.getRespMsg());
		return procResp;
		}
		else {
			EnrollmentProcessResp procResp = new EnrollmentProcessResp();
			procResp.setRespCode("100");
			procResp.setRespMsg("Credit score is less than 60");
			return procResp;
		}
			
	}

	public CardPaymentsProcessResBean dopayments(CardPaymentsProcessReqBean req)
			throws BusinessException, SystemException {
		logger.info("Entered into process layer" + req);

		// get the request from resource layer

		// prepare credit score request.
		CreditCheckServiceRequest creditReq = new CreditCheckServiceRequest();
		creditReq.setCardNumber(req.getCardNumber());
		creditReq.setCvvNumber(req.getCvvNumber());
		creditReq.setExpDate(req.getExpDate());
		creditReq.setNameOnCard(req.getNameOnCard());

		// call credit score service
		CreditCheckServiceClient checkServiceClient = new CreditCheckServiceClientImpl();
		CreditCheckServiceResponse creditResp = checkServiceClient.getCreditScore(creditReq);

		// Build Dao request
		CardPaymentsProcessReqBuilder reqBuilder = new CardPaymentsProcessReqBuilder();
		CardPaymentsDAOReq cardPaymentsDAOReq = reqBuilder.build(req);

		// call integration layer and get response
		CardPaymentsDAO cardPayments = new CardPaymentsDAOImpl();
		CardPaymentsDAORes cardPaymentsDAORes = cardPayments.doPayments(cardPaymentsDAOReq);

		// build process response
		CardPaymentsProcessResBuilder resBuilder = new CardPaymentsProcessResBuilder();
		CardPaymentsProcessResBean cardPaymentsProcessResBean = resBuilder.build(cardPaymentsDAORes);
		logger.debug("Exit from process layer");
		return cardPaymentsProcessResBean;
	}

}
