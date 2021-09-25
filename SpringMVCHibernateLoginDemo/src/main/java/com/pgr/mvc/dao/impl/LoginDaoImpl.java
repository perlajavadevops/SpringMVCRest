package com.pgr.mvc.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pgr.mvc.dao.LoginDao;
import com.pgr.mvc.entity.LoginEntity;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	

	@SuppressWarnings("unchecked")
	public List<LoginEntity> validateUser(final String userName, String password) {

		return (List<LoginEntity>) hibernateTemplate.findByCriteria(
		        DetachedCriteria.forClass(LoginEntity.class)
		        .add(Restrictions.eq("userName", userName)));
		
	}

}
