package com.pgr.mvc.service;

import com.pgr.mvc.dto.LoginBean;

public interface LoginService {

	public boolean validateUser(String userName, String password);

	public void resetPassword(String userName);

	public boolean registerForm(LoginBean userRegisterForm);

}
