package BillingSystem_View;

import java.util.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BillingSystem_Controller.Bills;
import BillingSystem_Controller.Customer;
import BillingSystem_Controller.Product;
import BillingSystem_Controller.PurchasedList;
public class Billingpage {
	static Scanner A=new Scanner(System.in);
	Bills bill=new Bills();
	Product pro=new Product();
	PurchasedList pl=new PurchasedList();
	Customer ct=new Customer();
public void bills() throws ClassNotFoundException, SQLException
{
	int billno=bill.getmaxbillno();
	int sum=0;
	int over=1;
	System.out.println(billno);
	while(over==1)
	{
		System.out.println("Welcome to the Billing Page");
		System.out.println("Enter the product id");
		int id=A.nextInt();
		System.out.println("Enter the product quantity");
		int qty=A.nextInt();
		Bills pd=bill.getDetail(id);
		int amount=pd.getamt();
		int stock=pd.getstk();
			if(stock>=qty)
			{
				int total=amount*qty;
				sum=sum+total;
				PurchasedList up=new PurchasedList();
				up.setbillid(billno);
				up.setpid(id);
				up.settamt(total);
				up.setpqty(qty);
				pl.setBills(up);
				Product p=new Product();
				p.setPid(id);
				p.setPstock(stock);
				p.setQty(qty);
				pro.setStock(p);
			}
			else
			{
				System.out.println("Stocks of the products is Insufficients");
			}
		
		System.out.println("If you again to billing the products press 1 otherwise print the bill");
		over=A.nextInt();
	}

	System.out.println("If you didn't have Customer card please enter 1 otherwise press any number");
	int given=A.nextInt();
	if(given==1)
	{
		 System.out.println("Welcome to the Customer data form");
		 A.nextLine();
		 System.out.println("Enter to the Customer name");
		 String name=A.nextLine();
		 System.out.println("Enter to the Customer Mobile");
		 String ph="";
		 boolean i=false;
		 while(i==false)
		 {
			 ph=A.next();
			 i=isValidMobile(ph);
			 if(!i)
				 System.out.println("Enter the valid Mobile number");
		 }
		 A.nextLine();
		 System.out.println("Enter to the Customer Address");
		 String add=A.nextLine();
		 Customer data=new Customer();
		 data.setName(name);
		 data.setMobile(ph);
		 data.setAddress(add);
		 data.setDiscount(0);
		 ct.setCustdetail(data);
	}
	boolean b=false;
	String c_mobile="";
	while(b==false)
	{
	System.out.println("Enter the customer card mobile number");
	c_mobile=A.next();
	b=ct.getmob(c_mobile);
	if(b==false)
		System.out.println("Incorrect mobile number");
	}
	
	int Discount_Card=0;
	int total=0;
	System.out.println("If you want Customer card discount please enter 'Yes', dont reduce amount please enter 'No'.");
	String discount=A.next();
	if(discount.equals("Yes")||discount.equals("yes"))
	{
		int d_amount=ct.getdiscountamount(c_mobile);
		if(d_amount>=1)
		{
			System.out.println("Your card saving amount is "+d_amount+" In case the discount price is higher than the price if you get a product of that remaining amount. Thank you");
			total=sum-d_amount;
			Discount_Card=d_amount;
		}
		else
		{
			System.out.println("Insufficent card saving amount, So no discount for your purchase gain discount for next purchasing");
			total=sum;
			Discount_Card=0;
		}		
	}
	else
	{
		total=sum;
		Discount_Card=0;
	}
	int carddiscount=total/40;
	Customer det=new Customer();
    det.setDiscount(carddiscount);
    det.setMobile(c_mobile);
	Customer details=ct.customerdetails(det);
	int cid=details.getId();
	String cname=details.getName();
	String cmob=details.getMobile();
	String cadd=details.getAddress();
	Date thisDate=new Date();
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String date=df.format(thisDate);
	Bills set=new Bills();
	set.setcid(cid);
	set.setdatetime(date);
	set.setdis(Discount_Card);
	set.setsub(sum);
	set.settot(total);
	Bills bl=bill.setfinalbill(set);
	int id=bl.getbillid();
	String date1=bl.getdatetime();
	int sub=bl.getsub();
	int dis=bl.getdis();
	int tot=bl.gettot();
	ArrayList<PurchasedList> al=pl.getfinalbill(id-1);
	System.out.println("Your Items list");
	System.out.println("+-------+----------------+------------------+-------------+-----------+---------------+---------+");
	System.out.println("| P_Id  | P_Name         | P_Weight         | P_Quantity  | Amount    | Total Amount  | Bill_Id |");
	System.out.println("+-------+----------------+------------------+-------------+-----------+---------------+---------+");
	int i=0; 
	while(i<al.size())
	 {
		PurchasedList rs=al.get(i);
		int pid=rs.getpid();
		
		Product pdet=pro.getproductdetail(pid);
		String pname=pdet.getPname();
		String pweight=pdet.getPweight();
		
		int amt=pdet.getAmount();
		int qty=rs.getpqty();
		int totamt=rs.gettamt();
		int billid=rs.getbillid();
	
		System.out.printf("| %-5s | %-14s | %-16s | %-11s | %-9s | %-13s | %-7s |\n",pid,pname,pweight,qty,amt,totamt,billid);
		i++;
	 }
	 System.out.println("+-------+----------------+------------------+-------------+-----------+---------------+---------+");
     
	 System.out.println("Your bill amount");
     System.out.println("+-----------+-----------+--------------------+------------------+-------------------+------------------------------+-----------+-----------+----------+");
	 System.out.println("| Bill_Id   | C_Id      | C_Name             | C_Mobile         | C_Address         | Purchasing_Date_Time         | Sub_Total | Discount  | Total    |");
	 System.out.println("+-----------+-----------+--------------------+------------------+-------------------+------------------------------+-----------+-----------+----------+");
	 System.out.printf("| %-9s | %-9s | %-18s | %-16s | %-17s | %-28s | %-9s | %-9s | %-8s |\n",id-1,cid,cname,cmob,cadd,date1,sub,dis,tot);
	 System.out.println("+-----------+-----------+--------------------+------------------+-------------------+------------------------------+-----------+-----------+----------+");
     System.out.println("Thanks for Visiting");

	
}


public static boolean isValid(String s)
{
	Pattern p = Pattern.compile("^\\d{10}$");
    Matcher m = p.matcher(s);
    return (m.matches());
}
public static boolean isValidMobile(String s)
{
	Pattern p = Pattern.compile("^\\d{10}$");
    Matcher m = p.matcher(s);
    return (m.matches());
}
}
