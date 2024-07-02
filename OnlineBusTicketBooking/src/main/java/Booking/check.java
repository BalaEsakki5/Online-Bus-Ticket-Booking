package Booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class check extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pnr =0;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/busticketbooking_db", "root", "root");
				
				PreparedStatement ps = c.prepareStatement("select max(pnr) from passengerdetails");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					pnr = rs.getInt("max(pnr)");
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			PrintWriter out = resp.getWriter();
			out.print("<h1>"+pnr+"</h1>");
		
	}

}
