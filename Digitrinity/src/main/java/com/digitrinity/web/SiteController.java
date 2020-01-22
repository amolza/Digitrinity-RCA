package com.digitrinity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/site")
public class SiteController {

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
}
