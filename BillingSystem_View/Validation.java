
package BillingSystem_View;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BillingSystem_Controller.Admin;


public class Validation {
	static Scanner A=new Scanner(System.in);
	final String key="SSIET";
	Admin a=new Admin();
	Dashboard dash=new Dashboard();
	public boolean checkKey(String h)
	{
		if(key.equals(h))
		return true;
		else
			return false;
	}
	
	public void login() throws ClassNotFoundException, SQLException
	{
		int input=1;
    	System.out.println("Welcome to the Login page");
    	while(input==1)
    	{
             System.out.println("Enter your Username");
             String user=A.next();
             System.out.println("Enter your Password");
             String pass=A.next();
             boolean check=a.getlogindetail(user,pass);
             if(check)
             {
            	 dash.access();
            	 System.out.println("If You want to continue Login Page Press 1 exit for other");
            	 input=A.nextInt();
            	 
             }
             else
             {
            	 System.out.println("You are enter the incorrect Username and Password");
             }
    	}
    
	}
	Admin r = new Admin(); 
	public void signup() throws SQLException
	{
		System.out.println("Welcome to the SignUp page");
	//	A.nextLine();
    	System.out.println("Enter the Name");
    	String name=A.nextLine();
    	System.out.println("Enter the Mobile");
    	String phone="";
    	boolean j=false;
    	while(j==false)
    	{
    	phone=A.next();
    	  Pattern p1 = Pattern.compile("^\\d{10}$");
    	  Matcher m1 = p1.matcher(phone);
          if(m1.matches()&&phone.length()==10)
        	  j=true;
          else {
        	  j=false;
        	  System.out.println("Enter the valid number");
          }
    	}
    	
        A.nextLine();
    	System.out.println("Enter the Address");
    	String address=A.nextLine();
    	System.out.println("Enter the Username");
    	String username=A.next();
    	System.out.println("Enter the Password (eg: Geeks@portal20 Contains all of the things)");
    	String password="";
    	boolean i=false;
  	while(i==false)
 	{
    	password=A.next();
    	 String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";        
         Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(password);
         i= m.matches();
    	if(i)
    	{
    		Admin rs=new Admin();
    		rs.setName(name);
    		rs.setAddress(address);
    		rs.setMobile(phone);
    		rs.setUsername(username);
    		rs.setPassword(password);
    		i=true;
    		r.setsignupdetail(rs);
    	}
    	else
    	{
    		System.out.println("Must enter the password with in  given model,\r\n  "
    				+ " Represents a digit must occur at least once.\r\n"
    				+ " Represents a lower case alphabet must occur at least once.\r\n"
    				+ " Represents an upper case alphabet that must occur at least once.\r\n"
    				+ " Represents a special character that must occur at least once.\r\n"
    				+ " White spaces don’t allowed in the entire string.\r\n"
    				+ " Represents at least 8 characters and at most 20 characters.");    	
    		i=false;
    	}
 	}
}
	

}
