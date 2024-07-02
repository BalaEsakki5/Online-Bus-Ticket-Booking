package database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SignUp")
public class Signup extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  String fname=req.getParameter("fname");
	  String lname=req.getParameter("lname");
	  String email=req.getParameter("email");
	  String password=req.getParameter("password");
	  String cofpasswrd=req.getParameter("cpassword");
	  String ph=req.getParameter("phone");
	  String gender=req.getParameter("gender");
	  String dob=req.getParameter("dob");
	  
	  long phone=Long.parseLong(ph);
	  
	  if(password.equals(cofpasswrd)) {
		  user u=new user();
		  u.setFname(fname); 
		  u.setLname(lname);
		  u.setEmail(email);
		  u.setPassword(password);
		  u.setPhone(phone);
		  u.setGender(gender);
		  u.setDob(dob);
		  
		  EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		  EntityManager em=emf.createEntityManager();
		  EntityTransaction et=em.getTransaction();
		  
		  et.begin();
		  em.persist(u);
		  et.commit();
		  
		  req.setAttribute("account_msg", "Account Created Successfully");
		  req.getRequestDispatcher("index.jsp").forward(req, resp);
		  
	  } else {
		  req.setAttribute("invalidMsg", "Mismatch password & confirm password");
		  req.getRequestDispatcher("signUp.jsp").include(req, resp);
	  }
	  
	  
//		PrintWriter out=resp.getWriter();
//		out.print("<h1>fname"+fname+"lname:"+lname+"email"+email+
//				"password"+password+"phone"+phone+"gender"+gender+"dob"+dob+"</h1>");
	 // out.print("<h1>data saved</h1>");
	 }
    
}
