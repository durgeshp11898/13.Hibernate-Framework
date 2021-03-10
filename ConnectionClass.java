package Com.Separate.Operation;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	private static Connection con;
	public static Connection dbConnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeee","root","root");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;

	}

}
