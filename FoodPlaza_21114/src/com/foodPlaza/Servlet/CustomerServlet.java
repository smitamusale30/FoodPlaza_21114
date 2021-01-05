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

import com.foodPlaza.Pojo.Customer;
import com.foodPlaza.Pojo.Food;
import com.foodPlaza.dao.CartDao_Impl;
import com.foodPlaza.dao.CustomerDao_Impl;
import com.foodPlaza.dao.FoodDao_Impl;
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet
{
	CustomerDao_Impl cdi=new CustomerDao_Impl();
	CartDao_Impl cd=new CartDao_Impl();
	Customer c=new Customer();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession s=req.getSession();
		String choice=req.getParameter("choice");
		if (choice != null && choice.equals("delete")) 
		{
			String custEmailID = req.getParameter("custEmailID");
			boolean flag = cd.clearCart(custEmailID);
			if (flag)
			{
				flag = cdi.deleteCustomer(custEmailID);
				if (flag) 
				{
					s.invalidate();
					resp.sendRedirect("index.jsp");
				} 
				else
				{
					resp.sendRedirect("Retry.jsp");
				}
			} 
			else
			{
				flag = cdi.deleteCustomer(custEmailID);
				if (flag) 
				{
					s.invalidate();
					resp.sendRedirect("index.jsp");
				} 
				else
				{
					resp.sendRedirect("Retry.jsp");
				}
			}
		}		
		else if (choice!=null && choice.equals("update"))
		{
			String custEmailID=req.getParameter("custEmailID");
			c=cdi.searchCustomer(custEmailID);
		    s=req.getSession();
			s.setAttribute("cdetails",c);
			resp.sendRedirect("UpdateCustomer.jsp");
		}
		else 
		{
			s = req.getSession();
			ArrayList<Customer> c = cdi.ShowAllCustomer();
			s.setAttribute("showAllCustomer", c);
			resp.sendRedirect("CustomerList.jsp");
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String choice=req.getParameter("choice");
		String custName,custEmailID,custAddress,custPassword;
		long custContactNo;
		Customer c=new Customer();
		PrintWriter p=resp.getWriter();
		CustomerDao_Impl cdi= new CustomerDao_Impl();
		if(choice.equals("addCustomer"))
		{
			custName=req.getParameter("cname");
			custEmailID=req.getParameter("uname");
			custAddress=req.getParameter("add");
			custPassword=req.getParameter("upass");
			custContactNo=Long.parseLong(req.getParameter("contactno"));
			
			c.setCustName(custName);
			c.setCustEmailID(custEmailID);
			c.setCustAddress(custAddress);
			c.setCustPassword(custPassword);
			c.setCustContactNo(custContactNo);
			
			boolean flag=cdi.registerCustomer(c);
	    	if(flag)
	    	{
	    		resp.sendRedirect("Successfull.jsp");
	    	}
	    	else
	    	{
	    		resp.sendRedirect("Retry.jsp");
	    	}
		}
		else if (choice.equals("updateCustomer")) 
		{
			custName=req.getParameter("cname");
			custEmailID=req.getParameter("uname");
			custAddress=req.getParameter("add");
			custPassword=req.getParameter("upass");
			custContactNo=Long.parseLong(req.getParameter("contactno"));
			
			c.setCustName(custName);
			c.setCustEmailID(custEmailID);
			c.setCustAddress(custAddress);
			c.setCustPassword(custPassword);
			c.setCustContactNo(custContactNo);
			
			boolean flag=cdi.updateCustomer(c);
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
}
