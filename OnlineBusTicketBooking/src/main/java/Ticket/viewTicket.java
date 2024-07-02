package Ticket;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Booking.passengers;
import searchBus.searchBus;

@WebServlet("/viewTicket")
public class viewTicket extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("pnr");
		
		int pnr = Integer.parseInt(no);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/busticketbooking_db", "root", "root");
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM passengerdetails "
					+ "INNER JOIN busdetails ON passengerdetails.busId=busdetails.id "
					+ "WHERE pnr=?");
			ps.setInt(1, pnr);
			
			ResultSet rs = ps.executeQuery();
				
			List<ticket> passenger = new ArrayList<ticket>();
			
			while(rs.next()) {
				int pnrs = rs.getInt("pnr");
				String pname = rs.getString("pname");
				String bname = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String sno = rs.getString("seatNo");
				String start = rs.getString("start");
				String end = rs.getString("end");
				String ddate = rs.getString("depature_date");
				String dtime = rs.getString("depature_time");
				String adate = rs.getString("arrival_date");
				String atime = rs.getString("arrival_time");
				String stype = rs.getString("seatType");
				String atype = rs.getString("acType");
				double price = rs.getDouble("price");
				
				ticket t = new ticket();
				t.setPnr(pnrs);
				t.setPname(pname);
				t.setBname(bname);
				t.setAge(age);
				t.setGender(gender);
				t.setSeatNo(sno);
				t.setStart(start);
				t.setEnd(end);
				t.setDdate(ddate);
				t.setDtime(dtime);
				t.setAdate(adate);
				t.setAtime(atime);
				t.setStype(stype);
				t.setAtype(atype);
				t.setPrice(price);
				
				passenger.add(t);
				
				
			}
			ServletContext passengerDetails = getServletContext();
			passengerDetails.setAttribute("passengerDetail", passenger);
			
			req.getRequestDispatcher("viewTicket.jsp").forward(req, resp);
	
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
