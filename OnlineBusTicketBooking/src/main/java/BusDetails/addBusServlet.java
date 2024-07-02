package BusDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addBus")
public class addBusServlet extends GenericServlet {
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String i = req.getParameter("id");
		String name = req.getParameter("name");
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		String dTime = req.getParameter("depTime");
		String dDate = req.getParameter("depDate");
		String aTime = req.getParameter("arrTime");
		String aDate = req.getParameter("arrDate");
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
			PreparedStatement ps = c.prepareStatement("insert into busdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, from);
			ps.setString(4, to);
			ps.setString(5, dDate);
			ps.setString(6, aDate);
			ps.setString(7, dTime);
			ps.setString(8, aTime);
			ps.setDouble(9, price);
			ps.setDouble(10, rating);
			ps.setInt(11, seatCap);
			ps.setString(12, sType);
			ps.setString(13, aType);

			ps.executeUpdate();

//			PrintWriter out = res.getWriter();
//			out.print("<h1>Data saved...</h1>");
			
			req.setAttribute("busAdd", "Bus Details Added Successfully...");
			
			req.getRequestDispatcher("addBus.jsp").include(req, res);
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


//		  

		System.out.println();

		
	}
		
}
