package com.foodPlaza.Pojo;

public class Cart 
{
	private int cartID;
	private int foodID;
	private int foodQuantity;
	private double foodPrice;
	private double totalPrice;
	private String custEmailID;
	
	public Cart()
	{
		
	}
	
	public Cart(int cartID, int foodID, int foodQuantity, double foodPrice, double totalPrice, String custEmailID) 
	{
		this.cartID = cartID;
		this.foodID = foodID;
		this.foodQuantity = foodQuantity;
		this.foodPrice = foodPrice;
		this.totalPrice = totalPrice;
		this.custEmailID = custEmailID;
	}

	public int getCartID() 
	{
		return cartID;
	}
	public void setCartID(int custID) 
	{
		this.cartID = custID;
	}
	public int getFoodID() 
	{
		return foodID;
	}
	public void setFoodID(int foodID) 
	{
		this.foodID = foodID;
	}
	public int getFoodQuantity() 
	{
		return foodQuantity;
	}
	public void setFoodQuantity(int foodQuantity) 
	{
		this.foodQuantity = foodQuantity;
	}
	public double getFoodPrice() 
	{
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) 
	{
		this.foodPrice = foodPrice;
	}
	public double getTotalPrice() 
	{
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) 
	{
		this.totalPrice = totalPrice;
	}
	public String getCustEmailID() 
	{
		return custEmailID;
	}
	public void setCustEmailID(String custEmailID) 
	{
		this.custEmailID = custEmailID;
	}

	@Override
	public String toString() 
	{
		return "Cart [custID=" + cartID + ", foodID=" + foodID + ", foodQuantity=" + foodQuantity + ", foodPrice="
				+ foodPrice + ", totalPrice=" + totalPrice + ", custEmailID=" + custEmailID + "]";
	}
	
	
}
