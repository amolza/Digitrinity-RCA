package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "issuecategorymaster")
public class IssueCategoryMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long issueCatID =0L;
	
	@Column(name = "Issuename")
	private String issuename="";

	public Long getIssueCatID() {
		return issueCatID;
	}

	public String getIssuename() {
		return issuename;
	}

	public void setIssuename(String issuename) {
		this.issuename = issuename;
	}

	public void setIssueCatID(Long issueCatID) {
		this.issueCatID = issueCatID;
	}

	
	

	
}
