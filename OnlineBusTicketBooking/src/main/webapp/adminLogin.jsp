<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" type="text/css" href="adminLoginCss.css">
</head>
<body>
	
	
	<section class="total">
		<article>
			<aside class="menu">
				<div class="myLogo">
					<img alt="logo" src="/OnlineBusTicketBooking/src/main/webapp/bus.png" height="40px" width="100px">
				</div>
				<div class="menuBar">
						<a href="index.jsp">Back</a>
						<a href="#">Sign Up</a>
						<a href="#">Contact</a>
						<a href="#">About</a>
				</div>
			</aside>
			<aside class="main">
				<div class="col">
					<div class="left"></div>
					<div class="center">
                        <div class="formClass">
                           	<form action="adminLoginValidation">
								<label>Email : </label> 
								<input type="email" name="email"> <br>
								<label>Password-1 : </label>  
								<input type="password" name="password1"> <br>
								<label>Password-2 : </label>
								<input type="password" name="password2"> <br>
								<input type="submit" class="loginBtn">
							</form>
							<% String adminLoginMsg = (String) request.getAttribute("adminLoginMsg");
								if(adminLoginMsg!=null){%>
								<h5><%=adminLoginMsg %></h5>
								
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