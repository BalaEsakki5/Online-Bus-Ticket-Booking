<%@page import="BusDetails.Bus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Bus Details</title>
<link rel="stylesheet" type="text/css" href="deleteBusDetails.css">
</head>
<body>
	<section class="total">
		<article>
			<aside class="menu">
				<div class="myLogo">
					<img alt="logo" src="/OnlineBusTicketBooking/src/main/webapp/bus.png" height="40px" width="100px">
				</div>
				<div class="menuBar">
						<a href="addBus.jsp">Add Bus</a>
						<a href="#">Contact</a>
						<a href="#">About</a>
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
                           	<h2>Delete Bus Details....</h2>
                           	<hr>

							<% Bus b = (Bus) application.getAttribute("updateBus"); 
									if(b!=null){%>
									<h3><%= b.getId() %> <br><span><%= b.getStart() %></span><span><%= b.getEnd() %></span></h3>
									<h3><%= b.getdTime() %><span><%= b.getdDate() %></span></h3>
									<h3><%= b.getaTime() %> <span><%= b.getaDate() %></span></h3>
									<h3><%= b.getsType() %><span><%= b.getaType() %></span></h3>
									<h3><%= b.getRating() %></h3>
									<h3>Price = <%= b.getPrice() %></h3>
								<%} %>
								<form action="deleteBusDetails">
									<label>Are you sure want to Delete : </label>
									<input type="submit" value="Yes">
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