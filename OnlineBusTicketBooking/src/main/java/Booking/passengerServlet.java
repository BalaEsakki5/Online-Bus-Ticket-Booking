package Booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/passenger")
public class passengerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		booking b = (booking) context.getAttribute("passengerBooking");
		
		
//		Date d = new Date();
//		int pnr = 40000000+(d.getHours()*d.getMinutes()*d.getMonth()*d.getSeconds()*d.getYear())+9999;

		List<passengers> passenger = new ArrayList<passengers>();
		int pnr =0;
		
		if(b!=null) {
			int n = b.getPassengers();
			int busId = b.getId();
			
			int id=0;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/busticketbooking_db", "root", "root");
				
				Statement ps = c.createStatement();
				
				ResultSet rs = ps.executeQuery("select max(pnr) from passengerDetails");
				
				while(rs.next()) {
					pnr = rs.getInt("max(pnr)")+1;
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			for(int i=1;i<=n;i++) {
				String name = req.getParameter("name"+i);
				String a = req.getParameter("age"+i);
				String gender = req.getParameter("gender"+i);
				
				
				
				int age = Integer.parseInt(a);
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/busticketbooking_db", "root", "root");
					
					Statement ps = c.createStatement();
					
					ResultSet rs = ps.executeQuery("select max(id) from passengerDetails");
					
					while(rs.next()) {
						id = rs.getInt("max(pid)")+1;
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				
				
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/busticketbooking_db", "root", "root");
					PreparedStatement ps = c.prepareStatement("insert into passengerdetails values(?,?,?,?,?,?,?)");
					ps.setInt(1, id);
					ps.setInt(2, pnr);
					ps.setString(3, name);
					ps.setInt(4, age);
					ps.setString(5, gender);
					ps.setString(6, "a1");
					ps.setInt(7, busId);
					
					ps.execute();	
					
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				
				passengers p = new passengers();
				p.setPnr(pnr);
				p.setBusName(b.getName());
				p.setAmount(b.getPrice());
				p.setStart(b.getStart());
				p.setEnd(b.getEnd());
				p.setName(name);
				p.setAge(age);
				p.setGender(gender);
				
				passenger.add(p);
				
				
			}
		
		}else {
			String notBook = "No seats available, Transactions Droped";
		}
		
		ServletContext passengerPnr = getServletContext();
		passengerPnr.setAttribute("passengerPnr", pnr);
		
		ServletContext passengerDetails = getServletContext();
		passengerDetails.setAttribute("passengerDetail", passenger);
		
		req.getRequestDispatcher("ticket.jsp").forward(req, resp);
		
//			String html = "<html><body><h3>PNR :- "
//				+ "<h3>"+passenger+"</h3></body></html>";
//		PrintWriter out = resp.getWriter();
//		out.print(html);
	}
}
