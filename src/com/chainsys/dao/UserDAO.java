package com.chainsys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.Transactions;
import com.chainsys.model.User;
import com.chainsys.util.ConnectionUtil;

public class UserDAO {
	TransactionsDAO dao = new TransactionsDAO();

	public boolean insertUser(User user) {
		boolean success = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "insert into bank_user(accountnumber,name,email,password,dateofbirth,gender,city,pin) values(bank_user_acno_seq.nextval,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setDate(4, Date.valueOf(user.getDateOfBirth()));
			preparedStatement.setString(5, user.getGender());
			preparedStatement.setString(6, user.getCity());
			preparedStatement.setInt(7, user.getPin());
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted: " + rows);
			ConnectionUtil.close(connection, preparedStatement, null);
			if (rows > 0) {
				success = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			success = false;
		}
		return success;
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select accountnumber,name,email,password,dateofbirth,gender,city from bank_user order by name asc";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setAccountNumber(resultSet.getInt("accountnumber"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setDateOfBirth(resultSet.getDate("dateofbirth")
						.toLocalDate());
				user.setGender(resultSet.getString("gender"));
				user.setCity(resultSet.getString("city"));
				list.add(user);
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean validator(User user) {
		boolean result = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select accountnumber,name,email,password,dateofbirth,gender,city from bank_user where email=? and password=?";
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			result = resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public User findByEmail(final User user) {
		User user1 = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select accountnumber,name,email,dateofbirth,gender,city from bank_user where email=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, user.getEmail());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user1 = new User();
				user1.setAccountNumber(resultSet.getInt("accountnumber"));
				user1.setName(resultSet.getString("name"));
				user1.setEmail(resultSet.getString("email"));
				user1.setDateOfBirth(resultSet.getDate("dateofbirth")
						.toLocalDate());
				user1.setGender(resultSet.getString("gender"));
				user1.setCity(resultSet.getString("city"));
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user1;
	}

	public User viewBalance(User user) {
		User user1 = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select bankbalance from bank_user where pin=? and accountnumber=?";
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user.getPin());
			preparedStatement.setInt(2, user.getAccountNumber());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user1 = new User();
				user1.setBankBalance(resultSet.getInt("bankbalance"));
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user1;
	}

	public boolean deposit(User user) {
		Transactions transactions = null;
		boolean result = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql2 = "UPDATE bank_user SET bankbalance = bankbalance+? WHERE pin = ? and accountnumber=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql2);
			preparedStatement.setFloat(1, user.getAmount());
			preparedStatement.setInt(2, user.getPin());
			preparedStatement.setInt(3, user.getAccountNumber());
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows updated: " + rows);
			ConnectionUtil.close(connection, preparedStatement, null);
			if (rows > 0) {
				result = true;
				transactions = new Transactions();
				transactions.setAccountNumber(user.getAccountNumber());
				transactions.setAmount(user.getAmount());
				dao.insertDeposit(transactions);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int withdraw(User user) {
		Transactions transactions = null;
		int rows = 0;
		float initial, newbalance;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select bankbalance from bank_user where pin=? and accountnumber=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, user.getPin());
			preparedStatement.setInt(2, user.getAccountNumber());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user.setBankBalance(resultSet.getInt("bankbalance"));
			}
			initial = user.getBankBalance();
			newbalance = user.getAmount();
			if (initial != 0) {
				if (initial > newbalance) {
					float withdrawAmount = initial - newbalance;
					user.setBankBalance(withdrawAmount);
					ConnectionUtil.close(connection, preparedStatement,
							resultSet);
					Connection connection2 = ConnectionUtil.getConnection();
					String sql2 = "UPDATE bank_user SET bankbalance = ? WHERE pin = ? and accountnumber=?";
					PreparedStatement preparedStatement2 = connection2
							.prepareStatement(sql2);
					preparedStatement2.setFloat(1, user.getBankBalance());
					preparedStatement2.setInt(2, user.getPin());
					preparedStatement2.setInt(3, user.getAccountNumber());
					rows = preparedStatement2.executeUpdate();
					System.out.println("Rows updated: " + rows);
					if (rows > 0) {
						transactions = new Transactions();
						transactions.setAccountNumber(user.getAccountNumber());
						transactions.setAmount(user.getAmount());
						dao.insertWithdraw(transactions);
					}
				} else {
					rows = 100;
				}
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	public int changePassword(User user) {
		int rows = 0;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "update bank_user set password=? where pin=? and accountnumber=?";
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setInt(2, user.getPin());
			preparedStatement.setInt(3, user.getAccountNumber());
			rows = preparedStatement.executeUpdate();
			System.out.println("Rows updated: " + rows);
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
}
