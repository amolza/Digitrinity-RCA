package com.digitrinity.formBeans;

public class OutageCategoryFormBean {
	private String outageCatID;
	private String outageCategory;
	public void clear() {
		this.outageCatID="";           
		this.outageCategory="";              
	}
	public String getOutageCatID() {
		return outageCatID;
	}
	public void setOutageCatID(String outageCatID) {
		this.outageCatID = outageCatID;
	}
	public String getOutageCategory() {
		return outageCategory;
	}
	public void setOutageCategory(String outageCategory) {
		this.outageCategory = outageCategory;
	}
	
	
	
}
