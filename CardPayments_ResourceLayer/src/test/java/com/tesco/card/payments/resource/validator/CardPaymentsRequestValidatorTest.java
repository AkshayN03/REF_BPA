package com.tesco.card.payments.resource.validator;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tesco.card.payments.resource.beans.CardPaymentsResourceReqBean;
import com.tesco.card.payments.resource.beans.ClientInfo;
import com.tesco.card.payments.resource.beans.CustomerInfo;
import com.tesco.card.payments.resource.beans.ServiceInfo;
import com.tesco.card.payments.resource.exception.InvalidRequestException;

public class CardPaymentsRequestValidatorTest {

	CardPaymentsRequestValidator validator;
	CardPaymentsResourceReqBean req;

	@Before
	public void setUp() throws Exception {
		validator = new CardPaymentsRequestValidator();
		req = buildResourceReq();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidateReqObj_Null_Scenerio() {
		try {
			validator.validate(null);
		} catch (InvalidRequestException e) {
			Assert.assertEquals("bpa001", e.getResponseCode());
		}
	}

	@Test
	public void testClientInfoReqObj_Null_Scenerio() {
		try {
			req.setClientInfo(null);
			validator.validate(req);
		} catch (InvalidRequestException e) {
			Assert.assertEquals("bpa001", e.getResponseCode());
		}
	}

	@Test
	public void testCustomerReqObj_Null_Scenerio() {
		try {
			req.setCustomerInfo(null);
			validator.validate(req);
		} catch (InvalidRequestException e) {
			Assert.assertEquals("bpa001", e.getResponseCode());
		}
	}

	@Test
	public void testClientIdInvalid_Scenerio() {
		try {
			req.getClientInfo().setClientId(null);
			validator.validate(req);
		} catch (InvalidRequestException e) {
			Assert.assertEquals("bpa002", e.getResponseCode());
		}
	}

	@Test
	public void testChannelIdInvalid_Scenerio() {
		try {
			req.getClientInfo().setChannelId(null);
			validator.validate(req);
		} catch (InvalidRequestException e) {
			Assert.assertEquals("bpa003", e.getResponseCode());
		}
	}

	@Test
	public void testCardNumberReqObj_Null_Scenerio() {
		try {
			req.getCustomerInfo().setCardNumber(null);
			validator.validate(req);
		} catch (InvalidRequestException e) {
			Assert.assertEquals("bpa004", e.getResponseCode());
		}
	}

	@Test
	public void testCvvNumberReqObj_Null_Scenerio() {
		try {
			req.getCustomerInfo().setCvvNumber(null);
			validator.validate(req);
		} catch (InvalidRequestException e) {
			Assert.assertEquals("bpa005", e.getResponseCode());
		}
	}

	@Test
	public void testCardExpireDateReqObj_Null_Scenerio() {
		try {
			req.getCustomerInfo().setExpDate(null);
			validator.validate(req);
		} catch (InvalidRequestException e) {
			Assert.assertEquals("bpa006", e.getResponseCode());
		}
	}

	@Test
	public void testNameOnCardReqObj_Null_Scenerio() {
		try {
			req.getCustomerInfo().setNameOnCard(null);
			validator.validate(req);
		} catch (InvalidRequestException e) {
			Assert.assertEquals("bpa007", e.getResponseCode());
		}
	}

	private CardPaymentsResourceReqBean buildResourceReq() {

		CardPaymentsResourceReqBean reqBean = new CardPaymentsResourceReqBean();
		ClientInfo clientInfo = new ClientInfo();
		clientInfo.setClientId("Web");
		clientInfo.setChannelId("Online");
		clientInfo.setCorrelationId("a@agshdvgdvh");

		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setCardNumber("1234567891231234");
		customerInfo.setCvvNumber("123");
		customerInfo.setExpDate("06/2022");
		customerInfo.setNameOnCard("Sandy");

		ServiceInfo serviceInfo = new ServiceInfo();
		serviceInfo.setSvcName("Card Payment Service");
		serviceInfo.setApiName("doPayment");
		serviceInfo.setVersion("1.0");

		reqBean.setClientInfo(clientInfo);
		reqBean.setCustomerInfo(customerInfo);
		reqBean.setServiceInfo(serviceInfo);
		return reqBean;

	}
}
