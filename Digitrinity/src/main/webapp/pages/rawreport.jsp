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
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Welcome</title>
<jsp:include page="include_hdr.jsp"></jsp:include>
</head>
<body style="background-color: #e9e9e9; font-size: .88rem;"
	data-spy="scroll">
	<jsp:include page="header.jsp"></jsp:include>

	<section id="raw-report-header">
		<div class="container-fluid">

			<div class="row-12 text-center" style="background-color: white;">
				<h3>Raw Data Report</h3>
			</div>
		</div>
	</section>


	<section id="raw-report-filter">
		<div class="container-fluid">
			<div class="row-12" style="background-color: white;">
				<table cellspacing="5" cellpadding="5">
					<tr>
						<td><label class='control-label mr-2'
							for="hourly-site-id-select"><strong>Region</strong></label></td>
						<td><select id="region-select" name="region-select"
							class="selectpicker form-control" data-live-search="true"
							multiple title="Region" data-width="150px"
							style="background-color: #5cb85c; color: #fff;">
								<option value="All" selected="selected">All</option>
						</select></td>
						<td><label class='control-label mr-2'
							for="hourly-site-id-select"><strong>Zone</strong></label></td>
						<td><select id="zone-select" name="zone-select"
							class="selectpicker" data-live-search="true" multiple
							title="Zone" data-width="150px" data-all="false">
								<option value="All" selected="selected">All</option>
						</select></td>
						<td><label class='control-label mr-2'
							for="hourly-site-id-select"><strong>Cluster</strong></label></td>
						<td><select id="cluster-select" name="cluster-select"
							class="selectpicker" data-live-search="true" multiple
							title="Cluster" data-width="150px">
								<option value="All" selected="selected">All</option>
						</select></td>
						<td><label class='control-label mr-2'
							for="hourly-site-id-select"><strong>Site ID</strong></label></td>
						<td><select id="siteId" name="siteId" class="selectpicker"
							data-live-search="true" multiple title="Site ID"
							data-width="150px">
								<option value="All" selected="selected">All</option>
						</select></td>
						<td><label class='control-label mr-2'
							for="hourly-site-id-select"><strong>Customer</strong></label></td>
						<td><select id="customer" name="customer"
							class="selectpicker" data-live-search="true" multiple
							title="Customer" data-width="150px">
								<option value="All" selected="selected">All</option>
						</select></td>

						<td><label class='control-label mr-2'
							for="hourly-site-id-select"><strong>Site Type</strong></label></td>
						<td><select id="siteType" name="siteType"
							class="selectpicker" data-live-search="true" multiple
							title="Site Type" data-width="150px">
								<option value="All" selected="selected">All</option>
						</select></td>
					</tr>
				</table>
			</div>
		</div>
	</section>
	<section id="raw-report-filter">
		<div class="container-fluid">
			<div class="row-12"
				style="background-color: white; overflow-x: auto; white-space: nowrap;">
				<div class="col-md-12 mx-auto box p-3"
					style="background-color: white; overflow-x: auto;overflow-y: auto; white-space: nowrap;height:100%">
					<table id="rawDataReportDataTable"
						class="table table-striped table-bordered table-fixed table-hover table-condensed"
						style="width: 100%;height:100%;">
						<thead class="text-center"
							style="background-color: #343a40; color: #fff;">
							<tr>
								<th>Cluster</th>
								<th>Site ID</th>
								<th>Updated Date time</th>
								<th>Transaction time</th>
								<th>Alarm</th>
								<th>Status</th>
								<th>Communication</th>
								<th>System Out Load Status</th>
								<th>Power Source</th>
								<th>Site Battery Voltage</th>
								<th>Battery SOC</th>
								<th>Opco 1 Load Current</th>
								<th>Opco 2 Load Current</th>
								<th>Opco 3 Load Current</th>
								<th>Opco 4 Load Current</th>
								<th>Opco 1 Energy</th>
								<th>Opco 2 Energy</th>
								<th>Opco 3 Energy</th>
								<th>Opco 4 Energy</th>
								<th>Battery 1 Temperature</th>
								<th>Battery 2 Temperature</th>
								<th>Battery 3 Temperature</th>
								<th>Battery 4 Temperature</th>
								<th>Fuel Level (%)</th>
								<th>Fuel Level (Liters)</th>
								<th>MDG R Voltage</th>
								<th>MDG Y Voltage</th>
								<th>MDG B Voltage</th>
								<th>MDG R Amp</th>
								<th>MDG Y Amp</th>
								<th>MDG B Amp</th>
								<th>MDG R Power Factor</th>
								<th>MDG Y Power Factor</th>
								<th>MDG B Power Factor</th>
								
								<th>MDG R Power</th>
								<th>MDG Y Power</th>
								<th>MDG B Power</th>
								
								<th>MDG Frequency</th>
								
								<th>DG R Voltage</th>
								<th>DG Y Voltage</th>
								<th>DG B Voltage</th>
								
								<th>DG R Amp</th>
								<th>DG Y Amp</th>
								<th>DG B Amp</th>
								<th>DG R Power Factor</th>
								<th>DG Y Power Factor</th>
								<th>DG B Power Factor</th>
								
								<th>DG R Power</th>
								<th>DG Y Power</th>
								<th>DG B Power</th>
								
								<th>DG Frequency</th>
								
								<th>DG Battery Voltage</th>
								
								<th>DG Tank Capacity</th>
								
								<th>Battery Charging Current</th>
								
								<th>Battery DisCharging Current</th>
								
								<th>Battery Cycle Count</th>
								
								<th>Battery Capacity (AH)</th>
								
								<th>Battery Next Full Charge Time</th>
								
								<th>Number of Batteries</th>
								
								<th>MDG Run (Hours)</th>
								
								<th>DG Run (Hours)</th>
								
								
								<th>Battery Run (Hours)</th>
								
								<th>MDG Energy</th>
								
								<th>DG Energy</th>
								
								<th>Battery Discharging Energy</th>
								
								<th>Battery Charging Energy</th>
								
								<th>React Input R Voltage</th>
								
								<th>React Input Y Voltage</th>
								
								<th>React Input B Voltage</th>
								
								<th>React Input R Current</th>
								
								<th>React Input Y Current</th>
								
								<th>React Input B Current</th>
								
								<th>React Output Voltage</th>
								
								<th>Number of Rectifier</th>
								
								
								<th>Total Rect Output Current</th>
								
								<th>Total DC Load Current</th>
								
								<th>Total DC Load Energy</th>
								
								<th>Input Voltage Solar Module 1</th>
								
								<th>Input Current Solar Module 1</th>
								
								<th>Input Power Solar Module 1</th>
								
								<th>Output Voltage Solar Module 1</th>
								
								<th>Output Current Solar Module 1</th>
								
								<th>Output Power Solar Module 1</th>
								
								<th>Solar Module 1 Status</th>
								
								
								<th>Input Voltage Solar Module 2</th>
								
								<th>Input Current Solar Module 2</th>
								
								<th>Input Power Solar Module 2</th>
								
								<th>Output Voltage Solar Module 2</th>
								
								<th>Output Current Solar Module 2</th>
								
								<th>Output Power Solar Module 2</th>
								
								<th>Solar Module 2 Status</th>
								
								
								<th>Input Voltage Solar Module 3</th>
								
								<th>Input Current Solar Module 3</th>
								
								<th>Input Power Solar Module 3</th>
								
								<th>Output Voltage Solar Module 3</th>
								
								<th>Output Current Solar Module 3</th>
								
								<th>Output Power Solar Module 3</th>
								
								<th>Solar Module 3 Status</th>
								
								
								<th>Input Voltage Solar Module 4</th>
								
								<th>Input Current Solar Module 4</th>
								
								<th>Input Power Solar Module 4</th>
								
								<th>Output Voltage Solar Module 4</th>
								
								<th>Output Current Solar Module 4</th>
								
								<th>Output Power Solar Module 4</th>
								
								<th>Solar Module 4 Status</th>
								
								
								
								<th>Input Voltage Solar Module 5</th>
								
								<th>Input Current Solar Module 5</th>
								
								<th>Input Power Solar Module 5</th>
								
								<th>Output Voltage Solar Module 5</th>
								
								<th>Output Current Solar Module 5</th>
								
								<th>Output Power Solar Module 5</th>
								
								<th>Solar Module 5 Status</th>
								
								
								<th>Input Voltage Solar Module 6</th>
								
								<th>Input Current Solar Module 6</th>
								
								<th>Input Power Solar Module 6</th>
								
								<th>Output Voltage Solar Module 6</th>
								
								<th>Output Current Solar Module 6</th>
								
								<th>Output Power Solar Module 6</th>
								
								<th>Solar Module 6 Status</th>
								
								
								<th>Input Voltage Solar Module 7</th>
								
								<th>Input Current Solar Module 7</th>
								
								<th>Input Power Solar Module 7</th>
								
								<th>Output Voltage Solar Module 7</th>
								
								<th>Output Current Solar Module 7</th>
								
								<th>Output Power Solar Module 7</th>
								
								<th>Solar Module 7 Status</th>
								
								
								<th>Input Voltage Solar Module 8</th>
								
								<th>Input Current Solar Module 8</th>
								
								<th>Input Power Solar Module 8</th>
								
								<th>Output Voltage Solar Module 8</th>
								
								<th>Output Current Solar Module 8</th>
								
								<th>Output Power Solar Module 8</th>
								
								<th>Solar Module 8 Status</th>
								
								
								<th>Input Voltage Solar Module 9</th>
								
								<th>Input Current Solar Module 9</th>
								
								<th>Input Power Solar Module 9</th>
								
								<th>Output Voltage Solar Module 9</th>
								
								<th>Output Current Solar Module 9</th>
								
								<th>Output Power Solar Module 9</th>
								
								<th>Solar Module 9 Status</th>
								
								
								<th>Input Voltage Solar Module 10</th>
								
								<th>Input Current Solar Module 10</th>
								
								<th>Input Power Solar Module 10</th>
								
								<th>Output Voltage Solar Module 10</th>
								
								<th>Output Current Solar Module 10</th>
								
								<th>Output Power Solar Module 10</th>
								
								<th>Solar Module 10 Status</th>
								
								
								<th>Input Voltage Solar Module 11</th>
								
								<th>Input Current Solar Module 11</th>
								
								<th>Input Power Solar Module 11</th>
								
								<th>Output Voltage Solar Module 11</th>
								
								<th>Output Current Solar Module 11</th>
								
								<th>Output Power Solar Module 11</th>
								
								<th>Solar Module 11 Status</th>
								
								
								<th>Input Voltage Solar Module 12</th>
								
								<th>Input Current Solar Module 12</th>
								
								<th>Input Power Solar Module 12</th>
								
								<th>Output Voltage Solar Module 12</th>
								
								<th>Output Current Solar Module 12</th>
								
								<th>Output Power Solar Module 12</th>
								
								<th>Solar Module 12 Status</th>
								
								
								<th>Input Voltage Solar Module 13</th>
								
								<th>Input Current Solar Module 13</th>
								
								<th>Output Voltage Solar Module 13</th>
								
								<th>Output Current Solar Module 13</th>
								
								<th>Solar Module 13 Status</th>
								
								
								<th>Input Voltage Solar Module 14</th>
								
								<th>Input Current Solar Module 14</th>
								
								<th>Output Voltage Solar Module 14</th>
								
								<th>Output Current Solar Module 14</th>
								
								<th>Solar Module 14 Status</th>
								
								
								<th>Input Voltage Solar Module 15</th>
								
								<th>Input Current Solar Module 15</th>
								
								<th>Output Voltage Solar Module 15</th>
								
								<th>Output Current Solar Module 15</th>
								
								<th>Solar Module 15 Status</th>
								
								
								<th>Input Voltage Solar Module 16</th>
								
								<th>Input Current Solar Module 16</th>
								
								<th>Output Voltage Solar Module 16</th>
								
								<th>Output Current Solar Module 16</th>
								
								<th>Solar Module 16 Status</th>
								
								
								<th>Input Voltage Solar Module 17</th>
								
								<th>Input Current Solar Module 17</th>
								
								<th>Output Voltage Solar Module 17</th>
								
								<th>Output Current Solar Module 17</th>
								
								<th>Solar Module 17 Status</th>
								
								
								<th>Input Voltage Solar Module 18</th>
								
								<th>Input Current Solar Module 18</th>
								
								<th>Output Voltage Solar Module 18</th>
								
								<th>Output Current Solar Module 18</th>
								
								<th>Solar Module 18 Status</th>
								
								
								<th>Input Voltage Solar Module 19</th>
								
								<th>Input Current Solar Module 19</th>
								
								<th>Output Voltage Solar Module 19</th>
								
								<th>Output Current Solar Module 19</th>
								
								<th>Solar Module 19 Status</th>
								
								
								<th>Input Voltage Solar Module 20</th>
								
								<th>Input Current Solar Module 20</th>
								
								<th>Output Voltage Solar Module 20</th>
								
								<th>Output Current Solar Module 20</th>
								
								<th>Solar Module 20 Status</th>
								
								
								<th>Input Voltage Solar Module 21</th>
								
								<th>Input Current Solar Module 21</th>
								
								<th>Output Voltage Solar Module 21</th>
								
								<th>Output Current Solar Module 21</th>
								
								<th>Solar Module 21 Status</th>
								
								
								<th>Input Voltage Solar Module 22</th>
								
								<th>Input Current Solar Module 22</th>
								
								<th>Output Voltage Solar Module 22</th>
								
								<th>Output Current Solar Module 22</th>
								
								<th>Solar Module 22 Status</th>
								
								
								<th>Input Voltage Solar Module 23</th>
								
								<th>Input Current Solar Module 23</th>
								
								<th>Output Voltage Solar Module 23</th>
								
								<th>Output Current Solar Module 23</th>
								
								<th>Solar Module 23 Status</th>
								
								
								<th>Input Voltage Solar Module 24</th>
								
								<th>Input Current Solar Module 24</th>
								
								<th>Output Voltage Solar Module 24</th>
								
								<th>Output Current Solar Module 24</th>
								
								<th>Solar Module 24 Status</th>
								
								
								<th>Number of Solar Module</th>
								
								<th>Solar Input Energy</th>
								
								<th>Solar Output Energy</th>
								
								
								<th>Solar Run (Hours)</th>
								
								<th>Solar Run MDG Run (Hours)</th>
								
								<th>Solar Run DG Run (Hours)</th>
								
								<th>Solar Battery Run (Hours)</th>
								
								<th>Solar Total Input Power</th>
								
								<th>Solar Total Output Power</th>
								
								<th>System Out Load Status</th>
								
								<th>MDG Run (Hours)</th>
								
								<th>Tele Run (Hours)</th>
								
								<th>Tele Energy</th>
								
								
								<th>Community Load R Voltage</th>
								<th>Community Load Y Voltage</th>
								<th>Community Load B Voltage</th>
								
								<th>Community Load R Current</th>
								<th>Community Load Y Current</th>
								<th>Community Load B Current</th>
								
								<th>Community Load R Power Factory</th>
								<th>Community Load Y Power Factory</th>
								<th>Community Load B Power Factory</th>
								
								
								<th>Community Load R Power</th>
								<th>Community Load Y Power</th>
								<th>Community Load B Power</th>
								
								<th>Community Load Frequency</th>
								
								<th>Community Load Run (Hours)</th>
								
								<th>Community Load Energy</th>
								
								<th>Inverter Input Voltage 1</th>
								<th>Inverter Input Current 1</th>
								<th>Inverter Out Voltage 1</th>
								<th>Inverter Output Current 1</th>
								<th>Inverter Output Energy 1</th>
								<th>Inverter Temperature 1</th>
								<th>Inverter Status 1</th>
								
								
								<th>Inverter Input Voltage 2</th>
								<th>Inverter Input Current 2</th>
								<th>Inverter Out Voltage 2</th>
								<th>Inverter Output Current 2</th>
								<th>Inverter Output Energy 2</th>
								<th>Inverter Temperature 2</th>
								<th>Inverter Status 2</th>
								
								<th>Inverter Input Voltage 3</th>
								<th>Inverter Input Current 3</th>
								<th>Inverter Out Voltage 3</th>
								<th>Inverter Output Current 3</th>
								<th>Inverter Output Energy 3</th>
								<th>Inverter Temperature 3</th>
								<th>Inverter Status 3</th>
								
								<th>Inverter Input Voltage 4</th>
								<th>Inverter Input Current 4</th>
								<th>Inverter Out Voltage 4</th>
								<th>Inverter Output Current 4</th>
								<th>Inverter Output Energy 4</th>
								<th>Inverter Temperature 4</th>
								<th>Inverter Status 4</th>
								
								<th>Inverter Input Voltage 5</th>
								<th>Inverter Input Current 5</th>
								<th>Inverter Out Voltage 5</th>
								<th>Inverter Output Current 5</th>
								<th>Inverter Output Energy 5</th>
								<th>Inverter Temperature 5</th>
								<th>Inverter Status 5</th>
								
								<th>Inverter Input Voltage 6</th>
								<th>Inverter Input Current 6</th>
								<th>Inverter Out Voltage 6</th>
								<th>Inverter Output Current 6</th>
								<th>Inverter Output Energy 6</th>
								<th>Inverter Temperature 6</th>
								<th>Inverter Status 6</th>
								
								<th>Inverter Input Voltage 7</th>
								<th>Inverter Input Current 7</th>
								<th>Inverter Out Voltage 7</th>
								<th>Inverter Output Current 7</th>
								<th>Inverter Output Energy 7</th>
								<th>Inverter Temperature 7</th>
								<th>Inverter Status 7</th>
								
								<th>Inverter Input Voltage 8</th>
								<th>Inverter Input Current 8</th>
								<th>Inverter Out Voltage 8</th>
								<th>Inverter Output Current 8</th>
								<th>Inverter Output Energy 8</th>
								<th>Inverter Temperature 8</th>
								<th>Inverter Status 8</th>
								
								<th>Inverter Input Voltage 9</th>
								<th>Inverter Input Current 9</th>
								<th>Inverter Out Voltage 9</th>
								<th>Inverter Output Current 9</th>
								<th>Inverter Output Energy 9</th>
								<th>Inverter Temperature 9</th>
								<th>Inverter Status 9</th>
								
								<th>Inverter Input Voltage 10</th>
								<th>Inverter Input Current 10</th>
								<th>Inverter Out Voltage 10</th>
								<th>Inverter Output Current 10</th>
								<th>Inverter Output Energy 10</th>
								<th>Inverter Temperature 10</th>
								<th>Inverter Status 10</th>
								
								<th>Inverter Input Voltage 11</th>
								<th>Inverter Input Current 11</th>
								<th>Inverter Out Voltage 11</th>
								<th>Inverter Output Current 11</th>
								<th>Inverter Output Energy 11</th>
								<th>Inverter Temperature 11</th>
								<th>Inverter Status 11</th>
								
								<th>Inverter Input Voltage 12</th>
								<th>Inverter Input Current 12</th>
								<th>Inverter Out Voltage 12</th>
								<th>Inverter Output Current 12</th>
								<th>Inverter Output Energy 12</th>
								<th>Inverter Temperature 12</th>
								<th>Inverter Status 12</th>
								
								
								<th>Number of Inverter Modules</th>
								<th>Inverter Run (Hours)</th>
								<th>Inverter Energy</th>
								<th>Inverter Input Power</th>
								<th>Inverter Output Power</th>
								
								
								<th>ACTEL R Voltage</th>
								<th>ACTEL Y Voltage</th>
								<th>ACTEL B Voltage</th>
								
								<th>ACTEL R Current</th>
								<th>ACTEL Y Current</th>
								<th>ACTEL B Current</th>
								
								<th>ACTEL R Power Factory</th>
								<th>ACTEL Y Power Factory</th>
								<th>ACTEL B Power Factory</th>
								
								<th>ACTEL R Power</th>
								<th>ACTEL Y Power</th>
								<th>ACTEL B Power</th>
								
								<th>ACTEL Frequency</th>
							</tr>
						</thead>
						<tbody class="text-center"></tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="include_ftr.jsp"></jsp:include>
	<script src="${contextPath}/resources/js/rawdatareport.js"
		type="text/javascript"></script>
</body>
</html>
