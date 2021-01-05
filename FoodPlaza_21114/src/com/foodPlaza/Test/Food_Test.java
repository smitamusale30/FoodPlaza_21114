package com.foodPlaza.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;


import com.foodPlaza.Pojo.Food;
import com.foodPlaza.dao.FoodDao_Impl;

public class Food_Test 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		FoodDao_Impl fdi=new FoodDao_Impl();
		Food f=new Food();
		
		int choice;
		do 
		{
			System.out.println("------------------Food Plaza------------------");
			System.out.println("\n");
			System.out.println("1.Add Food \n2.Update Food \n3.Delete Food \n4.Search Food by Type \n5.Search Food by Name \n6.Search Food by Category \n7.Show All Food Details");
			System.out.print("Please Enter your choice  : ");
			choice = sc.nextInt();
			switch (choice)
			{
			case 1:
				
				System.out.println("Enter Food Name: ");
				f.setFoodName(sc.next());
				System.out.println("Enter Food Description: ");
				f.setFoodDescription(sc.next());
				System.out.println("Enter Food Category: ");
				f.setFoodCategory(sc.next());
				System.out.println("Enter Food Type: ");
				f.setFoodType(sc.next());
				System.out.println("Enter Food Price: ");
				f.setFoodPrice(sc.nextDouble());
				
				if(fdi.addFood(f))
		        {
		        	System.out.println("Food Added Successfully.......:)");
		        }
		        else
		        {
		        	System.out.println("Please Enter Correct information!!!!!!!!");
		        }
		        break;
		        
			case 2:
				System.out.println("Enter Food ID to update: ");
				f.setFoodID(sc.nextInt());
				System.out.println("Enter Food Name: ");
				f.setFoodName(sc.next());
				System.out.println("Enter Food Description: ");
				f.setFoodDescription(sc.next());
				System.out.println("Enter Food Category: ");
				f.setFoodCategory(sc.next());
				System.out.println("Enter Food Type: ");
				f.setFoodType(sc.next());
				System.out.println("Enter Food Price: ");
				f.setFoodPrice(sc.nextDouble());
				
				if(fdi.addFood(f))
		        {
		        	System.out.println("Food Dtails Updated Successfully.......:)");
		        }
		        else
		        {
		        	System.out.println("Please Enter Correct information!!!!!!!!");
		        }
		        break;
		     
			case 3:
				System.out.println("Enter FoodID to Delete details");
				int foodID=sc.nextInt();
				
				if(fdi.deleteFoodDetails(foodID))
				{
					System.out.println("Food Detail Deleted successfully....");
				}
				else
				{
					System.out.println("Please try again........");
				}
				
				break;
				
			case 4:
					System.out.println("Enter Food Type to Search: ");
					String foodType=sc.next();
					ArrayList<Food> a=fdi.searchByFoodType(foodType);
					if(a!=null)
					{
						ListIterator<Food> lc=a.listIterator();
						while(lc.hasNext())
						{
							System.out.println(lc.next());
						}
					}
					else
					{
						System.err.println("Try Again");
					}
				break;
			
			case 5:
					System.out.println("Enter Food Name to Search: ");
					String foodName=sc.next();
					ArrayList<Food> a1=new ArrayList<Food>();
					a1=fdi.searchByFoodName(foodName);
					if(a1!=null)
					{
						ListIterator<Food> lc=a1.listIterator();
						while(lc.hasNext())
						{
							System.out.println(lc.next());
						}
					}
					else
					{
						System.err.println("Try Again");
					}
				break;
			
			case 6:
				System.out.println("Enter Food Category to Search: ");
				String foodCategory=sc.next();
				ArrayList<Food> a2=fdi.searchByFoodCategory(foodCategory);
				if(a2!=null)
				{
					ListIterator<Food> lc=a2.listIterator();
					while(lc.hasNext())
					{
						System.out.println(lc.next());
					}
				}
				else
				{
					System.err.println("Try Again");
				}
			break;
				
			case 7:
				ArrayList<Food> a3=fdi.showAllFoodDetails();
				if(a3!=null)
				{
					Iterator<Food> i=a3.iterator();
					while(i.hasNext())
					{
						System.out.println(i.next());
					}
				}
				else
				{
					System.err.println("No data available");
				}
				
				
			break;
			}
		}while(choice<=7 && choice>0);
	}

}
