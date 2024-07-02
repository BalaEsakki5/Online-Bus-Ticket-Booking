<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Bus</title>
<link rel="stylesheet" type="text/css" href="searchBus.css">
</head>
<body>
	<section class="total">
		<article>
			<aside class="menu">
				<div class="menuBar">
					<a href="#" class="currentPage">Search Bus</a>
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
							<form action="searchBus">
								<h1 class="mainTxt">Search Buses</h1>
								<label>From : </label>
								<input type="text" name="from"><br>
								<label>TO :</label>
								<input type="text" name="to"><br>
								<label for="">Date : </label>
								<input type="date" name="jdate" class="date"><br>
								<input type="submit" class="searchBtn" value="Search Bus">
							</form>
							<% String updateMsg = (String) request.getAttribute("userUpdate");
								String invalidLogin = (String) request.getAttribute("invalidLogin");
								if(updateMsg!=null){%>
									<h3 class="invalidMsg"><%= updateMsg %></h3>
									<%} if(invalidLogin!=null){%>
										<h3 class="invalidMsg"><%= invalidLogin %></h3>
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