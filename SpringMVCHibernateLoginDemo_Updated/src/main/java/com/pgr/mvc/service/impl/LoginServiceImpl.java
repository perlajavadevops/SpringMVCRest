package com.pgr.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgr.mvc.dao.LoginDao;
import com.pgr.mvc.dto.LoginBean;
import com.pgr.mvc.entity.LoginEntity;
import com.pgr.mvc.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao dao;


	public boolean validateUser(String userName, String password) {
		
		boolean valid = false;
		
		List<LoginEntity> loginEntities = dao.validateUser(userName, password);
		LoginBean loginBean = new LoginBean();
		for(LoginEntity entity: loginEntities) {
			loginBean.setPassword(entity.getPassword());
			loginBean.setUserName(entity.getUserName());
		}
		
		if(userName.equalsIgnoreCase(loginBean.getUserName()) && password.equalsIgnoreCase(loginBean.getPassword())) {
			valid = true;
		}else {
			valid = false;
		}

		return valid;
	}


	@Override
	public void resetPassword(String userName) {
		dao.resetPassword(userName);
	}


	@Override
	public boolean registerForm(LoginBean userRegisterForm) {
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setPassword(userRegisterForm.getPassword());
		loginEntity.setUserName(userRegisterForm.getUserName());
		return dao.registerForm(loginEntity);
	}

}
