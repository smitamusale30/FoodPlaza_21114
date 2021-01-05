package com.foodPlaza.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.foodPlaza.Pojo.Cart;
import com.foodPlaza.Pojo.Customer;
import com.foodPlaza.dao.CartDao_Impl;

public class Cart_Test 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Cart c=new Cart();
		CartDao_Impl cdi=new CartDao_Impl();
		
		int choice;
		do 
		{
			System.out.println("------------------Food Plaza------------------");
			System.out.println("\n");
			System.out.println("1.Add to Cart \n2.Delete Cart \n3.Clear Cart \n4.Show All Cart ");
			System.out.print("Please Enter your choice  : ");
			choice = sc.nextInt();
			switch (choice)
			{
			case 1:
				
				System.out.println("Enter Food ID: ");
				c.setFoodID(sc.nextInt());
				System.out.println("Enter Food Quanity: ");
				c.setFoodQuantity(sc.nextInt());
				System.out.println("Enter Customer EmailID: ");
				c.setCustEmailID(sc.next());
				
				if(cdi.addToCart(c))
				{
					System.out.println("Food Added to Cart successfully...");
				}
				else
				{
					System.err.println("Please try Again.....");
				}
			break;
			
			case 2:
				
				System.out.println("Enter CartID to Delete Cart");
				int CartID=sc.nextInt();
				
				if(cdi.deleteCart(CartID))
				{
					System.out.println("Cart Deleted successfully....");
				}
				else
				{
					System.err.println("Please try again........");
				}
				
			break;
			
			case 3:
				System.out.println("Enter Customer ID to Clear Cart: ");
				String custEmailID=sc.next();
				
				if(cdi.clearCart(custEmailID))
				{
					System.out.println("Cart Cleared Successfully......");
				}
				else
				{
					System.out.println("Please Try Again.......");
				}
			break;
				
			case 4:
				System.out.println("Enter Customer ID: ");
				custEmailID=sc.next();
				ArrayList<Cart> a=cdi.showAllCart(custEmailID);
				if(a!=null)
				{
					Iterator<Cart> i=a.iterator();
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
		}while(choice<=4 && choice >0);
	}
}
