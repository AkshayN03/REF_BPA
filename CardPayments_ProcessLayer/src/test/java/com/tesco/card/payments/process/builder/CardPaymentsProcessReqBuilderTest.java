package com.tesco.card.payments.process.builder;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tesco.card.payments.dao.beans.CardPaymentsDAOReq;
import com.tesco.card.payments.process.beans.CardPaymentsProcessReqBean;

public class CardPaymentsProcessReqBuilderTest {

	CardPaymentsProcessReqBean req;

	@Before
	public void setUp() throws Exception {
		req = buildResourceReq();
	}

	@After
	public void tearDown() throws Exception {
		req = null;
	}

	@Test
	public void testBuild() {
		CardPaymentsProcessReqBuilder builder = new CardPaymentsProcessReqBuilder();
		CardPaymentsDAOReq daoReq = builder.build(req);
		Assert.assertNotNull(daoReq);
		Assert.assertEquals("Web", daoReq.getClientId());
		Assert.assertEquals("Online", daoReq.getChannelId());
		Assert.assertEquals("1234567891231234", daoReq.getCardNumber());
		Assert.assertEquals("123", daoReq.getCvvNumber());
		Assert.assertEquals("06/2022", daoReq.getExpDate());
		Assert.assertEquals("Sandy", daoReq.getNameOnCard());
	}

	private CardPaymentsProcessReqBean buildResourceReq() {
		CardPaymentsProcessReqBean req = new CardPaymentsProcessReqBean();
		req.setClientId("Web");
		req.setChannelId("Online");
		req.setCardNumber("1234567891231234");
		req.setCvvNumber("123");
		req.setExpDate("06/2022");
		req.setNameOnCard("Sandy");
		return req;

	}

}
