package com.digitrinity.web;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digitrinity.formBeans.RCAReportFormBean;
import com.digitrinity.model.FaultCategoryMaster;
import com.digitrinity.model.IssueCategoryMaster;
import com.digitrinity.model.OutageCategoryMaster;
import com.digitrinity.model.RcaReport;
import com.digitrinity.model.RegionMaster;
import com.digitrinity.model.SiteMaster;
import com.digitrinity.repository.FaultCategoryMasterRepository;
import com.digitrinity.repository.IssueCategoryMasterRepository;
import com.digitrinity.repository.OutageCategoryMasterRepository;
import com.digitrinity.repository.RcaReportRepository;
import com.digitrinity.repository.RegionMasterRepository;
import com.digitrinity.repository.SiteMasterRepository;
import com.digitrinity.util.DateUtility;

@Controller
@RequestMapping(value = "/rca")
public class RCAController {

	@Autowired
	private FaultCategoryMasterRepository faultCategoryMasterRepository;
	@Autowired
	private OutageCategoryMasterRepository outageCategoryMasterRepository;
	@Autowired
	private RcaReportRepository rcaReportRepository;
	@Autowired
	private RegionMasterRepository regionMasterRepository;
	
	@Autowired
	private SiteMasterRepository siteMasterRepository;
	
	@Autowired
	private IssueCategoryMasterRepository issueCategoryMasterRepository;

	
	@GetMapping("/view_rca_form")
	public String viewRcaForm(@ModelAttribute("rcaReportForm") RCAReportFormBean rcaReportForm, Model model,BindingResult bindingResult) {

	getRcaFormData(model);
		
		return "pages/rca";
	}



	@PostMapping("/create_rca")
	public String createRca(@ModelAttribute("rcaReportForm") RCAReportFormBean rcaReportForm, BindingResult bindingResult,HttpServletRequest request,Model model) {

		String rcaDateStr=request.getParameter("rcaDate");
		String siteDownTimeStr=request.getParameter("siteDownTime");
		String restoredTimeStr=request.getParameter("restoredTime");
		
		String []rcaDatearr=rcaDateStr.split(" ");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
	
		
		java.util.Date rcaDate = null;
		Timestamp siteDownTime = null;
		Timestamp restoredTime  = null;
		Date rcaDateSql = null;
		Date siteDownTimeSql = null;
		Date restoredTimeSql  = null;
		try {
			rcaDate = (java.util.Date) formatter.parse(rcaDatearr[0]);
			siteDownTime=DateUtility.getTimestampByMySqlDateSlashMMDDYY(siteDownTimeStr);
			restoredTime=DateUtility.getTimestampByMySqlDateSlashMMDDYY(restoredTimeStr);
			/*
			 * siteDownTime= (java.util.Date) formatter.parse(siteDownTimeStr); restoredTime
			 * = (java.util.Date) formatter.parse(restoredTimeStr);
			 */
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RcaReport rcaReport=new RcaReport();
		rcaReport.setRcaDate(rcaDate);
		rcaReport.setSmSiteID(rcaReportForm.getSmSiteID()+"");
		rcaReport.setSmSitename(rcaReportForm.getSmSitename());
		rcaReport.setRgRegionID(rcaReportForm.getRgRegionID());
		rcaReport.setAnchorOprtr(rcaReportForm.getAnchorOprtr());
		rcaReport.setOpcoID(rcaReportForm.getOpcoId());
		rcaReport.setSiteDownTime(siteDownTime);
		rcaReport.setRestoredTime(restoredTime);
		rcaReport.setSiteDownDuration(rcaReportForm.getSiteDownDuration());
		rcaReport.setIssueCatID(Integer.parseInt(rcaReportForm.getIssueCatID()));
		rcaReport.setOutageCatID(rcaReportForm.getOutageCatID());
		rcaReport.setFaultID(Integer.parseInt(rcaReportForm.getFaultID()));
		rcaReport.setOutageInMinutes(rcaReportForm.getOutageInMinutes());
		rcaReport.setRca(rcaReportForm.getRca());
		rcaReport.setSla(rcaReportForm.getSla());
	
		
		rcaReportRepository.save(rcaReport);
		rcaReportForm.clear();
		getRcaFormData(model);
		//model.addAttribute("rcaReportForm", rcaReportForm);
		 //return "rca";
		 return "redirect:/welcome";
	}
	private void getRcaFormData(Model model) {
		List<FaultCategoryMaster> faultCategoryMasters = faultCategoryMasterRepository.findAll();
		 model.addAttribute("faultCategoryMasters", faultCategoryMasters);

		List<OutageCategoryMaster> outageCategoryMasters = outageCategoryMasterRepository.findAll();
		model.addAttribute("outageCategoryMasters", outageCategoryMasters);
		
		List<RcaReport> rcaReports = rcaReportRepository.findAll();
		model.addAttribute("rcaReports", rcaReports);
		
		List<RegionMaster> regionMasters = regionMasterRepository.findAll();
		model.addAttribute("regionMasters", regionMasters);
		
		List<SiteMaster> siteMasters = siteMasterRepository.findAll();
		model.addAttribute("siteMasters", siteMasters);
		
		
		List<IssueCategoryMaster> issueCategoryMasters = issueCategoryMasterRepository.findAll();
		model.addAttribute("issueCategoryMasters", issueCategoryMasters);
	}
}
