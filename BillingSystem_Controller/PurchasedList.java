package BillingSystem_Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import BillingSystem_Model.PurchasedListDB;

public class PurchasedList {

	private int pid;
	private int pqty;
	private int tamt;
	private int billid;
	PurchasedListDB db=new PurchasedListDB();
	public PurchasedList()
	{
		this.pid=0;
		this.pqty=0;
		this.tamt=0;
		this.billid=0;
	}
	public void setpid(int id)
	{
		this.pid=id;
	}
	public void setpqty(int qty)
	{
		this.pqty=qty;
	}
	public void settamt(int amt)
	{
		this.tamt=amt;
	}
	public void setbillid(int billid)
	{
		this.billid=billid;
	}
	public int getpid()
	{
		return pid;
	}
	public int getpqty()
	{
		return pqty;
	}
	public int gettamt()
	{
		return tamt;
	}
	public int getbillid()
	{
		return billid;
	}
	public void setBills(PurchasedList up) throws SQLException
	{
		db.updatebilling(up);
	}
	public ArrayList<PurchasedList> getfinalbill(int id) throws ClassNotFoundException, SQLException
	{
		return db.getfinalbills(id);
	}
}
