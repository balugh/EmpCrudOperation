package com.empcrud.service;

import java.util.List;

import com.empcrud.model.EmpEntity;

public interface EmpService {

	List<EmpEntity> getEmployees();
	EmpEntity saveEmployee(EmpEntity emp);
	EmpEntity getEmpById(int id);
	EmpEntity updateEmpById(EmpEntity emp, int id);
}
