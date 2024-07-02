package searchBus;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Attribute;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchBus")
public class searchBusServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String start = req.getParameter("from");
		String end = req.getParameter("to");
		String jdate = req.getParameter("jdate");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/busticketbooking_db", "root", "root");
			
			PreparedStatement ps = c.prepareStatement("select * from busdetails where start=? and end=?");
			ps.setString(1, start);
			ps.setString(2, end);
			
			
			
			ResultSet rs = ps.executeQuery();
			
//			String html1= "<html><body><table border='2px'>"
//					+ "<tr><th>ID</th><th>from</th><th>to</th>"
//					+ "<th>dtime</th><th>ddate</th><th>atime</th><th>adate</th>"
//					+ "<th>price</th><th>rating</th><th>seat Availability</th>"
//					+ "<th>seat type</th><th>ac type</th></tr>";
//			
			PrintWriter out = resp.getWriter();
//			out.print(html1);
//			
			List<searchBus> sb = new ArrayList<searchBus>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String dfrom = rs.getString("start");
				String dto = rs.getString("end");
				String ddtime = rs.getString("depature_time");
				String dddate = rs.getString("depature_date");
				String dadate = rs.getString("arrival_date");
				String datime = rs.getString("arrival_time");
				double dprice = rs.getDouble("price");
				double drating = rs.getDouble("rating");
				int dseatcap = rs.getInt("seatCapacity");
				String dstype = rs.getString("seatType");
				String datype = rs.getString("acType");
				
				searchBus s1 = new searchBus();
				s1.setId(id);
				s1.setName(name);
				s1.setStart(start);
				s1.setEnd(end);
				s1.setDtime(ddtime);
				s1.setDdate(dddate);
				s1.setAtime(datime);
				s1.setAdate(dadate);
				s1.setPrice(dprice);
				s1.setRating(drating);
				s1.setSeatCap(dseatcap);
				s1.setStype(dstype);
				s1.setAtype(datype);
				
				sb.add(s1);
				
//				String html2 = "<tr><td>"+id+"</td>"+"<td>"+dfrom+"</td>"+"<td>"+dto+"</td>"
//						+"<td>"+ddtime+"</td>"+"<td>"+dddate+"</td>"+"<td>"+datime+"</td>"+"<td>"+dadate+"</td>"
//						+"<td>"+dprice+"</td>"+"<td>"+drating+"</td>"+"<td>"+dseatcap+"</td>"
//						+"<td>"+dstype+"</td>"+"<td>"+datype+"</td></tr>";
//				
//				out.print(html2);
			}
			req.setAttribute("searchBus", sb);
			
			req.getRequestDispatcher("booking.jsp").forward(req, resp);		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
