package com.pgr.bs;

import com.pgr.beans.LoginBean;
import com.pgr.dao.LoginDao;

public class ValidateLoginDetails {
	
	LoginDao dao;//data access object
	public boolean validate(String username, String password) {
		dao = new LoginDao();
		LoginBean lb = dao.getPassword(username);
		if (lb.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
