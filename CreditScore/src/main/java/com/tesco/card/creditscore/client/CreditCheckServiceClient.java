/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.creditscore.client;

import com.tesco.card.creditscore.client.beans.CreditCheckServiceRequest;
import com.tesco.card.creditscore.client.beans.CreditCheckServiceResponse;

/**
 * @author : Sandilya Anisetty
 * @date   : 10-May-2019
 * @description:
 */
public interface CreditCheckServiceClient {
	
	CreditCheckServiceResponse getCreditScore (CreditCheckServiceRequest req);

}
