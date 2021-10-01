package com.pgr.mvc.service;

import java.util.List;

import com.pgr.mvc.dto.User;

public interface RegisterService {

	public boolean registerUser(User user);

	public List<User> getAllUsers();

	public User getUserDetailsById(int id);

	public void deleteUserByID(int id);

	public void updateUser(User user);
}
