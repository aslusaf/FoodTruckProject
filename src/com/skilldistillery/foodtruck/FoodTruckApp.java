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
			System.out.print("Enter the rating: "); //TODO Add rating range
			double rating = kb.nextDouble();
			System.out.println();

			ftArr[numOfFoodTrucks] = new FoodTruck(name, foodType, rating);

			numOfFoodTrucks++;
		} while (numOfFoodTrucks < 5);

		return ftArr;
	}

	public void printMenu(Scanner kb, FoodTruck[] ftArr) {

		int choice;

		do {
			System.out.println("\nChoose from the following options: \n");
			System.out.println("1) List all food trucks");
			System.out.println("2) List the average rating of all food trucks");
			System.out.println("3) List the highest rated food truck");
			System.out.println("4) Quit\n");
			choice = kb.nextInt();
			System.out.println();

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

				if (choice != 4)
					System.out.println("There are no food trucks!");

			}

		} while (choice != 4);

	}

	public boolean checkNull(FoodTruck[] ftArr) {
		return (ftArr[0] == null);
	}

	public void listFoodTrucks(FoodTruck[] ftArr) {

		for (FoodTruck truck : ftArr) {
			if (truck != null) {
				System.out.println(truck.toString()); // ********************************
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
		} // TODO round and printf the rating
		System.out.println("Average Rating: " + ratingTotal / numOfRatings);
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

}
