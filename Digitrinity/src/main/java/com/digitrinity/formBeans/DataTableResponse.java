package com.digitrinity.formBeans;

import java.io.Serializable;
import java.util.List;

public class DataTableResponse implements Serializable {

	private static final long serialVersionUID = 3260849263343353518L;
	private List<?> data;

	public DataTableResponse(List<?> data) {
		super();
		this.data = data;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
}
