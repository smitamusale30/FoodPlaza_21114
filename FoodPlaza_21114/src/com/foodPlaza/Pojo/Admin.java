package com.foodPlaza.Pojo;

public class Admin 
{
	private String admEmailID;
	private String admPassword;
	
	public Admin()
	{	}
	
	public Admin(String admEmailID, String admPassword)
	{
		this.admEmailID = admEmailID;
		this.admPassword = admPassword;
	}

	public String getAdmEmailID() 
	{
		return admEmailID;
	}
	public void setAdmEmailID(String admEmailID) 
	{
		this.admEmailID = admEmailID;
	}
	public String getAdmPassword() 
	{
		return admPassword;
	}
	public void setAdmPassword(String admPassword) 
	{
		this.admPassword = admPassword;
	}

	@Override
	public String toString() 
	{
		return "Admin [admEmailID=" + admEmailID + ", admPassword=" + admPassword + "]";
	}
	
	
}
