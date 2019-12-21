package com.digitrinity.dto;

import java.util.List;

public class DataSet {
	
	public DataSet() { }

	public DataSet(String label, String backgroundColor, List<Double> data) {
		this.label = label;
		this.backgroundColor = backgroundColor;
		this.data = data;
	}

	private String label;
	
	private String backgroundColor = "#3e95cd";
	
	private List<Double> data;
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public List<Double> getData() {
		return data;
	}

	public void setData(List<Double> data) {
		this.data = data;
	}
}
