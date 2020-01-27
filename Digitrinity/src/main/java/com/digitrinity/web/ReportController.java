package com.digitrinity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/report")
public class ReportController {
	
	@GetMapping("/rawreport")
	public String getRawReport() {
		return "rawreport";
	}

	@GetMapping("/powertrackertee")
	public String getPowerTrackerReport() {
		return "powertrackertee";
	}
}
