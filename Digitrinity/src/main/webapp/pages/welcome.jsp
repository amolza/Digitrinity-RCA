<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Welcome</title>
<jsp:include page="include_hdr.jsp"></jsp:include>
</head>
<body style="background-color: #e9e9e9; font-size: .88rem;" data-spy="scroll">
	<jsp:include page="header.jsp"></jsp:include>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.css"
		integrity="sha256-aa0xaJgmK/X74WM224KMQeNQC2xYKwlAt08oZqjeF0E="
		crossorigin="anonymous" />
	<div class="container-fluid">
		<div class="row-12 top7">
			<div class="row p-2" style="background-color: white">
				<div class="col" style="max-width: 10rem;">
					<div class="card bg-c-lite-green update-card">
						<div class="card-block">
							<div class="row align-items-end">
								<div class="col-8">
									<p class="text-white"><span id="totalSite" class="font-weight-bold" style="font-size: 0.8rem;">##</span></p>
									<p class="text-white m-b-0">Total</p>
								</div>
								<div class="col-4 text-right">
									<h6><i class="fas fa-signal"></i></h6>
								</div>
							</div>
						</div>						
					</div>
				</div>
				<div class="col" style="max-width: 10rem;">
					<div class="card bg-c-green update-card">
						<div class="card-block">
							<div class="row align-items-end">
								<div class="col-8">
									<p class="text-white"><span id="onlineSite" class="font-weight-bold" style="font-size: 0.8rem;">##</span></p>
									<p class="text-white m-b-0">Online</p>
								</div>
								<div class="col-4 text-right">
									<h6><i class="fas fa-signal"></i></h6>
								</div>
							</div>
						</div>						
					</div>
				</div>
				<div class="col" style="max-width: 10rem;">
					<div class="card bg-c-pink update-card">
						<div class="card-block">
							<div class="row align-items-end">
								<div class="col-8">
									<p class="text-white"><span id="offlineSite" class="font-weight-bold" style="font-size: 0.8rem;">##</span></p>
									 <p class="text-white m-b-0">Offline</p> 
								</div>
								<div class="col-4 text-right">
									<h6><i class="fas fa-signal"></i></h6>
								</div>
							</div>
						</div>						
					</div>
				</div>
			</div>
		</div>
		
		<div class="row top7" style="background-color:#e9e9e9;">
			<div class="col-md-9 mx-auto box p-3" style="background-color: white;overflow-x:auto;white-space: nowrap;">
			<div class="inner">
				<table cellspacing="5" cellpadding="5" class="filter-table">
					<tr>
						<td><label class='control-label mr-2'
							for="hourly-site-id-select"><strong>Region</strong></label></td>
						<td><select id="region-select" name="region-select"
							class="selectpicker form-control" data-live-search="true"
							multiple title="Region" data-width="50px"
							style="background-color: #5cb85c; color: #fff;">
								<option value="All" selected="selected">All</option>
						</select></td>
						<td><label class='control-label mr-2'
							for="hourly-site-id-select"><strong>Zone</strong></label></td>
						<td><select id="zone-select" name="zone-select"
							class="selectpicker" data-live-search="true" multiple
							title="Zone" data-width="50px" data-all="false">
								<option value="All" selected="selected">All</option>
						</select></td>
						<td><label class='control-label mr-2'
							for="hourly-site-id-select"><strong>Cluster</strong></label></td>
						<td><select id="cluster-select" name="cluster-select"
							class="selectpicker" data-live-search="true" multiple
							title="Cluster" data-width="50px">
								<option value="All" selected="selected">All</option>
						</select></td>
						<td><label class='control-label mr-2'
							for="hourly-site-id-select"><strong>Site ID</strong></label></td>
						<td><select id="siteId" name="siteId" class="selectpicker"
							data-live-search="true" data-size="5" multiple title="Site ID"
							data-width="50px">
								<option value="All" selected="selected">All</option>
						</select></td>
						<td><label class='control-label mr-2'
							for="hourly-site-id-select"><strong>Customer</strong></label></td>
						<td><select id="customer" name="customer"
							class="selectpicker" data-live-search="true" multiple
							title="Customer" data-width="50px">
								<option value="All" selected="selected">All</option>
						</select></td>

						<td><label class='control-label mr-2'
							for="hourly-site-id-select"><strong>Site Type</strong></label></td>
						<td><select id="siteType" name="siteType"
							class="selectpicker" data-live-search="true" multiple
							title="Site Type" data-width="50px">
								<option value="All" selected="selected">All</option>
						</select></td>
					</tr>
				</table>
				
				<table id="latestDataReportTable" class="table table-striped table-bordered table-fixed table-hover table-condensed" style="width: 100%">					
						<thead class="text-center datatable-header">
									<tr> 
										<th style="font-size: xx-small; width:5px;">Last Updated</th>
										<th style="font-size: xx-small; width:5px;">Site ID</th>
										<th style="font-size: xx-small; width:5px;">Site Name</th>
										<th style="font-size: xx-small; width:5px;">Power Source</th>										
										<th style="font-size: xx-small; width:5px;">Customer</th>
										<th style="font-size: xx-small; width:5px;">Battery SOC</th>
										<th style="font-size: xx-small; width:5px;">DC Load</th>
										<th style="font-size: xx-small; width:5px;">DC Voltage (Kw)</th>
										<th style="font-size: xx-small; width:5px;">DG Power (Kw)</th>
										<th style="font-size: xx-small; width:5px;">Fuel Level (Ltrs)</th>
										<th style="font-size: xx-small; width:5px;">Solar (Kw)</th>
										<th style="font-size: xx-small; width:5px;">Critical</th>
										<th style="font-size: xx-small; width:5px;">Major</th>
										<th style="font-size: xx-small; width:5px;">Minor</th>
										<th style="font-size: xx-small; width:5px;">Offline Duration</th>
										<th style="font-size: xx-small; width:5px;">Engineer Name</th>
										<th style="font-size: xx-small; width:5px;">Location</th>
									</tr>
								</thead>
								<tbody class="text-center"></tbody>							
							</table>
							
							</div>
							
				</div>
					
				<div class="col-md-3 mx-auto p-3" style="background-color: white;overflow-x:auto;white-space: nowrap;border-left: 5px solid #e9e9e9;">
				<div class="inner">
							<table cellspacing="5" cellpadding="5" class="filter-table">
								<tr>
									<td><label class='control-label mr-2'
										for="hourly-site-id-select"><strong>Alarm
												category</strong></label></td>
									<td><select id="alarm-category-select"
										name="region-select" class="selectpicker form-control"
										data-live-search="true" multiple title="Alarm Category"
										data-width="150px"
										style="background-color: #5cb85c; color: #fff;">
											<option value="All" selected="selected">All</option>
									</select></td>
									<td class="d-none"><label class='control-label mr-2'
										for="hourly-site-id-select"><strong>Site ID</strong></label></td>
									<td class="d-none"><select id="alarm-site-id-select"
										name="alarm-site-id-select" class="selectpicker"
										data-live-search="true" multiple title="Site ID"
										data-width="150px" data-all="false" data-size="10">
											<option value="All" selected="selected">All</option>
									</select></td>
									<td class="d-none"><label class='control-label mr-2'
										for="hourly-site-id-select"><strong>Severity</strong></label></td>
									<td class="d-none"><select id="alarm-severity-select"
										name="alarm-severity-select" class="selectpicker"
										data-live-search="true" multiple title="Site Type"
										data-width="150px">
											<option value="All" selected="selected">All</option>
									</select></td>
								</tr>
								<tr>
									
								</tr>
							</table>


							<table id="alarmTable"
								class="table table-striped table-bordered table-fixed table-hover table-condensed" style="width: 100%">								
								<thead class="text-center datatable-header">
									<tr>
										<th style="font-size: xx-small; width:5px;">Site ID</th>
										<th style="font-size: xx-small; width:5px;"">Alarm Name</th>
										<th style="font-size: xx-small; width:5px;"">Alarm Open Time</th>
										<th style="font-size: xx-small; width:5px;"">Elapsed Time</th>
									</tr>
								</thead>
								<tbody class="text-center"></tbody>
							</table>
							</div>
				</div>
				
				</div>
					
		 <div class="row-12 m-2">
			<div class="row p-2" style="background-color: white">
				<table cellspacing="5" cellpadding="5" class="filter-table">
				<tr>
					<td><label class='control-label mr-2'><strong>Date</strong></label></td>
					<td><input id="datetimepicker" class="form-control" type="text" style="width: 280px"/></td>
					<td class="d-none"><label class='control-label mr-2' for="hourly-site-id-select"><strong>Site ID</strong></label></td>
					<td class="d-none"><select id="hourly-site-id-select"
							name="hourly-site-id-select" class="selectpicker form-control"
							data-live-search="true" multiple title="Site Id"
							data-width="150px">
							<option value="All" selected="selected">All</option>
						</select>
					</td>
					<td class="d-none"><label class='control-label mr-2' for="hourly-site-type-select"><strong>Site ID</strong></label></td>
					<td class="d-none"><select id="hourly-site-type-select" class="form-control"
							name="hourly-site-type-select" class="selectpicker"
							data-live-search="true" multiple title="Site Type"
							data-width="150px">
							<option value="All" selected="selected">All</option>
						</select>
					</td>
					<td class="d-none"><label class='control-label mr-2' for="hourly-device-type-select"><strong>Device Type</strong></label></td>
					<td class="d-none"><select id="hourly-device-type-select" class="form-control"
							name="hourly-device-type-select" class="selectpicker"
							data-live-search="true" multiple title="Device Type"
							data-width="150px">
							<option value="All" selected="selected">All</option>
						</select>
					</td>
				</tr>
				</table>
			</div>
			<div class="row" style="background-color: white">
				<canvas id="bar-chart" width="800" height="190"></canvas>
			</div>
		</div>
	</div>
	<jsp:include page="include_ftr.jsp"></jsp:include>
	<script src="${contextPath}/resources/js/dashboard.js"
		type="text/javascript"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"
		integrity="sha256-R4pqcOYV8lt7snxMQO/HSbVCFRPMdrhAFMH+vr9giYI="
		crossorigin="anonymous"></script>
</body>
</html>