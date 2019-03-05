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

/**
 * Servlet implementation class Withdraw
 */
@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int pin=Integer.parseInt(request.getParameter("pin"));
     int amount=Integer.parseInt(request.getParameter("amount"));
     int accountnumber=Integer.parseInt(request.getParameter("acno"));
     User user = new User();
     user.setPin(pin);
     user.setAmount(amount);
     user.setAccountNumber(accountnumber);
     UserDAO dao = new UserDAO();
     System.out.println(user);
     try {
		int rows=dao.withdrawBalance(user);
		System.out.println(rows);
		if(rows==1) {
			request.setAttribute("USER", user);
			RequestDispatcher rd = request.getRequestDispatcher("redirect.html");
			rd.forward(request, response);
		}
		else if(rows==404)
		{
			RequestDispatcher rd = request.getRequestDispatcher("success.html");
			rd.forward(request, response);
		}
		else if(rows==0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("invalid2.html");
			rd.forward(request, response);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	}

}
