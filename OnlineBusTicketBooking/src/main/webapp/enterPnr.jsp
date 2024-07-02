<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Ticket</title>
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
						<a href="#">Contact</a>
						<a href="#">About</a>
				</div>
				
			</aside>
			<aside class="main">
				<div class="col">
					<div class="left"></div>
					<div class="center">
                        <div class="formClass">
                            <h3>View Ticket</h3>
                            <hr>
							<form action="viewTicket">
								<label>Enter Pnr Number : </label>
								<input type="number" name="pnr" required><br>
								<input type="submit" value="Find PNR status" class="loginBtn">
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