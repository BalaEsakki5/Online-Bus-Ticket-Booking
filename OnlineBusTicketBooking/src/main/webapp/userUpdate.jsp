<%@page import="database.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Update</title>
<link rel="stylesheet" type="text/css" href="userUpdate.css">
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
                            	<%	user u = (user) application.getAttribute("userLoginDetails"); 
									if(u!=null){%>
									<form action="userUpdate">
										<h2>User Update</h2>
										<hr>
									     <label>Firstname</label><br>
									     <input type="text" name="fname" value=<%=u.getFname() %>><br>
									     <label>Lastname</label><br>
									     <input type="text" name="lname" value=<%=u.getLname() %>><br>
									     <label>Email</label><br>
									     <input type="text" name="email" value=<%=u.getEmail() %> readonly><br>
									     <label>Phone Number</label><br>
									     <input type="tel" name="phone" value=<%=u.getPhone() %>><br>
									     <label>Gender</label><br>
									     <input type="radio" class="radioBtn" name="gender" value="male">
									     <label>male</label>
									     <input type="radio" class="radioBtn" name="gender" value="female">
									     <label>female</label>
									     <input type="radio" class="radioBtn" name="gender" value="other">
									     <label>other</label><br>
									     <label>Date of Birth</label><br>
									     <input type="date" name="dob" value=<%=u.getDob() %>><br>
									     <input type="submit" class="update" value="Update">
									 </form>
								<%	
									}else{
										request.setAttribute("invalidLogin", "Login to Continue");
										request.getRequestDispatcher("searchBus.jsp").include(request, response);%>
								<%	} %>
							                            	
						</div>
						
					</div>
					<div class="right"></div>
				</div>
			</aside>
			
		</article>
	</section>

	
</body>
</html>