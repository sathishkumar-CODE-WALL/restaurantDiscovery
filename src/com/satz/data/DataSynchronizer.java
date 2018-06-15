package com.satz.data;

import java.util.List;

import com.satz.entities.Combo;
import com.satz.entities.Item;
import com.satz.entities.Restaurant;
import com.satz.util.RestaurantFactory;

public class DataSynchronizer {

	public static void synchronizePriceFeed(List<Data> dataList) {
		Item item = null;
		Combo combo = null;
		Restaurant restaurant;
		for (Data data : dataList) {
			restaurant = RestaurantFactory.findRestaurant(data.getRestaurantId());
			if (restaurant == null) {
				restaurant = new Restaurant(data.getRestaurantId());
				RestaurantFactory.addToFactory(restaurant);
			}
			if (data.getItemList().size() == 1) {
				item = new Item(data.getItemList().get(0), data.getItemPrice());
				restaurant.addMenuItem(item);
			} else {
				combo = new Combo(data.getItemList(), data.getItemPrice());
				restaurant.addComboItem(combo);
			}
		}
	}

}
