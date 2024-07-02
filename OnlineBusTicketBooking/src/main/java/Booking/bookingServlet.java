package Booking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/booking")
public class bookingServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String s = (String)	req.getAttribute("booking");
		String i = req.getParameter("id");
		String name = req.getParameter("name");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		String dTime = req.getParameter("dTime");
		String dDate = req.getParameter("dDate");
		String aTime = req.getParameter("aTime");
		String aDate = req.getParameter("aDate");
		String pr = req.getParameter("price");
		String rat = req.getParameter("rating");
		String seat = req.getParameter("seatCap");
		String aType = req.getParameter("aType");
		String sType = req.getParameter("sType");
		String passengers = req.getParameter("passengers");
		
		int id = Integer.parseInt(i);
		double price = Double.parseDouble(pr);
		double rating = Double.parseDouble(rat);
		int seatCap = Integer.parseInt(seat);
		int passenger = Integer.parseInt(passengers);
		
		booking b = new booking();
		b.setId(id);
		b.setName(name);
		b.setStart(start);
		b.setEnd(end);
		b.setdDate(dDate);
		b.setdTime(dTime);
		b.setaDate(aDate);
		b.setaTime(aTime);
		b.setPrice(price);
		b.setRating(rating);
		b.setSeatCap(seatCap);
		b.setsType(sType);
		b.setaType(aType);
		b.setPassengers(passenger);
		
		ServletContext context = getServletContext();
		context.setAttribute("passengerBooking", b);
		
		
		req.getRequestDispatcher("passengerDetails.jsp").forward(req, resp);
		
//		String html = "<html><body><h3> ID: "+id+"</h3>"
//				+ "<h3> From : "+start+"</h3>"
//				+ "<h3>	To : "+end+"</h3>"
//				+ "<h3> Depature Date : "+dDate+" : "+dTime+"</h3>"
//				+ "<h3> Arrival Date: "+aDate+" : "+aTime+"</h3>"
//				+ "<h3> Price : "+price+"</h3>"
//				+ "<h3> Seat Type : "+sType+" AC Type : "+aType+"</h3>"
//				+ "<h3> Seat Availability : "+seatCap+"</h3>"
//				+ "</body></html>";
//		PrintWriter out = resp.getWriter();
//		
//		out.print(html);
	}
}
