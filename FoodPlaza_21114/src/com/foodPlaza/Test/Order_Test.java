package com.foodPlaza.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import com.foodPlaza.Pojo.Order;
import com.foodPlaza.dao.OrderDao_Impl;

public class Order_Test 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Order o=new Order();
		OrderDao_Impl odi=new OrderDao_Impl();
		
		int choice;
		do 
		{
			System.out.println("------------------Food Plaza------------------");
			System.out.println("\n");
			System.out.println("1.Place Order \n2.Cancle/Delete Order \n3.Clear Order \n4.Show All Order Details");
			System.out.print("Please Enter your choice  : ");
			choice = sc.nextInt();
			switch (choice)
			{
			case 1:
				System.out.println("Enter your EmailID: ");
				String custEmailID=sc.next();
				System.out.println("Enter your Address: ");
				o.setCustAddress(sc.next());
				
				if(odi.placeOrder(custEmailID))
				{
					System.out.println("Order placed successfully...");
				}
				else
				{
					System.err.println("Please try Again.....");
				}
				break;
				
			case 2:
				System.out.println("Enter Order ID to cancle Order: ");
				int orderID=sc.nextInt();
				if(odi.deleteOrder(orderID))
				{
					System.out.println("Order Cancled successfully.....");
				}
				else
				{
					System.err.println("Please try Again....");
				}
				break;
			case 3:
				System.out.println("Enter Customer ID to Clear Order Details: ");
				custEmailID=sc.next();
				
				if(odi.clearOrder(custEmailID))
				{
					System.out.println("Order Details Cleared Successfully......");
				}
				else
				{
					System.err.println("Please Try Again.......");
				}
				break;
				
			case 4:
				ArrayList<Order> a=odi.showAllOrder();
				if(a!=null)
				{
					Iterator<Order> i=a.iterator();
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
		}while(choice<=4 && choice>0);
	}
}
