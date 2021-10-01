package com.pgr.mvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pgr.mvc.dao.LoginDao;
import com.pgr.mvc.entity.LoginEntity;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public List<LoginEntity> validateUser(final String userName, String password) {

		return (List<LoginEntity>) hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(LoginEntity.class).add(Restrictions.eq("userName", userName)));

	}

	@Override
	public void resetPassword(String userName) {

		Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(LoginEntity.class);
		criteria.add(Restrictions.eq("userName", userName));
		LoginEntity loginEntity = (LoginEntity) criteria.uniqueResult();

		/*
		 * LoginEntity loginEntity = (LoginEntity) hibernateTemplate.findByCriteria(
		 * DetachedCriteria.forClass(LoginEntity.class).add(Restrictions.eq("userName",
		 * userName)));
		 */

		loginEntity.setPassword("password");

		hibernateTemplate.update(loginEntity);
	}

	@Override
	public boolean registerForm(LoginEntity loginEntity) {
		if (hibernateTemplate.save(loginEntity) != null) {
			return true;
		} else {
			return false;
		}
	}
}
