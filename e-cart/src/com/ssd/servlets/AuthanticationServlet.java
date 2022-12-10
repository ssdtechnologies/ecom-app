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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");

		if (isValiadeUser(fname,lname,email,pwd)) {

			User user = new User();

			String userName = fname + lname;

			user.setName(userName);
			user.setEmail(email);
			user.setPassword(pwd);

		} else {
			request.setAttribute("errmsg", "errMsg");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}

	public boolean isValiadeUser(String fname, String lname, String email, String pwd) {

		String errMsg = "Please enter ";

		boolean isValied = true;

		if (fname == null || fname.isEmpty() || fname.isBlank()) {

			errMsg = errMsg + "first Name";
			isValied = false;

		}
		if (lname == null || lname.isEmpty() || lname.isBlank()) {

			errMsg = errMsg + "last Name";
			isValied = false;

		}
		if (email == null || email.isEmpty() || email.isBlank()) {

			errMsg = errMsg + " email";
			isValied = false;

		}
		if (pwd == null || pwd.isEmpty() || pwd.isBlank() || pwd.length()>8) {

			errMsg = errMsg + " password";
			isValied = false;

		}
		return isValied;
	}

}
