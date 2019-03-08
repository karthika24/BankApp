package com.chainsys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import com.chainsys.model.Transactions;
import com.chainsys.model.User;
import com.chainsys.util.ConnectionUtil;

public class TransactionsDAO {
	public void insert() {
		User user = new User();
		UserDAO dao = new UserDAO();
		Transactions transactions = new Transactions();
		boolean result;
		try {
			Connection connection = ConnectionUtil.getConnection();
			result=dao.deposit(user);
			if (result == true) {
				String sql = "insert into transactions(accountnumber,transaction_id,credit,transaction_date) values(?,transaction_id_seq.nextval,?,?)";
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql);
				preparedStatement.setInt(1,transactions.getUser().getAccountNumber());
				preparedStatement.setString(2,transactions.getCredit());
				preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
				int rows = preparedStatement.executeUpdate();
				System.out.println("Rows inserted: " + rows);
				ConnectionUtil.close(connection, preparedStatement, null);
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
