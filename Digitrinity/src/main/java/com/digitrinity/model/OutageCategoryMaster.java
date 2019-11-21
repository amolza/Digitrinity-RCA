package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "outagecategorymaster")
public class OutageCategoryMaster{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long outageCatID=0L;
	
	@Column(name = "OutageCategory")
	private String outageCategory="";

	public Long getOutageCatID() {
		return outageCatID;
	}

	public void setOutageCatID(Long outageCatID) {
		this.outageCatID = outageCatID;
	}

	public String getOutageCategory() {
		return outageCategory;
	}

	public void setOutageCategory(String outageCategory) {
		this.outageCategory = outageCategory;
	}
	
	
	
}
