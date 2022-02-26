package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {

	private static int MAX_FOOD_TRUCKS = 5;

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		FoodTruck ft = new FoodTruck();
		FoodTruckApp fta = new FoodTruckApp();
		FoodTruck[] ftArr = fta.collectFoodTruckInfo(kb, ft);
		
		//test code
		for (int i=0; i < ftArr.length; i++) {
			System.out.println(ftArr[i].getName() + ftArr[i].getFoodType() +ftArr[i].getRating() + ftArr[i].getTruckID());
		
		}
		

		kb.close();

	}

	public FoodTruck[] collectFoodTruckInfo(Scanner kb, FoodTruck ft) {
		
			int numOfFoodTrucks = 0;
			FoodTruck[] ftArr = new FoodTruck[MAX_FOOD_TRUCKS];

		do {
			System.out.println("Enter the information for up to " + MAX_FOOD_TRUCKS + " food trucks below:");
			System.out.print("\nEnter the name of the Food Truck: ");
			String name = kb.next();
			if (name.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.print("Enter the food type: ");
			String foodType = kb.next();
			System.out.println("Enter the rating: \n");
			double rating = kb.nextDouble();
			
			
			
			ftArr[numOfFoodTrucks] = new FoodTruck(name, foodType, rating);
			
			numOfFoodTrucks++;
		} while (numOfFoodTrucks < 5);
		
		return ftArr;
	}

}
