package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {

	private static int MAX_FOOD_TRUCKS = 5;

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		FoodTruck ft = new FoodTruck();
		FoodTruckApp fta = new FoodTruckApp();
		FoodTruck[] ftArr = fta.collectFoodTruckInfo(kb, ft);

		fta.printMenu(kb, ftArr);

		kb.close();

	}

	public FoodTruck[] collectFoodTruckInfo(Scanner kb, FoodTruck ft) {

		int numOfFoodTrucks = 0;
		double rating = 0.0;
		double remainder = 0.0;
		FoodTruck[] ftArr = new FoodTruck[MAX_FOOD_TRUCKS];

		do {
			System.out.println("Enter the information for up to " + MAX_FOOD_TRUCKS + " more food trucks (Enter 'Quit' to exit):");
			decrementMAX_FOOD_TRUCKS();
			System.out.print("\nEnter the name of the Food Truck: ");
			String name = kb.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.print("Enter the food type: ");
			String foodType = kb.nextLine();
			System.out.print("Enter the rating [0.0 - 10]: ");
			//ensures the user enters a rating within the valid range of 0.0-10.0
			do {
				rating = kb.nextDouble();
				remainder = Math.round((rating % .1 ) * 10000000000.0) / 10000000000.0;
				System.out.println();
				if ((remainder > 0 && remainder < .1) || rating < 0 || rating > 10) {
					System.out.print("[Invalid rating] Try again: ");
				}
				kb.nextLine();
			} while ((remainder > 0 && remainder < .1) || rating < 0 || rating > 10);
			System.out.println();

			ftArr[numOfFoodTrucks] = new FoodTruck(name, foodType, rating);

			numOfFoodTrucks++;
		} while (numOfFoodTrucks < 5);

		return ftArr;
	}

	public void printMenu(Scanner kb, FoodTruck[] ftArr) {

		int choice;

		do {
			// prints menu with borders
			System.out.print("\n\u250c");
			for (int i = 0; i < 47; i++)
				System.out.print("\u2500");
			System.out.println("\u2510");
			System.out.println("\u2502 Choose from the following options:            \u2502");
			System.out.print("\u251c");
			for (int i = 0; i < 47; i++)
				System.out.print("\u2500");
			System.out.println("\u2524");
			System.out.println("\u2502 1) List all food trucks                       \u2502");
			System.out.println("\u2502 2) List the average rating of all food trucks \u2502");
			System.out.println("\u2502 3) List the highest rated food truck          \u2502");
			System.out.println("\u2502 4) Quit                                       \u2502");
			System.out.print("\u2514");
			for (int i = 0; i < 47; i++)
				System.out.print("\u2500");
			System.out.println("\u2518");
			System.out.print(" \u21f6 ");
			choice = kb.nextInt();
			System.out.println();

			// catch invalid options
			if (choice > 4 || choice < 1) {
				System.out.println(" Invalid option");
				continue;
			}
			// moves into switch if the array isn't empty or if user selects to quit
			if (ftArr[0] != null || choice == 4) {

				switch (choice) {

				case (4):
					System.out.println("Exiting...");
					break;
				case (1):
					listFoodTrucks(ftArr);
					break;
				case (2):
					listAverageRating(ftArr);
					break;
				case (3):
					listHighestRated(ftArr);
					break;
				}

			} else {
				// notifies user if they didn't enter any food truck information
				if (choice != 4)
					System.out.println("There are no food trucks!");

			}
			// loops menu
		} while (choice != 4);

	}

	public boolean checkNull(FoodTruck[] ftArr) {
		return (ftArr[0] == null);
	}

	public void listFoodTrucks(FoodTruck[] ftArr) {

		for (FoodTruck truck : ftArr) {
			if (truck != null) {
				System.out.println(truck.toString());
			}
		}

	}

	public void listAverageRating(FoodTruck[] ftArr) {
		int numOfRatings = 0;
		double ratingTotal = 0.0;

		for (FoodTruck truck : ftArr) {
			if (truck != null) {
				numOfRatings++;
				ratingTotal += truck.getRating();
			}
		}
		System.out.printf(" Average Rating: %.1f", Math.round((ratingTotal / numOfRatings) * 100.0) / 100.0);
		System.out.println();

	}

	public void listHighestRated(FoodTruck[] ftArr) {
		double highestRating = ftArr[0].getRating();
		int index = 0;

		for (int i = 1; i < ftArr.length; i++) {
			if (ftArr[i] != null && ftArr[i].getRating() > highestRating) {
				highestRating = ftArr[i].getRating();
				index = i;
			}
		}
		System.out.println(ftArr[index].toString());
	}
	
	public void decrementMAX_FOOD_TRUCKS() {
		MAX_FOOD_TRUCKS--;
	}

}
