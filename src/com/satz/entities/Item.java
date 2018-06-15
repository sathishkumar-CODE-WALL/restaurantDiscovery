package com.satz.entities;


public class Item {
	private String itemId;
	private double itemPrice;
	
	public Item(String itemId, double price){
		this.itemId = itemId;
		this.itemPrice = price;
	}
	
	public Item(String itemId){
		this.itemId=itemId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemPrice=" + itemPrice + "]";
	}
	
	
	
}
