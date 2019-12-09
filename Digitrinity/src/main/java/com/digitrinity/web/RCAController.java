package com.digitrinity.web;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digitrinity.formBeans.JsonResponse;
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
import com.digitrinity.util.CollectionUtils;
import com.digitrinity.util.DateUtility;
import com.digitrinity.util.StringUtil;

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

	private Set<SiteMaster> siteMasterSet=new HashSet<>();
	
	@GetMapping("/view_rca_form")
	public String viewRcaForm(@ModelAttribute("rcaReportForm") RCAReportFormBean rcaReportForm, Model model,
			BindingResult bindingResult) {

		getRcaFormData(model);
		List<RcaReport> rcaReportList = rcaReportRepository.findAll();
		model.addAttribute("rcaReportList", rcaReportList);
		rcaReportForm.clear();
		return "rca";
	}

	@PostMapping("/create_rca")
	public String createRca(@ModelAttribute("rcaReportForm") RCAReportFormBean rcaReportForm,
			BindingResult bindingResult, HttpServletRequest request, Model model) {

		String rcaDateStr = request.getParameter("rcaDate");
		String siteDownTimeStr = request.getParameter("siteDownTime");
		String restoredTimeStr = request.getParameter("restoredTime");

		String[] rcaDatearr = rcaDateStr.split(" ");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss ");

		java.util.Date rcaDate = null;
		Timestamp siteDownTime = null;
		Timestamp restoredTime = null;
		Date rcaDateSql = null;
		Date siteDownTimeSql = null;
		Date restoredTimeSql = null;
		try {
			if(!StringUtil.isNullOrEmpty(rcaDateStr))
			rcaDate = DateUtility.getDateObject(rcaDateStr);
			if(!StringUtil.isNullOrEmpty(siteDownTimeStr))
			siteDownTime = DateUtility.getTimestampByOnlyDateSlash(siteDownTimeStr);
			if(!StringUtil.isNullOrEmpty(restoredTimeStr))
			restoredTime = DateUtility.getTimestampByOnlyDateSlash(restoredTimeStr);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RcaReport rcaReport =null;
		String rcaidStr =request.getParameter("rcaid");// model.get("rcaid");
		Long rcaidLong = 0L;
		if (!StringUtil.isNullOrEmpty(rcaidStr) && !rcaidStr.equals("0")) {
			rcaidLong = Long.parseLong(rcaidStr);
		 rcaReport = rcaReportRepository.getOne(rcaidLong);
		}
		else
		 rcaReport = new RcaReport();
		rcaReport.setRcaDate(rcaDate);
		rcaReport.setSmSiteID(rcaReportForm.getSmSitecode());
		if(CollectionUtils.isCollectionNullOrEmpty(siteMasterSet))
		for (SiteMaster master : siteMasterSet) {
			if(master.getSmSitecode().equalsIgnoreCase(rcaReportForm.getSmSitecode()))
				rcaReport.setSmSitename(master.getSmSitename());
		}
		
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
		List<RcaReport> rcaReportList = rcaReportRepository.findAll();
		rcaReportForm.clear();
		getRcaFormData(model);
		model.addAttribute("rcaReportForm", rcaReportForm);
		model.addAttribute("rcaReportList", rcaReportList);
		return "rca";
		// return "redirect:/welcome";
	}

	/*@PostMapping("/get_rca_details")
	public @ResponseBody JsonResponse getRcaDetails(@RequestBody(required = false) Map<String, String> model,
			@ModelAttribute("rcaReportForm") RCAReportFormBean rcaReportForm, HttpServletRequest request)
			throws Exception {*/
	@RequestMapping(value = "/get_rca_details", method = RequestMethod.POST)
	public String getRcaDetails(@ModelAttribute("rcaReportForm") RCAReportFormBean rcaReportForm,
			BindingResult bindingResult, HttpServletRequest request, Model model) {
		JsonResponse jsonResponse = new JsonResponse();
		String rcaidStr =request.getParameter("rcaid");// model.get("rcaid");
		Long rcaidLong = 0L;
		if (!StringUtil.isNullOrEmpty(rcaidStr))
			rcaidLong = Long.parseLong(rcaidStr);
		RcaReport rcaReport = rcaReportRepository.getOne(rcaidLong);
		rcaReportForm.setRcaid(rcaidLong);
		rcaReportForm.setRcaDate(DateUtility.convertUtilToSqlDate(rcaReport.getRcaDate()));
		rcaReportForm.setSmSiteID(Integer.parseInt(rcaReport.getSmSiteID()));
		rcaReportForm.setSmSitename(rcaReport.getSmSitename());
		rcaReportForm.setRgRegionID(rcaReport.getRgRegionID());
		rcaReportForm.setAnchorOprtr(rcaReport.getAnchorOprtr());
		rcaReportForm.setOpcoId(rcaReport.getOpcoID());
		rcaReportForm.setSiteDownTime(DateUtility.convertUtilToSqlDate(rcaReport.getSiteDownTime()));
		rcaReportForm.setRestoredTime(DateUtility.convertUtilToSqlDate(rcaReport.getRestoredTime()));
		rcaReportForm.setSiteDownDuration(rcaReport.getSiteDownDuration());
		rcaReportForm.setIssueCatID(String.valueOf(rcaReport.getIssueCatID()));
		rcaReportForm.setOutageCatID(rcaReport.getOutageCatID());
		rcaReportForm.setFaultID(String.valueOf(rcaReport.getFaultID()));
		rcaReportForm.setOutageInMinutes(rcaReport.getOutageInMinutes());
		rcaReportForm.setRca(rcaReport.getRca());
		rcaReportForm.setSla(rcaReport.getSla());
		getRcaFormData(model);
		List<RcaReport> rcaReportList = rcaReportRepository.findAll();
		model.addAttribute("rcaReportList", rcaReportList);
		return "rca";
	}

	//@PostMapping("/delete_rca_details")
	/*public @ResponseBody JsonResponse deleteRcaDetails(@RequestBody(required = true) Map<String, String> model,
			@ModelAttribute("rcaReportForm") RCAReportFormBean rcaReportForm, HttpServletRequest request)
			throws Exception {*/
	@RequestMapping(value = "/delete_rca_details", method = RequestMethod.POST)
	public String deleteRcaDetails(@ModelAttribute("rcaReportForm") RCAReportFormBean rcaReportForm,
			BindingResult bindingResult, HttpServletRequest request, Model model) {
		JsonResponse jsonResponse = new JsonResponse();
		String rcaidStr =request.getParameter("rcaid");// model.get("rcaid");
		Long rcaidLong =rcaReportForm.getRcaid();
		if (!StringUtil.isNullOrEmpty(rcaidStr))
			rcaidLong = Long.parseLong(rcaidStr);
		rcaReportRepository.deleteById(rcaidLong);
		jsonResponse.setStatus("SUCCESS");
		List<RcaReport> rcaReportList = rcaReportRepository.findAll();
		model.addAttribute("rcaReportList", rcaReportList);
		rcaReportForm.clear();
		return "rca";
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
		siteMasterSet.addAll(siteMasters);
		
		
		List<IssueCategoryMaster> issueCategoryMasters = issueCategoryMasterRepository.findAll();
		model.addAttribute("issueCategoryMasters", issueCategoryMasters);
	}
}
