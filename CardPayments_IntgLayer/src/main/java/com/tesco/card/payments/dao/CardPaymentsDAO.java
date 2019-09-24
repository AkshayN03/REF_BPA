/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.dao;

import com.tesco.card.payments.dao.beans.CardPaymentsDAOReq;
import com.tesco.card.payments.dao.beans.CardPaymentsDAORes;
import com.tesco.card.payments.dao.beans.EnrollmentDaoReq;
import com.tesco.card.payments.dao.beans.EnrollmentDaoResp;
import com.tesco.card.payments.exceptions.BusinessException;
import com.tesco.card.payments.exceptions.SystemException;

/**
 * @author : Sandilya Anisetty
 * @date   : {date}
 * @description: 
 */
public interface CardPaymentsDAO {
	
	EnrollmentDaoResp doEnroll(EnrollmentDaoReq req) throws BusinessException, SystemException;
	CardPaymentsDAORes doPayments(CardPaymentsDAOReq req) throws BusinessException, SystemException;

}
