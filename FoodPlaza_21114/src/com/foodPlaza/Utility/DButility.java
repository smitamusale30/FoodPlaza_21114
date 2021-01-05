package com.foodPlaza.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButility 
{
	public static Connection getConnect()
	{
		Connection con=null;
		try 
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodPlaza_21115","root","root");
		}
		catch(ClassNotFoundException | SQLException e)
		{	}
		return con;
	}
	
	public static void main(String[] args) 
	{
		if(getConnect()!=null)
		{
			System.out.println("Connection succeed......");
		}
		else
		{
			System.out.println("Try Again ");
		}
		getConnect();
	}
}
