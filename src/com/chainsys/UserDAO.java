package com.chainsys;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.util.ConnectionUtil;

public class UserDAO {

	public int insertUser(User user) throws Exception {
		int rows = 0;
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

			rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted: " + rows);
			ConnectionUtil.close(connection, preparedStatement, null);

		} catch (SQLException e) {
			e.printStackTrace();
			// throw new Exception("Unable to insert book");
		}
		return rows;
	}

	public ArrayList<User> findAll() {
		ArrayList<User> list = new ArrayList<User>();
		try {

			Connection connection = ConnectionUtil.getConnection();
			String sql = "select accountnumber,name,email,password,dateofbirth,gender,city from bank_user order by name asc";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User user = new User();
				user.setAccountNumber(resultSet.getInt("accountnumber"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				// Date date = resultSet.getDate("dateofbirth");

				user.setDateOfBirth(resultSet.getDate("dateofbirth")
						.toLocalDate());

				user.setGender(resultSet.getString("gender"));
				user.setCity(resultSet.getString("city"));
				list.add(user);

			}

			ConnectionUtil.close(connection, preparedStatement, resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
			// throw new Exception("Unable to find book");
		}
		return list;
	}

	public boolean validator(User user) throws SQLException {
		boolean result = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select accountnumber,name,email,password,dateofbirth,gender,city from bank_user where email=? and password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getPassword());

		ResultSet resultSet = preparedStatement.executeQuery();
		result = resultSet.next();
		return result;

	}

	public User findByEmail(User user) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select accountnumber,name,email,dateofbirth,gender,city from bank_user where email=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, user.getEmail());
			ResultSet resultSet = preparedStatement.executeQuery();
			user = null;
			if (resultSet.next()) {
				user = new User();
				user.setAccountNumber(resultSet.getInt("accountnumber"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setDateOfBirth(resultSet.getDate("dateofbirth")
						.toLocalDate());
				user.setGender(resultSet.getString("gender"));
				user.setCity(resultSet.getString("city"));

			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
			// throw new Exception("Unable to find book");
		}
		return user;

	}

	public User viewBalance(User user) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select bankbalance from bank_user where pin=? and accountnumber=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, user.getPin());
		preparedStatement.setInt(2, user.getAccountNumber());
		ResultSet resultSet = preparedStatement.executeQuery();
		user = null;
		if (resultSet.next()) {
			user = new User();
			user.setBankBalance(resultSet.getInt("bankbalance"));

		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return user;

	}

	public int addBalance(User user) throws SQLException {
		int temp1, temp2;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select bankbalance from bank_user where pin=? and accountnumber=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, user.getPin());
		preparedStatement.setInt(2, user.getAccountNumber());
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			user.setBankBalance(resultSet.getInt("bankbalance"));

		}
		temp1 = user.getBankBalance();
		temp2 = user.getAmount();
		System.out.println(temp1);
		System.out.println(temp2);
		int depositAmount = temp1 + temp2;
		System.out.println(depositAmount);
		user.setBankBalance(depositAmount);
		System.out.println(user); // correct
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		Connection connection2 = ConnectionUtil.getConnection();
		
		String sql2 = "UPDATE bank_user SET bankbalance = ? WHERE pin = ? and accountnumber=?";
		PreparedStatement preparedStatement2 = connection2
				.prepareStatement(sql2);
		preparedStatement2.setInt(1, user.getBankBalance());
		preparedStatement2.setInt(2, user.getPin());
		preparedStatement2.setInt(3, user.getAccountNumber());
		int rows = preparedStatement2.executeUpdate();
		System.out.println("Rows updated: " + rows);

		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return rows;

	}
	
   public int withdrawBalance(User user) throws SQLException {
	   int temp1, temp2,rows = 0;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select bankbalance from bank_user where pin=? and accountnumber=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, user.getPin());
		preparedStatement.setInt(2, user.getAccountNumber());
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			user.setBankBalance(resultSet.getInt("bankbalance"));

		}
		temp1 = user.getBankBalance();
		temp2 = user.getAmount();
		System.out.println(temp1);
		System.out.println(temp2);
		if(temp1!=0)
		{
		if(temp1>temp2)
		{
		int withdrawAmount = temp1 - temp2;
		System.out.println(withdrawAmount);
		user.setBankBalance(withdrawAmount);
		System.out.println(user); // correct
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		Connection connection2 = ConnectionUtil.getConnection();
		
		String sql2 = "UPDATE bank_user SET bankbalance = ? WHERE pin = ? and accountnumber=?";
		PreparedStatement preparedStatement2 = connection2
				.prepareStatement(sql2);
		preparedStatement2.setInt(1, user.getBankBalance());
		preparedStatement2.setInt(2, user.getPin());
		preparedStatement2.setInt(3, user.getAccountNumber());
		rows = preparedStatement2.executeUpdate();
		System.out.println("Rows updated: " + rows);
		}
		else
		{
			rows=404;
		}
		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		
	  System.out.println(rows);
	   return rows;
   }
   
   public int changePassword(User user) throws SQLException {
	   
	   Connection connection = ConnectionUtil.getConnection();
		String sql = "update bank_user set password=? where pin=? and accountnumber=?";
		PreparedStatement preparedStatement = connection
				.prepareStatement(sql);
		preparedStatement.setString(1, user.getPassword());
		preparedStatement.setInt(2, user.getPin());
		preparedStatement.setInt(3, user.getAccountNumber());
		int rows = preparedStatement.executeUpdate();

		System.out.println("Rows updated: " + rows);

		ConnectionUtil.close(connection, preparedStatement, null);
		return rows;
	   
   }
}
