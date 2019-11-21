package com.digitrinity.formBeans;

public class IssueCategoryFormBean {
	private String issueCatID;
	private String issuename;
	public void clear() {
		this.issueCatID="";           
		this.issuename="";              
	}
	public String getIssueCatID() {
		return issueCatID;
	}
	public void setIssueCatID(String issueCatID) {
		this.issueCatID = issueCatID;
	}
	public String getIssuename() {
		return issuename;
	}
	public void setIssuename(String issuename) {
		this.issuename = issuename;
	}
	
	
	
}
