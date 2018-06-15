package com.satz.data;

import java.util.ArrayList;
import java.util.List;

public class Data {
	private int restaurantId;
	private double itemPrice;
	private List<String> itemList = new ArrayList<>();

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public List<String> getItemList() {
		return itemList;
	}

	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}
	
	public void addItem(String item){
		this.itemList.add(item);
	}

	@Override
	public String toString() {
		return "Data [restaurantId=" + restaurantId + ", itemPrice=" + itemPrice + ", itemList=" + itemList + "]";
	}


	

}
