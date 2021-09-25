package com.pgr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pgr.beans.LoginBean;

public class LoginDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public LoginBean getPassword(String username) {
		LoginBean e = new LoginBean();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from userdetails where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setName(rs.getString(1));
				e.setPassword(rs.getString(2));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

}
