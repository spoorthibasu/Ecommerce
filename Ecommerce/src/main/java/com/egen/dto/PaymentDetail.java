package com.egen.dto;

public class PaymentDetail {
	private String type;
	private double charge;
	private String paymentConfirmation;
	private long billingId;
	
	public long getBillingId() {
		return billingId;
	}
	public void setBillingId(long billingId) {
		this.billingId = billingId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	public String getPaymentConfirmation() {
		return paymentConfirmation;
	}
	public void setPaymentConfirmation(String paymentConfirmation) {
		this.paymentConfirmation = paymentConfirmation;
	}
	

}
