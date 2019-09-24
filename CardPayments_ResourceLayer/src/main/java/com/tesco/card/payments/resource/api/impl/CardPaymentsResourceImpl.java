/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.resource.api.impl;

import java.io.IOException;
import java.lang.annotation.Repeatable;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.tesco.card.payments.exceptions.BusinessException;
import com.tesco.card.payments.exceptions.SystemException;
import com.tesco.card.payments.process.CardPaymentsProcess;
import com.tesco.card.payments.process.beans.CardPaymentsProcessReqBean;
import com.tesco.card.payments.process.beans.CardPaymentsProcessResBean;
import com.tesco.card.payments.process.beans.EnrollmentProcessReq;
import com.tesco.card.payments.process.beans.EnrollmentProcessResp;
import com.tesco.card.payments.process.impl.CardPaymentsProcessImpl;
import com.tesco.card.payments.resource.api.CardPaymentsResource;
import com.tesco.card.payments.resource.beans.CardPaymentsResourceReqBean;
import com.tesco.card.payments.resource.beans.CardPaymentsResourceResBean;
import com.tesco.card.payments.resource.beans.EnrollmentRequest;
import com.tesco.card.payments.resource.beans.EnrollmentResponse;
import com.tesco.card.payments.resource.beans.StatusBlock;
import com.tesco.card.payments.resource.builder.CardPaymentsReqBuilder;
import com.tesco.card.payments.resource.builder.CardPaymentsResBuilder;
import com.tesco.card.payments.resource.exception.InvalidRequestException;
import com.tesco.card.payments.resource.validator.CardPaymentsRequestValidator;

/**
 * @author : Sandilya Anisetty
 * @date : 30-Apr-2019
 * @description:
 */

@Path("/card")
public class CardPaymentsResourceImpl implements CardPaymentsResource {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tesco.card.payments.resource.api.cardPaymentsResource#doPayments(com.
	 * tesco.card.payments.resource.beans.cardPaymentsResourceReqBean)
	 */

	private Logger logger = Logger.getLogger(CardPaymentsResourceImpl.class);

	@Path("/enroll")
	@POST
	@Produces("application/json")
	@Consumes("MediaType.APPLICATION_JSON")
	public EnrollmentResponse doEnroll(@HeaderParam("client_id") String client_id, @HeaderParam("channel_id") String channel_id,
									   @HeaderParam("correlation_id") String correlation_id,
									   @HeaderParam("msg_ts") String msg_ts, EnrollmentRequest req) {

		// get the request from the client

		// validate the request
		CardPaymentsRequestValidator validator = new CardPaymentsRequestValidator();
		//Need to check
		validator.validate(req);

		// prepare the request for process layer
		CardPaymentsReqBuilder reqBuilder = new CardPaymentsReqBuilder();
		EnrollmentProcessReq processReq = reqBuilder.buildEnrollProcessReq(req);

		// call process layer and get the response
		CardPaymentsProcess process = new CardPaymentsProcessImpl();
		EnrollmentProcessResp processResp;
		EnrollmentResponse resp = null;
		try {
			processResp = process.doEnroll(processReq);
			// prepare the service response
			CardPaymentsResBuilder respBuilder = new CardPaymentsResBuilder();
			resp = respBuilder.buildEnrollResp(processResp);

		} catch (BusinessException be) {
			logger.error("Error occured", be);
		} catch (SystemException se) {
			logger.error("Error occured", se);
		} catch (Exception e) {
			logger.fatal("Error occured", e);
		}

		return resp;
	}
	
	

	@Path("/payments")
	@POST
	@Produces("application/json")
	@Consumes("MediaType.APPLICATION_JSON")
	public CardPaymentsResourceResBean doPayments(CardPaymentsResourceReqBean req) {

		logger.info("Entered into resource layer" + req);
		// get request from the client

		// validate the request
		CardPaymentsResourceResBean res = new CardPaymentsResourceResBean();
		try {
			CardPaymentsRequestValidator validator = new CardPaymentsRequestValidator();
			validator.validate(req);

			// build process request
			CardPaymentsReqBuilder reqBuilder = new CardPaymentsReqBuilder();
			CardPaymentsProcessReqBean processReq = reqBuilder.reqBuild(req);

			// call process layer and get process response
			CardPaymentsProcess cardPaymentsProcess = new CardPaymentsProcessImpl();
			CardPaymentsProcessResBean processRes = cardPaymentsProcess.dopayments(processReq);

			// build resource response
			CardPaymentsResBuilder resBuilder = new CardPaymentsResBuilder();
			res = resBuilder.resBuild(processRes);
		} catch (InvalidRequestException e) {

			StatusBlock statusBlock = new StatusBlock();
			statusBlock.setResponseCode(e.getResponseCode());
			statusBlock.setResponseMsg(e.getResponseMsg());
			res.setStatusBlock(statusBlock);
			logger.error("Error occured", e);
		} catch (BusinessException be) {
			StatusBlock statusBlock = new StatusBlock();
			statusBlock.setResponseCode(be.getResponseCode());
			statusBlock.setResponseMsg(be.getResponseMsg());
			res.setStatusBlock(statusBlock);
			logger.error("Error occured", be);
		} catch (SystemException se) {
			StatusBlock statusBlock = new StatusBlock();
			statusBlock.setResponseCode(se.getResponseCode());
			statusBlock.setResponseMsg(se.getResponseMsg());
			res.setStatusBlock(statusBlock);
			logger.error("Error occured", se);
		} catch (Exception e) {
			logger.fatal("Error occured", e);
		}

		logger.info("Exit from resource layer" + res);

		return res;
	}

	@Path("/health")
	// @Produces(MediaType.TEXT_HTML_TYPE)
	public String healthCheck() {
		String msg = "Healthy";
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(msg);
		} catch (JsonGenerationException e) {
			logger.error("Error occured", e);
		} catch (JsonMappingException e) {
			logger.error("Error occured", e);
		} catch (IOException e) {
			logger.error("Error occured", e);
		} catch (Exception e) {
			logger.fatal("Error occured", e);
		}

		return json;

	}

}
