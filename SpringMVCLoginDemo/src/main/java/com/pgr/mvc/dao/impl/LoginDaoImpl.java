package com.pgr.mvc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pgr.mvc.bean.LoginBean;
import com.pgr.mvc.dao.LoginDao;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
*/


	public List<LoginBean> validateUser(final String userName, String password) {

		String selectQuery = "select * from userdetails where username = '"+userName+"'";//
		//select * from userdetails where username = 'red'
		
		return jdbcTemplate.query(selectQuery, new ResultSetExtractor<List<LoginBean>>() {
			
			public List<LoginBean> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				List<LoginBean> loginBeans = new ArrayList<LoginBean>();

				while (rs.next()) {
					LoginBean loginBean = new LoginBean();
					loginBean.setUserName(rs.getString(1));
					loginBean.setPassword(rs.getString(2));
					loginBeans.add(loginBean);
				}

				return loginBeans;
			}

		});
		
	}

}
