
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.lang.annotation.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

@WebServlet("/loginServlet")

public class loginServlet extends HttpServlet
{
	public void init()
	{
	}
	public void service(HttpServletRequest req, HttpServletResponse res)  throws IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String uname = req.getParameter("Uname");
		int pwd = Integer.parseInt(req.getParameter("pwd"));
		
		
		try
		{
	
             Connection con = DBConnection.connectDB();
		     
		     java.sql.PreparedStatement ps =  con.prepareStatement("select * from trainapp where Uname = ? and pwd = ?");
		     
		     ps.setString(1,uname);
		     ps.setInt(2,pwd);
		    
 
		     java.sql.ResultSet rs = ps.executeQuery();
		    
		     if (rs.next())
		     {
		    	 
		    	 RequestDispatcher rd = req.getRequestDispatcher("homepg.html");
		    	 rd.forward(req, res);
		    
		     }
		     else
		     {
		    	 pw.println("<br> Invalid Username and Password!");
		    	 RequestDispatcher rd = req.getRequestDispatcher("login.html");
		    	 rd.include(req, res);
		     }
		     
		}
		 catch(Exception e)
		 {
			 System.out.println(e);		
		 }

		
		}
	
	}

