package com.pgr.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pgr.mvc.entity.EmployeeEntity;


@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<EmployeeEntity> getListOfEmployee() {
		return hibernateTemplate.execute(new HibernateCallback<List<EmployeeEntity>>() {

			@Override
			public List<EmployeeEntity> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from EmployeeEntity");// select * from emp;
				@SuppressWarnings("unchecked")
				List<EmployeeEntity> list = query.list();
				return list;
			}
		});
	}

	public boolean addEmployee(EmployeeEntity employee) {

		if (employee != null) {
			hibernateTemplate.save(employee);
			return true;
		} else {
			return false;
		}
	}

	public boolean updateEmployee(EmployeeEntity employee) {
		if (employee != null) {
			hibernateTemplate.update(employee);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteEmployee(String empNo) {
		Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(EmployeeEntity.class);
		criteria.add(Restrictions.eq("empNo", empNo));
		EmployeeEntity employee = (EmployeeEntity) criteria.uniqueResult();		
		if (employee != null) {
			hibernateTemplate.delete(employee);
			return true;
		}else {		
			return false;
		}
	}

}
