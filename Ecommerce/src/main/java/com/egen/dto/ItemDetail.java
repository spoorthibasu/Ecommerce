package com.egen.dto;
/*Data Transfer object
 * It calls for the use of objects that aggregate and encapsulate data for transfer
 * */
public class ItemDetail {
	private long id;
	private int qty;
	private double price;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
