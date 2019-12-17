package com.anvs.mem.client;

import java.util.List;

public class EmployeeListView {

	public EmployeeListView(List<EmployeeData> listData) {
		// TODO Auto-generated constructor stub
		showData(listData);
	}

//	public EmployeeListView() {
//		// TODO Auto-generated constructor stub
//	}
	
	public void showData(List<EmployeeData> listData) {
		for (EmployeeData row : listData) {
			System.out.println(row.toString());
			System.out.println("--------------------------------------------------------------");
		}
	}
	
	public void editCommand(EmployeeData selectedItem) {
		
	}
	
	public void createCommand() {
		
	}

}
