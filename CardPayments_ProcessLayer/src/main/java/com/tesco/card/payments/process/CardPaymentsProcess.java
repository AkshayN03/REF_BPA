/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.process;

import com.tesco.card.payments.exceptions.BusinessException;
import com.tesco.card.payments.exceptions.SystemException;
import com.tesco.card.payments.process.beans.CardPaymentsProcessReqBean;
import com.tesco.card.payments.process.beans.CardPaymentsProcessResBean;
import com.tesco.card.payments.process.beans.EnrollmentProcessReq;
import com.tesco.card.payments.process.beans.EnrollmentProcessResp;

/**
 * @author : Sandilya Anisetty
 * @date   : 30-Apr-2019
 * @description:
 */
public interface CardPaymentsProcess {
	
	EnrollmentProcessResp doEnroll(EnrollmentProcessReq req) throws BusinessException, SystemException;
	CardPaymentsProcessResBean dopayments(CardPaymentsProcessReqBean req) throws BusinessException, SystemException;

}
