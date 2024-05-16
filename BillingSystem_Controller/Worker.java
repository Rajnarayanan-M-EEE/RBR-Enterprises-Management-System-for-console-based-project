package BillingSystem_Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import BillingSystem_Model.WorkerDB;

public class Worker {

	private int id;
	private String name;
	private String mobile;
	private String email;
	private String address;
	private String qual;
	private int sal;
	WorkerDB db=new WorkerDB();
	public Worker()
	{
		this.id=0;
		this.name="";
		this.address="";
		this.mobile="";
		this.sal=0;
		this.qual="";
		this.email="";
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
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setQuali(String qual)
	{
		this.qual=qual;
	}
	public void setSalary(int sal)
	{
		this.sal=sal;
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
	public String getEmail()
	{
		return email;
	}
	public String getQuali()
	{
		return qual;
	}
	public int getSalary()
	{
		return sal;
	}
	public boolean setWorkerdetail(Worker a1) throws SQLException
	{
			if(db.storeworkerdetail(a1)) {
			System.out.println("Successfully added");
			return true;
			}
		else {
			System.out.println("Error occurs");
			return false;
		}
	}
	public  ArrayList<Worker> displayWorker() throws ClassNotFoundException, SQLException
	{
		return db.displayWorker();
	}
}
