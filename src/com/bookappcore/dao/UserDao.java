package com.bookappcore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bookappcore.user.User;
import com.bookappcore.util.Connectionutil;

public class UserDao {
	public void register(User user) throws Exception {
		Connection connection = Connectionutil.getConnection();
		String sql = "insert into users values(?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user.getName());
		pst.setString(2, user.getEmail());
		pst.setString(3, user.getPassword());
		pst.executeUpdate();

	}

	public boolean login(User user) throws Exception {
		Connection connection = Connectionutil.getConnection();
		String sql = "select name from users where email=? and password=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user.getEmail());
		pst.setString(2, user.getPassword());
		ResultSet rs = pst.executeQuery();
		boolean count = false;

		if (rs.next())
			count = true;

		return count;
	}
}