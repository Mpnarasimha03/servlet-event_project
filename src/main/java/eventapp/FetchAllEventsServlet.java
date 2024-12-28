package eventapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/all")
public class FetchAllEventsServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management_system","root","root");
		PreparedStatement ps=con.prepareStatement("select * from event");
		ResultSet rs=ps.executeQuery();
		
		req.setAttribute("rs", rs);
		RequestDispatcher rd=req.getRequestDispatcher("allevents.jsp");
		rd.forward(req, res);
		
//		while(rs.next()) {
//			System.out.print(rs.getInt(1)+" ");
//			System.out.print(rs.getString(2)+" ");
//			System.out.print(rs.getString(3)+" ");
//			System.out.print(rs.getString(4)+" ");
//			System.out.print(rs.getString(5)+" ");
//			System.out.println();
//		}
		
		rs.close();
		ps.close();
		con.close();
		
		
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
