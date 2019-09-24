package com.tesco.card.payments.resource.builder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tesco.card.payments.process.beans.CardPaymentsProcessReqBean;
import com.tesco.card.payments.resource.beans.CardPaymentsResourceReqBean;
import com.tesco.card.payments.resource.beans.ClientInfo;
import com.tesco.card.payments.resource.beans.CustomerInfo;

public class CardPaymentsReqBuilderTest {

	CardPaymentsResourceReqBean req;
	@Before
	public void setUp() throws Exception {
		req=buildResourceReq();
	}

	@After
	public void tearDown() throws Exception {
		req=null;
	}

	@Test
	public void testReqBuild() {
		CardPaymentsReqBuilder reqBuilder=new CardPaymentsReqBuilder();
		CardPaymentsProcessReqBean processReq=reqBuilder.reqBuild(req);
		Assert.assertNotNull(processReq);
		Assert.assertEquals("1234567891231234", processReq.getCardNumber());
		Assert.assertEquals("123",processReq.getCvvNumber());
		Assert.assertEquals("06/2022",processReq.getExpDate());
		Assert.assertEquals("Sandy",processReq.getNameOnCard());
		Assert.assertEquals("Web",processReq.getClientId());
		Assert.assertEquals("Online",processReq.getChannelId());
	}
	
	private CardPaymentsResourceReqBean buildResourceReq() {
		
		CardPaymentsResourceReqBean req=new CardPaymentsResourceReqBean();
		ClientInfo clientInfo=new ClientInfo();
		clientInfo.setClientId("Web");
		clientInfo.setChannelId("Online");
		req.setClientInfo(clientInfo);
		
		/*Setting customer info*/
		CustomerInfo customerInfo=new CustomerInfo();
		customerInfo.setCardNumber("1234567891231234");
		customerInfo.setCvvNumber("123");
		customerInfo.setExpDate("06/2022");
		customerInfo.setNameOnCard("Sandy");
		req.setCustomerInfo(customerInfo);
		
		return req;
		
	}

}
