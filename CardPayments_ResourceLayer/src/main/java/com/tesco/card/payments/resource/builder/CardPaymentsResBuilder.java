/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.resource.builder;

import org.apache.log4j.Logger;

import com.tesco.card.payments.process.beans.CardPaymentsProcessResBean;
import com.tesco.card.payments.process.beans.EnrollmentProcessResp;
import com.tesco.card.payments.resource.beans.BillPaymentsInfo;
import com.tesco.card.payments.resource.beans.StatusBlock;
import com.tesco.card.payments.resource.beans.CardPaymentsResourceResBean;
import com.tesco.card.payments.resource.beans.EnrollmentResponse;

/**
 * @author : Sandilya Anisetty
 * @date : 30-Apr-2019
 * @description:
 */
public class CardPaymentsResBuilder {

	/**
	 * @param processRes
	 * @return
	 */
	private Logger logger= Logger.getLogger(CardPaymentsResBuilder.class);
	
	public CardPaymentsResourceResBean resBuild(CardPaymentsProcessResBean processRes) {
		logger.info("Entered into response builder method" + processRes);
		CardPaymentsResourceResBean cardPaymentsResourceResBean = new CardPaymentsResourceResBean();

		/* Setting status block */
		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setResponseCode(processRes.getResCode());
		statusBlock.setResponseMsg(processRes.getRespMsg());

		/* Setting payment info */
		BillPaymentsInfo billPaymentsInfo = new BillPaymentsInfo();
		billPaymentsInfo.setAmount(processRes.getAmount());
		billPaymentsInfo.setDate(processRes.getDate());
		billPaymentsInfo.setPaymentStatus(processRes.getPaymentStatus());
		billPaymentsInfo.setDesc(processRes.getDesc());

		cardPaymentsResourceResBean.setStatusBlock(statusBlock);
		cardPaymentsResourceResBean.setBillPaymentsInfo(billPaymentsInfo);
		logger.info("Exit from response builder method" + cardPaymentsResourceResBean);
		return cardPaymentsResourceResBean;
	}

	public EnrollmentResponse buildEnrollResp(EnrollmentProcessResp processResp) {
		// TODO Auto-generated method stub
		return null;
	}

}
