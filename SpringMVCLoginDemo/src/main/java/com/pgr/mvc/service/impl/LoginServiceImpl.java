package com.pgr.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgr.mvc.bean.LoginBean;
import com.pgr.mvc.dao.LoginDao;
import com.pgr.mvc.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao dao;


	public boolean validateUser(String userName, String password) {
		
		boolean valid = false;
		
		List<LoginBean> loginBeans = dao.validateUser(userName, password);
		for(LoginBean bean: loginBeans) {
			if(userName.equalsIgnoreCase(bean.getUserName())) {
				valid = true;
			}else {
				valid = false;
			}
		}
		
		return valid;
	}

}
