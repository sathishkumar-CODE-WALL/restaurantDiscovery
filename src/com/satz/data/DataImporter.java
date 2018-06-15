package com.satz.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataImporter {

	public static List<Data> importData(String fileName) {

		String line = null;
		Scanner scanner = null;
		int index = 0;
		List<Data> dataList = new ArrayList<>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){

			while ((line = reader.readLine()) != null) {
				Data data = new Data();
				scanner = new Scanner(line);
				scanner.useDelimiter(",");
				while (scanner.hasNext()) {
					String col = scanner.next().trim();
					if (index == 0)
						data.setRestaurantId(Integer.parseInt(col));
					else if (index == 1)
						data.setItemPrice(Double.parseDouble(col));
					else 
						data.addItem(col);
					index++;
				}
				index = 0;
				dataList.add(data);
			}
		}catch(IOException e){
			System.out.println("Error in reading file. Please check the filename!");
		}
		return dataList;

	}
}
