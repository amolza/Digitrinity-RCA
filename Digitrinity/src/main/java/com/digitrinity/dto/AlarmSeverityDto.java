package com.digitrinity.dto;

import java.util.List;
import java.util.stream.Collectors;

public class AlarmSeverityDto {

	public AlarmSeverityDto() {
	}

	public AlarmSeverityDto(String severity) {
		this.severity = severity;
	}

	private String severity;

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	public static List<AlarmSeverityDto> generate(List<String> severities){
		return severities.stream().filter(sev -> sev !=null).map(sev -> { return new AlarmSeverityDto(sev); }).collect(Collectors.toList());
	}
}
