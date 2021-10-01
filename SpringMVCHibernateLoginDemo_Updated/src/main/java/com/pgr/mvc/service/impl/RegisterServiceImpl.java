package com.pgr.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgr.mvc.dao.RegisterDao;
import com.pgr.mvc.dto.User;
import com.pgr.mvc.entity.UserEntity;
import com.pgr.mvc.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDao registerDao;

	@Override
	public boolean registerUser(User user) {
		UserEntity entity = new UserEntity();
		entity.setCountry(user.getCountry());
		entity.setEmail(user.getEmail());
		entity.setId(user.getId());
		entity.setName(user.getName());
		entity.setPassword(user.getPassword());
		entity.setSex(user.getSex());
		return registerDao.registerUser(entity);
	}

	@Override
	public List<User> getAllUsers() {

		List<User> users = new ArrayList<>();

		List<UserEntity> entities = registerDao.getAllUsers();
		for (UserEntity entity : entities) {
			User user = new User();
			user.setCountry(entity.getCountry());
			user.setEmail(entity.getEmail());
			user.setId(entity.getId());
			user.setName(entity.getName());
			user.setPassword(entity.getPassword());
			user.setSex(entity.getSex());

			users.add(user);

		}
		return users;
	}

	@Override
	public User getUserDetailsById(int id) {
		UserEntity entity = registerDao.getUserDetailsById(id);
		User user = new User();
		user.setCountry(entity.getCountry());
		user.setEmail(entity.getEmail());
		user.setId(entity.getId());
		user.setName(entity.getName());
		user.setPassword(entity.getPassword());
		user.setSex(entity.getSex());

		return user;
	}

	@Override
	public void deleteUserByID(int id) {
		registerDao.deleteUserByID(id);
		
	}

	@Override
	public void updateUser(User user) {
		UserEntity entity = new UserEntity();
		entity.setCountry(user.getCountry());
		entity.setEmail(user.getEmail());
		entity.setId(user.getId());
		entity.setName(user.getName());
		entity.setPassword(user.getPassword());
		entity.setSex(user.getSex());
		
		registerDao.updateUser(entity);
	}

}
