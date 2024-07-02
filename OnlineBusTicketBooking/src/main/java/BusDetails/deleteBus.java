package BusDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Booking.booking;

@WebServlet("/deleteBusDetails")
public class deleteBus extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		Bus b = (Bus) context.getAttribute("updateBus");
		int id = b.getId();
		if(b!=null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/busticketbooking_db", "root", "root");
				PreparedStatement ps = c.prepareStatement("delete from busdetails where id=?");
				ps.setInt(1, id);

				ps.executeUpdate();		
				
				req.setAttribute("dltBus", "Bus Details can be Deleted...");
				
				req.getRequestDispatcher("fetchAllBus").forward(req, resp);
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//		PrintWriter out = resp.getWriter();
//		out.print("<h1>data deleted...</h1>");
	}
}
