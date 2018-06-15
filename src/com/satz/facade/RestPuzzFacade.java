package com.satz.facade;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.satz.data.Data;
import com.satz.data.DataImporter;
import com.satz.data.DataSynchronizer;
import com.satz.entities.Order;
import com.satz.entities.Restaurant;
import com.satz.util.RestaurantFactory;

/**
 * 
 * @author sathish this is the facade class to run the application
 *
 */
public class RestPuzzFacade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int index = 1;
		String fileName = null;
		Order order = new Order();

		if (args[0] != null)
			fileName = args[0];

		feedPriceData(fileName);

		for (index = 1; index < args.length; index++)
			order.addItemToOrder(args[index], 1);

		Map<Integer, Double> restaurantPriceMap = processOrder(order);
		if (restaurantPriceMap.entrySet().size() == 0) {
			System.out.println("None");
		} else {
			Entry<Integer, Double> optimalRestaurant = getOptimalRestaurant(restaurantPriceMap);
			System.out.println(optimalRestaurant.getKey() + "," + optimalRestaurant.getValue());
		}

	}

	/**
	 * Extract data and sync to restaurants
	 * 
	 * @param fileName
	 */
	private static void feedPriceData(String fileName) {
		List<Data> dataList = DataImporter.importData(fileName);
		DataSynchronizer.synchronizePriceFeed(dataList);
	}

	/**
	 * processing the order in all the available restaurants and returning a map
	 * of restaurant and cost.
	 * 
	 * @param order
	 * @return
	 */
	private static Map<Integer, Double> processOrder(Order order) {
		Map<Integer, Double> tempMap = new HashMap<Integer, Double>();
		double estimatedCost = 0.0;

		for (Restaurant r : RestaurantFactory.getAllRestaurants()) {
			estimatedCost = r.estimateOrder(order);
			if (estimatedCost > 0)
				tempMap.put(r.getRestaurantId(), estimatedCost);
		}
		return tempMap;
	}

	/**
	 * find restaurant that offers miminimum cost
	 * 
	 * @param map
	 * @return
	 */
	private static Entry<Integer, Double> getOptimalRestaurant(Map<Integer, Double> map) {
		Entry<Integer, Double> optimalRestaurant = Collections.min(map.entrySet(),
				new Comparator<Entry<Integer, Double>>() {
					public int compare(Entry<Integer, Double> entry1, Entry<Integer, Double> entry2) {
						return entry1.getValue().compareTo(entry2.getValue());
					}
				});
		return optimalRestaurant;
	}

}
