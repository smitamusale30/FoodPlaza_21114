package com.foodPlaza.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodPlaza.Pojo.Food;
import com.foodPlaza.dao.FoodDao_Impl;

@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	Food f = new Food();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		FoodDao_Impl fdi = new FoodDao_Impl();
		String choice=req.getParameter("choice");
		if(choice!=null && choice.equals("delete"))
		{
			int fid=Integer.parseInt(req.getParameter("fid"));
			boolean flag=fdi.deleteFoodDetails(fid);
			if (flag)
			{
				HttpSession s = req.getSession();
				ArrayList<Food> f = fdi.showAllFoodDetails();
				s.setAttribute("showAll", f);
				resp.sendRedirect("FoodList.jsp");
			} 
			else 
			{
				resp.sendRedirect("Retry.jsp");
			}
		}
		else if (choice!=null && choice.equals("update"))
		{
			String fname=req.getParameter("fname");
			ArrayList<Food> f=fdi.searchByFoodName(fname);
			HttpSession s=req.getSession();
			s.setAttribute("fdetails",f);
			resp.sendRedirect("UpdateFood.jsp");
		}
		else 
		{
		HttpSession s = req.getSession();
		ArrayList<Food> f = fdi.showAllFoodDetails();
		s.setAttribute("showAll", f);
		resp.sendRedirect("FoodList.jsp");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String choice = req.getParameter("choice");
		String fname, ftype, fcategory, fdescription;
		Double fprice;
		int fid;
		PrintWriter p = resp.getWriter();
		FoodDao_Impl fi = new FoodDao_Impl();
		if (choice.equals("addfood")) {

			fname = req.getParameter("fname");
			ftype = req.getParameter("ftype");
			fcategory = req.getParameter("fcategory");
			fdescription = req.getParameter("fdescription");
			fprice = Double.parseDouble(req.getParameter("fprice"));

			f.setFoodName(fname);
			f.setFoodCategory(fcategory);
			f.setFoodDescription(fdescription);
			f.setFoodPrice(fprice);
			f.setFoodType(ftype);

			boolean flag = fi.addFood(f);
			if (flag) {
				resp.sendRedirect("Successfull.jsp");
			} else {
				resp.sendRedirect("Retry.jsp");
			}
		} else if (choice.equals("updatefood")) {
			fid = Integer.parseInt(req.getParameter("fid"));
			fname = req.getParameter("fname");
			ftype = req.getParameter("ftype");
			fcategory = req.getParameter("fcategory");
			fdescription = req.getParameter("fdescription");
			fprice = Double.parseDouble(req.getParameter("fprice"));
			f.setFoodID(fid);
			f.setFoodName(fname);
			f.setFoodCategory(fcategory);
			f.setFoodDescription(fdescription);
			f.setFoodPrice(fprice);
			f.setFoodType(ftype);

			boolean flag = fi.updateFoodDetails(f);
			if (flag) {
				resp.sendRedirect("Successfull.jsp");
			} else {
				resp.sendRedirect("Retry.jsp");
			}

		}

	}
}
