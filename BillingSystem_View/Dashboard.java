package BillingSystem_View;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BillingSystem_Controller.Admin;
import BillingSystem_Controller.Bills;
import BillingSystem_Controller.Customer;
import BillingSystem_Controller.Product;
import BillingSystem_Controller.Worker;
public class Dashboard {
	static Scanner A=new Scanner(System.in);
	Product pd=new Product();
	Customer ct=new Customer();
	Admin ad=new Admin();
	Worker wk=new Worker();
	Billingpage bp=new Billingpage();
	Bills b=new Bills();
	public void access() throws ClassNotFoundException, SQLException
	{
		int menupage=1;
		while(menupage!=0)
		{
			 System.out.println("*-------*------*-------*--------  Welcome to the Dash Board  -------*------*-------*---------*");
			 System.out.println("Enter 0 to Billing");
			 System.out.println("Enter 1 to add new products");
			 System.out.println("Enter 2 to Restock products");
			 System.out.println("Enter 3 to add Customer");
			 System.out.println("Enter 4 to add Worker");
			 System.out.println("Enter 5 to display the Customer List");
			 System.out.println("Enter 6 to display the Product List");
			 System.out.println("Enter 7 to display the Users List");
			 System.out.println("Enter 8 to display the Billing Details");
			 System.out.println("Enter 9 to display the workers list");
	   		 System.out.println("Enter 111 to exit the dashboard");
			 int input=A.nextInt();
			 if(input==0)
			 {
				 bp.bills();
				 System.out.println("Go to the dashboard page press '1' or exit menu page press '0'");
					menupage=A.nextInt();
			 }
			 else if(input==1)
			 {
				 System.out.println("Welcome to the new Product add to the databse");
				 int in=1;
				 while(in==1)
				 {
					 A.nextLine();
				 System.out.println("Enter to the Product name");
				 String name=A.nextLine();
				 System.out.println("Enter to the Product Weight");
				 String weight=A.next();
				 System.out.println("Enter to the Product Amount");
				 int amt=A.nextInt();
				 System.out.println("Enter to the Product Purchase Date (MM/DD/YYYY)");
				 String pdate="";
				 boolean i=false;
				 while(i==false)
				 {
				 pdate=A.next();
				 if(isValidDate(pdate))
					 i=true;
				 else {
					 System.out.println("Enter the valid date format (MM/DD/YYYY)");
					 i=false;
				 }
				 }
				 System.out.println("Enter to the Product Expired Date (MM/DD/YYYY)");
				 String edate="";
				 boolean j=false;
				 while(j==false)
				 {
				 edate=A.next();
				 if(isValidDate(edate))
					 j=true;
				 else {
					 System.out.println("Enter the valid date format (MM/DD/YYYY)");
					 j=false;
				 }
				 }
				 System.out.println("Enter to the Product Quantity for adding Stock");
				 int stock=A.nextInt();
				 
				 
				 Product data=new Product();
				 data.setPname(name);
				 data.setPweight(weight);
				 data.setAmount(amt);
				 data.setPdate(pdate);
				 data.setEdate(edate);
				 data.setPstock(stock);
				 boolean c=pd.setproductdetail(data);
				 if(c)
					 System.out.println("Successfully added the product Press 1 for add more product othervise exit");
				 in=A.nextInt();
				 A.nextLine();
				 }
				 
				 System.out.println("Go to the dashboard page press '1' or exit menu page press '0'");
					menupage=A.nextInt();
			}
			 else if(input==2)
			 {
				 System.out.println("Welcome to the Restock the product");
				 int in=1;
				 while(in==1)
				 {
				 System.out.println("Enter to the Product id");
				 int id=A.nextInt();
				 System.out.println("Enter to the Product Quantity for adding Stock");
				 int stock=A.nextInt();
				 boolean c=pd.restock(id,stock);
				 if(c)
					 System.out.println("Successfully added the product, again restocl press 1 otherwise exit");
				 in=A.nextInt();
				 }
				 System.out.println("Go to the dashboard page press '1' or exit menu page press '0'");
					menupage=A.nextInt();
			 }
			 else if(input==3)
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
				
				 
				 System.out.println("Go to the dashboard page press '1' or exit menu page press '0'");
					menupage=A.nextInt();
			 }
			 else if(input==4)
			 {
				 
				 System.out.println("Welcome to the Employee data form");
				 A.nextLine();
				 System.out.println("Enter to the Employee name");
				 String name=A.nextLine();
				 System.out.println("Enter to the Employee Qualification");
				 String quli=A.next();
				 A.nextLine();
				 System.out.println("Enter to the Customer Address");
				 String add=A.nextLine();
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
				 System.out.println("Enter to the Employee Email");
				 String email="";
				 boolean k=false;
				 while(k==false)
				 {
					 email=A.next();
					 k=isValidemail(email);
					 if(!k)
					 System.out.println("Enter the valid email");
						 
				 }
				 System.out.println("Enter to the Employee Salary");
				 int sal=A.nextInt();
				 
				 Worker data=new Worker();
				 data.setName(name);
				 data.setMobile(ph);
				 data.setAddress(add);
				 data.setEmail(email);
				 data.setQuali(quli);
				 data.setSalary(sal);
				 wk.setWorkerdetail(data);
				
				 System.out.println("Go to the dashboard page press '1' or exit menu page press '0'");
					menupage=A.nextInt();
			 }
			 else if(input==5)
			 {
				 ArrayList<Customer> al=ct.displayCust();
				 System.out.println("Customers:");
				 System.out.println("+-----------+--------------------+------------------+-------------------+----------------+");
				 System.out.println("| C_Id      | C_Name             | C_Mobile         | C_Address         | Discount       |");
				 System.out.println("+-----------+--------------------+------------------+-------------------+----------------+");
				 int i=0;
				 while(i<al.size())
				 {
					 Customer g=al.get(i);
					 int id=g.getId();
					 String name=g.getName();
					 String ph=g.getMobile();
					 String add=g.getAddress();
					 int dis=g.getDiscount();
					
					 System.out.printf("| %-9s | %-18s | %-16s | %-17s | %-14s |\n",id,name,ph,add,dis);
					i++;
					 
				 }
				 System.out.println("+-----------+--------------------+------------------+-------------------+----------------+");
			
				 System.out.println("Go to the dashboard page press '1' or exit menu page press '0'");
					menupage=A.nextInt();
			 }
			 else if(input==6)
			 {
				 ArrayList<Product> al=pd.display();
				 System.out.println("Products:");
				 System.out.println("+-----------+------------------+------------------+---------+----------------+--------------+----------+");
				 System.out.println("| P_Id      | P_Name           | P_Weight         | Amount  | Purchase_Date  | Expired_Date | P_Stock  |");
				 System.out.println("+-----------+------------------+------------------+---------+----------------+--------------+----------+");
				 int i=0;
				 while(i<al.size())
				 {
					 Product rs=new Product();
					 rs=al.get(i);
					 int id=rs.getPid();
					 String pname=rs.getPname();
					 String pweight=rs.getPweight();
					 int amount=rs.getAmount();
					 String pdate=rs.getPdate();
					 String edate=rs.getEdate();
					 int stock=rs.getPstock();
					 System.out.printf("| %-9s | %-16s | %-16s | %-7s | %-14s | %-12s | %-8s |\n",id,pname,pweight,amount,pdate,edate,stock);
					i++;
					 
				 }
				 System.out.println("+-----------+------------------+------------------+---------+----------------+--------------+----------+");
			
				 System.out.println("Go to the dashboard page press '1' or exit menu page press '0'");
					menupage=A.nextInt();
			 }
			 else if(input==7)
			 {
				 ArrayList<Admin> al=ad.displayUser();
				 int i=0;
				 System.out.println("Users:");
				 System.out.println("+-----------+--------------------+------------------+-------------------+----------------+--------------+");
				 System.out.println("| Id_User   | U_Name             | U_Mobile         | U_Address         | Username       | Password     |");
				 System.out.println("+-----------+--------------------+------------------+-------------------+----------------+--------------+");
				 
				 while(i<al.size())
				 {
					 Admin g=al.get(i);
						 int id=g.getId();
						 String name=g.getName();
						 String ph=g.getMobile();
						 String add=g.getAddress();
						 String username=g.getUsername();
						 String pass="********";
						 System.out.printf("| %-9s | %-18s | %-16s | %-17s | %-14s | %-12s |\n",id,name,ph,add,username,pass);
						i++;
				 }
				 System.out.println("+-----------+--------------------+------------------+-------------------+----------------+--------------+");
				 
				 System.out.println("Go to the dashboard page press '1' or exit menu page press '0'");
					menupage=A.nextInt();
			 }
			 else if(input==8)
			 {
				 	System.out.println("The details of bill upto today");
				 	ArrayList<Bills> al=b.getBilling();
				 	
				 	 System.out.println("Bills:");
				 	 System.out.println("+-----------+-----------+------------------------------+-----------+-----------+----------+");
				 	 System.out.println("| Bill_Id   | C_Id      | Purchasing_Date_Time         | Sub_Total | Discount  | Total    |");
				 	 System.out.println("+-----------+-----------+------------------------------+-----------+-----------+----------+");
				 	 int i=0;
				 	 while(i<al.size())
				 	 {
				 		 Bills g=al.get(i);
				 		 int id=g.getbillid();
				 		 int cid=g.getcid();
				 		 String date=g.getdatetime();
				 		 int sub=g.getsub();
				 		 int dis=g.getdis();
				 		 int tot=g.gettot();
				 		 System.out.printf("| %-9s | %-9s | %-28s | %-9s | %-9s | %-8s |\n",id,cid,date,sub,dis,tot);
				 		
				 		 i++;
				 	 }
				 	 System.out.println("+-----------+-----------+------------------+------------------------------+-----------+-----------+----------+");

			
				 System.out.println("Go to the dashboard page press '1' or exit menu page press '0'");
					menupage=A.nextInt();
			 }
			 else if(input==9)
			 {
				 ArrayList<Worker> al=wk.displayWorker();

				 System.out.println("Employees:");
				 System.out.println("+-----------+--------------------+------------------+-------------------+----------------+--------------------+-----------+");
				 System.out.println("| W_Id      | W_Name             |W_Qualification   | W_Address         | W_Mobile       | W_Email            | Salary    |");
				 System.out.println("+-----------+--------------------+------------------+-------------------+----------------+--------------------+-----------+");
				 int i=0;
				 while(i<al.size())
				 {
					 Worker g=al.get(i);
					 int id=g.getId();
					 String name=g.getName();
					 String qal=g.getQuali();
					 String add=g.getAddress();
					 String ph=g.getMobile();
					 String mail=g.getEmail();
					 int sal=g.getSalary();
					 System.out.printf("| %-9s | %-18s | %-16s | %-17s | %-14s | %-18s | %-9s |\n",id,name,qal,ph,add,mail,sal);
					
					 i++;
				 }
				 System.out.println("+-----------+--------------------+------------------+-------------------+----------------+--------------------+-----------+");
			
				 System.out.println("Go to the dashboard page press '1' or exit menu page press '0'");
					menupage=A.nextInt();
			 }
			 
		}
	}
	
	
	
	  public static boolean isValidDate(String d) 
	    { 
	        String regex = "^(1[0-2]|0[1-9])/(3[01]"
	                       + "|[12][0-9]|0[1-9])/[0-9]{4}$"; 
	        Pattern pattern = Pattern.compile(regex); 
	        Matcher matcher = pattern.matcher((CharSequence)d); 
	        return matcher.matches(); 
	    } 
	  public static boolean isValidMobile(String s)
	    {
			Pattern p = Pattern.compile("^\\d{10}$");
	        Matcher m = p.matcher(s);
	        return (m.matches());
	    }
	  public static boolean isValidemail(String email) 
	    { 
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                            "[a-zA-Z0-9_+&*-]+)*@" + 
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                            "A-Z]{2,7}$"; 
	                              
	        Pattern pat = Pattern.compile(emailRegex); 
	        if (email == null) 
	            return false; 
	        return pat.matcher(email).matches(); 
	    } 
}
