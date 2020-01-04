package com.digitrinity.dto;

public class RawDataReportReqDto {

	private int start;
	
	private int length;
	
	private int draw;
	
	private int page;
	

	public RawDataReportReqDto() {
	}

	public RawDataReportReqDto(int start, int length, int draw) {
		this.start = start;
		this.length = length;
		this.draw = draw;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
