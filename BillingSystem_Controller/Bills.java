package BillingSystem_Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import BillingSystem_Model.BillsDB;

public class Bills {

	private int billid;
	private int cid;
	private String datetime;
	private int sub;
	private int dis;
	private int tot;
	
	private int stk;
	private int amt;
	public void setcid(int id)
	{
		this.cid=id;
	}
	public void setdatetime(String datetime)
	{
		this.datetime=datetime;
	}
	public void setsub(int sub)
	{
		this.sub=sub;
	}
	public void setbillid(int billid)
	{
		this.billid=billid;
	}
	public void setdis(int dis)
	{
		this.dis=dis;
	}
	public void setamt(int amt)
	{
		this.amt=amt;
	}
	public void setstk(int stk)
	{
		this.stk=stk;
	}
	public void settot(int tot)
	{
		this.tot=tot;
	}
	
	public int getcid()
	{
		return cid;
	}
	public String getdatetime()
	{
		return datetime;
	}
	public int getsub()
	{
		return sub;
	}
	public int getbillid()
	{
		return billid;
	}
	public int gettot()
	{
		return tot;
	}
	public int getdis()
	{
		return dis;
	}
	public int getamt()
	{
		return amt;
	}
	public int getstk()
	{
		return stk;
	}
	BillsDB db=new BillsDB();
	public int getmaxbillno() throws ClassNotFoundException, SQLException
	{
		return db.findmaxbill();
	}
	
	public Bills getDetail(int id) throws ClassNotFoundException, SQLException
	{
		Bills pd=db.productDetail(id);
		return pd;
	}
	public Bills setfinalbill(Bills set) throws ClassNotFoundException, SQLException
	{
		return db.finalbill(set);
	}
	public ArrayList<Bills> getBilling() throws ClassNotFoundException, SQLException
	{
		return db.displayBilling();
	}
}
