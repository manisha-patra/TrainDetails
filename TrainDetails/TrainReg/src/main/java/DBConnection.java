
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    
	           static Connection con = null;
	public static Connection connectDB() {
	{
		try
		{
			 Class.forName("com.mysql.jdbc.Driver");

			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","");
		     return con;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	return con;
	
	}		
	
}
