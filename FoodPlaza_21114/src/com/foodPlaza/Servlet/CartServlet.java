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

import com.foodPlaza.Pojo.Cart;
import com.foodPlaza.Pojo.Food;
import com.foodPlaza.dao.CartDao_Impl;
import com.foodPlaza.dao.FoodDao_Impl;
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet
{
	Cart c=new Cart();
	CartDao_Impl cdi=new CartDao_Impl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String choice=req.getParameter("choice");
		if(choice!=null && choice.equals("delete"))
		{
			int CartID=Integer.parseInt(req.getParameter("CartID"));
			boolean flag=cdi.deleteCart(CartID);
			if (flag)
			{
				resp.sendRedirect("CartList.jsp");
			} 
			else 
			{
				resp.sendRedirect("Retry.jsp");
			}
		}
		else if(choice!=null && choice.equals("clear"))
		{
			String custEmailID=req.getParameter("choice");
			boolean flag=cdi.clearCart(custEmailID);
			if (flag)
			{
				HttpSession s = req.getSession();
				ArrayList<Cart> c = cdi.showAllCart(custEmailID);
				s.setAttribute("showAllCart", c);
				resp.sendRedirect("CartList.jsp");
			} 
			else 
			{
				resp.sendRedirect("Retry.jsp");
			}
		}
		else if (choice!=null && choice.equals("addtocart"))
		{
			Food f=new Food();
			FoodDao_Impl fdi=new FoodDao_Impl();
			String fname=req.getParameter("fname");
		    ArrayList<Food> c=fdi.searchByFoodName(fname);
			HttpSession s=req.getSession();
			s.setAttribute("cartdetails",c);
			resp.sendRedirect("AddToCart.jsp");
		}
		else
		{
			HttpSession s = req.getSession();
			String custEmailID=(String)s.getAttribute("cname");
			ArrayList<Cart> c = cdi.showAllCart(custEmailID);
			s.setAttribute("showAllCart", c);
			resp.sendRedirect("CartList.jsp");
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int foodID,foodQuantity;
		String custEmailID; 
		double foodPrice;
		
		Cart c =new Cart();
		CartDao_Impl cdi=new CartDao_Impl();
		PrintWriter p=resp.getWriter();
		
		foodID=Integer.parseInt(req.getParameter("fid"));
		foodQuantity=Integer.parseInt(req.getParameter("fq"));
		custEmailID=req.getParameter("custid");
		foodPrice=Double.parseDouble(req.getParameter("fprice"));
		//totalPrice=Double.parseDouble(req.getParameter("ftprice"));
		
		c.setFoodID(foodID);
		c.setFoodQuantity(foodQuantity);
		c.setCustEmailID(custEmailID);
		c.setFoodPrice(foodPrice);
		//c.setTotalPrice(totalPrice);
		
		boolean flag=cdi.addToCart(c);
    	if(flag)
    	{
    		resp.sendRedirect("Successfull.jsp");
    	}
    	else
    	{
    		resp.sendRedirect("Retry.jsp");
    	}	
	}	
}
