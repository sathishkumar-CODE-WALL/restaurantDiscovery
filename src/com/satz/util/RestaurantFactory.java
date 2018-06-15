package com.satz.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.satz.entities.Restaurant;

public class RestaurantFactory {
	
	public static HashMap<Integer,Restaurant> restuarantMap = new HashMap<>();

	public static Restaurant findRestaurant(int restaurantId) {
		return restuarantMap.get(restaurantId);
	}
	
	public static void addToFactory(Restaurant restaurant){
		restuarantMap.put(restaurant.getRestaurantId(), restaurant);
	}
	
	public static List<Restaurant> getAllRestaurants(){
		return new ArrayList<Restaurant>(restuarantMap.values());
	}
	
	public static void displayRestaurants() {
		for (Map.Entry<Integer,Restaurant> entry : restuarantMap.entrySet()) {
			System.out.println(entry.getValue());
		}
            	
	}
	

}
