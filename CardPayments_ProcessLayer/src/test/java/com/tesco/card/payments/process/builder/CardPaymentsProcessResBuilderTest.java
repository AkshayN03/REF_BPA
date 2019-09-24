package com.tesco.card.payments.process.builder;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tesco.card.payments.dao.beans.CardPaymentsDAORes;
import com.tesco.card.payments.process.beans.CardPaymentsProcessResBean;


public class CardPaymentsProcessResBuilderTest {
	
	CardPaymentsDAORes res;

	@Before
	public void setUp() throws Exception {
		res=buildDaoRes();
	}

	@After
	public void tearDown() throws Exception {
		res=null;
	}

	@Test
	public void testBuild() {
		CardPaymentsProcessResBuilder builder=new CardPaymentsProcessResBuilder();
		CardPaymentsProcessResBean resBean=builder.build(res);
		Assert.assertNotNull(resBean);
		Assert.assertEquals("10000", resBean.getAmount());
		Assert.assertEquals("07-05-2019", resBean.getDate());
		Assert.assertEquals("Payment cleared on time", resBean.getDesc());
		//Assert.assertEquals("", resBean.getErrorCode());
		//Assert.assertEquals("", resBean.getErrorMsg());
		Assert.assertEquals("Success", resBean.getPaymentStatus());
		Assert.assertEquals("0", resBean.getResCode());
		Assert.assertEquals("Success", resBean.getRespMsg());
		
	}
	
	private CardPaymentsDAORes buildDaoRes() {
		CardPaymentsDAORes res=new CardPaymentsDAORes();
		res.setAmount("10000");
		res.setDate("07-05-2019");
		res.setDesc("Payment cleared on time");
		//res.setErrorCode("");
		//res.setErrorMsg("");
		res.setPaymentStatus("Success");
		res.setResCode("0");
		res.setRespMsg("Success");
		return res;
		
	}

}
