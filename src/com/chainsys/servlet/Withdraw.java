package com.chainsys.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.UserDAO;
import com.chainsys.model.User;

@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int pin = Integer.parseInt(request.getParameter("pin"));
		float amount = Float.parseFloat(request.getParameter("amount"));
		int accountnumber = Integer.parseInt(request.getParameter("acno"));
		User user = new User();
		user.setPin(pin);
		user.setAmount(amount);
		user.setAccountNumber(accountnumber);
		UserDAO dao = new UserDAO();
		int rows;
		rows = dao.withdraw(user);
		if (rows == 1) {
			request.setAttribute("USER", user);
			request.setAttribute("MESSAGE",
					"*Transaction completed successfully");
			RequestDispatcher rd = request
					.getRequestDispatcher("viewbalance.jsp");
			rd.forward(request, response);
		} else if (rows == 100) {
			request.setAttribute("ERROR", "*Insufficient Balance");
			RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
			rd.forward(request, response);
		} else if (rows == 0) {
			request.setAttribute("ERROR", "*Invalid pin or account number");
			RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
			rd.include(request, response);
		}
	}
}
