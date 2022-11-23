package com.empcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empcrud.model.EmpEntity;
import com.empcrud.service.EmpServiceImpl;

@RestController
@RequestMapping("api/emp")
public class EmpController {
	
	@Autowired
	private EmpServiceImpl empimpl;

	
	@PostMapping("/save")
	public EmpEntity saveEmployee(@RequestBody EmpEntity emp) {
		return empimpl.saveEmployee(emp);
		
	}
	
	@GetMapping("/get")
	public List<EmpEntity> getEmployees(){
		return empimpl.getEmployees();
	}
	
	@GetMapping("/getbyid/{id}")
	public EmpEntity getEmpById(@PathVariable("id") int id) {
		return empimpl.getEmpById(id);
	}
	
	@PutMapping("/update/{id}")
	public EmpEntity updateEmpById(@RequestBody EmpEntity emp, @PathVariable("id") int id) {
		return empimpl.updateEmpById(emp, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmpById(@PathVariable int id) {
		return empimpl.deleteEmpById(id);
	}
}
