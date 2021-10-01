package com.pgr.mvc.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pgr.mvc.dao.RegisterDao;
import com.pgr.mvc.entity.UserEntity;

@Repository
@Transactional
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean registerUser(UserEntity userEntity) {

		if (hibernateTemplate.save(userEntity) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return hibernateTemplate.execute(new HibernateCallback<List<UserEntity>>() {

			@Override
			public List<UserEntity> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from UserEntity");// select * from emp;
				List<UserEntity> list = query.list();
				return list;
			}
		});
	}

	@Override
	public UserEntity getUserDetailsById(int id) {
		UserEntity userEntity = hibernateTemplate.get(UserEntity.class, id);
		return userEntity;
	}

	@Override
	public void deleteUserByID(int id) {
		UserEntity userEntity = hibernateTemplate.get(UserEntity.class, id);
		hibernateTemplate.delete(userEntity);
	}

	@Override
	public void updateUser(UserEntity entity) {
		hibernateTemplate.update(entity);
	}

}
