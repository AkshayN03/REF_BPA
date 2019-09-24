package com.tesco.card.payments.resource.builder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tesco.card.payments.process.beans.CardPaymentsProcessResBean;
import com.tesco.card.payments.resource.beans.CardPaymentsResourceResBean;

public class CardPaymentsResBuilderTest {

	CardPaymentsProcessResBean res;
	@Before
	public void setUp() throws Exception {
		res=new CardPaymentsProcessResBean();
		res.setAmount("10000");
		res.setDate("07-05-2019");
		res.setDesc("Payment cleared on time");
		res.setErrorCode("null");
		res.setErrorMsg("null");
		res.setPaymentStatus("Success");
		res.setResCode("0");
		res.setRespMsg("Success");
	}

	@After
	public void tearDown() throws Exception {
		res=null;
	}

	@Test
	public void testResBuild() {
		CardPaymentsResBuilder resBuilder=new CardPaymentsResBuilder();
		CardPaymentsResourceResBean resBean=resBuilder.resBuild(res);
		Assert.assertNotNull(res);
		Assert.assertEquals("10000", res.getAmount());
		Assert.assertEquals("07-05-2019", res.getDate());
		Assert.assertEquals("Payment cleared on time", res.getDesc());
		Assert.assertEquals("Success", res.getPaymentStatus());
		Assert.assertEquals("null", res.getErrorCode());
		Assert.assertEquals("null", res.getErrorMsg());
		Assert.assertEquals("0", res.getResCode());
		Assert.assertEquals("Success", res.getRespMsg());
				
	}
	

}
