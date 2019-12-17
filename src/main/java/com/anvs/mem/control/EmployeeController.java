package com.anvs.mem.control;

public interface EmployeeController {
	/*
	 * На уровне модели где-то хранится список актуальной выборки из БД
	 * Контроллер получает команды от UI и приказывает модели сохранить/получить/создать и пр. данные
	 * 
	 */
	
	String getFullListAsJSON();
	
}
