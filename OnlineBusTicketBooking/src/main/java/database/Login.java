package database;

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
@WebServlet("/Login")
public class Login extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String email=req.getParameter("email");
   	  String password=req.getParameter("password");
   	  
   	  EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	  EntityManager em=emf.createEntityManager();
	  EntityTransaction et=em.getTransaction();
	  
	  PrintWriter out=resp.getWriter();
	  user u=em.find(user.class, email);
	 
	  if(u!=null) {
		 if(u.getPassword().equals(password)) {
			 ServletContext context = getServletContext();
			 context.setAttribute("userLoginDetails", u);
		     req.getRequestDispatcher("searchBus.jsp").forward(req, resp);
		 }else {
			 req.setAttribute("invalidMsg", "Invalid Password");
		 }
	  }else {
		  req.setAttribute("invalidMsg", "Invalid Email");
	  }
	  req.getRequestDispatcher("index.jsp").include(req, resp);;   
}
}
