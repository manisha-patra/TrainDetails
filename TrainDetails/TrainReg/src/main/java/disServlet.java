

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.lang.NumberFormatException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class disServlet extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res)  throws IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		int trainNo = Integer.parseInt(req.getParameter("TrainNo"));
		
		try
		{
	
          Connection con = DBConnection.connectDB();
		
		  PreparedStatement ps = con.prepareStatement("select * from traindata where TrainNo=?");

		  ps.setInt(1,trainNo);
		    
			
		  ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				

				 pw.println("******Details***** ");
				 pw.println("<br>Train No: "+rs.getInt(1));
				 pw.println("<br>Train Name: "+rs.getString(2));
				 pw.println("<br>From Station: "+rs.getString(3));
				 pw.println("<br>To Station: "+rs.getString(4));
				 pw.println("<br>Availability: "+rs.getInt(5));
				
				
			}
			
			else
			{
				 pw.println("<br>Sorry!!!! Invalid Train No!!!!");
		    	 RequestDispatcher rd = req.getRequestDispatcher("homepg.html");
		    	 rd.include(req, res);
			}
		
		}
		catch(Exception e)
		{
		 System.out.println(e);	
		}
	}
}
