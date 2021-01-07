package com.egen.dto;

import java.util.List;
import java.util.Map;

public class OrderCreation {

	private List<ItemDetail> itemDetailList;
	private long shippingId;
	private long customerId;
	private List<PaymentDetail> paymentDetailList;
	public List<ItemDetail> getItemDetailList() {
		return itemDetailList;
	}
	public void setItemDetailList(List<ItemDetail> itemDetailList) {
		this.itemDetailList = itemDetailList;
	}
	public long getShippingId() {
		return shippingId;
	}
	public void setShippingId(long shippingId) {
		this.shippingId = shippingId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public List<PaymentDetail> getPaymentDetailList() {
		return paymentDetailList;
	}
	public void setPaymentDetailList(List<PaymentDetail> paymentDetailList) {
		this.paymentDetailList = paymentDetailList;
	}
	
	
	 
}
