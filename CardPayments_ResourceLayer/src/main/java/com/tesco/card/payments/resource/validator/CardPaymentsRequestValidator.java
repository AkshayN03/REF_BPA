/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.resource.validator;

import org.apache.log4j.Logger;

import com.tesco.card.payments.resource.api.impl.CardPaymentsResourceImpl;
import com.tesco.card.payments.resource.beans.CardPaymentsResourceReqBean;
import com.tesco.card.payments.resource.beans.EnrollmentRequest;
import com.tesco.card.payments.resource.exception.InvalidRequestException;

/**
 * @author : Sandilya Anisetty
 * @date : 30-Apr-2019
 * @description:
 */
public class CardPaymentsRequestValidator {

	/**
	 * @param req
	 * @throws InvalidRequestException
	 */
	
	private Logger logger= Logger.getLogger(CardPaymentsRequestValidator.class);
	
	public void validate(CardPaymentsResourceReqBean req) throws InvalidRequestException {
		logger.debug("Entered into validate method");

		if (req == null || req.getCustomerInfo() == null || req.getClientInfo() == null)
			throw new InvalidRequestException("bpa001", "Request object is null");

		if (req.getClientInfo().getClientId() == null || " ".equals(req.getClientInfo()))
			throw new InvalidRequestException("bpa002", "Client id is not valid");

		if (req.getClientInfo().getChannelId() == null || " ".equals(req.getClientInfo()))
			throw new InvalidRequestException("bpa003", "Channel id is not valid");

		if (req.getCustomerInfo().getCardNumber() == null || " ".equals(req.getCustomerInfo()) || req.getCustomerInfo().getCardNumber().length()>16 ||req.getCustomerInfo().getCardNumber().length()<16 )
			throw new InvalidRequestException("bpa004", "Card number is not valid");

		if (req.getCustomerInfo().getCvvNumber() == null || " ".equals(req.getCustomerInfo()))
			throw new InvalidRequestException("bpa005", "cvv number is not valid");

		if (req.getCustomerInfo().getExpDate() == null || " ".equals(req.getCustomerInfo()))
			throw new InvalidRequestException("bpa006", "Expire date is not valid");

		if (req.getCustomerInfo().getNameOnCard() == null || " ".equals(req.getCustomerInfo()))
			throw new InvalidRequestException("bpa007", "Name on card is not valid");

		logger.debug("Exit from validate method");
	}

	public void validate(EnrollmentRequest req) {
		// TODO Auto-generated method stub
		
	}




}
