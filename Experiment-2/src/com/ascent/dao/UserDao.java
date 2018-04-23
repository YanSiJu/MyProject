package com.ascent.dao;

import java.sql.Connection;
import com.ascent.entity.User;

public class UserDao extends DataAccess {

	public User login(String userName, String pwd) {
		Class<User> clazz = User.class;
		String sql = "select * from user where name = ? and password = ?";
		Connection conn = this.getConnection();
		User user = this.getRecord(clazz, sql, conn, userName, pwd);
		return user;
	}

}
