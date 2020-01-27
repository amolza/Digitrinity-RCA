package com.digitrinity.web;

import com.digitrinity.dto.CustomerDto;
import com.digitrinity.dto.LatestReportDto;
import com.digitrinity.dto.SitePerformanceDTO;
import com.digitrinity.model.VHourlyPerformance;
import com.digitrinity.service.SitePerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/site")
public class SiteController {

    @Autowired
    private SitePerformanceService performanceService;

    @GetMapping("/details/{siteid}")
    public String getSiteDetails(@PathVariable("siteid") String siteId, Model model, HttpServletRequest request) {
        model.addAttribute("siteid", siteId);
        return "sitedetails";
    }

    @GetMapping("/perfdashboard/{siteid}")
    public String getPerformaceDashboard(@PathVariable("siteid") String siteId, Model model, HttpServletRequest request) {
        model.addAttribute("siteid", siteId);
        return "performancedashboard";
    }

    @GetMapping(path = "/hourly-performance", produces = "application/json")
    public List<VHourlyPerformance> getHourlyPerformance(@RequestBody SitePerformanceDTO sitePerformanceDTO, HttpServletRequest request) {
        return performanceService.getHourlyPerformance(sitePerformanceDTO);
    }
}
