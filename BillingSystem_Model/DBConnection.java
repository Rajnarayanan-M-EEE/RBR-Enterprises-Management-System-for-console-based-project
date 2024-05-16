package BillingSystem_Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection con = null;

	static
	{
		String url = "jdbc:mysql:// localhost:3306/demo";
		String user = "root";
		String pass = "21EE037@r0702";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		return con;
	}
}
