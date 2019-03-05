package com.chainsys.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.User;
import com.chainsys.UserDAO;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDAO dao = new UserDAO();
		ArrayList<User> list=dao.findAll();
		if (email.equalsIgnoreCase("admin@gmail.com")
				&& password.equalsIgnoreCase("admin")) {
			request.setAttribute("USER", list);
			RequestDispatcher rd = request.getRequestDispatcher("listofusers.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("ERROR", "Wrong password");
			RequestDispatcher rd = request
					.getRequestDispatcher("admin.jsp");
			rd.include(request, response);
		}
	}

}