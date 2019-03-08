package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.UserDAO;
import com.chainsys.model.User;

/**
 * Servlet implementation class ResetServlet
 */
@WebServlet("/ResetServlet")
public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //String oldpassword=request.getParameter("oldpassword");
     String newpassword=request.getParameter("newpassword");
     int pin=Integer.parseInt(request.getParameter("pin"));
     int accountnumber=Integer.parseInt(request.getParameter("acno"));
     User user = new User();
     user.setPassword(newpassword);
     user.setPin(pin);
     user.setAccountNumber(accountnumber);;
     UserDAO dao = new UserDAO();
     try {
		int result=dao.changePassword(user);
		if(result>0){
			
			RequestDispatcher rd = request.getRequestDispatcher("newlogin.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("ERROR", "*Invalid pin or account number");
			RequestDispatcher rd = request.getRequestDispatcher("reset.jsp");
			rd.forward(request, response);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
