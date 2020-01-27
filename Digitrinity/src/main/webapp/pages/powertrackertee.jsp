<!DOCTYPE html>
<html lang="en">
<head>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<%@page import="com.fasterxml.jackson.databind.ObjectMapper" %>
	<%@page import="java.util.HashMap" %>
	<%@page import="java.util.Map" %>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<meta charset="UTF-8">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Welcome</title>
	<jsp:include page="include_hdr.jsp"></jsp:include>
</head>
<body style="background-color: #e9e9e9; font-size: .88rem;"
	  data-spy="scroll">
<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid">
	<div class="row-12">
		<div class="col-xs-12">
			<div class="text-center mb-3 p-2 mt-3" style="background-color: #1A3E4C;color: #E4F1F6;">
				<h5>Power Tracker Report(TEE)</h5>
			</div>

			<div class="p-2" style="background-color: white;">
				<table cellspacing="5" cellpadding="5" class="filter-table">
					<tr>
						<td><label class='control-label mr-2'
								   for="hourly-site-id-select"><strong>Region</strong></label></td>
						<td><select id="region-select" name="region-select"
									class="selectpicker form-control" data-live-search="true"
									multiple title="Region" data-width="80px"
									style="background-color: #5cb85c; color: #fff;">
							<option value="All" selected="selected">All</option>
						</select></td>
						<td><label class='control-label mr-2'
								   for="hourly-site-id-select"><strong>Zone</strong></label></td>
						<td><select id="zone-select" name="zone-select"
									class="selectpicker form-control" data-live-search="true" multiple
									title="Zone" data-width="80px" data-all="false">
							<option value="All" selected="selected">All</option>
						</select></td>
						<td><label class='control-label mr-2'
								   for="hourly-site-id-select"><strong>Cluster</strong></label></td>
						<td><select id="cluster-select" name="cluster-select"
									class="selectpicker form-control" data-live-search="true" multiple
									title="Cluster" data-width="80px">
							<option value="All" selected="selected">All</option>
						</select></td>
						<td><label class='control-label mr-2'
								   for="hourly-site-id-select"><strong>Site ID</strong></label></td>
						<td><select id="siteId" name="siteId" class="selectpicker form-control"
									data-live-search="true" multiple title="Site ID"
									data-width="80px">
							<option value="All" selected="selected">All</option>
						</select></td>
						<td><label class='control-label mr-2'
								   for="device-type-select"><strong>Device Type</strong></label></td>
						<td><select id="device-type-select" name="customer"
									class="selectpicker form-control" data-live-search="true" multiple
									title="Device Type" data-width="80px">
							<option value="All" selected="selected">All</option>
						</select></td>

						<td><label class='control-label mr-2'
								   for="hourly-site-id-select"><strong>Site Type</strong></label></td>
						<td><select id="siteType" name="siteType"
									class="selectpicker form-control" data-live-search="true" multiple
									title="Site Type" data-width="80px">
							<option value="All" selected="selected">All</option>
						</select></td>
						<td><label class='control-label mr-2'
								   for="hourly-site-id-select"><strong>Date</strong></label></td>
						<td><input id="datetimepicker" class="form-control" type="text" style="width: 175px"/></td>
						<%--<td>
                            <div class="download" align="right">
                                &lt;%&ndash;<button type="button" class="btn btn-outline-primary" style="background-color: white;" id="btncExport" onclick="exportTableToExcel('RCAReport.xls','latestDataReportTable');"> EXPORT to Excel </button>
                                &ndash;%&gt;<button type="button" class="btn btn-outline-primary" style="background-color: white;" id="btnExportCSV" onclick="exportTableToCSV('RawReport.csv','rawDataReportDataTable')"> EXPORT to CSV </button>
                           </div></td>&ndash;%&gt;--%>

						<%--                        <td>--%>
						<%--                            <div class="download" align="right">--%>
						<%--                                <a type="button" class="btn btn-outline-primary" style="background-color: white;"--%>
						<%--                                   id="btnExport1" href="../raw-report/raw-data-excel"> Download Excel </a>--%>
						<%--                                <button type="button" class="btn btn-outline-primary"--%>
						<%--                                        style="background-color: white;"--%>
						<%--                                        id="btnExport2" onclick="downloadExcelNew()"> Download Excel--%>
						<%--                                </button>--%>
						<%--                            </div>--%>
						<%--                        </td>--%>
					</tr>
					</tr>
				</table>
			</div>

			<div style="background-color: white;white-space: nowrap; padding: 14px; overflow: auto;">
				<table id="powerTrackerDataTable"
					   class="table table-striped table-bordered table-fixed table-hover table-condensed"
					   style="width: 100%;height:100%;">
					<thead class="text-center datatable-header">
					<tr>
						<th>Inverter Input Voltage 2</th>
						<th>Inverter Input Current 2</th>
						<th>Inverter Out Voltage 2</th>
						<th>Inverter Output Current 2</th>
						<th>Inverter Output Energy 2</th>
						<th>Inverter Temperature 2</th>
						<th>Inverter Status 2</th>
					</tr>
					</thead>
					<tbody class="text-center"></tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</div>
<jsp:include page="include_ftr.jsp"></jsp:include>
<script src="${contextPath}/resources/js/util.js"
		type="text/javascript"></script>
<script src="${contextPath}/resources/js/powertrackerreport.js"
		type="text/javascript"></script>
</body>
</html>
