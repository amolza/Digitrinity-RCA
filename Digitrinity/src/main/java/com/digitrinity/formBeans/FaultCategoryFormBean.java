package com.digitrinity.formBeans;

public class FaultCategoryFormBean {
	private String faultID;
	private String faultCategory;
	public void clear() {
		this.faultID="";           
		this.faultCategory="";              
	}
	public String getFaultID() {
		return faultID;
	}
	public void setFaultID(String faultID) {
		this.faultID = faultID;
	}
	public String getFaultCategory() {
		return faultCategory;
	}
	public void setFaultCategory(String faultCategory) {
		this.faultCategory = faultCategory;
	}
	
	
	
}
