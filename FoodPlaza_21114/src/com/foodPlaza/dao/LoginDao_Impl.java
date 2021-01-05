package com.foodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foodPlaza.Utility.DButility;

public class LoginDao_Impl implements LoginDao 
{

	@Override
	public boolean adminLogin(String admEmailID, String admPassword) 
	{
		Connection con=DButility.getConnect();
		String query="Select admPassword from Admin_21114 where admEmailID=?";
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			prp.setString(1, admEmailID);
			ResultSet r=prp.executeQuery();
			String pass="";
			while(r.next())
			{
				pass=r.getString(1);
			}
			if(pass.equals(admPassword))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean customerLogin(String custEmailID, String custPassword) 
	{
		Connection con=DButility.getConnect();
		String query="select custPassword from Customer_21114 where custEmailID=?";
		try
		{
		PreparedStatement prp=con.prepareStatement(query);
		prp.setString(1, custEmailID);
		ResultSet r=prp.executeQuery();
		String passC="";
		while(r.next())
		{
			passC=r.getString(1);
		}
		if(passC.equals(custPassword))
		{
			return true;
		}
		else
		{
			return false;
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changeAdminPassword(String admEmailID, String newAdmPassword) 
	{
		Connection con=DButility.getConnect();
		String query="update Admin_21114 set admP"
				+ "assword=? where admEmailID=?";
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			prp.setString(1,newAdmPassword);
			prp.setString(2, admEmailID);
			int i=prp.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changeCustomerPassword(String custEmailID, String newCustPassword) 
	{
		Connection con=DButility.getConnect();
		String query="update Customer_21114 set custPassword=? where custEmailID=?";
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			prp.setString(1,newCustPassword);
			prp.setString(2,custEmailID);
			int i=prp.executeUpdate();
	
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}

