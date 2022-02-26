package com.skilldistillery.foodtruck;

public class FoodTruck {

	private static int cumulativeTruckID = 1;

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
	
	public String toString() {
		
		return 
		" Name     : " + this.getName() + 
		"\n Food Type: " + this.getFoodType() +
		"\n Rating   : " + this.getRating() +
		"\n ID       : 00" + this.getTruckID() + "\n";
				
	}

}
