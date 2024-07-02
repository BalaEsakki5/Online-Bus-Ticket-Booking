<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Booking.booking"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Details</title>
<link rel="stylesheet" type="text/css" href="passengerDetailsCss.css">
</head>
<body>
	<section class="total">
		<article>
			<aside class="menu">
				<div class="menuBar">
						<a href="searchBus.jsp">Search Bus</a>
					
						<a href="contact.jsp">Contact</a>
						<a href="about.jsp">About</a>
				</div>
				
			</aside>
			<aside class="main">
				<div class="col">
					<div class="left"></div>
					<div class="center">
                        <div class="formClass">
                        	<% booking b = (booking) application.getAttribute("passengerBooking"); 
								if(b!=null){%>
								
								<h3><%= b.getName() %> Travels (<%= b.getId() %>)</h3>
								<hr> 
								<p><%= b.getdTime() %> <span><%= b.getaTime() %> </span></p>
								<p><%= b.getStart() %> <span><%= b.getEnd() %></span> </p>
								<p><%= b.getdDate() %> <span><%= b.getaDate() %></span></p>
								<p> &nbsp; <span><%= b.getSeatCap() %></span></p>
								<p>Adult : <%= b.getPassengers() %> &nbsp;|&nbsp; <%= b.getRating() %> 
									&nbsp;|&nbsp; <%= b.getsType() %>&nbsp; | &nbsp;<%= b.getaType() %> 
									&nbsp;|&nbsp; <%= b.getPrice() %></p>							
								<hr>
								
								
							<%} %>
							<h4>Passenger Details</h4>
							<form action="passenger">
							<% int p = b.getPassengers();
								for(int i=1;i<=p;i++){%>
								<%=i %>.
								<input type="text" class="name" name="name<%=i%>" placeholder="name">
								<input type="number" class="age" name="age<%=i %>" placeholder="age">
									<select id="gender" name="gender<%=i %>">
								  		<option value="male">Male</option>
								  		<option value="female">Female</option>
								  		<option value="others">Others</option>
									</select>
								<br>
								
							<% }
								if(b!=null){%>
									<% double totalAmount = b.getPrice()*b.getPassengers();  %>
									<h3>Total Amount = <%=totalAmount %> </h3>
								<%} %>
							
								<input type="submit" class="submit" value="Book">
							</form>
                            
						</div>
						
					</div>
					<div class="right"></div>
				</div>
			</aside>
			
		</article>
	</section>
	
	
	
	
	
	
</body>
</html>