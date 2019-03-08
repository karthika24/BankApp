package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.UserDAO;
import com.chainsys.model.User;

/**
 * Servlet implementation class HistoryServlet
 */
@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pin=Integer.parseInt(request.getParameter("pin"));
	     int accountnumber=Integer.parseInt(request.getParameter("acno"));
	     System.out.println(pin);
	     User user = new User();
	     user.setPin(pin);
	     user.setAccountNumber(accountnumber);
	     UserDAO dao = new UserDAO();
	}

}
