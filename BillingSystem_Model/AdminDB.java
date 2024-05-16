package BillingSystem_Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BillingSystem_Controller.Admin;


public class AdminDB {

	   static Connection con = DBConnection.getConnection();
	public Admin userdetail(String u) throws SQLException, ClassNotFoundException
	{
		String query="SELECT * FROM USER WHERE USERNAME='"+u+"';";
		//ResultSet result=display(query);
		Statement ps = con.createStatement();
		ResultSet result = ps.executeQuery(query);
		Admin rs=new Admin();
		while(result.next())
		{
		
		rs.setName(result.getString("U_Name"));
		rs.setMobile(result.getString("U_Mobile"));
		rs.setAddress(result.getString("U_Address"));
		rs.setUsername(result.getString("Username"));
		rs.setPassword(result.getString("Password"));
		}
		return rs;
	}
	public boolean storedetail(Admin db) throws SQLException
	{
		String query="INSERT INTO USER(U_NAME,U_MOBILE,U_ADDRESS,USERNAME,PASSWORD)"
				+"VALUES('"+db.getName()+"','"+db.getMobile()+"','"+db.getAddress()+"','"+db.getUsername()+"','"+db.getPassword()+"');";
		Statement ps = con.createStatement();
		int r=ps.executeUpdate(query);
		if(r>0)
			return true;
		return false;
		//boolean result_query=update(query);
		//return result_query;
	}
	public ArrayList<Admin> displayUser() throws SQLException, ClassNotFoundException
	{
	    ArrayList<Admin> al=new ArrayList<Admin>();
		String query="Select * FROM USER;";
		Statement ps = con.createStatement();
		ResultSet dis = ps.executeQuery(query);
		//ResultSet dis=display(query);
		while(dis.next())
		{
			Admin ad=new Admin();
			ad.setId(dis.getInt("Id_User"));
			ad.setName(dis.getString("U_Name"));
			ad.setMobile(dis.getString("U_Mobile"));
			ad.setAddress(dis.getString("U_Address"));
			ad.setUsername(dis.getString("Username"));
			ad.setPassword(dis.getString("Password"));
			al.add(ad);
		}
		return al;
	}
}
