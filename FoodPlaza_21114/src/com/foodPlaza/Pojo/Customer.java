package com.foodPlaza.Pojo;

public class Customer 
{
	private String custName;
	private String custEmailID;
	private String custAddress;
	private long custContactNo;
	private String custPassword;
	
	public Customer()
	{
		
	}
	
	public Customer(String custName, String custEmailID, String custAddress, long custContactNo, String custPassword) 
	{
		this.custName = custName;
		this.custEmailID = custEmailID;
		this.custAddress = custAddress;
		this.custContactNo = custContactNo;
		this.custPassword = custPassword;
	}

	public String getCustName() 
	{
		return custName;
	}
	public void setCustName(String custName) 
	{
		this.custName = custName;
	}
	public String getCustEmailID() 
	{
		return custEmailID;
	}
	public void setCustEmailID(String custEmailID) 
	{
		this.custEmailID = custEmailID;
	}
	public String getCustAddress() 
	{
		return custAddress;
	}
	public void setCustAddress(String custAddress) 
	{
		this.custAddress = custAddress;
	}
	public long getCustContactNo() 
	{
		return custContactNo;
	}
	public void setCustContactNo(long custContactNo)
	{
		this.custContactNo = custContactNo;
	}
	public String getCustPassword() 
	{
		return custPassword;
	}
	public void setCustPassword(String custPassword) 
	{
		this.custPassword = custPassword;
	}

	@Override
	public String toString() 
	{
		return "Customer [custName=" + custName + ", custEmailID=" + custEmailID + ", custAddress=" + custAddress
				+ ", custContactNo=" + custContactNo + ", custPassword=" + custPassword + "]";
	}
	
}
