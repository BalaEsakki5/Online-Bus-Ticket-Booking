<html>
<head>
	<title>Ticket Booking</title>
	<link rel="stylesheet" type="text/css" href="index.css">
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
						<a href="signUp.jsp">Sign Up</a>
						<a href="contact.jsp">Contact</a>
						<a href="about.jsp">About</a>
				</div>
				<div class="admin">
						<a href="adminLogin.jsp">Admin</a>
				</div>
			</aside>
			<aside class="main">
				<div class="col">
					<div class="left"></div>
					<div class="center">
                        <div class="formClass">
                            <form action="Login">
                                <h1 class="login">Login</h1>
							    <label>Email :</label>
							    <input type="text" name="email"> <br>
							    <label>Password :	</label>
							    <input type="text" name="password"> <br>
								Don't have an account ? <a href="signUp.jsp">signUp</a><br>
								<a href="forgotPassword.jps">Forget Password</a>
								<input type="submit" value="Login" class="loginBtn">	
						</form>
						<% String invalidMsg = (String) request.getAttribute("invalidMsg"); 
							if(invalidMsg!=null){%>
							<h5 class="invalidMsg"><%= invalidMsg %></h5>
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
