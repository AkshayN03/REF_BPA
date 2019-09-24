package com.tesco.card.payments.resource.api.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.tesco.card.payments.exceptions.BusinessException;
import com.tesco.card.payments.exceptions.SystemException;
import com.tesco.card.payments.process.CardPaymentsProcess;
import com.tesco.card.payments.process.beans.EnrollmentProcessReq;
import com.tesco.card.payments.process.beans.EnrollmentProcessResp;
import com.tesco.card.payments.process.impl.CardPaymentsProcessImpl;
import com.tesco.card.payments.resource.beans.ClientInfo;
import com.tesco.card.payments.resource.beans.CustomerInfo;
import com.tesco.card.payments.resource.beans.EnrollmentRequest;
import com.tesco.card.payments.resource.beans.EnrollmentResponse;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CardPaymentsResourceImpl.class, CardPaymentsProcessImpl.class, CardPaymentsProcess.class})
public class CardPaymentsResourceImplTest {
	
	CardPaymentsResourceImpl resourceImpl;
	CardPaymentsProcess mockProcess;
	CardPaymentsProcessImpl mockProcessImpl;

	@Before
	public void setUp() throws Exception {
		resourceImpl=new CardPaymentsResourceImpl();
		mockProcessImpl = PowerMockito.mock(CardPaymentsProcessImpl.class);
		PowerMockito.whenNew(CardPaymentsProcessImpl.class).withNoArguments().thenReturn(mockProcessImpl);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testDoEnroll() throws BusinessException, SystemException {

		PowerMockito.when(mockProcessImpl.doEnroll(Matchers.any(EnrollmentProcessReq.class))).thenReturn(buildEnrollProcessResp());
		EnrollmentRequest req=buildEnrollReq();
		EnrollmentResponse resp=resourceImpl.doEnroll(null, null, null, null, req);
		System.out.println(resp);
		//assertNotNull(resp);
		assertEquals("0", resp.getStatusBlock().getResponseCode());
	}

	private EnrollmentRequest buildEnrollReq() {
		
		EnrollmentRequest req=new EnrollmentRequest();
		ClientInfo clientInfo=new ClientInfo();
		clientInfo.setClientId("web");
		clientInfo.setChannelId("online");
		clientInfo.setCorrelationId("asdad");
		clientInfo.setMessageTs("12/2019");
		req.setClientInfo(clientInfo);
		
		CustomerInfo customerInfo=new CustomerInfo();
		customerInfo.setCardNumber("1234567890123456");
		customerInfo.setCvvNumber("123");
		customerInfo.setNameOnCard("Sandy");
		customerInfo.setExpDate("12/2022");
		req.setCustomerInfo(customerInfo);
		
		
		return req;
	}
	
	private EnrollmentProcessResp buildEnrollProcessResp() {
		EnrollmentProcessResp response=new EnrollmentProcessResp();
		response.setRespCode("0");
		response.setRespMsg("success");
		response.setEnrollStatus("Enrollment done successfully");
		return response;
	}

}
