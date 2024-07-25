package com.org.SpringDemo.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.SpringDemo.json.EmployeeJson;
import com.org.SpringDemo.json.MessageJson;
import com.org.SpringDemo.model.EmployeeModel;
import com.org.SpringDemo.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	public MessageJson addEmployee(EmployeeJson employeeJson) {
		MessageJson mess=new MessageJson();
		
		Optional<EmployeeModel> mod=employeeRepo.findByIdEmp(employeeJson.getId());
		
		if(mod.isPresent()) {
			mess.setMessage("already data is prasent");
			mess.setStatuscode(400);
		}else {
			EmployeeModel model=new EmployeeModel();
			model.setId(employeeJson.getId());
			model.setName(employeeJson.getName());
			model.setEmail(employeeJson.getEmail());
			model.setDesignation(employeeJson.getDesignation());
			model.setCtc(employeeJson.getCtc());
			
			employeeRepo.save(model);
			mess.setMessage("employee data is added succefully");
			mess.setStatuscode(200);
		}
		

		
		return mess;
	}
//===========================================================================
	//get all employee list
	public List<EmployeeModel> getAllEmployees() {
		List<EmployeeModel> list=new ArrayList<EmployeeModel>();
		Collection<EmployeeModel> mod=employeeRepo.findAll();
		
		for(EmployeeModel empd:mod) {
			list.add(empd);
			
			
		}
		
		return list;
	}

}
