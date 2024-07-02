package Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adminLoginValidation")
public class adminLogin extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String email = req.getParameter("email");
    	String password1 = req.getParameter("password1");
    	String password2 = req.getParameter("password2");
    	
    	
    	String invalidMsg = "";
    	
    	PrintWriter out = resp.getWriter();
    	
    	if(email.equals("adminBala@gmail.com")) {
    		if(password1.equals("bala@#1234")) {
    			if(password2.equals("esakki@#921")) {
    				req.getRequestDispatcher("fetchAllBus").forward(req, resp);
        		}else {
        			req.setAttribute("adminLoginMsg", "Invalid Password-2");
        			req.getRequestDispatcher("adminLogin.jsp").include(req, resp);
//        			invalidMsg = "Invalid Password-2...";
//        			out.print("<h1>"+invalidMsg+"</h1>");
        		}	
    		}else {
    			req.setAttribute("adminLoginMsg", "Invalid Password-1");
    			req.getRequestDispatcher("adminLogin.jsp").include(req, resp);
//				invalidMsg = "Invalid Password-1...";
//    			out.print("<h1>"+invalidMsg+"</h1>");
    		}
    	}else {
    		req.setAttribute("adminLoginMsg", "Invalid Email");
			req.getRequestDispatcher("adminLogin.jsp").include(req, resp);
//    		invalidMsg = "Invalid Email...";
//    		out.print("<h1>"+invalidMsg+"</h1>");
    	}
    	
    }
}
