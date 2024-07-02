<%@page import="searchBus.searchBus"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
<link rel="stylesheet" type="text/css" href="bookingCss.css">
</head>
<body>
    <section class="total">
        <article>
            <aside class="menu">
                <div class="menuBar">
                    <a href="#" class="currentPage">Book Ticket</a>
					<a href="searchBus.jsp" >Modify Search</a>
					<a href="enterPnr.jsp">View Ticket</a>
					<a href="userUpdate.jsp">Update Profile</a>
				</div>
				<div class="logout">
					<a href="index.jsp">Logout</a>
				</div>
            </aside>
            <aside class="main">
                <div class="col">
                    <div class="left"></div>
                    <div class="center">
	                    <div class="formClass">
	                    	 <%
	                        List<searchBus> ls = (List<searchBus>) request.getAttribute("searchBus");
	                        if(ls.size()==0){%>
	                            <h2 class="invalidMsg">No Bus Available Right Now...</h2>
	                        <%} %>

	                        <table border="0px" cellpadding="5px" >
	                            <% for(searchBus s :ls){ %>
                                	<form action="booking">
                                   	 <tr>
                                    
                                        <td>
                                            <input type="text" name="name" value=<%= s.getName() %> readonly>
                                        </td>
                                        <td>
                                            <input type="text" name="dTime" value=<%= s.getDtime() %> readonly>
                                        </td>
                                        <td>
                                            <input type="text" name="aTime" value=<%= s.getAtime() %> readonly>
                                        </td>
                                        <td>
                                            <input type="text" name="rating" value=<%= s.getRating() %> readonly>
                                        </td>
                                        <td>
                                            <input type="text" name="price" value=<%= s.getPrice() %> readonly>
                                        </td>
                                        <td>
                                            <label for="passengers">No of passengers :</label>
                                                <select id="passengers" name="passengers">
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                </select>
                                        </td>
                                       
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="text" name="sType" value=<%= s.getStype() %> readonly>
                                            <input type="text" name="aType" value=<%= s.getAtype() %> readonly>
                                        </td>
                                        <td>
                                            <input type="text" name="dDate" value=<%= s.getDdate() %> readonly>
                                            <input type="text" name="start" value=<%= s.getStart() %> readonly>
                                        </td>
                                        <td>
                                            <input type="text" name="aDate" value=<%= s.getAdate() %> readonly>
                                            <input type="text" name="end" value=<%= s.getEnd() %> readonly>
                                        </td>
                                        <td>
                                            <input type="text" name="id" value=<%= s.getId() %> readonly>                                        
                                        </td>
                                        <td>
                                            <input type="text" name="seatCap" value=<%=s.getSeatCap() %> readonly>
                                        </td>
                                        <td>
                                            <input type="submit" value="Passenger Details" class="bookBtn">	
                                        </td>
                                    </tr>
                                    <tr>
                                    	<td colspan="6"><hr></td>
                                    </tr>
                               	</form>
                               		
                            
                                  <%} %>
                            </table>
                                    
                                    
	                    
	                    </div>
                             
                    </div>
                    <div class="right"></div>
                </div>
            </aside>
        </article>
    </section>
</body>
</html>