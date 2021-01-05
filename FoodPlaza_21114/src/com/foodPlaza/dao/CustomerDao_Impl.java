package com.foodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.foodPlaza.Pojo.Customer;
import com.foodPlaza.Utility.DButility;

public class CustomerDao_Impl implements CustomerDao 
{

	@Override
	public boolean registerCustomer(Customer c) 
	{
		Connection con=DButility.getConnect();
		String query="insert into Customer_21114(custName,custEmailID,custAddress,custContactNo,custPassword) values(?,?,?,?,?)";
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			prp.setString(1,c.getCustName());
			prp.setString(2,c.getCustEmailID());
			prp.setString(3,c.getCustAddress());
			prp.setLong(4,c.getCustContactNo());
			prp.setString(5,c.getCustPassword());
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
			
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) 
	{
		Connection con=DButility.getConnect();
		String query="update Customer_21114 set custName=?,custAddress=?,custContactNo=?,custPassword=? where custEmailID=?";
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			prp.setString(1,c.getCustName());
			prp.setString(2,c.getCustAddress());
			prp.setLong(3,c.getCustContactNo());
			prp.setString(4,c.getCustPassword());
			prp.setString(5,c.getCustEmailID());
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
	public boolean deleteCustomer(String custEmailID) 
	{
		Connection con=DButility.getConnect();
		String query="delete from Customer_21114 where custEmailID=?";
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			prp.setString(1, custEmailID);
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
	public Customer searchCustomer(String custEmailID) 
	{
		Connection con=DButility.getConnect();
		String query="select custName,custAddress,custContactNo,custPassword,custEmailID from Customer_21114 where custEmailID=?";
		Customer c=new Customer();
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			prp.setString(1, custEmailID);
			ResultSet r=prp.executeQuery();
			
			while(r.next())
			{
				c.setCustName(r.getString(1));
				c.setCustAddress(r.getString(2));
				c.setCustContactNo(r.getLong(3));
				c.setCustPassword(r.getString(4));
				c.setCustEmailID(r.getString(5));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public ArrayList<Customer> ShowAllCustomer() 
	{
		Connection con=DButility.getConnect();
		String query="select custEmailID,custName,custAddress,custContactNo,custPassword from Customer_21114";
		ArrayList<Customer> l=new ArrayList<Customer>();
		
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			ResultSet r=prp.executeQuery();
			
			while(r.next())
			{
				Customer c=new Customer();
				c.setCustEmailID(r.getString(1));
				c.setCustName(r.getString(2));
				c.setCustAddress(r.getString(3));
				c.setCustContactNo(r.getLong(4));
				c.setCustPassword(r.getString(5));
				l.add(c);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return l;
	}

}
