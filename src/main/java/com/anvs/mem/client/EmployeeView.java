package com.anvs.mem.client;

public class EmployeeView {

	public EmployeeView() {
	
	}

	public EmployeeView(EmployeeData viewData) {
		this.showData(viewData);
	}
	
	public void showData(EmployeeData data) {
		System.out.println(data.toString());		
	}
	
	public EmployeeData createNewInstance(String fio
											, Integer companyId
											, Integer positionId
											, String citizenship) {
		EmployeeData newInstance = new EmployeeData();
		newInstance.setFio(fio);
		newInstance.setCompanyId(companyId);
		newInstance.setPositionId(positionId);
		newInstance.setCitizenship(citizenship);
		
		return newInstance;
	}
	
	public void saveOrUpdateCommand() {
		// TODO
	}

}
