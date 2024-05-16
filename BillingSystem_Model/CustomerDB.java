package BillingSystem_Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BillingSystem_Controller.Customer;

public class CustomerDB {

	   static Connection con = DBConnection.getConnection();
	public boolean storecustdetail(Customer c) throws SQLException
	{
		String query="INSERT INTO CUSTOMERS (C_NAME,C_MOBILE,C_ADDRESS,C_DISCOUNT)"
				+ "VALUES('" + c.getName() + "','" + c.getMobile() + "','"+ c.getAddress() + "',"+c.getDiscount()+");";
		Statement ps = con.createStatement();
		int r=ps.executeUpdate(query);
		if(r>0)
			return true;
		return false;
	}
	public ArrayList<Customer> displayCustomer() throws ClassNotFoundException, SQLException
	{
		ArrayList<Customer> al=new ArrayList<Customer>();
		String query="Select * FROM CUSTOMERS;";
		Statement ps = con.createStatement();
		ResultSet dis = ps.executeQuery(query);
		while(dis.next())
		{
			Customer rs=new Customer();
			rs.setId(dis.getInt("C_Id"));
			rs.setName(dis.getString("C_Name"));
			rs.setMobile(dis.getString("C_Mobile"));
			rs.setAddress(dis.getString("C_Address"));
			rs.setDiscount(dis.getInt("C_Discount"));
			al.add(rs);
		}
		return al;
	}
	public boolean checkmob(String mob) throws SQLException, ClassNotFoundException
	{
		String query="SELECT C_ID FROM CUSTOMERS WHERE C_MOBILE='"+mob+"';";
		Statement ps = con.createStatement();
		ResultSet query_result2 = ps.executeQuery(query);
		//ResultSet =display(query);
		int id=0;
		while(query_result2.next())
		{
		id=query_result2.getInt("C_Id");
		}
		String res=String.valueOf(id);
		if(!res.equals("0"))
		{
			return true;
		}
		else
			return false;
	}
	public int dis_amount(String c_mobile) throws SQLException, ClassNotFoundException
	{
		String query="SELECT C_Discount FROM CUSTOMERS WHERE C_Mobile='"+c_mobile+"';";
		Statement ps = con.createStatement();
		ResultSet query_result = ps.executeQuery(query);
		//ResultSet query_result=display(query);
		int tot=0;
		while(query_result.next())
		{
		 tot=query_result.getInt("C_Discount");
		}
		String query1="update CUSTOMERS SET C_Discount=0 where C_MOBILE='"+c_mobile+"';";
		ps.executeUpdate(query1);
		return tot;
	}
	public Customer custget( int amount,String mob) throws ClassNotFoundException, SQLException
	{
		Statement ps = con.createStatement();
		Customer det=new Customer();
		String query1="UPDATE CUSTOMERS SET C_Discount="+amount+" WHERE C_MOBILE='"+mob+"';";
		ps.executeUpdate(query1);
		String query2="SELECT * FROM CUSTOMERS WHERE C_MOBILE='"+mob+"';";
		ResultSet custdetail = ps.executeQuery(query2);
		//ResultSet =display(query2);
		while(custdetail.next())
		{
			det.setId(custdetail.getInt("C_Id"));
			det.setDiscount(custdetail.getInt("C_Discount"));
			det.setAddress(custdetail.getString("C_Address"));
			det.setName(custdetail.getString("C_Name"));
			det.setMobile(custdetail.getString("C_Mobile"));
		}
		return det;
	}
}
