package com.digitrinity.formBeans;

import java.io.Serializable;
import java.util.List;

public class ServerSideDataTableResponse implements Serializable {

	private static final long serialVersionUID = 3260849263343353518L;
	private List<?> data;
	
	private int draw = 1;
	
	private long recordsTotal = 500;
	
	private long recordsFiltered = 50;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public ServerSideDataTableResponse(List<?> data, long recordsTotal, long recordsFiltered, int draw) {
		super();
		this.data = data;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.draw = draw;
	}

	public ServerSideDataTableResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
}
