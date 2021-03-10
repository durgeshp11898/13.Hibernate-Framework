package Com.Separate.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sum_Emp
{
	public static void main(String[] args)
	{
		Connection con=ConnectionClass.dbConnect();
		try
		{
			PreparedStatement ps =con.prepareStatement("select sum(salary) from employe");
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				System.out.println("sum of salary is  :"+rs.getInt(1));
			}   
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
