package com.pgr.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgr.mvc.dao.EmployeeDao;
import com.pgr.mvc.dto.EmployeeDto;
import com.pgr.mvc.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeDao employeeDao;

	public List<EmployeeDto> getListOfEmployee() {
		List<EmployeeDto> employeesList = new ArrayList<>();

		List<EmployeeEntity> employees = employeeDao.getListOfEmployee();
		for (EmployeeEntity entity : employees) {
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setId(entity.getId());
			employeeDto.setEmpNo(entity.getEmpNo());
			employeeDto.setFirstName(entity.getFirstName());
			employeeDto.setLastName(entity.getLastName());
			employeeDto.setDeptName(entity.getDeptName());
			employeeDto.setDesignation(entity.getDesignation());
			employeeDto.setSalary(entity.getSalary());
			employeeDto.setBranch(entity.getBranch());
			employeeDto.setCountry(entity.getCountry());
			employeeDto.setGender(entity.getGender());
			employeeDto.setPassword(entity.getPassword());
			employeeDto.setEmail(entity.getEmail());
			employeeDto.setPhone(entity.getPhone());
			employeeDto.setDop(entity.getDop());

			employeesList.add(employeeDto);

		}
		return employeesList;
	}

	public boolean addEmployee(EmployeeDto employeeDto) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setId(employeeDto.getId());
		employeeEntity.setEmpNo(employeeDto.getEmpNo());
		employeeEntity.setFirstName(employeeDto.getFirstName());
		employeeEntity.setLastName(employeeDto.getLastName());
		employeeEntity.setDeptName(employeeDto.getDeptName());
		employeeEntity.setDesignation(employeeDto.getDesignation());
		employeeEntity.setSalary(employeeDto.getSalary());
		employeeEntity.setBranch(employeeDto.getBranch());
		employeeEntity.setCountry(employeeDto.getCountry());
		employeeEntity.setGender(employeeDto.getGender());
		employeeEntity.setPassword(employeeDto.getPassword());
		employeeEntity.setEmail(employeeDto.getEmail());
		employeeEntity.setPhone(employeeDto.getPhone());
		employeeEntity.setDop(employeeDto.getDop());
		return employeeDao.addEmployee(employeeEntity);
	}

	public boolean updateEmployee(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setId(employeeDto.getId());
		employeeEntity.setEmpNo(employeeDto.getEmpNo());
		employeeEntity.setFirstName(employeeDto.getFirstName());
		employeeEntity.setLastName(employeeDto.getLastName());
		employeeEntity.setDeptName(employeeDto.getDeptName());
		employeeEntity.setDesignation(employeeDto.getDesignation());
		employeeEntity.setSalary(employeeDto.getSalary());
		employeeEntity.setBranch(employeeDto.getBranch());
		employeeEntity.setCountry(employeeDto.getCountry());
		employeeEntity.setGender(employeeDto.getGender());
		employeeEntity.setPassword(employeeDto.getPassword());
		employeeEntity.setEmail(employeeDto.getEmail());
		employeeEntity.setPhone(employeeDto.getPhone());
		employeeEntity.setDop(employeeDto.getDop());
		return employeeDao.updateEmployee(employeeEntity);
	}

	public boolean deleteEmployee(String empNo) {
		return employeeDao.deleteEmployee(empNo);
	}

}