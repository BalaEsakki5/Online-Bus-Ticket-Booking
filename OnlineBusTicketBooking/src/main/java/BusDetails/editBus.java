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

@WebServlet("/editBusDetails")
public class editBus extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String i = req.getParameter("id");
		String name = req.getParameter("name");
		String from = req.getParameter("start");
		String to = req.getParameter("end");
		String dTime = req.getParameter("dTime");
		String dDate = req.getParameter("dDate");
		String aTime = req.getParameter("aTime");
		String aDate = req.getParameter("aDate");
		String pr = req.getParameter("price");
		String rat = req.getParameter("rating");
		String seat = req.getParameter("seatCap");
		String aType = req.getParameter("aType");
		String sType = req.getParameter("sType");

		int id = Integer.parseInt(i);
		double price = Double.parseDouble(pr);
		double rating = Double.parseDouble(rat);
		int seatCap = Integer.parseInt(seat);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/busticketbooking_db", "root", "root");
		
			PreparedStatement ps = c.prepareStatement("update busdetails set start=?, end=?, depature_date=?,arrival_date=?,depature_time=?,arrival_time=?,price=?,"
					+ "rating=?,seatCapacity=?,seatType=?,acType=? where id=?");
			ps.setInt(12, id);
			ps.setString(1, from);
			ps.setString(2, to);
			ps.setString(3, dDate);
			ps.setString(4, aDate);
			ps.setString(5, dTime);
			ps.setString(6, aTime);
			ps.setDouble(7, price);
			ps.setDouble(8, rating);
			ps.setInt(9, seatCap);
			ps.setString(10, sType);
			ps.setString(11, aType);

			ps.executeUpdate();

//			PrintWriter out = resp.getWriter();
//			out.print("<h1>Data has been updated...</h1>");
			ServletContext context = getServletContext();
			context.setAttribute("updateMsg", "Data has been updated successfully...");
			
			req.getRequestDispatcher("fetchAllBus").include(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
