package com.foodPlaza.Pojo;

public class Food 
{
	private int foodID;
	private String foodName;
	private String foodDescription;
	private String foodCategory;
	private String foodType;
	private double foodPrice;
	
	public Food()
	{
		
	}
	
	public Food(int foodID, String foodName, String foodDescription, String foodCategory, String foodType, double foodPrice) 
	{
		this.foodID = foodID;
		this.foodName = foodName;
		this.foodDescription = foodDescription;
		this.foodCategory = foodCategory;
		this.foodType = foodType;
		this.foodPrice = foodPrice;
	}

	public int getFoodID() 
	{
		return foodID;
	}
	public void setFoodID(int foodID) 
	{
		this.foodID = foodID;
	}
	public String getFoodName() 
	{
		return foodName;
	}
	public void setFoodName(String foodName) 
	{
		this.foodName = foodName;
	}
	public String getFoodDescription() 
	{
		return foodDescription;
	}
	public void setFoodDescription(String foodDescription) 
	{
		this.foodDescription = foodDescription;
	}
	public String getFoodCategory() 
	{
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) 
	{
		this.foodCategory = foodCategory;
	}
	public String getFoodType() 
	{
		return foodType;
	}
	public void setFoodType(String foodType) 
	{
		this.foodType = foodType;
	}
	public double getFoodPrice() 
	{
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) 
	{
		this.foodPrice = foodPrice;
	}

	@Override
	public String toString() 
	{
		return "Food [foodID=" + foodID + ", foodName=" + foodName + ", foodDescription=" + foodDescription
				+ ", foodCategory=" + foodCategory + ", foodType=" + foodType + ", foodPrice=" + foodPrice + "]";
	}
	
	
}
