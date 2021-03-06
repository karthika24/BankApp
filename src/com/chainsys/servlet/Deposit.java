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

@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int pin = Integer.parseInt(request.getParameter("pin"));
		int accountnumber = Integer.parseInt(request.getParameter("acno"));
		float amount = Float.parseFloat(request.getParameter("amount"));
		User user = new User();
		user.setPin(pin);
		user.setAccountNumber(accountnumber);
		user.setAmount(amount);
		UserDAO dao = new UserDAO();
		boolean result;
		result = dao.deposit(user);
		if (result) {
			request.setAttribute("USER", user);
			request.setAttribute("MESSAGE",
					"*Transaction completed successfully");
			RequestDispatcher rd = request
					.getRequestDispatcher("viewbalance.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("ERROR", "*Invalid pin or account number");
			RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
			rd.forward(request, response);
		}
	}
}
