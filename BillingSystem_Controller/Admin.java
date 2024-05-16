package BillingSystem_Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import BillingSystem_Model.AdminDB;


public class Admin {
	private int id;
	private String name;
	private String address;
	private String mobile;
	private String username;
	private String password;
	AdminDB a=new AdminDB();
	public Admin()
	{
		this.id=0;
		this.name="";
		this.address="";
		this.mobile="";
		this.username="";
		this.password="";
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
	public void setUsername(String username)
	{
		this.username=username;
	}
	public void setPassword(String password)
	{
		this.password=password;
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
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public boolean getlogindetail(String u,String p) throws ClassNotFoundException, SQLException
	{
		Admin db=a.userdetail(u);
		if(db.getUsername().equals(u)&&db.getPassword().equals(p))
			return true;
		else
			return false;
	}
	public void setsignupdetail(Admin a1) throws SQLException
	{
		if(a.storedetail(a1))
			System.out.println("Successfully added");
		else
			System.out.println("Error occurs");
	}
	public ArrayList<Admin> displayUser() throws ClassNotFoundException, SQLException
	{
		 return a.displayUser();
	}
}
