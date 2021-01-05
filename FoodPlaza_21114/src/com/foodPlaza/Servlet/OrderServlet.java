package com.foodPlaza.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodPlaza.Pojo.Order;
import com.foodPlaza.dao.CartDao_Impl;
import com.foodPlaza.dao.OrderDao_Impl;
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		OrderDao_Impl odi=new OrderDao_Impl();
		CartDao_Impl cdi=new CartDao_Impl();
		Order o=new Order();
		int orderID=0;
		double totalPrice=0.0;
		HttpSession h=req.getSession();
		String custEmailID=(String)h.getAttribute("cname");
		boolean flag=odi.placeOrder(custEmailID);
		if(flag)
		{
			cdi.clearCart(custEmailID);
			ArrayList<Order> l=odi.showAllOrder(custEmailID);
			for (Order order : l)
			{
				orderID=order.getOrderID();
				totalPrice=order.getTotalPrice();
			}
			RequestDispatcher r=req.getRequestDispatcher("PlaceOrder.jsp");
			req.setAttribute("OID",orderID);
			req.setAttribute("TP", totalPrice);
			r.forward(req, resp);
			//resp.sendRedirect("PlaceOrder.jsp");
		}
		else
		{
			resp.sendRedirect("Retry.jsp");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		OrderDao_Impl odi=new OrderDao_Impl();
		HttpSession hs=req.getSession();
		String custEmailID=(String)hs.getAttribute("cname");
		String adminEmailID=(String)hs.getAttribute("aname");
		
		if(custEmailID!=null && adminEmailID==null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("Order.jsp");
			ArrayList<Order> l=odi.showAllOrder(custEmailID);
			req.setAttribute("ShowOrder",l);
			rd.forward(req, resp);
		}
		else if(custEmailID==null && adminEmailID!=null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("Order.jsp");
			ArrayList<Order> l=odi.showAllOrder();
			req.setAttribute("ShowOrder",l);
			rd.forward(req, resp);
		}
	}
}
