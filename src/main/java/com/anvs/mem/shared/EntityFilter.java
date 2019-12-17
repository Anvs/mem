package com.anvs.mem.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityFilter {
	
	public enum EntityClass {
		POSITION,
		COMPANY,
		EMPLOYEE
	};
	
	@JsonProperty("class")
	EntityClass entityClass;
	
	@JsonProperty("example")
	Object example;

	public EntityClass getEntityClass() {
		return entityClass;
	}

	public void  setEntityClass(EntityClass entityClass) {
		this.entityClass = entityClass;
	}

	public Object getExample() {
		return example;
	}

	public void setExample(Object example) {
		this.example = example;
	}
}
