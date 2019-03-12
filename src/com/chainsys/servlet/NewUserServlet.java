package com.chainsys.servlet;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.UserDAO;
import com.chainsys.model.User;

@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		int pin = Integer.parseInt(request.getParameter("pin"));
		LocalDate dateofbirth = LocalDate.parse(request
				.getParameter("dateofbirth"));
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.setGender(gender);
		user.setCity(city);
		user.setDateOfBirth(dateofbirth);
		user.setPin(pin);
		UserDAO dao = new UserDAO();
		boolean result = dao.insertUser(user);
		if (result) {
			RequestDispatcher rd = request.getRequestDispatcher("newlogin.jsp");
			rd.forward(request, response);
		}
	}
}
