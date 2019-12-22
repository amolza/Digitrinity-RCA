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
<title>Welcome</title>
<jsp:include page="include_hdr.jsp"></jsp:include>
</head>
<body style="background-color: #e9e9e9" data-spy="scroll">
	<jsp:include page="header.jsp"></jsp:include>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.css"
		integrity="sha256-aa0xaJgmK/X74WM224KMQeNQC2xYKwlAt08oZqjeF0E="
		crossorigin="anonymous" />
	<div class="container-fluid">
		<div class="row-12 m-2">
		<div class="row p-3 text-center" style="background-color: white">
					<div class="col-sm">
						<div class="alert alert-primary" role="alert">
							<span class="font-weight-bold" style="font-size: 15px;">Total
								Sites</span>
							<h5>
								<span class="font-weight-bold" style="font-size: 25px;">300</span>
							</h5>
						</div>
					</div>
					<div class="col-sm">
						<div class="alert alert-success" role="alert">
							<span class="font-weight-bold" style="font-size: 15px;">Online</span>
							<h5>
								<span class="font-weight-bold" style="font-size: 25px;">250</span>
							</h5>
						</div>
					</div>
					<div class="col-sm">
						<div class="alert alert-danger" role="alert">
							<span class="font-weight-bold" style="font-size: 15px;">Offline</span>
							<h5>
								<span class="font-weight-bold" style="font-size: 25px;">50</span>
							</h5>
						</div>
					</div>
				</div>
		</div>	
		<div class="row-12 m-2">
			<div class="row">	
			<div class="col-8">
				<div class="row p-2" style="background-color: white;">
					<form class="form-inline pt-3">
						<div class="form-group">
							<label class='control-label mr-2' for="hourly-site-id-select"><strong>Region</strong></label>
							<select id="region-select" name="region-select"
								class="selectpicker form-control" data-live-search="true"
								multiple title="Region" data-width="150px"
								style="background-color: #5cb85c; color: #fff;">
								<option value="All" selected="selected">All</option>
							</select>
						</div>
						<div class="form-group m-2">
						<label class='control-label mr-2' for="hourly-site-id-select"><strong>Zone</strong></label>
						<select id="zone-select" name="zone-select" class="selectpicker"
									data-live-search="true" multiple title="Zone"
									data-width="150px" data-all="false">
									<option value="All" selected="selected">All</option>
								</select>
						</div>
						<div class="form-group m-2">
						<label class='control-label mr-2' for="hourly-site-id-select"><strong>Cluster</strong></label>
						<select id="cluster-select" name="cluster-select"
									class="selectpicker" data-live-search="true" multiple
									title="Cluster" data-width="150px">
									<option value="All" selected="selected">All</option>
								</select>
						</div>
						<div class="form-group m-2">
						<label class='control-label mr-2' for="hourly-site-id-select"><strong>Site ID</strong></label>
						<select id="siteId" name="siteId" class="selectpicker"
									data-live-search="true" multiple title="Site ID"
									data-width="150px">
									<option value="All" selected="selected">All</option>
								</select>
						</div>
						<div class="form-group m-2">
						<label class='control-label mr-2' for="hourly-site-id-select"><strong>Customer</strong></label>
						<select id="customer" name="customer" class="selectpicker"
									data-live-search="true" multiple title="Customer"
									data-width="150px">
									<option value="All" selected="selected">All</option>
								</select>
						</div>
						<div class="form-group m-2">
						<label class='control-label mr-2' for="hourly-site-id-select"><strong>Site Type</strong></label>
						<select id="siteType" name="siteType" class="selectpicker"
									data-live-search="true" multiple title="Site Type"
									data-width="150px">
									<option value="All" selected="selected">All</option>
								</select>
						</div>

					</form>
					<table id="latestDataReportTable"
						class="table table-bordered compact nowrap"
						style="width: 100%">
						<!-- <thead style="background-color: #343a40;color: #fff;"> -->
						<thead class="text-center"
							style="background-color: #343a40; color: #fff;">
							<tr>
								<th></th>
								<th>Last Updated</th>
								<th>Site ID</th>
								<th>Site Name</th>
								<th>Customer</th>
								<th>DC Voltage (Kw)</th>
								<th>Critical</th>
								<th>Major</th>								
								<th>Offline Duration</th>								
							</tr>
						</thead>
						<tbody class="text-center"></tbody>
						<!-- <tfoot class="text-center">
							<tr>
								
								<th>Last Updated</th>
								<th>Site ID</th>
								<th>Site Name</th>
								<th>Customer</th>
								<th>DC Load</th>
								<th>Critical</th>
								<th>Major</th>
								<th>Minor</th>
								<th>Offline Duration</th>
							</tr>
						</tfoot> -->
					</table>
				</div>
			</div>
			</div>	

		</div>
		<div class="row-12 m-2">
			<div class="row p-2" style="background-color: white">
				<form class="form-inline">

					<div class="form-group m-2">
						<label class='control-label mr-2'><strong>Date</strong></label> <input
							id="datetimepicker" class="form-control" type="text"
							style="width: 280px">
					</div>
					<div class="form-group m-2">
						<label class='control-label mr-2' for="hourly-site-id-select"><strong>Site
								ID</strong></label> <select id="hourly-site-id-select"
							name="hourly-site-id-select" class="selectpicker form-control"
							data-live-search="true" multiple title="Site Id"
							data-width="150px">
							<option value="All" selected="selected">All</option>
						</select>
					</div>
					<div class="form-group m-2">
						<label class='control-label mr-2' for="hourly-site-type-select"><strong>Site
								ID</strong></label> <select id="hourly-site-type-select" class="form-control"
							name="hourly-site-type-select" class="selectpicker"
							data-live-search="true" multiple title="Site Type"
							data-width="150px">
							<option value="All" selected="selected">All</option>
						</select>
					</div>
					<div class="form-group m-2">
						<label class='control-label mr-2' for="hourly-device-type-select"><strong>Device
								Type</strong></label> <select id="hourly-device-type-select" class="form-control"
							name="hourly-device-type-select" class="selectpicker"
							data-live-search="true" multiple title="Device Type"
							data-width="150px">
							<option value="All" selected="selected">All</option>
						</select>
					</div>

				</form>				
			</div>
			<div class="row" style="background-color: white">
					<canvas id="bar-chart" width="800" height="200"></canvas>
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