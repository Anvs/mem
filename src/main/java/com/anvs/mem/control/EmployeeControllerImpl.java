package com.anvs.mem.control;

import java.util.List;

import com.anvs.mem.dao.EmployeeDAOImpl;
import com.anvs.mem.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeControllerImpl implements EmployeeController {
	
	private ObjectMapper mapper;
	private List<Employee> retrievedList;
	private EmployeeDAOImpl empDaoInstance;
	
	public EmployeeControllerImpl() {
		// TODO Auto-generated constructor stub
		this.empDaoInstance = new EmployeeDAOImpl();
		mapper = new ObjectMapper();
	}
	
//	public String getMappedList() {
//		try {
//			return mapper.writeValueAsString();
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//			return e.getMessage();
//		}
//	} 
	
	public String getFullListAsJSON() {
		if (retrievedList == null || retrievedList.size() == 0) {
			retrievedList = empDaoInstance.findAll();
		}
		
		try {
			return mapper.writeValueAsString(retrievedList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	

}
