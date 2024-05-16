package BillingSystem_Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import BillingSystem_Model.CustomerDB;

public class Customer {

	private int id;
	private String name;
	private String mobile;
	private String address;
	private int dis;
	CustomerDB db=new CustomerDB();
	public Customer()
	{
		this.id=0;
		this.name="";
		this.address="";
		this.mobile="";
		this.dis=0;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setMobile(String mobile)
	{
		this.mobile=mobile;
	}
	public void setDiscount(int dis)
	{
		this.dis=dis;
	}
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getAddress()
	{
		return address;
	}
	public String getMobile()
	{
		return mobile;
	}
	public int getDiscount()
	{
		return dis;
	}
	public boolean setCustdetail(Customer a1) throws SQLException
	{
			if(db.storecustdetail(a1)) {
			System.out.println("Successfully added");
			return true;
			}
		else {
			System.out.println("Error occurs");
			return false;
		}
	}
	public boolean getmob(String mob) throws ClassNotFoundException, SQLException
	{
		return db.checkmob(mob);
	}
	public int getdiscountamount(String mob) throws ClassNotFoundException, SQLException
	{
		return db.dis_amount(mob);
	}
	public Customer customerdetails(Customer det) throws ClassNotFoundException, SQLException 
	{
		return db.custget(det.getDiscount(),det.getMobile());
	}
	public ArrayList<Customer> displayCust() throws ClassNotFoundException, SQLException
	{
		 return db.displayCustomer();
	}
}
