/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.StoredProcedure;

import com.tesco.card.payments.dao.CardPaymentsDAO;
import com.tesco.card.payments.dao.beans.CardPaymentsDAOReq;
import com.tesco.card.payments.dao.beans.CardPaymentsDAORes;
import com.tesco.card.payments.dao.beans.EnrollmentDaoReq;
import com.tesco.card.payments.dao.beans.EnrollmentDaoResp;
import com.tesco.card.payments.exceptions.BusinessException;
import com.tesco.card.payments.exceptions.SystemException;

/**
 * @author : Sandilya Anisetty
 * @date : 30-Apr-2019
 * @description:
 */
public class CardPaymentsDAOImpl extends StoredProcedure implements CardPaymentsDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tesco.card.payments.dao.cardPaymentsDAO#doPayments(com.tesco.card.
	 * payments.dao.beans.cardPaymentsDAOReq)
	 */

	private Logger logger = Logger.getLogger(CardPaymentsDAOImpl.class);

	public CardPaymentsDAOImpl() {
		super(prepareJdbcTemplate(), "GET_ENROLLMENT");
		registerSpParams();
	}

	private static JdbcTemplate prepareJdbcTemplate() {
		
		String dbUrl = null;
		String userName = null;
		String password = null;
		String env=System.getProperty("environment");
		String propFile="properties/"+env+"_db_properties.properties";
			try (InputStream input = CardPaymentsDAOImpl.class.getClassLoader().getResourceAsStream(propFile)) {
  
		Properties properties = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find properties file");
            }
            //load a properties file from class path, inside static method
            properties.load(input);
            //get the property value and print it out
            dbUrl=properties.getProperty("db_url");
            userName=properties.getProperty("username");
            password=properties.getProperty("password");
            System.out.println(dbUrl);
            System.out.println(userName);
            System.out.println(password);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

	private void registerSpParams() {

		/* Input params */
		declareParameter(new SqlParameter("CLIENT_ID", Types.VARCHAR));
		declareParameter(new SqlParameter("CHANNEL_ID", Types.VARCHAR));
		declareParameter(new SqlParameter("CARD_NUMBER", Types.VARCHAR));
		declareParameter(new SqlParameter("MOB_NUMBER", Types.VARCHAR));
		declareParameter(new SqlParameter("CVV", Types.VARCHAR));
		declareParameter(new SqlParameter("EXP_DATE", Types.VARCHAR));
		declareParameter(new SqlParameter("ACCOUNT_NUM", Types.VARCHAR));

		/* Output params */
		declareParameter(new SqlOutParameter("RESPCODE", Types.VARCHAR));
		declareParameter(new SqlOutParameter("RESPMSG", Types.VARCHAR));

		compile();
	}

	public EnrollmentDaoResp doEnroll(EnrollmentDaoReq daoReq) throws BusinessException, SystemException {

		EnrollmentDaoResp daoresp = new EnrollmentDaoResp();
		try {

			/* Prepare Stored Procedure Request */
			Map<String, Object> inputMap = new HashMap<String, Object>();
			inputMap.put("CLIENT_ID", daoReq.getClientId());
			inputMap.put("CHANNEL_ID", daoReq.getChannelId());
			inputMap.put("CARD_NUMBER", daoReq.getCardNumber());
			inputMap.put("ACCOUNT_NUM", daoReq.getAccountNumber());
			inputMap.put("CVV", daoReq.getCvvNumber());
			inputMap.put("EXP_DATE", daoReq.getExpDate());
			inputMap.put("MOB_NUMBER", daoReq.getMobile());
			

			/* Execute the Stored Procedure */
			Map<String, Object> respMsg = super.execute(inputMap);
			String dbRespCode = null;
			String dbRespMsg = null;
			
			System.out.println("respMsg "+respMsg.get("RESPCODE"));
			/* Get the output params */
			if (respMsg != null) {
				dbRespCode = respMsg.get("RESPCODE").toString();
				dbRespMsg = respMsg.get("RESPMSG").toString();
			}
			if ("0".equals(dbRespCode)) {
				daoresp.setResCode(dbRespCode);
				daoresp.setRespMsg(dbRespMsg);
			} else if (dbRespCode.startsWith("1"))
				throw new BusinessException(dbRespCode, dbRespMsg);
//		else if("200".equals(responseCode) || "201".equals(responseCode))
			else if (dbRespCode.startsWith("2"))
				throw new SystemException(dbRespCode, dbRespMsg);
			else
				throw new SystemException("999", "Unknown error from db");
		} catch (BusinessException be) {
			logger.error("Exception caught", be);
			throw be;
		} catch (SystemException se) {
			logger.error("Exception caught", se);
			throw se;
		} catch (DataAccessException dae) {
			logger.error("Exception occured", dae);
		} catch (Exception e) {
			logger.fatal("Exception occured", e);
		}

		return daoresp;
	}

	public CardPaymentsDAORes doPayments(CardPaymentsDAOReq req) throws BusinessException, SystemException {
		logger.info("Entered into integration layer" + req);
		/* prepare db request */
		/* call db and get resultset */
		CardPaymentsDAORes daoRes = new CardPaymentsDAORes();
		String responseCode = "0"; // db.getResponseCode();
		String responseMsg = "Success"; // db.getResponseMsg();
		try {
			if ("0".equals(responseCode)) {
				daoRes.setResCode(responseCode);
				daoRes.setRespMsg(responseMsg);
				daoRes.setErrorCode("0");
				daoRes.setErrorMsg("Success");
				daoRes.setAmount("10000");
				daoRes.setDate("07-05-2019");
				daoRes.setPaymentStatus("Success");
				daoRes.setDesc("Payment cleared on time");
			}
//		else if("100".equals(responseCode) || "101".equals(responseCode))
			else if (responseCode.startsWith("1"))
				throw new BusinessException(responseCode, responseMsg);
//		else if("200".equals(responseCode) || "201".equals(responseCode))
			else if (responseCode.startsWith("2"))
				throw new SystemException(responseCode, responseMsg);
			else
				throw new SystemException("999", "Unknown error from db");
		} catch (BusinessException be) {
			logger.error("Exception caught", be);
		} catch (SystemException se) {
			logger.error("Exception caught", se);
		} catch (Exception e) {
			logger.fatal("Exception occured", e);
		}

		logger.debug("Exit from integration layer");
		return daoRes;
	}
	
	public static void main (String args[]) throws Exception, SystemException {
		
		System.setProperty("environment", "dev");
		EnrollmentDaoReq req=new EnrollmentDaoReq();
		req.setClientId("1111");
		req.setChannelId("online");
		req.setCardNumber("1234567890123456");
		req.setCvvNumber("123");
		req.setAccountNumber("12358974");
		req.setExpDate("28/2020");
		req.setMobile("9553137350");
		CardPaymentsDAOImpl impl = new CardPaymentsDAOImpl();
		EnrollmentDaoResp resp = impl.doEnroll(req);
		System.out.println("resp code= "+resp.getResCode());
		System.out.println("resp msg= "+resp.getRespMsg());
	}

}
