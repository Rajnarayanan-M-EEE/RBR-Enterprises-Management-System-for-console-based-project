package BillingSystem_View;

import java.sql.SQLException;
import java.util.*;
public class Mainpage{
	
    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
    	@SuppressWarnings("resource")
		Scanner A=new Scanner(System.in);
    	Validation vd=new Validation();
    	System.out.println("--------*-------*--------*---------*---------*--------*--------*----------*");
    	System.out.println("1Welcome to the RBR Enterprise Billing and Management console based Project");
    	System.out.println("-------*-------*--------*--------*--------*----------*-----------*--------*");
    	int in=1;
    	while(in==1)
    	{
        System.out.println("Login - 'Press 1'");
        System.out.println("Sign Up - 'Press 2'");
        int choose=A.nextInt();
        if(choose==1)
        {
        	vd.login();
        	System.out.println("If You want Main Page Press 1 exit for any other number");
        	in=A.nextInt();
        }
        else if(choose==2)
        {
        	int t=1;
        	while(t==1)
        	{
        	System.out.println("Please enter to application key to access");
        	String key=A.next();
        	boolean s =vd.checkKey(key);
        	if(s)
        	{
        	 vd.signup();
        	 System.out.println("If You want Main Page Press 1 exit for any other number");
        	 in=A.nextInt();
        	 t=in;
        	}
        	else
        	{
        		System.out.println("Incorrect Password");
        		t=1;
        	}
        	}
        }
        else
        {
        	System.out.println("Enter the valid number");
        	in=1;
        }
        }
    	
    }
}