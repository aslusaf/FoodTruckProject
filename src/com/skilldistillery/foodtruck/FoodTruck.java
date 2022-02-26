package com.skilldistillery.foodtruck;

public class FoodTruck {

	private static int cumulativeTruckID = 1000;

	private String name;
	private String foodType;
	private double rating;
	private int truckID;

	public FoodTruck() {

	}

	public FoodTruck(String name, String foodType, double rating) {
		setName(name);
		setFoodType(foodType);
		setRating(rating);
		setTruckID();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public int getTruckID() {
		return this.truckID;
	}

	public void setTruckID() {
		this.truckID = cumulativeTruckID++;
	}

}
