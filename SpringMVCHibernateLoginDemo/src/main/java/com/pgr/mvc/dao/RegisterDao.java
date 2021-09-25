package com.pgr.mvc.dao;

import java.util.List;

import com.pgr.mvc.entity.UserEntity;

public interface RegisterDao {

	public boolean registerUser(UserEntity userEntity);
	
	public List<UserEntity> getAllUsers();

	public UserEntity getUserDetailsById(int id);

	public void deleteUserByID(int id);

	public void updateUser(UserEntity entity);
	
}
