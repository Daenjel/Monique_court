package rental;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FulltimeDAO {
	private Connection myConn;
	
	private FulltimeDAO() throws Exception
	{
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		myConn = DriverManager.getConnection(dburl, user, password);
		System.out.println("DB Connection successful to: " +dburl);
	}
	
	public List<FullTime> getAll() throws Exception
	{
		List<FullTime> list = new ArrayList<>();
		
		java.sql.Statement myStmt = null;
		ResultSet myRs = null;
		
		try{
			myStmt =myConn.createStatement();
			myRs = myStmt.executeQuery("Select *from actor");
			
			while(myRs.next())
			{
				FullTime tempFullTime = convertRowToFullTime(myRs);
				list.add(tempFullTime);
		}
			return list;
		}
		finally
		{
			close(myStmt, myRs);
		}
	}

		public List<FullTime> searchactor(String last_name) throws Exception
		{
			List<FullTime> list = new ArrayList<>();
			
			PreparedStatement mystmt = null;
			ResultSet myRs =null;
			
			try
			{
				last_name += "%";
				mystmt = myConn.prepareStatement("select *from actor where last_name like ?");
				
				mystmt.setString(1, last_name);
				myRs = mystmt.executeQuery();
				
				while(myRs.next())
					{
					FullTime tempFullTime = convertRowToFullTime(myRs);
					list.add(tempFullTime);
					}
				return list;
			}
			finally
			{
				close(mystmt, myRs);
			}
			
		}
	

	private void close(java.sql.Statement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub
		
	}


	private FullTime convertRowToFullTime(ResultSet myRs) {
		// TODO Auto-generated method stub
		return null;
	}

public static void main(String[] args) throws Exception
{
	FulltimeDAO dao = new FulltimeDAO();
	System.out.println(dao.searchactor("nick"));
}
}