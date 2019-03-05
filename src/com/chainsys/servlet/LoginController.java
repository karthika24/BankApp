package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.User;
import com.chainsys.UserDAO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	
		
		//System.out.println("Session : " + session);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		UserDAO dao = new UserDAO();
		// PrintWriter out = response.getWriter();
		boolean result;
		try {
			result = dao.validator(user);
			System.out.println(result);
			if (result == true) {
				User user1 = new User();
				user1.setEmail(email);
				user1 = dao.findByEmail(user1);
				request.setAttribute("USER", user1);
				RequestDispatcher rd = request
						.getRequestDispatcher("details.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("ERROR", "Wrong password. Try again or click forget password");
				RequestDispatcher rd = request
						.getRequestDispatcher("newlogin.jsp");
				rd.include(request, response);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
