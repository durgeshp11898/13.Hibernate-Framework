package Com.Separate.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GroupBy {
	public static void main(String[] args) {
		Connection con= ConnectionClass.dbConnect();
		try
		{
			PreparedStatement ps = con.prepareStatement("select profile,avg(salary) from employe  group by profile");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
