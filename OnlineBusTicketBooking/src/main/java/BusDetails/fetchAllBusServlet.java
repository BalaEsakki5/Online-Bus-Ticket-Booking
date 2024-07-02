package BusDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import searchBus.searchBus;

@WebServlet("/fetchAllBus")
public class fetchAllBusServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/busticketbooking_db", "root", "root");
			
			PreparedStatement ps = c.prepareStatement("select * from busdetails");
			
			ResultSet rs = ps.executeQuery();
			
			List<fetchAllBus> fetch = new ArrayList<fetchAllBus>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String dfrom = rs.getString("start");
				String dto = rs.getString("end");
				String ddtime = rs.getString("depature_time");
				String dddate = rs.getString("depature_date");
				String datime = rs.getString("arrival_date");
				String dadate = rs.getString("arrival_time");
				double dprice = rs.getDouble("price");
				double drating = rs.getDouble("rating");
				int dseatcap = rs.getInt("seatCapacity");
				String dstype = rs.getString("seatType");
				String datype = rs.getString("acType");
				
				fetchAllBus s1 = new fetchAllBus();
				s1.setId(id);
				s1.setStart(dfrom);
				s1.setEnd(dto);
				s1.setDtime(ddtime);
				s1.setDdate(dddate);
				s1.setAtime(datime);
				s1.setAdate(dadate);
				s1.setPrice(dprice);
				s1.setRating(drating);
				s1.setSeatCap(dseatcap);
				s1.setStype(dstype);
				s1.setAtype(datype);
				
				fetch.add(s1);
				
				
			}
			req.setAttribute("fetchAllBus", fetch);
			
			req.getRequestDispatcher("fetchAllBus.jsp").forward(req, resp);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
