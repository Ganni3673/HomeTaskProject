package com.org.SpringDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.SpringDemo.json.EmployeeJson;
import com.org.SpringDemo.json.MessageJson;
import com.org.SpringDemo.model.EmployeeModel;
import com.org.SpringDemo.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/api/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("empo")
	public ResponseEntity<MessageJson> addemp(@RequestBody EmployeeJson employeeJson){
		MessageJson mess=new MessageJson();
		mess=employeeService.addEmployee(employeeJson);
	
		
		if(mess.getStatuscode()==400) {
			return new ResponseEntity<MessageJson>(mess,HttpStatus.BAD_REQUEST);
			
		}else {
			return new ResponseEntity<MessageJson>(mess,HttpStatus.OK);
		}		
        	
	}

	
	
	//=============================================================================
	
	   @GetMapping("/getemployee")
	    public List<EmployeeModel> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }
	
}


//=======================================================================================
