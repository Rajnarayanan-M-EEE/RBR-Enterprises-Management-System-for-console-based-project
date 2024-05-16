package BillingSystem_Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BillingSystem_Controller.PurchasedList;

public class PurchasedListDB {
	static Connection con = DBConnection.getConnection();
	public void updatebilling(PurchasedList up) throws SQLException 
	{
		String query="INSERT INTO purchased_list (P_ID,P_QUANTITY,TOTAL_AMOUNT,Bill_Id)"
				+ "VALUES(" + up.getpid() +","+ up.getpqty() + ","  + up.gettamt() +","+up.getbillid()+");";
		Statement ps = con.createStatement();
		ps.executeUpdate(query);
	}
	public ArrayList<PurchasedList> getfinalbills(int n) throws ClassNotFoundException, SQLException
	{
		ArrayList<PurchasedList> al=new ArrayList<PurchasedList>();
		String query2="SELECT * FROM purchased_list WHERE BILL_ID="+n+";";
		Statement ps = con.createStatement();
		ResultSet output2 = ps.executeQuery(query2);
		//ResultSet output2=executeConnection(query2);
		while(output2.next())
		{
			PurchasedList data=new PurchasedList();
			data.setbillid(output2.getInt("Bill_Id"));
			data.setpid(output2.getInt("P_Id"));
			data.setpqty(output2.getInt("P_Quantity"));
			data.settamt(output2.getInt("Total_Amount"));
			al.add(data);
		}
		return al;
	}
}
