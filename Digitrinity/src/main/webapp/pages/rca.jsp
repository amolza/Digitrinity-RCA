<!DOCTYPE html>
<html lang="en" >
	<head>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div class="content-wrapper content-wrapper--with-bg" style="overflow-x: hidden; overflow-y: auto;">
				<div class="list-group">
					<form:form method="POST" modelAttribute="rcaReportForm"	name="rcaReportForm">
						<div class="container">
						    <div class="row">
						    	<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
						    		<span class="control-label">Select Date</span>
						    	</div>
						        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
						            <div class="form-group">
							            <div class="input-group date" data-provide="datepicker">
											<form:input path="rcaDate" class="form-control" placeholder="Select Date" id="datetimepicker1"/>
											<div class="input-group-append" >
												<span class="input-group-text">
												<span class="fa fa-calendar-alt"></span>
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
						            	<form:select class="form-control" path="smSiteID" items="${siteMasters}" itemLabel="smSitename" itemValue="smSiteID" />
									</div>
						        </div>
						    </div>
						    <div class="row">
						    	<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
						    		<span class="control-label">Select Region Name</span>
						    	</div>
						        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
						            <div class="form-group">
							            <form:select class="form-control" path="rgRegionID" items="${regionMasters}" itemLabel="rgRegion" itemValue="rgRegionID" />
									</div>
						        </div>
						        <div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
						    		<span>Enter AnhorOprtr</span>
						    	</div>
						        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
						            <div class="form-group">
						            	<form:input class="form-control" placeholder="Enter AnchorOprtr" id="anchorOprtr" path="anchorOprtr" name="anchorOprtr" required="required" pattern="(?!^ +$)^.+$" value="" maxlength="100" />
									</div>
						        </div>
						    </div>
						    <div class="row">
						    	<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
						    		<span class="control-label">Enter OPCOID</span>
						    	</div>
						        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
						            <div class="form-group">
							            <form:input class="form-control" placeholder="Enter OPCOID" id="opcoId" path="opcoId" name="opcoId" required="required" pattern="(?!^ +$)^.+$" value="" maxlength="100" />
									</div>
						        </div>
						        <div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
						    		<span>Input Site Down Time</span>
						    	</div>
						        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
						            <div class="form-group">
						            	<div class="input-group date" data-provide="datepicker">
											<form:input path="siteDownTime" class="form-control" placeholder="Select Date" id="datetimepicker2" onchange="calculateDiffereneceInTime(this); return false;"/>
											<div class="input-group-append" >
												<span class="input-group-text">
												<span class="fa fa-calendar-alt"></span>
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
											<form:input path="restoredTime" class="form-control" placeholder="Select Date" id="datetimepicker3" onchange="calculateDiffereneceInTime(this); return false;"/>
											<div class="input-group-append" >
												<span class="input-group-text">
													<span class="fa fa-calendar-alt"></span>
												</span>                    
											</div>
										</div>
									</div>
						        </div>
						        <div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
						    		<span>Input Time</span>
						    	</div>
						        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
						            <div class="form-group">
						            	<form:input id="input-time" class="form-control" path="siteDownDuration" /> <!-- type="time" value="00:00:01" -->
									</div>
						        </div>
						    </div>
						    <div class="row">
						    	<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
						    		<span class="control-label">Select Issue Name</span>
						    	</div>
						        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
						            <div class="form-group">
							            <form:select path="issueCatID" items="${issueCategoryMasters}" class="form-control" itemLabel="issuename" itemValue="issueCatID" />
									</div>
						        </div>
						        <div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
						    		<span>Select Outage Category</span>
						    	</div>
						        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
						            <div class="form-group">
						            	<form:select path="outageCatID" class="form-control" items="${outageCategoryMasters}" itemLabel="outageCategory" itemValue="outageCatID" />
									</div>
						        </div>
						    </div>
						    <div class="row">
						    	<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
						    		<span class="control-label">Select Fault Category</span>
						    	</div>
						        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
						            <div class="form-group">
							            <form:select path="faultID" items="${faultCategoryMasters}" class="form-control" itemLabel="faultCategory" itemValue="faultID" />
									</div>
						        </div>
						        <div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
						    		<span>Enter RCA</span>
						    	</div>
						        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
						            <div class="form-group">
						            	<form:input class="form-control" placeholder="Enter RCA" id="" path="rca" name="" required="required" pattern="(?!^ +$)^.+$" value="" maxlength="100" />
									</div>
						        </div>
						    </div>
						    <div class="row">
						    	<div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
						    		<span class="control-label">Enter Outage In Minutes</span>
						    	</div>
						        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
						            <div class="form-group">
							            <form:input class="form-control" placeholder="Enter Title" id="" path="outageInMinutes" name="" required="required" pattern="(?!^ +$)^.+$" value="" maxlength="100" />
									</div>
						        </div>
						        <div class="col-lg-2 col-md-2 col-sm-6 col-xs-6 text-right">
						    		<span>Enter SLA</span>
						    	</div>
						        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
						            <div class="form-group">
						            	<form:input class="form-control" placeholder="Enter Title" id="" path="sla" name="" required="required" pattern="(?!^ +$)^.+$" value=""	maxlength="100" />
									</div>
						        </div>
						    </div>
						    <div class="row">
						    	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" align="center">
									<button class="btn btn-primary" title="SUBMIT" onclick="submitRCA(); return false;" type="button">SUBMIT</button>
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
		
	</script>
</html>