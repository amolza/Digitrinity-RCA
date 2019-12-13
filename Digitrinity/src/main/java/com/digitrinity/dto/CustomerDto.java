package com.digitrinity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public CustomerDto(String name) {
		this.name = name;
	}
	
	public CustomerDto() { }
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static List<CustomerDto> generate(List<String> customerNames){
		List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
		if (customerNames != null && customerNames.size() > 0) {
			customerDtos = customerNames.stream().map(name -> {
				return new CustomerDto(name);
			}).collect(Collectors.toList());
		}
		return customerDtos;
	}
}
