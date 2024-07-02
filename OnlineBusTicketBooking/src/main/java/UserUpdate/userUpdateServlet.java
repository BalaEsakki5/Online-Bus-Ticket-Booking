package UserUpdate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.user;

@WebServlet("/userUpdate")
public class userUpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String ph = req.getParameter("phone");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");
		
		long phone = Long.parseLong(ph);
		
		userUpdate up = new userUpdate();
		up.setFname(fname);
		up.setLname(lname);
		up.setEmail(email);
		up.setPhone(phone);
		up.setGender(gender);
		up.setDob(dob);
		
		
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		user u=em.find(user.class, email);
		
		if(u!=null) {
			u.setFname(fname);
			u.setLname(lname);
			u.setEmail(email);
			u.setPhone(phone);
			u.setGender(gender);
			u.setDob(dob);
			
			et.begin();
			em.merge(u);
			et.commit();
			
			req.setAttribute("userUpdate", "User Deatils Updated successfully...");
			
		}else {
			req.setAttribute("userUpdate", "User Deatils can't updated...");
			
		}
		req.getRequestDispatcher("searchBus.jsp").forward(req, resp);
		
		
	
	}
	

}
