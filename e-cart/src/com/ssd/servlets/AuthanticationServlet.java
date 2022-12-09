package com.ssd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.model.User;

/**
 * Servlet implementation class AuthanticationServlet
 */
@WebServlet("/userSignup")
public class AuthanticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthanticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		String errMsg="Please enter ";
		
		boolean isValied=true;
		
		if(fname.isEmpty() || fname==null || fname.isBlank()) {
			
			errMsg = errMsg+"first Name";
			isValied=false;
			
		}
		if(lname.isEmpty() || lname==null || lname.isBlank()) {
			
			errMsg = errMsg+"last Name";
			isValied=false;
			
		}
		if(email.isEmpty() || email==null || email.isBlank()) {
			
			errMsg = errMsg+" email";
			isValied=false;
			
		}
		if(pwd.isEmpty() || pwd==null || pwd.isBlank()) {
			
			errMsg = errMsg+" password";
			isValied=false;
			
		}
		
		if(isValied) {
			
			User user = new User();
			
			String userName = fname+lname;
			
			user.setName(userName);
			user.setEmail(email);
			user.setPassword(pwd);
			
			
		}else {
			request.setAttribute("errmsg", errMsg);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		
		
		
	}

}
