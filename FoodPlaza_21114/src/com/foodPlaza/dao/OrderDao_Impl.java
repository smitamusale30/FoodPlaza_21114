package com.foodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.foodPlaza.Pojo.Order;
import com.foodPlaza.Utility.DButility;

public class OrderDao_Impl implements OrderDao
{

	@Override
	public boolean placeOrder(String custEmailID) 
	{
		Connection con=DButility.getConnect();
		
		String query="select sum(totalPrice) as FinalPrice from Cart_21114 where custEmailID=?";
		String queryadd="select custAddress from Customer_21114 where custEmailID=?";
		String insertQuery="insert into Order_21114 (custAddress,totalPrice,custEmailID,orderDate) values(?,?,?,?)";
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			prp.setString(1, custEmailID);
			ResultSet r=prp.executeQuery();
			double tPrice=0;
			if(r.next())
			{
				tPrice=r.getDouble("FinalPrice");
			}
			String date=new Date().toString();
			PreparedStatement prp2=con.prepareStatement(queryadd);
			prp2.setString(1, custEmailID);
			String add="";
			ResultSet r2=prp2.executeQuery();
			if(r2.next())
			{
				add=r2.getString(1);
			}
			PreparedStatement prp1=con.prepareStatement(insertQuery);
			prp1.setString(1, add);
			prp1.setDouble(2,tPrice);
			prp1.setString(3, custEmailID);
			prp1.setString(4, date);
			int i=prp1.executeUpdate();
			if(i>0)
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
	public boolean deleteOrder(int orderID) 
	{
		Connection con=DButility.getConnect();
		String query="delete from Order_21114 where orderID=?";
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			prp.setInt(1, orderID);
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
	public boolean clearOrder(String custEmailID) 
	{
		Connection con=DButility.getConnect();
		String query="delete from Order_21114 where custEmailID=?";
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
	public ArrayList<Order> showAllOrder() 
	{
		Connection con=DButility.getConnect();
		String query="select orderID,custAddress,totalPrice,custEmailID,orderDate from Order_21114";
		ArrayList<Order> l=new ArrayList<Order>();
		
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			ResultSet r=prp.executeQuery();
			
			while(r.next())
			{
				Order o=new Order();
				o.setOrderID(r.getInt(1));
				o.setCustAddress(r.getString(2));
				o.setTotalPrice(r.getDouble(3));
				o.setCustEmailID(r.getString(4));
				o.setOrderDate(r.getString(5));
				l.add(o);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return l;
	}
	public ArrayList<Order> showAllOrder(String custEmailID) 
	{
		Connection con=DButility.getConnect();
		String query="select orderID,custAddress,totalPrice,custEmailID,orderDate from Order_21114 where custEmailID=?";
		ArrayList<Order> l=new ArrayList<Order>();
		
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			prp.setString(1, custEmailID);
			ResultSet r=prp.executeQuery();
			
			while(r.next())
			{
				Order o=new Order();
				o.setOrderID(r.getInt(1));
				o.setCustAddress(r.getString(2));
				o.setTotalPrice(r.getDouble(3));
				o.setCustEmailID(r.getString(4));
				o.setOrderDate(r.getString(5));
				l.add(o);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return l;
	}

}
