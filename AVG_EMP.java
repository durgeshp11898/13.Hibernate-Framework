package Com.Separate.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AVG_EMP {
	public static void main(String[] args) {
		Connection con=ConnectionClass.dbConnect();
		try
		{
			PreparedStatement ps =con.prepareStatement("select avg(salary) from employe");
			ResultSet rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getInt(1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
