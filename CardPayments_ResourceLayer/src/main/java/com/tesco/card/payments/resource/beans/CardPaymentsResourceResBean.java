/** Copyrights 2019 Tesco.. All rights reserved..
 * we should not disclose the info outside
 * otherwise terms and conditions apply
 */
package com.tesco.card.payments.resource.beans;

/**
 * @author : Sandilya Anisetty
 * @date : 30-Apr-2019
 * @description:
 */
public class CardPaymentsResourceResBean {

	private StatusBlock statusBlock;
	private BillPaymentsInfo billPaymentsInfo;

	/**
	 * @return the statusBlock
	 */
	public StatusBlock getStatusBlock() {
		return statusBlock;
	}

	/**
	 * @param statusBlock the statusBlock to set
	 */
	public void setStatusBlock(StatusBlock statusBlock) {
		this.statusBlock = statusBlock;
	}

	/**
	 * @return the billPaymentsInfo
	 */
	public BillPaymentsInfo getBillPaymentsInfo() {
		return billPaymentsInfo;
	}

	/**
	 * @param billPaymentsInfo the billPaymentsInfo to set
	 */
	public void setBillPaymentsInfo(BillPaymentsInfo billPaymentsInfo) {
		this.billPaymentsInfo = billPaymentsInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cardPaymentsResourceResBean [statusBlock=");
		builder.append(statusBlock);
		builder.append(", billPaymentsInfo=");
		builder.append(billPaymentsInfo);
		builder.append("]");
		return builder.toString();
	}

}
