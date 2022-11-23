package com.empcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empcrud.model.EmpEntity;
import com.empcrud.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpRepository emprepo;
	
	@Override
	public List<EmpEntity> getEmployees() {
		return emprepo.findAll();
	}

	@Override
	public EmpEntity saveEmployee(EmpEntity emp) {
		return emprepo.save(emp);
	}

	@Override
	public EmpEntity getEmpById(int id) {
		Optional<EmpEntity> emp = emprepo.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		else return null;
	}

	@Override
	public EmpEntity updateEmpById(EmpEntity emp, int id) {
		EmpEntity existingEmp = emprepo.findById(id).orElseThrow(null);
		existingEmp.setId(emp.getId());
		existingEmp.setName(emp.getName());
		existingEmp.setEmail(emp.getEmail());
		EmpEntity updatedEmployee = emprepo.save(existingEmp);
		return existingEmp;  
	}
	
	public String deleteEmpById(int id) {
		emprepo.deleteById(id);
		return "Employee Deleted with id "+id;
	}
}