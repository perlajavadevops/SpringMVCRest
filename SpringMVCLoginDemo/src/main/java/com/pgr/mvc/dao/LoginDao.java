package com.pgr.mvc.dao;

import java.util.List;

import com.pgr.mvc.bean.LoginBean;

public interface LoginDao {

	public List<LoginBean> validateUser(String userName, String password);

}
