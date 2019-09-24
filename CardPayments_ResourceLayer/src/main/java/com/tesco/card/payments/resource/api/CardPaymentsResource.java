/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.resource.api;

import com.tesco.card.payments.resource.beans.CardPaymentsResourceReqBean;
import com.tesco.card.payments.resource.beans.CardPaymentsResourceResBean;
import com.tesco.card.payments.resource.beans.EnrollmentRequest;
import com.tesco.card.payments.resource.beans.EnrollmentResponse;

/**
 * @author : Sandilya Anisetty
 * @date   : 30-Apr-2019
 * @description:
 */
public interface CardPaymentsResource {
	
	CardPaymentsResourceResBean doPayments (CardPaymentsResourceReqBean req);

}
