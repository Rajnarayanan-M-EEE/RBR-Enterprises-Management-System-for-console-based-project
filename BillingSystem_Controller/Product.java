package BillingSystem_Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import BillingSystem_Model.ProductDB;

public class Product {
	private int id;
	private String pname;
	private String pweight;
	private int amt;
	private String pdate;
	private String edate;
	private int pstock;
	private int qty;
	ProductDB db=new ProductDB();
	
	public Product()
	{
		this.id=0;
		this.pname="";
		this.pweight="";
		this.amt=0;
		this.pdate="";
		this.edate="";
		this.pstock=0;
	}
	public void setPid(int id)
	{
		this.id=id;
	}
	public void setPname(String name)
	{
		this.pname=name;
	}
	public void setPweight(String weight)
	{
		this.pweight=weight;
	}
	public void setAmount(int amt)
	{
		this.amt=amt;
	}
	public void setPdate(String pdate)
	{
		this.pdate=pdate;
	}
	public void setEdate(String edate)
	{
		this.edate=edate;
	}
	public void setPstock(int stk)
	{
		this.pstock=stk;
	}
	public void setQty(int qty)
	{
		this.qty=qty;
	}
	public int getPid()
	{
		return id;
	}
	public String getPname()
	{
		return pname;
	}
	public String getPweight()
	{
		return pweight;
	}
	public int getAmount()
	{
		return amt;
	}
	public String getPdate()
	{
		return pdate;
	}
	public String getEdate()
	{
		return edate;
	}
	public int getPstock()
	{
		return pstock;
	}
	public int getQty()
	{
		return qty;
	}
	public boolean setproductdetail(Product a1) throws SQLException
	{
			if(db.storedetail(a1)) {
			System.out.println("Successfully added");
			return true;
			}
		else {
			System.out.println("Error occurs");
			return false;
		}
	}
	public boolean restock(int id,int qty) throws ClassNotFoundException, SQLException
	{
		if(db.restoredetail(id,qty))
			return true;
		else
			return false;
	}
	public void setStock(Product pd) throws SQLException
	{
		db.updatestock(pd);
	}
	public Product getproductdetail(int id) throws ClassNotFoundException, SQLException
	{
		return db.fulldetail(id);
	}
	public ArrayList<Product> display() throws ClassNotFoundException, SQLException
	{
		 return db.displayProduct();
	}
}
