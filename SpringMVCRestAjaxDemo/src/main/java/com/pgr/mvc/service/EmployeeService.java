package com.pgr.mvc.service;

import java.util.List;

import com.pgr.mvc.dto.*;

public interface EmployeeService {
	
	public List<EmployeeDto> getListOfEmployee();

	public boolean addEmployee(EmployeeDto employee);

	public boolean updateEmployee(EmployeeDto employee);

	public boolean deleteEmployee(String empNo);
}
