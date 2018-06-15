package com.satz.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	private int restaurantId;
	private List<Item> itemList = new ArrayList<Item>();
	private List<Combo> comboList = new ArrayList<Combo>();

	public Restaurant(int restaurantId, List<Item> itemList, List<Combo> comboList) {
		this.restaurantId = restaurantId;
		this.itemList = itemList;
		this.comboList = comboList;
	}
	public Restaurant(int restaurantId){
		this.restaurantId = restaurantId;
	}
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public List<Item> getMenuList() {
		return itemList;
	}
	public void setMenuList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public List<Combo> getComboList() {
		return comboList;
	}
	public void setComboList(List<Combo> comboList) {
		this.comboList = comboList;
	}
	
	public void addMenuItem(Item item){
		this.itemList.add(item);
	}

	public void addComboItem(Combo combo){
		this.comboList.add(combo);
	}
	
	public Item fetchItem(String orderItem){
		Item mitem = itemList.stream().filter(item->item.getItemId().equalsIgnoreCase(orderItem)).findAny().orElse(null);
		return mitem;
	}
	
	public Combo fetchCombo(String orderItem){
		String resultCombo = null;
		for(Combo combo : this.comboList){
			resultCombo = combo.getItems().stream().filter(str->str.equalsIgnoreCase(orderItem)).findAny().orElse(null);
			if(resultCombo==null){
				continue;
			}else{
				return combo;
			}
		}
		return null;
	}
	
	public double estimateOrder(Order order){
		double estimate=0.0;
		Item item;
		Combo cItem;
		for(String orderItem: order.getOrderMap().keySet()){
			item = fetchItem(orderItem);
			cItem = fetchCombo(orderItem);
			
			if(item==null && cItem==null){
				return 0.0;
			}else if(item!=null){
				estimate+=item.getItemPrice();
			}else if(cItem!=null){
				estimate+=cItem.getPrice();
			}
		}
		return estimate;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", menuList=" + itemList + ", comboList=" + comboList + "]";
	}
	
	
	
}
