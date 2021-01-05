package com.foodPlaza.Test;

import java.util.Scanner;

import com.foodPlaza.dao.CustomerDao_Impl;
import com.foodPlaza.dao.LoginDao_Impl;

public class Login_Test 
{
	public static void main(String[] args) 
	{
		LoginDao_Impl login=new LoginDao_Impl();
		
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
			System.out.println("------------------Food Plaza------------------");
			System.out.println("1.Admin Login \n2.Customer Login \n3.Admin Change Password \n4.Customer Change Password \nEnter any key to exit..");
			System.out.println("Please Enter your choice  : ");
			choice = sc.nextInt();
			switch (choice)
			{
			case 1:
				System.out.println("Enter UserName and Password");
				String admEmailID=sc.next();
				String admPassword=sc.next();
			
				if(login.adminLogin(admEmailID, admPassword))
				{
					System.out.println("Admin Login Successfully......:)");
				}
				else
				{
					System.out.println("Please try again.....:(");
				}
				break;
				
			case 2:
				System.out.println("Enter UserName and Password");
				String custEmailID=sc.next();
				String custPassword=sc.next();
				
				if(login.customerLogin(custEmailID, custPassword))
				{
					System.out.println("Customer Login Successful......:)");
				}
				else
				{
					System.out.println("Please try again.....:(");
				}
				break;
			case 3:
				System.out.println("Re-Enter UserName and Password");
				String admEmailIDA=sc.next();
				String newAdmPassword=sc.next();
				
				if(login.changeAdminPassword(admEmailIDA, newAdmPassword))
				{
					System.out.println("Admin Password Changed......");
				}
				break;
			
			case 4:
				System.out.println("Re-Enter UserName and Password");
				String custEmailIDA=sc.next();
				String newCustPassword=sc.next();
				
				if(login.changeCustomerPassword(custEmailIDA, newCustPassword))
				{
					System.out.println("Customer Password Changed......");
				}
			}
		}while(choice<=4 && choice>0);
	}

}