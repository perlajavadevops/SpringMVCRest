package com.pgr.mvc.dao;

import java.util.List;

import com.pgr.mvc.entity.EmployeeEntity;

public interface EmployeeDao {
	public List<EmployeeEntity> getListOfEmployee();

	public boolean addEmployee(EmployeeEntity employee);

	public boolean updateEmployee(EmployeeEntity employee);

	public boolean deleteEmployee(String empNo);
}
