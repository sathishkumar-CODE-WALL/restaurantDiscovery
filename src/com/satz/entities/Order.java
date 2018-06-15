package com.satz.entities;

import java.util.HashMap;
import java.util.Map;

public class Order {
	
	Map<String,Integer> orderMap = new HashMap<String,Integer>();
	
	public Map<String, Integer> getOrderMap() {
		return orderMap;
	}

	public void setOrderMap(Map<String, Integer> orderMap) {
		this.orderMap = orderMap;
	}

	public void addItemToOrder(String itemId, Integer quantity){
		if(orderMap.get(itemId)!=null){
			orderMap.put(itemId, orderMap.get(itemId)+quantity);
		}else{
			orderMap.put(itemId, quantity);
		}
	}
	
	public void removeItemToOrder(String itemId){
		if(orderMap.get(itemId)!=null){
			orderMap.remove(itemId);
		}
	}
	

}
