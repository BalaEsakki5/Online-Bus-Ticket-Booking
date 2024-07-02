<%@page import="Booking.booking"%>
<%@page import="Booking.passengers"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="ticket.css">
</head>
<body>
	<section class="total">
		<article>
			<aside class="menu">
				<div class="menuBar">
						<a href="searchBus.jsp">Book Again</a>
						<a href="enterPnr.jsp">View Ticket</a>
						<a href="contact.jsp">Contact</a>
						<a href="about.jsp">About</a>
				</div>
				<div class="admin">
						<a href="index.jsp">Logout</a>
				</div>
			</aside>
			<aside class="main">
				<div class="col">
					<div class="left"></div>
					<div class="center">
                        <div class="formClass">
                            
							<% List<passengers> passenger= (List<passengers>) application.getAttribute("passengerDetail"); 
								int pnr = (int) application.getAttribute("passengerPnr");
								booking bus = (booking)	application.getAttribute("passengerBooking");
								if(passenger!=null ||bus!=null){
									int i=1;
							%>	
								<p>Booked From <span>To</span></p>
								<p><%= bus.getStart() %> <span><%= bus.getEnd() %></span>
								<p>Start Date*<%= bus.getdTime() + bus.getdDate() %><span>Arrival*<%= bus.getaTime() + bus.getaDate() %></span>
								<h3>Bus Name : <%= bus.getName()%></h3>	<br>
								<h3>PNR No : <%= pnr %></h3>
								<% for(passengers p :passenger){ %>
										<h3>Passenger<%= i++ %> = Name : <%=p.getName() %> Age : <%= p.getAge() %> Gender : <%=p.getGender() %></h3>
							<% 		}
								} %>	
								<h3></h3>
								<input type="button" value="Print">
						</div>
						
					</div>
					<div class="right"></div>
				</div>
			</aside>
			
		</article>
	</section>

	



	
	

</body>
</html>