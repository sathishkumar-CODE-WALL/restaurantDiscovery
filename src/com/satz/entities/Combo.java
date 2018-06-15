package com.satz.entities;

import java.util.ArrayList;
import java.util.List;

public class Combo{
	
	private List<String> items = new ArrayList<String>();
	private double price;
	
	public Combo(List<String> items, double price) {
		this.items = items;
		this.price = price;
		
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Combo [items=" + items + ", price=" + price + "]";
	}
	
}
