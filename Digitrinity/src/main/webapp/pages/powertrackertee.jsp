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
    <div class="row">
        <div class="col-sm-12">
            <div class="text-center mb-3 p-2 mt-3" style="background-color: #1A3E4C;color: #E4F1F6;">
                <h5>Power Tracker Report(TEE)</h5>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="power-tee-export-container report-filter-export-container">
                <table cellspacing="5" cellpadding="5" class="filter-table" id="powerTrackerDataTableFilters">
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
                        <td>
                            <label class='control-label mr-2'
                                   for="hourly-site-id-select"><strong>Customer</strong>
                            </label>
                        </td>
                        <td>
                            <select id="customer" name="customer"
                                    class="selectpicker" data-live-search="true" multiple
                                    title="Customer" data-width="80px">
                                <option value="All" selected="selected">All</option>
                            </select>
                        </td>
                        <td><label class='control-label mr-2'
                                   for="hourly-site-id-select"><strong>Site ID</strong></label></td>
                        <td><select id="siteId" name="siteId" class="selectpicker form-control"
                                    data-live-search="true" multiple title="Site ID"
                                    data-width="80px">
                            <option value="All" selected="selected">All</option>
                        </select></td>
                        <td><label class='control-label mr-2'
                                   for="hourly-site-id-select"><strong>Device Type</strong></label></td>
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
                        <td>
                            <label class='control-label mr-2'
                                   for="hourly-site-id-select">
                                <strong>Power Source</strong>
                            </label>
                        </td>
                        <td>
                            <select id="powersource" name="siteStatus"
                                    class="selectpicker" data-live-search="true" multiple
                                    title="PowerSource" data-width="80px">
                                <option value="-1" selected="selected">All</option>
                                <option value="0">SOL+MDG</option>
                                <option value="1">Mobile_DG</option>
                                <option value="2">BAT+SOL</option>
                                <option value="3">DG+SOL</option>
                                <option value="4">Battery</option>
                                <option value="5">EB+SOL</option>
                                <option value="6">Solar</option>
                                <option value="7">EB</option>
                                <option value="8">DG</option>
                                <option value="9">AC_Power</option>
                                <option value="10">unknown</option>

                            </select>
                        </td>
                    </tr>
                </table>
                <div class="report-export-container">
                    <jsp:include page="include_export.jsp"></jsp:include>
                </div>
            </div>
            <table id="powerTrackerDataTable"
                   class="table table-striped table-bordered table-fixed table-hover table-condensed"
                   style="width: 100%">
                <thead class="text-center datatable-header">
                <tr>
                    <th style="font-size: xx-small; width:5px;">Last Updated</th>
                    <th style="font-size: xx-small; width:5px;">Site ID</th>
                    <th style="font-size: xx-small; width:5px;">Site Name</th>
                    <th style="font-size: xx-small; width:5px;">Power Source</th>
                    <th style="font-size: xx-small; width:5px;">Customer</th>
                    <th style="font-size: xx-small; width:5px;">Battery SOC</th>
                    <th style="font-size: xx-small; width:5px;">DC Load</th>
                    <th style="font-size: xx-small; width:5px;">DC Voltage</th>
                    <th style="font-size: xx-small; width:5px;">DG Power (Kw)</th>
                    <th style="font-size: xx-small; width:5px;">Fuel Level (Ltrs)</th>
                </tr>
                </thead>
                <tbody class="text-center"></tbody>
            </table>
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
