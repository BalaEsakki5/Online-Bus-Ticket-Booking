<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Bus(ADMIN)</title>
<link rel="stylesheet" type="text/css" href="addBusCss.css">
</head>
<body>


    <section class="total">
		<article>
			<aside class="menu">
				<div class="menuBar">
						<!-- <a href=".jsp">Bus Details</a>
						<a href="contact.jsp">Contact</a>
						<a href="about.jsp">About</a> -->
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
                            <form action="addBus">
                                <table>
                                   <thead>
                                    <tr>
                                        <th colspan="2">
                                            <h1>Bus Details</h1>
                                        </th>
                                    </tr>
                                   </thead>
                                    <tr>
                                        <td>
                                            <label>Bus ID : </label><br>
                                            <input type="number" name="id" placeholder="Bus ID">
                                        </td>
                                        <td>
                                            <label>Bus Name: </label><br>
                                            <input type="text" name="name" placeholder=""> 
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>From : </label><br>
                                            <input type="text" name="from" placeholder="">
                                        </td>
                                        <td>
                                            <label>To : </label><br>
                                            <input type="text" name="to" placeholder="">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Dept Date: </label><br>
                                            <input type="date" name="depDate" placeholder="">
                                        </td>
                                        <td>
                                            <label>Dept Time: </label><br>
                                            <input type="time" name="depTime" placeholder="">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Arrival Date: </label><br>
                                            <input type="date" name="arrDate" placeholder="">
                                        </td>
                                        <td>
                                            <label>Arrival time: </label><br>
                                            <input type="time" name="arrTime" placeholder="">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Price: </label><br>
                                            <input type="number" name="price" placeholder="">
                                        </td>
                                        <td>
                                            <label>Rating: </label><br>
                                            <input type="number" name="rating" placeholder="">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Seat Capacity : </label><br>
                                            <input type="number" name="seatCap" placeholder="">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>AC Type </label><br>
                                            <input type="radio" class="radioBtn" name="aType" value="AC">AC
                                            <input type="radio" class="radioBtn" name="aType" value="Non-AC">Non-AC
                                        </td>

                                        <td>
                                            <label>Seat Type </label><br>
                                            <input type="radio" class="radioBtn" name="sType" value="slepper">Sleeper
                                            <input type="radio" class="radioBtn" name="sType" value="sitting">Sitting	
                                        </td>
                                    </tr>
                                    
                                        <tr>
                                            <td colspan="2">
                                                <input type="submit" class="submit" value="Add Bus">	
                                            </td>
                                        </tr>
                                </table>
                                
                            </form>
                            <%	String add = (String) request.getAttribute("busAdd");
                                if(add!=null){%>
                                <h4><%= add %></h4>
                                
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