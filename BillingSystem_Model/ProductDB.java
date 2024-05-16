package BillingSystem_Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BillingSystem_Controller.Product;

public class ProductDB {

	static Connection con = DBConnection.getConnection();
	public boolean storedetail(Product a) throws SQLException 
	{
		
		String query="INSERT INTO PRODUCTS (P_NAME,P_WEIGHT,AMOUNT,PURCHASE_DATE,EXPIRED_DATE,P_STOCK)"
				+ "VALUES('" + a.getPname() + "','" + a.getPweight() + "',"+ a.getAmount() + ",'"  + a.getPdate() + "','"+ a.getEdate() +"',"+a.getPstock()+");";
//		boolean res=update(query);
//		return res;
		Statement ps = con.createStatement();
		int r=ps.executeUpdate(query);
		if(r>0)
			return true;
		return false;
	}
	public boolean restoredetail(int id,int qty) throws ClassNotFoundException, SQLException
	{
		String query1="SELECT P_STOCK FROM PRODUCTS WHERE P_ID="+id+";";
		Statement ps = con.createStatement();
		ResultSet output2 = ps.executeQuery(query1);
	//	ResultSet =display(query1);
		int q=0;
		while(output2.next())
		{
		 q=output2.getInt("P_Stock")+qty;	
		}
		String query="UPDATE PRODUCTS SET P_STOCK="+q+" WHERE P_ID="+id+";";
		int r=ps.executeUpdate(query);
		if(r>0)
			return true;
		return false;
	}
	public ArrayList<Product> displayProduct() throws ClassNotFoundException, SQLException
	{
		ArrayList<Product> al=new ArrayList<Product>();
		String query="Select * FROM PRODUCTS;";
		Statement ps = con.createStatement();
		ResultSet dis = ps.executeQuery(query);
		//ResultSet =display(query);
		while(dis.next())
		{
			Product rs=new Product();
			rs.setPid(dis.getInt("P_Id"));
			rs.setPname(dis.getString("P_Name"));
			rs.setPweight(dis.getString("P_Weight"));
			rs.setAmount(dis.getInt("Amount"));
			rs.setPdate(dis.getString("Purchase_Date"));
			rs.setEdate(dis.getString("Expired_Date"));
			rs.setPstock(dis.getInt("P_Stock"));
			al.add(rs);
		}
		return al;
	}
	public void updatestock(Product pd) throws SQLException {
		int q=Math.abs(pd.getPstock()-pd.getQty());
		String query="UPDATE PRODUCTS SET P_STOCK="+q+" WHERE P_ID="+pd.getPid()+";";
		Statement ps = con.createStatement();
		ps.executeUpdate(query);
		
	}
	public Product fulldetail(int pid) throws ClassNotFoundException, SQLException {
		
		String query="Select * FROM PRODUCTS WHERE P_ID="+pid+";";
		Statement ps = con.createStatement();
		ResultSet dis = ps.executeQuery(query);
		//ResultSet dis=display(query);
		Product p=new Product();
		while(dis.next())
		{
			p.setPname(dis.getString("P_Name"));
			p.setPweight(dis.getString("P_Weight"));
			p.setAmount(dis.getInt("Amount"));
		}
		return p;
	}
}
