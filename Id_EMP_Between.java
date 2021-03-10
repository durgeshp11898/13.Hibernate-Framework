package Com.Separate.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Id_EMP_Between {
	public static void main(String[] args) {
		Connection con = ConnectionClass.dbConnect();
		try
		{
			PreparedStatement ps = con.prepareStatement("select * from employe where eid  BETWEEN 3 and 7");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));

			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
