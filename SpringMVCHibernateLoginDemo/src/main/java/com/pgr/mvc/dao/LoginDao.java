package com.pgr.mvc.dao;

import java.util.List;

import com.pgr.mvc.entity.LoginEntity;

public interface LoginDao {

	public List<LoginEntity> validateUser(String userName, String password);

}
