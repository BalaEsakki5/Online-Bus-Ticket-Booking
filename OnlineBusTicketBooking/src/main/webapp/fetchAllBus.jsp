<%@page import="BusDetails.fetchAllBus"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Archu Bus</title>
<link rel="stylesheet" type="text/css" href="fetchAllBus.css">
</head>
<body>
	<section class="total">
		<article>
			<aside class="menu">
				<div class="menuBar">
					<a href="#" class="currentPage">Search Bus</a>
					<a href="addBus.jsp">Add Bus</a>
					<a href="#">User Details</a>
				</div>
				<div class="logout">
					<a href="index.jsp">Logout</a>
				</div>
			</aside>
			<aside class="main">
				<div class="col">
					<div class="left"></div>
					<div class="center">
						
						<%
						List<fetchAllBus> ls = (List<fetchAllBus>) request.getAttribute("fetchAllBus");
						String dltBus = (String) request.getAttribute("dltBus");
						if(dltBus!=null){%>
							<h4><%= dltBus %></h4>
						<%} 
						String updMsg = (String) request.getAttribute("updateMsg");
						if(updMsg!=null){%>
							<h4><%= updMsg %></h4>
						<%} %>
						
						<table cellpadding="5px">
							<% for(fetchAllBus s :ls){ %>
							<form action="updateBus">
							<tr>
								<td><input type="text" name="id" value=<%= s.getId() %> readonly></td>
								<td><input type="text" name="start" value=<%= s.getStart() %> readonly></td>
								<td><input type="text" name="end" value=<%= s.getEnd() %> readonly></td>
							</tr>	
							<tr>	
								<td><input type="text" name="dTime" value=<%= s.getDtime() %> readonly></td>
								<td><input type="text" name="dDate" value=<%= s.getDdate() %> readonly></td>
								<td><input type="text" name="aDate" value=<%= s.getAdate() %> readonly></td>
								<td><input type="text" name="aTime" value=<%= s.getAtime() %> readonly></td>
							</tr>
							<tr>
								<td><input type="text" name="price" value=<%= s.getPrice() %> readonly></td>
								<td><input type="text" name="rating" value=<%= s.getRating() %> readonly></td>
								<td><input type="text" name="seatCap" value=<%= s.getSeatCap() %> readonly></td>
							</tr>	
							<tr>	
								<td><input type="text" name="sType" value=<%= s.getStype() %> readonly></td>
								<td><input type="text" name="aType" value=<%= s.getAtype() %> readonly></td>
								
								<td><input type="submit" name="submit" value="edit"><input type="submit" name="submit" value="Delete"></td>	
								
							</tr>
							<tr>
								<td>&nbsp</td>
							</tr>
							</form>
							
							<%} %>
						</table>
						
					</div>
					<div class="right"></div>
				</div>
			</aside>
		</article>
	</section>
	



	
</body>
</html>