package com.anvs.mem.model;

public class Company {
	private int id;
	private String name;
	private int dinnerLimitInMinutes;
	private boolean limitCheck;
	private String broadcastEmail;
	
	public Company(String name, int dinnerLimitInMinutes, boolean limitCheck, String broadcastEmail) {
		this.name = name;
		this.dinnerLimitInMinutes = dinnerLimitInMinutes;
		this.limitCheck = limitCheck;
		this.broadcastEmail = broadcastEmail;
	}
	
	public Company(String name) {
		this.name = name;
		this.dinnerLimitInMinutes = 0;
		this.limitCheck = false;
		this.broadcastEmail = "";
	}

	public Company() {
		this.name = "";
		this.dinnerLimitInMinutes = 0;
		this.limitCheck = false;
		this.broadcastEmail = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDinnerLimitInMinutes() {
		return dinnerLimitInMinutes;
	}

	public void setDinnerLimitInMinutes(int dinnerLimitInMinutes) {
		this.dinnerLimitInMinutes = dinnerLimitInMinutes;
	}

	public boolean isLimitCheck() {
		return limitCheck;
	}

	public void setLimitCheck(boolean limitCheck) {
		this.limitCheck = limitCheck;
	}

	public String getBroadcastEmail() {
		return broadcastEmail;
	}

	public void setBroadcastEmail(String broadcastEmail) {
		this.broadcastEmail = broadcastEmail;
	}

	public int getId() {
		return id;
	}
	
	

}
