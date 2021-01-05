package com.foodPlaza.dao;

import java.util.ArrayList;

import com.foodPlaza.Pojo.Food;

public interface FoodDao 
{
	boolean addFood(Food f);
	boolean deleteFoodDetails(int foodID);
	boolean updateFoodDetails(Food f);
	ArrayList<Food> searchByFoodType(String foodType);
	ArrayList<Food> searchByFoodName(String foodName);
	ArrayList<Food> searchByFoodCategory(String foodCategory);
	ArrayList<Food> showAllFoodDetails();
}
