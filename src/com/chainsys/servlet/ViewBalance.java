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
 * Servlet implementation class ViewBalance
 */
@WebServlet("/ViewBalance")
public class ViewBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int pin=Integer.parseInt(request.getParameter("pin"));
     int accountnumber=Integer.parseInt(request.getParameter("acno"));
     System.out.println(pin);
     User user = new User();
     user.setPin(pin);
     user.setAccountNumber(accountnumber);
     UserDAO dao = new UserDAO();
     try {
    	 //user=new User();
		user=dao.viewBalance(user);
		System.out.println(user);
		if(user!=null){
		request.setAttribute("USER", user);
		RequestDispatcher rd = request.getRequestDispatcher("balance.jsp");
		rd.forward(request, response);
		}
		else {
			request.setAttribute("MESSAGE", "*Invalid pin or account number");
			RequestDispatcher rd = request.getRequestDispatcher("viewbalance.jsp");
			rd.forward(request, response);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
