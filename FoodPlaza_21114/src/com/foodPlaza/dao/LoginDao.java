package com.foodPlaza.dao;

public interface LoginDao 
{
	boolean adminLogin(String admEmailID,String admPassword);
	boolean customerLogin(String custEmailID,String custPassword);
	
	boolean changeAdminPassword(String admEmailID,String newAdmPassword);
	boolean changeCustomerPassword(String custEmailID,String newCustPassword);
}
