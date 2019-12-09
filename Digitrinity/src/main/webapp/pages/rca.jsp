<!DOCTYPE html>
<html lang="en" >
	<head>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
		
		<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
		<%@page import="java.util.HashMap"%>
		<%@page import="java.util.Map"%>
		
	    <meta charset="UTF-8">
	    <title>Welcome</title>
		<jsp:include page="include_hdr.jsp"></jsp:include>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="container">
			<div class="form-group mt-5">
				<div class="collapse multi-collapse" id="multiCollapseExample1">
					<div class="card card-body">
						<form:form method="POST" modelAttribute="rcaReportForm"	name="rcaReportForm">
							<input type="hidden" id="rcaid" name="rcaid" value="${rcaReportForm.rcaid}" />
								
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
										<form:select class="form-control" path="smSitecode"
											items="${siteMasters}" itemLabel="smSitecode"
											itemValue="smSitecode" data-status="smSitename" />
											<input type="hidden" id="smSitename" name="smSitename" value="${smSitename}"  />
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
									<button class="btn btn-outline-primary" title="SAVE"	onclick="submitRCA(); return false;" type="button">SAVE</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
				<div class="row mt-3 mb-3">
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
	 					<a class="btn btn-outline-primary" data-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Add RCA Details</a>
	 				</div>
	 				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6" align="right">
						<button type="button" class="btn btn-outline-primary" id="btnExport" onclick="fnExcelReport();"> EXPORT to Excel </button>
						<button type="button" class="btn btn-outline-primary" id="btnExport" onclick="exportTableToCSV('RCAReport.csv')"> EXPORT to CSV </button>
					</div>
				</div>
				<div class="row" style="overflow-x: scroll;">
					<c:if test="${not empty rcaReportList}">
						<%
							int count = 1;
						%>
						<table id="rcaReportTable" class="table table-striped table-bordered nowrap">
							<thead>
								<tr>
									<th width=200px; style='text-align:center; font-size:15px;'>Sr.No</th>
									<th width=200px; style='text-align:center; font-size:15px;'>Site ID</th>
									<th width=200px; style='text-align:center; font-size:15px;'>Site Name</th>
									<th width=200px; style='text-align:center; font-size:15px;'>AnchorOprtr</th>
									<th width=200px; style='text-align:center; font-size:15px;'>Opco ID</th>
									<th width=200px; style='text-align:center; font-size:15px;'>Site Down Time</th>
									<th width=200px; style='text-align:center; font-size:15px;'>Restored Time</th>
									<th width=200px; style='text-align:center; font-size:15px;'>Site Down Duration</th>
									<th width=200px; style='text-align:center; font-size:15px;'>Rca</th>
									<th width=200px; style='text-align:center; font-size:15px;'>Outage In Minutes</th>
									<th width=200px; style='text-align:center; font-size:15px;'>Sla</th>
									<th width=200px; style='text-align:center; font-size:15px;'>Edit</th>
									<th width=200px; style='text-align:center; font-size:15px;'>Delete</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="rcaReport" items="${rcaReportList}">
									<tr>
										<td width=200px; style='text-align:right; font-size:15px;'><%=count%></td>
										<td width=200px; style='text-align:right; font-size:15px;'>${rcaReport.smSiteID}</td>
										<td width=200px; style='text-align:right; font-size:15px;'>${rcaReport.smSitename}</td>
										<td width=200px; style='text-align:right; font-size:15px;'>${rcaReport.anchorOprtr}</td>
										<td width=200px; style='text-align:right; font-size:15px;'>${rcaReport.opcoID}</td>
										<td width=200px; style='text-align:right; font-size:15px;'>${rcaReport.siteDownTime}</td>
										<td width=200px; style='text-align:right; font-size:15px;'>${rcaReport.restoredTime}</td>
										<td width=200px; style='text-align:right; font-size:15px;'>${rcaReport.siteDownDuration}</td>
										<td width=200px; style='text-align:right; font-size:15px;'>${rcaReport.rca}</td>
										<td width=200px; style='text-align:right; font-size:15px;'>${rcaReport.outageInMinutes}</td>
										<td width=200px; style='text-align:right; font-size:15px;'>${rcaReport.sla}</td>
										<td width=200px; style='text-align:right; font-size:15px;'><i class="fas fa-edit fa-lg  margin-left-20" title="Click for edit" onclick="javascript:viewEditRCAForm('${rcaReport.rcaid}');"></i></td>
										<td width=200px; style='text-align:right; font-size:15px;'><i style="color: #f95414fa;" class="fas fa-trash-alt fa-lg  margin-left-20" title="Click for delete" onclick="javascript:deleteRCAForm('${rcaReport.rcaid}');"></i></td>
									</tr>
								<%
									count++;
								%>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
				</div>
			</div>
		</div>
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
		function submitData() {
			document.rcaReportForm.method = "POST";
			document.rcaReportForm.action = "<c:url value='${contextPath}/rca/view_rca_form'/>";
			document.rcaReportForm.submit();
		}
		function submitRCA() {
			var smSitecodeValue = $ID('smSitecode').value;
			var smSitenameValue = $ID('smSitename').value;
			
			if (checkNullOrEmpty(smSitecodeValue)) {
			document.rcaReportForm.method = "POST";
			document.rcaReportForm.action = "<c:url value='${contextPath}/rca/create_rca'/>";
			document.rcaReportForm.submit();
			}else
				alert("Please Select atleast one Site Code.");
		}
		function calculateDiffereneceInTime(){
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
			document.rcaReportForm.action = "<c:url value='${contextPath}/rca/get_rca_details'/>";
			document.rcaReportForm.submit();
		}
		function deleteRCAForm(rcaid)
		{ 
			$("#rcaid").val(rcaid);
			document.rcaReportForm.method = "POST";
			document.rcaReportForm.action = "<c:url value='${contextPath}/rca/delete_rca_details'/>";
			document.rcaReportForm.submit();
		}
		
		function fnExcelReport()
		{
		   
		   var tab_text="<table border='2px'>"; 
			var tab_text=tab_text+"<tr  height='50'><th colspan='11' style='text-align:center; font-size:20px;'>RCA Report</th></tr>"; 
		   
		    var textRange; var j=0;
		    tab = document.getElementById('rcaReportTable'); // id of table

		    var lines = tab.rows.length;
			 // the first headline of the table
		    if (lines > 0) {
		        tab_text = tab_text + '<tr > <th width=200px; style=text-align:center; font-size:20px;>' + tab.rows[0].innerHTML + '</th></tr>';
		    }
			    for(i=1 ; i < lines-2 ; i++) 
			    { 
			    tab_text = tab_text + '<tr>  <td width=200px; style=text-align:right; font-size:15px;>' + tab.rows[i].innerHTML + '</td></tr>';
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
		        sa=txtArea1.document.execCommand("SaveAs",true,"RCAReport.xls");
		    }  
		    else   {              //other browser not tested on IE 11
		       /*  sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));   */

		    	  let a = $("<a />", {
		              href: 'data:application/vnd.ms-excel,' + encodeURIComponent(tab_text),
		              download: "RCAReport.xls"
		          })
		          .appendTo("body")
		          .get(0)
		          .click();
		          e.preventDefault();
		      }

		      return (sa);
		}
		
		function downloadCSV(csv, filename) {
		    var csvFile;
		    var downloadLink;

		    // CSV file
		    csvFile = new Blob([csv], {type: "text/csv"});

		    // Download link
		    downloadLink = document.createElement("a");

		    // File name
		    downloadLink.download = filename;

		    // Create a link to the file
		    downloadLink.href = window.URL.createObjectURL(csvFile);

		    // Hide download link
		    downloadLink.style.display = "none";

		    // Add the link to DOM
		    document.body.appendChild(downloadLink);

		    // Click download link
		    downloadLink.click();
		}

		function exportTableToCSV(filename) {
		    var csv = [];
			var rows = document.getElementById("rcaReportTable").rows;
		    for (var i = 0; i < rows.length; i++) {
				var row = [], cols = rows[i].querySelectorAll("td, th");
		        for (var j = 0; j < cols.length; j++) 
		            row.push(cols[j].innerText);
					csv.push(row.join(","));		
			}

		    // Download CSV file
		    downloadCSV(csv.join("\n"), filename);
		}
		
		$(document).ready(function() {
		    var table = $('#rcaReportTable').DataTable( {
		        responsive: true
		    } );
		 
		    // new $.fn.dataTable.FixedHeader( table );
		} );
	</script>
</html>