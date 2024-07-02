<%@page import="java.util.List"%>
<%@page import="Booking.booking"%>
<%@page import="Ticket.ticket"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ticket</title>
<link rel="stylesheet" type="text/css" href="viewTicket.css">
</head>
<body>


	<section class="total">
		<article>
			<aside class="menu">
				<div class="myLogo">
					<img alt="logo" src="/OnlineBusTicketBooking/src/main/webapp/bus.png" height="40px" width="100px">
				</div>
				<div class="menuBar">
						<a href="searchBus.jsp">Search Bus</a>
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
                            
							<% List<ticket> passenger= (List<ticket>) application.getAttribute("passengerDetail"); 
								int pnr = 0;
								String bname ="";
								String ddate = "";
								String dtime = "";
								String adate = "";
								String atime = "";
								String start = "";
								String end = "";
								String stype = "";
								String atype = "";
								double price =0;
								double totalPrice=0 ;
								int count = 0;
								
								if(passenger!=null){
									int i=1;
							%>	
								
								<% for(ticket p :passenger){%>
										<% pnr = p.getPnr(); bname = p.getBname(); 
											ddate = p.getDdate(); dtime =  p.getDtime(); 
											adate = p.getAdate(); atime = p.getAtime();
											start = p.getStart(); end = p.getEnd();
											stype = p.getStype(); atype = p.getAtype();
											price = p.getPrice();
											%>
										
								<% 	
									}
									
								 %>
								 <h3>Booked From <span>To</span></h3>
								 <p><%= start  %> <span><%= end   %></span></p>
								 <p>Start Date*<%= dtime  %> :  <%=ddate %>  
								 	<span>Arrival*<%= atime  %> :  <%=adate %></span>
								 </p><hr>
								 <h3>PNR<span> Bus Name</span></h3>
								 <p><%= pnr  %> <span><%= bname   %></span></p>
								 <p><%= stype  %> <span><%= atype   %></span></p>
								 <hr>
								 <h3>Passenger Details</h3>
								 <div class="passdetails">
								 
								<table>
									<tr>
										<td>#</td>
										<td>Name</td>
										<td>Age</td>
										<td>Gender</td>
									</tr>
								<% for(ticket p :passenger){ count++;%>
										<tr>
											<td>
												<p><%= i++ %></p>
											</td>
											<td>
												<p><%=p.getPname() %></p>
											</td>
											<td>
												<p><%= p.getAge() %></p>
											</td>
											<td>
												<p><%=p.getGender() %></p>
											</td>
										</tr>
									
								<% 		}
									totalPrice = price*count;
								%>
								</table>
								<hr>
									<h3>Ticket Fare : <%= totalPrice %></h3>
								<% 	
								} %>	
									<hr>
									
								
								<input type="button" value="Print" class="print">	
									<span><i>Happy Journey</i></span>																																																				
								</div>
						</div>
						
					</div>
					<div class="right"></div>
				</div>
			</aside>
			
		</article>
	</section>

	

</body>
</html>