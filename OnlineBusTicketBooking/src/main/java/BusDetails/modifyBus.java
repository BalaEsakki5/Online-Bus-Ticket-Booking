package BusDetails;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Booking.booking;

@WebServlet("/updateBus")
public class modifyBus extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String i = req.getParameter("id");
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
		String submit = req.getParameter("submit");
		
		int id = Integer.parseInt(i);
		double price = Double.parseDouble(pr);
		double rating = Double.parseDouble(rat);
		int seatCap = Integer.parseInt(seat);
		
		Bus b = new Bus();
		b.setId(id);
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
		
		ServletContext context = getServletContext();
		context.setAttribute("updateBus", b);
		
		if(submit.equals("edit")) {
			req.getRequestDispatcher("editBusDetails.jsp").forward(req, resp);
			
		}else if(submit.equals("Delete")) {
			req.getRequestDispatcher("deleteBusDetails.jsp").forward(req, resp);
		}
		
		
		
		
		
		
		
		
	}
}
