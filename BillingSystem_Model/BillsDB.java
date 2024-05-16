package BillingSystem_Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BillingSystem_Controller.Bills;

public class BillsDB {
	  static Connection con = DBConnection.getConnection();
	public int findmaxbill() throws SQLException, ClassNotFoundException
	{
		String query="SELECT MAX(BILL_ID) as Bill_Id FROM BILLS;";
		Statement ps = con.createStatement();
		ResultSet query_result = ps.executeQuery(query);
		//ResultSet query_result=display(query);
		int num=0;
		while(query_result.next()) {
		num=query_result.getInt("Bill_Id");
		}
		return num;
	}
	public Bills productDetail(int id) throws ClassNotFoundException, SQLException
	{Bills pd=new Bills();
	
		String query="SELECT Amount,P_Stock FROM PRODUCTS WHERE P_ID="+id+";";
		Statement ps = con.createStatement();
		ResultSet query_result = ps.executeQuery(query);
		//ResultSet =display(query);
		while(query_result.next())
		{
			pd.setamt(query_result.getInt("Amount"));
			pd.setstk(query_result.getInt("P_Stock"));
		}
		return pd;
	}
	public Bills finalbill(Bills set) throws SQLException, ClassNotFoundException{
		Statement ps = con.createStatement();
		String query="INSERT INTO BILLS (C_ID,Purchasing_Date_Time,SUB_TOTAL,DISCOUNT,TOTAL)"
				+ "VALUES(" + set.getcid() + ",'" + set.getdatetime() + "',"+ set.getsub() + ","  + set.getdis() + ","+ set.gettot()+");";
		ps.executeUpdate(query);
		String query1="SELECT * FROM BILLS WHERE BILL_ID IN (SELECT MAX(BILL_ID) FROM BILLS);";
		ResultSet output = ps.executeQuery(query1);
		//ResultSet =display(query1);
		Bills ret=new Bills();
		while(output.next())
		{
			ret.setbillid(output.getInt("Bill_Id"));
			ret.setdatetime(output.getString("Purchasing_Date_Time"));
			ret.settot(output.getInt("Total"));
			ret.setdis(output.getInt("Discount"));
			ret.setsub(output.getInt("Sub_Total"));
		}
		return ret;
	}
	public ArrayList<Bills> displayBilling() throws ClassNotFoundException, SQLException
	{
		ArrayList<Bills> al=new ArrayList<Bills>();
		String query="Select * FROM BILLS;";
		Statement ps = con.createStatement();
		ResultSet dis = ps.executeQuery(query);
		//ResultSet =display(query);
		while(dis.next())
		{
			Bills x=new Bills();
			x.setbillid(dis.getInt("Bill_Id"));
			x.setcid(dis.getInt("C_Id"));
			x.setdatetime(dis.getString("Purchasing_Date_Time"));
			x.setdis(dis.getInt("Sub_Total"));
			x.setsub(dis.getInt("Discount"));
			x.settot(dis.getInt("Total"));
			al.add(x);
		}
		return al;
	}
	
}
