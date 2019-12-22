package com.digitrinity.dto;

import java.util.List;
import java.util.stream.Collectors;

public class AlarmCategoryDto {
	
	private String category;

	public AlarmCategoryDto() {
	}

	public AlarmCategoryDto(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public static List<AlarmCategoryDto> generate(List<String> categories){
		return categories.stream().filter( cat -> cat !=null).map(cat -> { return new AlarmCategoryDto(cat); }).collect(Collectors.toList());
	}
}
