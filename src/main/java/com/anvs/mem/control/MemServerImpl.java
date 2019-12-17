package com.anvs.mem.control;

import java.util.List;

import com.anvs.mem.client.EmployeeData;
import com.anvs.mem.dao.CompanyDAOImpl;
import com.anvs.mem.dao.DAO;
import com.anvs.mem.dao.EmployeeDAOImpl;
import com.anvs.mem.dao.HibernateDAO;
import com.anvs.mem.dao.PositionDAOImpl;
import com.anvs.mem.model.Company;
import com.anvs.mem.model.Employee;
import com.anvs.mem.model.Position;
import com.anvs.mem.shared.EntityFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class MemServerImpl implements MemServer {
	//private EmployeeController empCrtl;
	
	public MemServerImpl () {
		//empCrtl = new EmployeeControllerImpl();
	}
	
	@Override
	public String getFilteredEntityListAsJSON (String filterJson) throws JsonMappingException, JsonProcessingException {
//		- build filter instance
		EntityFilter filter;
		ObjectMapper parser = new ObjectMapper();
		TypeFactory typeFactory = parser.getTypeFactory();
        CollectionType collectionType = typeFactory.constructCollectionType(
                                            List.class, EntityFilter.class);
		filter = parser.readValue(filterJson, collectionType);
//		- define entity class
		DAO c = getDAOAccessor(filter);
//		- create suitable DAO instance

		
//		- build example instance from filterJson string
//		- get entity list, filtered by example 
//		- wrap result with json
//  	
		
		
		String jsonSrt = null; 
		return jsonSrt;
	}
	
	@Override
	public String getSingleEntinyAsJSON(String keyJson) {
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	private DAO getDAOAccessor(EntityFilter filter) {
		DAO accessor = null;
		switch (filter.getEntityClass()) {
		case POSITION:
			accessor = new PositionDAOImpl();
			break;
		case COMPANY:
			accessor = new CompanyDAOImpl();
			break;
		case EMPLOYEE:
			accessor = new EmployeeDAOImpl();
			break;
		}
		return accessor;
	}
}
