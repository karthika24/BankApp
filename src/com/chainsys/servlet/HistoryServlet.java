package com.chainsys.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.TransactionsDAO;
import com.chainsys.model.Transactions;

/**
 * Servlet implementation class HistoryServlet
 */
@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int accountnumber = Integer.parseInt(request.getParameter("acno"));
		Transactions transactions = new Transactions();
		transactions.setAccountNumber(accountnumber);
		TransactionsDAO dao = new TransactionsDAO();
		List<Transactions> list = dao.findByAccountNumber(transactions);
		if (list.isEmpty()) {
			request.setAttribute("MESSAGE", "*Invalid Account number");
			RequestDispatcher rd = request.getRequestDispatcher("history.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("TRANSACTIONS", list);
			RequestDispatcher rd = request
					.getRequestDispatcher("transactionlist.jsp");
			rd.forward(request, response);
		}
	}
}
