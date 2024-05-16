package BillingSystem_Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BillingSystem_Controller.Worker;

public class WorkerDB {

	static Connection con = DBConnection.getConnection();
	public boolean storeworkerdetail(Worker c) throws SQLException
	{
		String query="INSERT INTO WORKER (W_NAME,W_QUALIFICATION,W_ADDRESS,W_MOBILE,W_EMAIL,W_SALARY)"
				+ "VALUES('" + c.getName() + "','" + c.getQuali() + "','"+ c.getAddress() + "','"  + c.getMobile() + "','"+ c.getEmail() +"',"+ c.getSalary() +");";
		Statement ps = con.createStatement();
		int r=ps.executeUpdate(query);
		if(r>0)
			return true;
		return false;
	}
	public ArrayList<Worker> displayWorker() throws ClassNotFoundException, SQLException
	{
		ArrayList<Worker> al=new ArrayList<Worker>();
		String query="Select * FROM WORKER;";
		Statement ps = con.createStatement();
		ResultSet dis= ps.executeQuery(query);
		//ResultSet =display(query);
		while(dis.next())
		{
			Worker rs=new Worker();
			rs.setId(dis.getInt("W_Id"));
			rs.setName(dis.getString("W_Name"));
			rs.setMobile(dis.getString("W_Mobile"));
			rs.setAddress(dis.getString("W_Address"));
			rs.setEmail(dis.getString("W_Email"));
			rs.setQuali(dis.getString("W_Qualification"));
			rs.setSalary(dis.getInt("W_Salary"));
			al.add(rs);
		}
		return al;
	}
}
