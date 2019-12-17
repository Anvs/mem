package com.anvs.mem.control;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface MemServer {

	String getFilteredEntityListAsJSON(String filterJson) throws JsonMappingException, JsonProcessingException;

	String getSingleEntinyAsJSON(String keyJson);

}