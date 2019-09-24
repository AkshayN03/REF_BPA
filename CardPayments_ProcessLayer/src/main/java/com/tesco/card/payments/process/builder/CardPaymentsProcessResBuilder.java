/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.process.builder;

import org.apache.log4j.Logger;

import com.tesco.card.payments.dao.beans.CardPaymentsDAORes;
import com.tesco.card.payments.process.beans.CardPaymentsProcessResBean;
import com.tesco.card.payments.process.impl.CardPaymentsProcessImpl;

/**
 * @author : Sandilya Anisetty
 * @date   : 30-Apr-2019
 * @description:
 */
public class CardPaymentsProcessResBuilder {

	/**
	 * @param cardPaymentsDAORes
	 * @return
	 */
	
	private Logger logger= Logger.getLogger(CardPaymentsProcessImpl.class);
	
	public CardPaymentsProcessResBean build(CardPaymentsDAORes cardPaymentsDAORes) {
		logger.debug("Entered into process res builder");
		CardPaymentsProcessResBean cardPaymentsProcessResBean=new CardPaymentsProcessResBean();
		cardPaymentsProcessResBean.setResCode(cardPaymentsDAORes.getResCode());
		cardPaymentsProcessResBean.setRespMsg(cardPaymentsDAORes.getRespMsg());
		cardPaymentsProcessResBean.setAmount(cardPaymentsDAORes.getAmount());
		cardPaymentsProcessResBean.setDate(cardPaymentsDAORes.getDate());
		cardPaymentsProcessResBean.setPaymentStatus(cardPaymentsDAORes.getPaymentStatus());
		cardPaymentsProcessResBean.setDesc(cardPaymentsDAORes.getDesc());
		logger.debug("Exit from process res builder");
		return cardPaymentsProcessResBean;
	}

}
