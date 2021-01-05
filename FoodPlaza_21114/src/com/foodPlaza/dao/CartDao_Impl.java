package com.foodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.foodPlaza.Pojo.Cart;
import com.foodPlaza.Utility.DButility;

public class CartDao_Impl implements CartDao
{

	@Override
	public boolean addToCart(Cart cr) 
	{
		Connection con=DButility.getConnect();
		String query1="select foodPrice from Food_21114 where foodID=?";
		String query="insert into Cart_21114(foodID,foodQuantity,foodPrice,totalPrice,custEmailID) values(?,?,?,?,?)";
		try
		{
			PreparedStatement prp1=con.prepareStatement(query1);
			prp1.setInt(1, cr.getFoodID());
			double fPrice=0;
			ResultSet r=prp1.executeQuery();
			if(r.next())
			{
				fPrice=r.getDouble(1);
			}
			double tp=fPrice*cr.getFoodQuantity();
			
			PreparedStatement prp=con.prepareStatement(query);
			prp.setInt(1, cr.getFoodID());
			prp.setInt(2, cr.getFoodQuantity());
			prp.setDouble(3, fPrice);
			prp.setDouble(4, tp);
			prp.setString(5, cr.getCustEmailID());
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
	public boolean deleteCart(int CartID) 
	{
		Connection con=DButility.getConnect();
		String query="delete from Cart_21114 where CartID=?";
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			prp.setInt(1, CartID);
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
	public boolean clearCart(String custEmailID)
	{
		Connection con=DButility.getConnect();
		String query="delete from Cart_21114 where custEmailID=?";
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
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

//	@Override
//	public boolean updateCart(Cart cr) 
//	{
//		Connection con=DButility.getConnect();
//		String query="update Cart_21114 set foodID=?,foodQuantity=?,foodPrice=?,totalPrice=?,custEmailID=? where cartID=?";
//		try
//		{
//			PreparedStatement prp=con.prepareStatement(query);
//			prp.setInt(1, cr.getFoodID());
//			prp.setInt(2, cr.getFoodQuantity());
//			prp.setDouble(3, cr.getFoodPrice());
//			prp.setDouble(4, cr.getTotalPrice());
//			prp.setString(5, cr.getCustEmailID());
//			prp.setInt(6, cr.getCartID());
//			int i=prp.executeUpdate();
//			if(i>0)
//			{
//				return true;
//			}
//			else
//			{
//				return false;
//			}
//			
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//		return false;
//	}

	@Override
	public ArrayList<Cart> showAllCart(String custEmailID) 
	{
		Connection con=DButility.getConnect();
		String query="select cartID,foodID,foodQuantity,foodPrice,totalPrice,custEmailID from Cart_21114 where custEmailID=?";
		ArrayList<Cart> l=new ArrayList<Cart>();
		
		try
		{
			PreparedStatement prp=con.prepareStatement(query);
			prp.setString(1,custEmailID);;
			ResultSet r=prp.executeQuery();
			
			
			while(r.next())
			{
				Cart cr=new Cart();
				cr.setCartID(r.getInt(1));
				cr.setFoodID(r.getInt(2));
				cr.setFoodQuantity(r.getInt(3));
				cr.setFoodPrice(r.getDouble(4));
				cr.setTotalPrice(r.getDouble(5));
				cr.setCustEmailID(r.getString(6));
				l.add(cr);
			}
			return l;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	

}
