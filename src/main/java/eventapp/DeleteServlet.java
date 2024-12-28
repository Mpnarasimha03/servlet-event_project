package eventapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management_system","root","root");
			PreparedStatement ps=con.prepareStatement("delete from event where id=?");
			ps.setInt(1,id);
			int row=ps.executeUpdate();
			 
			if(row==1) {
				PrintWriter pw=res.getWriter();
				pw.write("<h1>Event Deleted successfully...</h1>");
				
				RequestDispatcher rd=req.getRequestDispatcher("all");
				rd.include(req, res);
			}
			
			ps.close();
			con.close();
			
		
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	

}
