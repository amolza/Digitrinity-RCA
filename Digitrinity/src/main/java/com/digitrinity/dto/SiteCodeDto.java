package com.digitrinity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SiteCodeDto implements Serializable {
	
	private static final long serialVersionUID = -1987313163889990945L;
	
	public SiteCodeDto(String code) {
		this.code = code;
	}
	
	public SiteCodeDto() { }
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public static List<SiteCodeDto> generate(List<String> codes){
		List<SiteCodeDto> codeDtos = new ArrayList<SiteCodeDto>();
		if (codes != null && codes.size() > 0) {
			codeDtos = codes.stream().map(code ->{
				return new SiteCodeDto(code);
			}).collect(Collectors.toList());
		}
		return codeDtos;
	}
}
