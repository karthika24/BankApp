package com.chainsys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.Transactions;
import com.chainsys.util.ConnectionUtil;

public class TransactionsDAO {
	public void insertDeposit(Transactions transactions) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into transactions(accountnumber,transaction_id,status,amount,transaction_date) values(?,transaction_id_seq.nextval,?,?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, transactions.getAccountNumber());
			preparedStatement.setString(2, "Credit");
			preparedStatement.setFloat(3, transactions.getAmount());
			preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted in transaction: " + rows);
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertWithdraw(Transactions transactions) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into transactions(accountnumber,transaction_id,status,amount,transaction_date) values(?,transaction_id_seq.nextval,?,?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, transactions.getAccountNumber());
			preparedStatement.setString(2, "Debit");
			preparedStatement.setFloat(3, transactions.getAmount());
			preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted in transaction: " + rows);
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Transactions> findByAccountNumber(Transactions transactions) {
		List<Transactions> list = new ArrayList<Transactions>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select transaction_id,status,amount,transaction_date from transactions where accountnumber=? order by transaction_id";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, transactions.getAccountNumber());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				transactions = new Transactions();
				transactions.setId(resultSet.getInt("transaction_id"));
				transactions.setStatus(resultSet.getString("status"));
				transactions.setAmount(resultSet.getFloat("amount"));
				transactions.setTransactionDate(resultSet.getDate(
						"transaction_date").toLocalDate());
				list.add(transactions);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return list;
	}
}
