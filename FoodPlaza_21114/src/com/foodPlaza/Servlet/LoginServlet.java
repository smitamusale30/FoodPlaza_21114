package com.foodPlaza.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodPlaza.Pojo.Admin;
import com.foodPlaza.Pojo.Customer;
import com.foodPlaza.dao.CustomerDao_Impl;
import com.foodPlaza.dao.LoginDao_Impl;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession s=req.getSession();
		s.invalidate();
		resp.sendRedirect("Logout.jsp");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String choice=req.getParameter("choice");
		String admEmailID,admPassword,custEmailID,custPassword,newAdmPassword,newCustPassword;
		String opt=req.getParameter("selectOpt");
		Admin a=new Admin();
		Customer c=new Customer();
		PrintWriter p=resp.getWriter();
		LoginDao_Impl ldi=new LoginDao_Impl();
		HttpSession s;
		if(choice!=null && choice.equals("login"))
		{
			if(opt.equals("Administrator"))
			{
				admEmailID=req.getParameter("aName");
				admPassword=req.getParameter("aPass");
				a.setAdmEmailID(admEmailID);
				a.setAdmPassword(admPassword);
				
				boolean flag=ldi.adminLogin(admEmailID, admPassword);
		    	if(flag)
		    	{
		    		s=req.getSession();
		    		s.setAttribute("aname", admEmailID);
		    		resp.sendRedirect("index.jsp");
		    	}
		    	else
		    	{
		    		resp.sendRedirect("Retry.jsp");
		    	}
			}
			else if(opt.equals("Customer"))
			{
				custEmailID=req.getParameter("aName");
				custPassword=req.getParameter("aPass");
				c.setCustEmailID(custEmailID);
				c.setCustPassword(custPassword);
					
				boolean flag=ldi.customerLogin(custEmailID, custPassword);
			    if(flag)
			    {
		    		s=req.getSession();
		    		s.setAttribute("cname",custEmailID);
		    		resp.sendRedirect("index.jsp");
			    }
			    else
			    {
			    	resp.sendRedirect("Retry.jsp");
			    }
			
			}
		}
		else if(choice!=null && choice.equals("changePassword"))
		{
			if(opt.equals("Administrator"))
			{
				admEmailID=req.getParameter("aName");
				admPassword=req.getParameter("aPass");
				newAdmPassword=req.getParameter("nPass");
				a.setAdmEmailID(admEmailID);
				a.setAdmPassword(newAdmPassword);
				
				boolean flag=ldi.changeAdminPassword(admEmailID, newAdmPassword);
		    	if(flag)
		    	{
		    		resp.sendRedirect("Successfull.jsp");
		    	}
		    	else
		    	{
		    		resp.sendRedirect("Retry.jsp");
		    	}
			}
			else if(opt.equals("Customer"))
			{
				custEmailID=req.getParameter("aName");
				custPassword=req.getParameter("aPass");
				newCustPassword=req.getParameter("nPass");
				c.setCustEmailID(custEmailID);
				c.setCustPassword(newCustPassword);
					
				boolean flag=ldi.changeCustomerPassword(custEmailID, newCustPassword);
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
	
}
