package com.foodPlaza.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import com.foodPlaza.Pojo.Customer;
import com.foodPlaza.dao.CustomerDao_Impl;

public class Customer_Test 
{
	public static void main(String[] args) 
	{
		CustomerDao_Impl cust=new CustomerDao_Impl();
		Customer c=new Customer();
		Scanner sc=new Scanner(System.in);
		
		int choice;
		do 
		{
			System.out.println("------------------Food Plaza------------------");
			System.out.println("\n");
			System.out.println("1.Register Customer \n2.Update Customer \n3.Delete Customer \n4.Search Customer \n5.Show All customer Details");
			System.out.print("Please Enter your choice  : ");
			choice = sc.nextInt();
			switch (choice)
			{
			case 1:
				
				System.out.println("Enter your Name: ");
				c.setCustName(sc.next());
				System.out.println("Enter your MailID: ");
				c.setCustEmailID(sc.next());
				System.out.println("Enter Your Address: ");
				c.setCustAddress(sc.next());
		        System.out.println("Enter your Contact Number: ");
		        c.setCustContactNo(sc.nextLong());
		        System.out.println("Enter your Password: ");
		        c.setCustPassword(sc.next());
		        
		        if(cust.registerCustomer(c))
		        {
		        	System.out.println("Registration done Successfully.......:)");
		        }
		        else
		        {
		        	System.err.println("Please Enter Correct information!!!!!!!!");
		        }
		        break;
		        
			case 2:
				System.out.println("Enter your Existing MailID: ");
				c.setCustEmailID(sc.next());
				System.out.println("Enter your Name: ");
				c.setCustName(sc.next());
				System.out.println("Enter Your Address: ");
				c.setCustAddress(sc.next());
		        System.out.println("Enter your Contact Number: ");
		        c.setCustContactNo(sc.nextLong());
		        System.out.println("Enter your Password: ");
		        c.setCustPassword(sc.next());
		        
		        if(cust.updateCustomer(c))
		        {
		        	System.out.println("Updation done Successfully.......:)");
		        }
		        else
		        {
		        	System.err.println("Please Enter Correct information!!!!!!!!");
		        }
		        break;
		        
			case 3:
				System.out.println("Enter Your EmailID to Delete details");
				String custEmailID=sc.next();
				
				if(cust.deleteCustomer(custEmailID))
				{
					System.out.println("Customer Detail Deleted successfully....");
				}
				else
				{
					System.err.println("Please try again........");
				}
				
				break;
				
			case 4:
				System.out.println("Enter your EmailID to Search details");
				c=cust.searchCustomer(sc.next());
				if(c!=null)
				{
				System.out.println(c);
				}
				else
				{
					System.err.println("Try Again");
				}
				break;
				
			case 5:
				ArrayList<Customer> a=cust.ShowAllCustomer();
				if(a!=null)
				{
					Iterator<Customer> i=a.iterator();
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
		}while(choice<=5 && choice>0);
	}
}
