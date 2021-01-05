package com.foodPlaza.dao;

import java.util.ArrayList;

import com.foodPlaza.Pojo.Customer;

public interface CustomerDao 
{
	boolean registerCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean deleteCustomer(String custEmailID);
	Customer searchCustomer(String custEmailID);
	ArrayList<Customer> ShowAllCustomer();
}
