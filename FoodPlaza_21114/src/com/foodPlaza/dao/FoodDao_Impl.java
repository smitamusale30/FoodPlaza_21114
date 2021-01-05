package com.foodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.foodPlaza.Pojo.Customer;
import com.foodPlaza.Pojo.Food;
import com.foodPlaza.Utility.DButility;

public class FoodDao_Impl implements FoodDao {

	@Override
	public boolean addFood(Food f) {
		Connection con = DButility.getConnect();
		String query = "insert into Food_21114(foodName,foodDescription,foodCategory,foodType,foodPrice) values(?,?,?,?,?)";
		try {
			PreparedStatement prp = con.prepareStatement(query);
			prp.setString(1, f.getFoodName());
			prp.setString(2, f.getFoodDescription());
			prp.setString(3, f.getFoodCategory());
			prp.setString(4, f.getFoodType());
			prp.setDouble(5, f.getFoodPrice());

			int i = prp.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {

		}

		return false;
	}

	@Override
	public boolean deleteFoodDetails(int foodID) {
		Connection con = DButility.getConnect();
		String query = "delete from Food_21114 where foodID=?";
		try {
			PreparedStatement prp = con.prepareStatement(query);
			prp.setInt(1, foodID);
			int i = prp.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateFoodDetails(Food f) {
		Connection con = DButility.getConnect();
		String query = "update Food_21114 set foodName=?,foodDescription=?,foodCategory=?,foodType=?,foodPrice=? where foodID=?";
		try {
			PreparedStatement prp = con.prepareStatement(query);
			prp.setString(1, f.getFoodName());
			prp.setString(2, f.getFoodDescription());
			prp.setString(3, f.getFoodCategory());
			prp.setString(4, f.getFoodType());
			prp.setDouble(5, f.getFoodPrice());
			prp.setInt(6, f.getFoodID());
			int i = prp.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Food> searchByFoodType(String foodType) {
		Connection con = DButility.getConnect();
		String query = "select foodName,foodDescription,foodCategory,foodType,foodPrice,foodID from Food_21114 where foodType=?";
		ArrayList<Food> l = new ArrayList<Food>();
		try {
			PreparedStatement prp = con.prepareStatement(query);
			prp.setString(1, foodType);
			ResultSet r = prp.executeQuery();
			while (r.next()) {
				Food f = new Food();
				f.setFoodName(r.getString(1));
				f.setFoodDescription(r.getString(2));
				f.setFoodCategory(r.getString(3));
				f.setFoodType(r.getString(4));
				f.setFoodPrice(r.getDouble(5));
				f.setFoodID(r.getInt(6));
				l.add(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public ArrayList<Food> searchByFoodName(String foodName) {
		Connection con = DButility.getConnect();
		String query = "select foodName,foodDescription,foodCategory,foodType,foodPrice,foodID from Food_21114 where foodName=?";
		ArrayList<Food> l = new ArrayList<Food>();

		try {
			PreparedStatement prp = con.prepareStatement(query);
			prp.setString(1, foodName);
			ResultSet r = prp.executeQuery();

			while (r.next()) {
				Food f = new Food();
				f.setFoodName(r.getString(1));
				f.setFoodDescription(r.getString(2));
				f.setFoodCategory(r.getString(3));
				f.setFoodType(r.getString(4));
				f.setFoodPrice(r.getDouble(5));
				f.setFoodID(r.getInt(6));
				l.add(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public ArrayList<Food> searchByFoodCategory(String foodCategory) {
		Connection con = DButility.getConnect();
		String query = "select foodName,foodDescription,foodCategory,foodType,foodPrice,foodID from Food_21114 where foodCategory=?";
		ArrayList<Food> l = new ArrayList<Food>();

		try {
			PreparedStatement prp = con.prepareStatement(query);
			prp.setString(1, foodCategory);
			ResultSet r = prp.executeQuery();

			while (r.next()) {
				Food f = new Food();
				f.setFoodName(r.getString(1));
				f.setFoodDescription(r.getString(2));
				f.setFoodCategory(r.getString(3));
				f.setFoodType(r.getString(4));
				f.setFoodPrice(r.getDouble(5));
				f.setFoodID(r.getInt(6));

				l.add(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public ArrayList<Food> showAllFoodDetails() {
		Connection con = DButility.getConnect();
		String query = "select foodName,foodDescription,foodCategory,foodType,foodPrice,foodID from Food_21114";
		ArrayList<Food> l = new ArrayList<Food>();

		try {
			PreparedStatement prp = con.prepareStatement(query);
			ResultSet r = prp.executeQuery();

			while (r.next()) {
				Food f = new Food();
				f.setFoodName(r.getString(1));
				f.setFoodDescription(r.getString(2));
				f.setFoodCategory(r.getString(3));
				f.setFoodType(r.getString(4));
				f.setFoodPrice(r.getDouble(5));
				f.setFoodID(r.getInt(6));
				l.add(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

}
