<!DOCTYPE html>
<html lang="en" >
	<head>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
		
		<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
		<%@page import="java.util.HashMap"%>
		<%@page import="java.util.Map"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	    <meta charset="UTF-8">
	    <title>Welcome</title>
		<jsp:include page="include_hdr.jsp"></jsp:include>
	</head>
	<body class="sidebar-is-reduced overflow-hidden">
		<header class="l-header">
			<jsp:include page="header.jsp"></jsp:include>
		</header>
		<div class="l-sidebar">
			<jsp:include page="sidebar.jsp"></jsp:include>
		</div>
	<main class="l-main">
	<div class="content-wrapper content-wrapper--with-bg"
		style="overflow-x: hidden; overflow-y: auto;">
		<div class="list-group">
			<form:form method="POST" modelAttribute="rcaReportForm"
				name="rcaReportForm">
				<input type="hidden" id="rcaid" name="rcaid"
					value="${rcaReportForm.rcaid}" />
				<div class="container">
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span class="control-label">Select Date</span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<div class="input-group date" data-provide="datepicker">
									<form:input path="rcaDate" class="form-control"
										placeholder="Select Date" id="datetimepicker1" value="${rcaReportForm.rcaDate}" />
									<div class="input-group-append">
										<span class="input-group-text"> <span
											class="fa fa-calendar-alt"></span>
										</span>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span>Select Site Name</span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<form:select class="form-control" path="smSiteID"
									items="${siteMasters}" itemLabel="smSitename"
									itemValue="smSiteID" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span class="control-label">Select Region Name</span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<form:select class="form-control" path="rgRegionID"
									items="${regionMasters}" itemLabel="rgRegion"
									itemValue="rgRegionID" />
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span>Enter AnhorOprtr</span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<form:input class="form-control" placeholder="Enter AnchorOprtr"
									id="anchorOprtr" path="anchorOprtr" name="anchorOprtr"
									required="required" pattern="(?!^ +$)^.+$" value="${rcaReportForm.anchorOprtr}"
									maxlength="100" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span class="control-label">Enter OPCOID</span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<form:input class="form-control" placeholder="Enter OPCOID"
									id="opcoId" path="opcoId" name="opcoId" required="required"
									pattern="(?!^ +$)^.+$" value="${rcaReportForm.opcoId}" maxlength="100" />
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span>Input Site Down Time</span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<div class="input-group date" data-provide="datepicker">
									<form:input path="siteDownTime" class="form-control"
										placeholder="Select Date" id="datetimepicker2"
										onchange="calculateDiffereneceInTime(this); return false;" value="${rcaReportForm.siteDownTime}"/>
									<div class="input-group-append">
										<span class="input-group-text"> <span
											class="fa fa-calendar-alt"></span>
										</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span class="control-label">Input Restored Time</span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<div class="input-group date" data-provide="datepicker">
									<form:input path="restoredTime" class="form-control"
										placeholder="Select Date" id="datetimepicker3"
										onchange="calculateDiffereneceInTime(this); return false;" value="${rcaReportForm.restoredTime}" />
									<div class="input-group-append">
										<span class="input-group-text"> <span
											class="fa fa-calendar-alt"></span>
										</span>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span>Site Down Duration </span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<form:input id="input-time" class="form-control"
									path="siteDownDuration" value="${rcaReportForm.siteDownDuration}" />
								<!-- type="time" value="00:00:01" -->
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span class="control-label">Select Issue Name</span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<form:select path="issueCatID" items="${issueCategoryMasters}"
									class="form-control" itemLabel="issuename"
									itemValue="issueCatID" />
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span>Select Outage Category</span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<form:select path="outageCatID" class="form-control"
									items="${outageCategoryMasters}" itemLabel="outageCategory"
									itemValue="outageCatID" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span class="control-label">Select Fault Category</span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<form:select path="faultID" items="${faultCategoryMasters}"
									class="form-control" itemLabel="faultCategory"
									itemValue="faultID" />
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span>Enter RCA</span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<form:input class="form-control" placeholder="Enter RCA" id=""
									path="rca" name="" required="required" pattern="(?!^ +$)^.+$"
									value="${rcaReportForm.rca}"  maxlength="100" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span class="control-label">Enter Outage In Minutes</span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<form:input class="form-control" placeholder="Enter Title" id=""
									path="outageInMinutes" name="" required="required"
									pattern="(?!^ +$)^.+$" value="${rcaReportForm.outageInMinutes}"  maxlength="100" />
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
							<span>Enter SLA</span>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
							<div class="form-group">
								<form:input class="form-control" placeholder="Enter Title" id=""
									path="sla" name="" required="required" pattern="(?!^ +$)^.+$"
									value="${rcaReportForm.outageInMinutes}" maxlength="100" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
							align="center">
							<button class="btn btn-primary" title="SUBMIT"
								onclick="submitRCA(); return false;" type="button">SUBMIT</button>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6 col-lg-12"
							align="right">
							<button id="btnExport" onclick="fnExcelReport();"> EXPORT to Excel </button>
							</div>
					</div>
					<div>
						<div>
							<c:if test="${not empty rcaReportList}">
								<%
									int count = 1;
								%>

								<div class="box">
									<div class="box-body">
										<div class="table-responsive">
											<table class="table table-bordered table-striped dataTable display"
												id="headerTable">
												<thead>
													<tr>
														<th>Sr.No</th>
														<th>Site ID</th>
														<th>Site Name</th>
														<th>AnchorOprtr</th>
														<th>Opco ID</th>
														<th>Site Down Time</th>
														<th>Restored Time</th>
														<th>Site Down Duration</th>
														<th>Rca</th>
														<th>Outage In Minutes</th>
														<th>Sla</th>
														<th>Edit</th>
														<th>Delete</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="rcaReport" items="${rcaReportList}">
														<tr>
															<td align="center" class="width-3"><%=count%></td>
															<td align="center" class="width-5"><p>${rcaReport.smSiteID}</p></td>
															<td align="center" class="width-5"><p>${rcaReport.smSitename}</p></td>
															<td align="center" class="width-5"><p>${rcaReport.anchorOprtr}</p></td>
															<td align="center" class="width-5"><p>${rcaReport.opcoID}</p></td>
															<td align="center" class="width-5"><p>${rcaReport.siteDownTime}</p></td>
															<td align="center" class="width-5"><p>${rcaReport.restoredTime}</p></td>
															<td align="center" class="width-5"><p>${rcaReport.siteDownDuration}</p></td>
															<td align="center" class="width-5"><p>${rcaReport.rca}</p></td>
															<td align="center" class="width-5"><p>${rcaReport.outageInMinutes}</p></td>
															<td align="center" class="width-5"><p>${rcaReport.sla}</p></td>
															<td align="center" class="width-5"><img
																class="cursor-pointer" alt="EDIT"
																src="<c:url value="/resources/images/edit.png"/>"
																height="20px" width="20px" title="Click for edit"
																onclick="javascript:viewEditRCAForm('${rcaReport.rcaid}');" /></td>

															<td align="center" class="width-5""><img
																alt="INACTIVE"
																src="<c:url value="/resources/images/wrong_tick.png"/>"
																height="20px" width="20px" title="Click for delete"
																onclick="javascript:deleteRCAForm('${rcaReport.rcaid}');" /></td>

														</tr>
														<%
															count++;
														%>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>

								<!-- 	<script type="text/javascript">
							$(function(){
								if ($('#categoryTable').length > 0) {
									$("#categoryTable").dataTable({
										"aLengthMenu": [[-1], ["All"]],
										"iDisplayLength": -1
									});
								}	
							});
							
							</script> -->
							</c:if>
						</div>


					</div>

				</div>
			</form:form>
		</div>
	</div>
	</main>
	<jsp:include page="include_ftr.jsp"></jsp:include>
	</body>
	<script type="text/javascript">
	jQuery(document).ready(function () {
        'use strict';
        jQuery('#datetimepicker1').datetimepicker({
        	timepicker:false,
        	format:'Y/m/d'
        });
        jQuery('#datetimepicker2').datetimepicker({
            formatTime:"h:i a",
            step:60
        });
        jQuery('#datetimepicker3').datetimepicker({
        	formatTime:"h:i a",
            step:60
        });
    });
		$('#tabAddDetails').addClass('is-active');
		function submitData() {
			document.rcaReportForm.method = "POST";
			document.rcaReportForm.action = "<c:url value='/rca/view_rca_form'/>";
			document.rcaReportForm.submit();
		}
		function submitRCA() {
			document.rcaReportForm.method = "POST";
			document.rcaReportForm.action = "<c:url value='/rca/create_rca'/>";
			document.rcaReportForm.submit();
		}
		function calculateDiffereneceInTime(){
			debugger;
			var today = new Date();
		    var date1 = new Date($('#datetimepicker2').val()).getTime();
		    var date2 = new Date($('#datetimepicker3').val()).getTime();
		    var msec = date2 - date1;
		    var mins = Math.floor(msec / 60000);
		    var hrs = Math.floor(mins / 60);
		    mins = mins % 60;
		    $("#input-time").val(hrs+":"+mins);
		}
		
		function viewEditRCAForm(rcaid)
		{ 
			$("#rcaid").val(rcaid);
			document.rcaReportForm.method = "POST";
			document.rcaReportForm.action = "<c:url value='/rca/get_rca_details'/>";
			document.rcaReportForm.submit();
		}
		function deleteRCAForm(rcaid)
		{ 
			$("#rcaid").val(rcaid);
			document.rcaReportForm.method = "POST";
			document.rcaReportForm.action = "<c:url value='/rca/delete_rca_details'/>";
			document.rcaReportForm.submit();
		}
		
		<%-- function deleteRCAForm(rcaid)
		{
				var JSONObject;
				JSONObject = {
						"rcaid" : "" + rcaid + "" 
				};
				var domainContexPath ="http://localhost:8080/";"<%=request.getContextPath() %>";
					$.ajax({
						type : "post",
						url : domainContexPath + "rca/delete_rca_details",
						contentType : "application/json",
						data : JSON.stringify(JSONObject),
						success : function(response) {
							if(response.status === "SUCCESS")
							/*  showScriptMessage("SUCCESS","Record deleted successfully"); */
							alert("Record deleted successfully");
							else{
								/* showScriptMessage('ERROR', "Please try again."); */
									alert("Please try again.");
							return false;
							}
						},
						error : function(e) {
							/* showScriptMessage('ERROR', "Something went wrong!,Please try again."); */
							alert("Please try again.");
							return false;
						}
					});
		} --%>
		
		function fnExcelReport()
		{
		    var tab_text="<table border='2px'><tr bgcolor='#87AFC6'>";
		    var textRange; var j=0;
		    tab = document.getElementById('headerTable'); // id of table

		    for(j = 0 ; j < tab.rows.length ; j++) 
		    {     
		        tab_text=tab_text+tab.rows[j].innerHTML+"</tr>";
		        //tab_text=tab_text+"</tr>";
		    }

		    tab_text=tab_text+"</table>";
		    tab_text= tab_text.replace(/<A[^>]*>|<\/A>/g, "");//remove if u want links in your table
		    tab_text= tab_text.replace(/<img[^>]*>/gi,""); // remove if u want images in your table
		    tab_text= tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

		    var ua = window.navigator.userAgent;
		    var msie = ua.indexOf("MSIE "); 

		    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer
		    {
		        txtArea1.document.open("txt/html","replace");
		        txtArea1.document.write(tab_text);
		        txtArea1.document.close();
		        txtArea1.focus(); 
		        sa=txtArea1.document.execCommand("SaveAs",true,"Say Thanks to Sumit.xls");
		    }  
		    else                 //other browser not tested on IE 11
		        sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  

		    return (sa);
		}
		
	</script>
</html>