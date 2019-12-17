package com.anvs.mem.client;

import java.util.Arrays;
import java.util.List;

import com.anvs.mem.control.MemServer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class ClientHandler {
	
	private EmployeeListView employeeList;
	private EmployeeView employeeCard;
	private MemServer server;
	
	public ClientHandler(MemServer server) {
		this.server = server;
	}
	
	public EmployeeData  parseJson(String jsonStr) throws JsonMappingException, JsonProcessingException {
		EmployeeData emp;
		ObjectMapper parser = new ObjectMapper();
		TypeFactory typeFactory = parser.getTypeFactory();
        CollectionType collectionType = typeFactory.constructCollectionType(
                                            List.class, EmployeeData.class);
		emp = parser.readValue(jsonStr, collectionType);
		return emp;
	}
	
	public List<EmployeeData> getEmployees() throws JsonMappingException, JsonProcessingException {
		List<EmployeeData> empList = null;
		ObjectMapper jsonParser = new ObjectMapper();
		//empList =  Arrays.asList(jsonParser.readValue(server.getFilteredEntityListAsJSON(null);
		return empList;
	}
	
	public void openEmpListView() throws JsonMappingException, JsonProcessingException {
		employeeList = new EmployeeListView(getEmployees());
		//employeeList.showData(listData);
	}
}

