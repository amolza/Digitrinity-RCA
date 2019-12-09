package com.digitrinity.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.digitrinity.formBeans.FaultCategoryFormBean;
import com.digitrinity.formBeans.IssueCategoryFormBean;
import com.digitrinity.formBeans.JsonResponse;
import com.digitrinity.formBeans.OutageCategoryFormBean;
import com.digitrinity.model.FaultCategoryMaster;
import com.digitrinity.model.IssueCategoryMaster;
import com.digitrinity.model.OutageCategoryMaster;
import com.digitrinity.repository.FaultCategoryMasterRepository;
import com.digitrinity.repository.IssueCategoryMasterRepository;
import com.digitrinity.repository.OutageCategoryMasterRepository;
import com.digitrinity.repository.RcaReportRepository;
import com.digitrinity.repository.RegionMasterRepository;
import com.digitrinity.repository.SiteMasterRepository;
import com.digitrinity.util.StringUtil;

@Controller
@RequestMapping(value = "/master_data")
public class MasterDataController {

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

	
	@GetMapping("/view_issuecategory_form")
	public String viewRcaForm(@ModelAttribute("issueCategoryFormBean") IssueCategoryFormBean issueCategoryFormBean, Model model,BindingResult bindingResult) {

		List<IssueCategoryMaster> issueCategoryMasterList =issueCategoryMasterRepository.findAll();
		model.addAttribute("issueCategoryMasterList", issueCategoryMasterList);
		return "view_issuecategory_form";
	}

	@GetMapping("/view_outageCategory_form")
	public String viewRcaForm(@ModelAttribute("outageCategoryFormBean") OutageCategoryFormBean outageCategoryFormBean, Model model,BindingResult bindingResult) {

		
		List<OutageCategoryMaster> outageCategoryMasterList =outageCategoryMasterRepository.findAll();
		model.addAttribute("outageCategoryMasterList", outageCategoryMasterList);
		return "view_outageCategory_form";
	}

	@GetMapping("/view_faultCategory_form")
	public String viewRcaForm(@ModelAttribute("faultCategoryFormBean") FaultCategoryFormBean faultCategoryFormBean, Model model,BindingResult bindingResult) {

		
		List<FaultCategoryMaster> faultCategoryMasterList =faultCategoryMasterRepository.findAll();
		model.addAttribute("faultCategoryMasterList", faultCategoryMasterList);
		return "view_faultCategory_form";
	}

	//@PostMapping("/issue_category")
	@RequestMapping(value = "/issue_category", method = RequestMethod.POST)
	public String createIssueCategory(@ModelAttribute("issueCategoryFormBean") IssueCategoryFormBean issueCategoryFormBean, BindingResult bindingResult,Model model, HttpServletRequest request) {
		IssueCategoryMaster categoryMaster=null;
		String issueCatIDStr =request.getParameter("issueCatID");
		Long issueCatIDLong = 0L;
		if (!StringUtil.isNullOrEmpty(issueCatIDStr)&& !issueCatIDStr.equals("0")) {
			issueCatIDLong = Long.parseLong(issueCatIDStr);
			categoryMaster= issueCategoryMasterRepository.getOne(issueCatIDLong);
		}else
		 categoryMaster=new IssueCategoryMaster();
		categoryMaster.setIssuename(issueCategoryFormBean.getIssuename());
		
		issueCategoryMasterRepository.save(categoryMaster);
		issueCategoryFormBean.setIssueCatID("");
		issueCategoryFormBean.setIssuename("");
		List<IssueCategoryMaster> issueCategoryMasterList =issueCategoryMasterRepository.findAll();
		model.addAttribute("issueCategoryMasterList", issueCategoryMasterList);
		return "view_issuecategory_form";
	}

	//@PostMapping("/outage_category")
	@RequestMapping(value = "/outage_category", method = RequestMethod.POST)
	public String createOutageCategory(@ModelAttribute("outageCategoryFormBean") OutageCategoryFormBean outageCategoryFormBean, BindingResult bindingResult,Model model, HttpServletRequest request) {
		OutageCategoryMaster outageCategoryMaster=null;
		String outageCatIDStr =request.getParameter("outageCatID");
		String outageCatID =outageCategoryFormBean.getOutageCatID();
		Long outageCatIDLong =0L;
		if (!StringUtil.isNullOrEmpty(outageCatIDStr) && !outageCatIDStr.equals("0")) {
			outageCatIDLong = Long.parseLong(outageCatIDStr);
		 outageCategoryMaster= outageCategoryMasterRepository.getOne(outageCatIDLong);
		}else
		 outageCategoryMaster=new OutageCategoryMaster();
		outageCategoryMaster.setOutageCategory(outageCategoryFormBean.getOutageCategory());
		
		outageCategoryMasterRepository.save(outageCategoryMaster);
		outageCategoryFormBean.setOutageCatID("");
		outageCategoryFormBean.setOutageCategory("");
		List<OutageCategoryMaster> outageCategoryMasterList =outageCategoryMasterRepository.findAll();
		model.addAttribute("outageCategoryMasterList", outageCategoryMasterList);
		return "view_outageCategory_form";
	}
	//@PostMapping("/fault_category")
	@RequestMapping(value = "/fault_category", method = RequestMethod.POST)
	public String createFaultCategory(@ModelAttribute("faultCategoryFormBean") FaultCategoryFormBean faultCategoryFormBean, BindingResult bindingResult,Model model, HttpServletRequest request) {
		FaultCategoryMaster faultCategoryMaster=null;
		String faultIDStr =request.getParameter("faultID");
		String faultID =faultCategoryFormBean.getFaultID();
		Long faultIDLong =0L;
		if (!StringUtil.isNullOrEmpty(faultIDStr) && !faultIDStr.equals("0")) {
			faultIDLong = Long.parseLong(faultIDStr);
		 faultCategoryMaster= faultCategoryMasterRepository.getOne(faultIDLong);
		}else
		 faultCategoryMaster=new FaultCategoryMaster();
		faultCategoryMaster.setFaultCategory(faultCategoryFormBean.getFaultCategory());
		
		faultCategoryMasterRepository.save(faultCategoryMaster);
		faultCategoryFormBean.setFaultID("");
		faultCategoryFormBean.setFaultCategory("");
		List<FaultCategoryMaster> faultCategoryMasterList =faultCategoryMasterRepository.findAll();
		model.addAttribute("faultCategoryMasterList", faultCategoryMasterList);
		return "view_faultCategory_form";
	}
	
	@RequestMapping(value = "/get_issueCategory_details", method = RequestMethod.POST)
	public String getIssueCategoryDetails(@ModelAttribute("issueCategoryFormBean") IssueCategoryFormBean issueCategoryFormBean,
			BindingResult bindingResult, HttpServletRequest request, Model model) {
		String issueCatIDStr =request.getParameter("issueCatID");
		Long issueCatIDLong = 0L;
		if (!StringUtil.isNullOrEmpty(issueCatIDStr))
			issueCatIDLong = Long.parseLong(issueCatIDStr);
		IssueCategoryMaster issueCategoryMaster= issueCategoryMasterRepository.getOne(issueCatIDLong);
		issueCategoryFormBean.setIssueCatID(issueCategoryMaster.getIssueCatID()+"");
		issueCategoryFormBean.setIssuename(issueCategoryMaster.getIssuename());
		List<IssueCategoryMaster> issueCategoryMasterList =issueCategoryMasterRepository.findAll();
		model.addAttribute("issueCategoryMasterList", issueCategoryMasterList);
		return "view_issuecategory_form";
	}

	@RequestMapping(value = "/delete_issueCategory_details", method = RequestMethod.POST)
	public String deleteIssueCategoryDetails(@ModelAttribute("issueCategoryFormBean") IssueCategoryFormBean issueCategoryFormBean,
			BindingResult bindingResult, HttpServletRequest request, Model model) {
		JsonResponse jsonResponse = new JsonResponse();
		String issueCatIDStr =request.getParameter("issueCatID");
		String issueCatID =issueCategoryFormBean.getIssueCatID();
		Long issueCatIDLong = 0L;
		if (!StringUtil.isNullOrEmpty(issueCatIDStr))
			issueCatIDLong = Long.parseLong(issueCatIDStr);
		issueCategoryMasterRepository.deleteById(issueCatIDLong);
		jsonResponse.setStatus("SUCCESS");
		issueCategoryFormBean.setIssuename("");
		List<IssueCategoryMaster> issueCategoryMasterList =issueCategoryMasterRepository.findAll();
		model.addAttribute("issueCategoryMasterList", issueCategoryMasterList);
		return "view_issuecategory_form";
	}
	
	
	@RequestMapping(value = "/get_outageCategory_details", method = RequestMethod.POST)
	public String getOutageCategoryDetails(@ModelAttribute("outageCategoryFormBean") OutageCategoryFormBean outageCategoryFormBean,
			BindingResult bindingResult, HttpServletRequest request, Model model) {
		String outageCatIDStr =request.getParameter("outageCatID");
		String outageCatID =outageCategoryFormBean.getOutageCatID();
		Long outageCatIDLong =0L;
		if (!StringUtil.isNullOrEmpty(outageCatIDStr))
			outageCatIDLong = Long.parseLong(outageCatIDStr);
		OutageCategoryMaster outageCategoryMaster= outageCategoryMasterRepository.getOne(outageCatIDLong);
		outageCategoryFormBean.setOutageCatID(outageCategoryMaster.getOutageCatID()+"");
		outageCategoryFormBean.setOutageCategory(outageCategoryMaster.getOutageCategory());
		List<OutageCategoryMaster> outageCategoryMasterList =outageCategoryMasterRepository.findAll();
		model.addAttribute("outageCategoryMasterList", outageCategoryMasterList);
		return "view_outageCategory_form";
	}

	@RequestMapping(value = "/delete_outageCategory_details", method = RequestMethod.POST)
	public String deleteOutageCategoryDetails(@ModelAttribute("outageCategoryFormBean") OutageCategoryFormBean outageCategoryFormBean,
			BindingResult bindingResult, HttpServletRequest request, Model model) {
		JsonResponse jsonResponse = new JsonResponse();
		String outageCatIDStr =request.getParameter("outageCatID");
		String outageCatID =outageCategoryFormBean.getOutageCatID();
		Long outageCatIDLong =0L;
		if (!StringUtil.isNullOrEmpty(outageCatIDStr))
			outageCatIDLong = Long.parseLong(outageCatIDStr);
		outageCategoryMasterRepository.deleteById(outageCatIDLong);
		jsonResponse.setStatus("SUCCESS");
		outageCategoryFormBean.setOutageCategory("");
		List<OutageCategoryMaster> outageCategoryMasterList =outageCategoryMasterRepository.findAll();
		model.addAttribute("outageCategoryMasterList", outageCategoryMasterList);
		return "view_outageCategory_form";
	}
	
	
	
	@RequestMapping(value = "/get_faultCategory_details", method = RequestMethod.POST)
	public String getFaultCategoryDetails(@ModelAttribute("faultCategoryFormBean") FaultCategoryFormBean faultCategoryFormBean,
			BindingResult bindingResult, HttpServletRequest request, Model model) {
		String faultIDStr =request.getParameter("faultID");
		String faultID =faultCategoryFormBean.getFaultID();
		Long faultIDLong =0L;
		if (!StringUtil.isNullOrEmpty(faultIDStr))
			faultIDLong = Long.parseLong(faultIDStr);
		FaultCategoryMaster faultCategoryMaster= faultCategoryMasterRepository.getOne(faultIDLong);
		faultCategoryFormBean.setFaultID(faultID);
		faultCategoryFormBean.setFaultCategory(faultCategoryMaster.getFaultCategory());
		List<FaultCategoryMaster> faultCategoryMasterList =faultCategoryMasterRepository.findAll();
		model.addAttribute("faultCategoryMasterList", faultCategoryMasterList);
		return "view_faultCategory_form";
	}

	@RequestMapping(value = "/delete_faultCategory_details", method = RequestMethod.POST)
	public String deleteFaultCategoryDetails(@ModelAttribute("faultCategoryFormBean") FaultCategoryFormBean faultCategoryFormBean,
			BindingResult bindingResult, HttpServletRequest request, Model model) {
		JsonResponse jsonResponse = new JsonResponse();
		String faultIDStr =request.getParameter("faultID");
		String faultID =faultCategoryFormBean.getFaultID();
		Long faultIDLong =0L;
		if (!StringUtil.isNullOrEmpty(faultIDStr))
			faultIDLong = Long.parseLong(faultIDStr);
		faultCategoryMasterRepository.deleteById(faultIDLong);
		jsonResponse.setStatus("SUCCESS");
		faultCategoryFormBean.setFaultCategory("");
		List<FaultCategoryMaster> faultCategoryMasterList =faultCategoryMasterRepository.findAll();
		model.addAttribute("faultCategoryMasterList", faultCategoryMasterList);
		return "view_faultCategory_form";
	}
}
