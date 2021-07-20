
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/*manisha*/
@WebServlet("/regServlet")
public class regServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init()
	{
	}
	public void service(HttpServletRequest req, HttpServletResponse res)  throws IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String uname = req.getParameter("Uname");
		int pwd = Integer.parseInt(req.getParameter("pwd"));
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String address = req.getParameter("address");
		int phno = Integer.parseInt(req.getParameter("phno"));
		String email = req.getParameter("mailId");
	
		int age = Integer.parseInt(req.getParameter("age"));
		
	
		
		try
		{
			Connection con = DBConnection.connectDB();
		     java.sql.PreparedStatement ps =  con.prepareStatement("insert into trainapp values(?,?,?,?,?,?,?,?)");
		     
		     ps.setString(1,uname);
		     ps.setInt(2,pwd);
		     ps.setString(3,fname);
		     ps.setString(4,lname);
		     ps.setString(5,address);
		     ps.setInt(6,phno);
		     ps.setString(7,email);

		     ps.setInt(8,age);
				
			  
     
		     int k = ps.executeUpdate();
		     
		     if (k==1)
		     {
		         /*pw.println("<br><h2> Registration Successful</h2>");*/
		    	 RequestDispatcher rd = req.getRequestDispatcher("login.html");
		    	 rd.include(req, res);
		    	
		     }
		     else
		     {
		    	 pw.println("<br><center> Invalid Username and Password!</center>");
		    	 RequestDispatcher rd = req.getRequestDispatcher("login.html");
		    	 rd.include(req, res);
		     }
			
		}

		catch(Exception e)
		{
			
		}
	}

}
