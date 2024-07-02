<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="signUpCss.css">
</head>
<body>
    <section class="total">
		<article>
			<aside class="menu">
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
                            <form action="SignUp">
                                <table>
                                    <tr>
                                        <th colspan="2">
                                            <h1>SIGN UP</h1>
                                        </th>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>First Name</label><br>
                                            <input type="text" name="fname">
                                        </td>
                                        <td>
                                            <label>Lastname</label><br>
                                            <input type="text" name="lname">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <label>Email</label><br>
                                             <input type="text" class="inputLen" name="email">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <label>Password</label><br>
                                            <input type="text" class="inputLen" name="password">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <label>Confirm password</label><br>
                                            <input type="text" class="inputLen" name="cpassword">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <label>Phone Number</label><br>
                                            <input type="tel" class="inputLen" name="phone">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <label>Gender</label><br>
                                            <input type="radio" class="radioBtn" name="gender" value="male">Male
                                            <input type="radio" class="radioBtn" name="gender" value="female">Female
                                            <input type="radio" class="radioBtn"
                                             name="gender" value="other">Others
                                        </td> 
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <label>Date of Birth</label>
                                            <input type="date" class="inputLen" name="dob">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <input type="submit" value="SignUp" class="submit">
                                        </td>
                                    </tr>
                                </table>  
                               <% String invalidMsg = (String) request.getAttribute("invalidMsg"); 
                                        if(invalidMsg!=null){%>
                                        <h6><%= invalidMsg %></h6>
                                <%} %>
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