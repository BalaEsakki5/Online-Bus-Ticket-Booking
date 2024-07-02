<%@page import="BusDetails.Bus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Bus Details</title>
<link rel="stylesheet" type="text/css" href="editBusDetails.css">
</head>
<body>

	<section class="total">
		<article>
			<aside class="menu">
				<div class="myLogo">
					<img alt="logo" src="/OnlineBusTicketBooking/src/main/webapp/bus.png" height="40px" width="100px">
				</div>
				<div class="menuBar">
						<a href="#">Edit Bus</a>
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
                            <h4>Edit Bus Details....</h4>
							<% Bus b = (Bus) application.getAttribute("updateBus"); 
									if(b!=null){%>
									
									
									<form action="editBusDetails">
										<table>
									    <tr>
									    	
									        <td>
									        	<label>Bus Id :</label><br>
									        	<input type="text" name="id" value=<%= b.getId() %> readonly required>
									        </td>
									        
									    </tr>	
									    <tr>
									    	<td>
									        	<label>Start : </label><br>
									        	<input type="text" name="start" value=<%= b.getStart() %> required>
									        </td>
									        <td>End : <br>
									        	<input type="text" name="end" value=<%= b.getEnd() %> required>
									        </td>
									    </tr>
									    <tr>	
									        <td>Dept Time : <br><input type="time" name="dTime" value=<%= b.getdTime() %> required></td>
									        <td>Dept Date : <br><input type="date" name="dDate" value=<%= b.getdDate() %> required></td>
									    </tr>
									    <tr>
									        <td>Arrival Date :<br><input type="date" name="aDate" value=<%= b.getaDate() %> required></td>
									        <td>Arrival Time<br><input type="time" name="aTime" value=<%= b.getaTime() %> required></td>
									    </tr>
									    <tr>
									
									        <td>Price : <br><input type="number" name="price" value=<%= b.getPrice() %> required></td>
									        <td>Rating :<br> <input type="number" name="rating" value=<%= b.getRating() %> required></td>
									    </tr>
									    <tr>    
									        <td>Seat Capacity<br><input type="number" name="seatCap" value=<%= b.getSeatCap() %> required></td>
									    </tr>	
									    <tr>	
									        <td>Seat Type<br><input type="text" name="sType" value=<%= b.getsType() %> required></td>
									        <td>AC Type<br><input type="text" name="aType" value=<%= b.getaType() %> required></td>
									    </tr>
									     <tr>
									        <td colspan="2"><input type="submit" class="submit"></td>	
									      
									    </tr>
								    </form>
									
									
									
							<%} %>
						</div>
						
					</div>
					<div class="right"></div>
				</div>
			</aside>
			
		</article>
	</section>


</body>
</html>