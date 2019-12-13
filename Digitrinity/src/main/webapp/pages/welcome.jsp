<!DOCTYPE html>
<html lang="en">
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
<body style="background-color: #e9e9e9" data-spy="scroll">
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row-12">
		<div class="col-12">
		<div class="row p-3 m-2 text-center" style="background-color: white">
				<div class="col-sm">
					<div class="alert alert-primary" role="alert">						
						<span class="font-weight-bold" style="font-size:15px;">Total Sites</span>
						<h5><span class="font-weight-bold" style="font-size:25px;">300</span></h5>
					</div>
				</div>
				<div class="col-sm">
					<div class="alert alert-success" role="alert">
						<span class="font-weight-bold" style="font-size:15px;">Online</span>
						<h5><span class="font-weight-bold" style="font-size:25px;">250</span></h5>
					</div>
				</div>
				<div class="col-sm">
					<div class="alert alert-danger" role="alert">
						<span class="font-weight-bold" style="font-size:15px;">Offline</span>
						<h5><span class="font-weight-bold" style="font-size:25px;">50</span></h5>
					</div>
				</div>
			</div>

			<div class="row m-2 p-2" style="background-color: white">
				<div class="col-sm">
					<div class="form-group">
				    	<label for="region-select" class="col-sm-5 control-label font-weight-bold" style="color:#004085;"> Region </label>
					    <div class="col-sm-7">
							<select id="region-select" name="region-select" class="selectpicker" data-live-search="true" multiple
								title="Region" data-width="150px" style="background-color: #5cb85c; color: #fff;">
								<option value="All" selected="selected">All</option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-sm">
					<div class="form-group">
				    	<label for="zone-select" class="col-sm-5 control-label font-weight-bold" style="color:#004085;"> Zone </label>
					    <div class="col-sm-7">						
							<select id="zone-select" name= "zone-select" class="selectpicker" data-live-search="true" multiple
								title="Zone" data-width="150px" data-all="false">
								<option value="All" selected="selected">All</option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-sm">
					<div class="form-group">
				    	<label for="cluster-select" class="col-sm-5 control-label font-weight-bold" style="color:#004085;"> Cluster </label>
					    <div class="col-sm-7">
							<select id="cluster-select"  name= "cluster-select" class="selectpicker" data-live-search="true" multiple
								title="Cluster" data-width="150px">
								<option value="All" selected="selected">All</option>
							</select>
						</div>
					</div>
				</div>				
				<div class="col-sm">
					<div class="form-group">
				    	<label for="siteId" class="col-sm-5 control-label font-weight-bold" style="color:#004085;"> Site ID </label>
					    <div class="col-sm-7">
							<select id="siteId" name= "siteId" class="selectpicker" data-live-search="true" multiple
								title="Site ID" data-width="150px">						
								<option value="All" selected="selected">All</option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-sm">
					<div class="form-group">
				    	<label for="customer" class="col-sm-5 control-label font-weight-bold" style="color:#004085;"> Customer </label>
					    <div class="col-sm-7">
							<select id="customer" name= "customer" class="selectpicker" data-live-search="true" multiple
								title="Customer" data-width="150px">						
								<option value="All" selected="selected">All</option>
							</select>
						</div>
					</div>					
				</div>
				<div class="col-sm">
					<div class="form-group">
				    	<label for="siteType" class="col-sm-5 control-label font-weight-bold" style="color:#004085;"> Site Type </label>
					    <div class="col-sm-7">
							<select id="siteType" name= "siteType" class="selectpicker" data-live-search="true" multiple
								title="Site Type" data-width="150px">						
								<option value="All" selected="selected">All</option>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row m-2 p-2 overflow-auto" style="background-color: white;">				
			<table id="latestDataReportTable" class="table table-bordered table-sm table-hover display compact" cellspacing="5px" cellpadding="10" style="width:100%">
		    	<!-- <thead style="background-color: #343a40;color: #fff;"> -->
		    	<thead class="text-center" style="background-color: #343a40;color: #fff;">
		        <tr>
		            <th>Last Updated</th>
		            <th>Site ID</th>
		            <th>Site Name</th>
   		            <th>Power Source</th>
   		            <th>Customer</th>
   		            <th>Battery SOC</th>
   		            <th>DC Load</th>
   		            <th>DC Voltage (Kw)</th>
   		            <th>Fuel Level (%)</th>
   		            <th>Solar (Kw)</th>
   		            <th>Critical</th>
   		            <th>Major</th>
   		            <th>Minor</th>
   		            <th>Offline Duration</th>   		            
   		            <th>Engineer Name</th>
   		            <!-- <th>Location</th> -->
		        </tr>
		    	</thead>
		    	<tbody class="text-center"></tbody>
		    	<tfoot class="text-center">
            <tr>
                <th>Last Updated</th>
		            <th>Site ID</th>
		            <th>Site Name</th>
   		            <th>Power Source</th>
   		            <th>Customer</th>
   		            <th>Battery SOC</th>
   		            <th>DC Load</th>
   		            <th>DC Voltage (Kw)</th>
   		            <th>Fuel Level (%)</th>
   		            <th>Solar (Kw)</th>
   		            <th>Critical</th>
   		            <th>Major</th>
   		            <th>Minor</th>
   		            <th>Offline Duration</th>   		            
   		            <th>Engineer Name</th>
   		            <!-- <th>Location</th> -->
            </tr>
        </tfoot>   
			</table>
			</div>
		</div>
			
		</div>
	</div>
	<jsp:include page="include_ftr.jsp"></jsp:include>
</body>
<script type="text/javascript">
$(document).ready(function() {    
	loadCustomers();
 	loadSiteIds();
 	loadSiteTypes();
 	loadClusters(); 		
 	loadZones();
 	loadRegions();
 	var table = $('#latestDataReportTable').DataTable( {
 				"ajax" : {
 					"url":"dashboard/latest-data1",
 					"type": "POST",
 					"dataType": 'json',
 					"contentType": "application/json",
 					"data": function ( d ) {
 						return JSON.stringify(buildDataTableAjaxData())
 					}
 				},
 				"order": [[ 0, 'desc' ]],
		        responsive: true,
		         "columns": [
		            { "data": "lastUpdated" },
		            { "data": "smSiteCode" },
		            { "data": "siteName" },
		            { "data": "powerSource" },		            
		            { "data": "customerName" },
		            { "data": "batterySOC" },
		            { "data": "dcLoad" },
		            { "data": "dcVoltage" },
		            { "data": "fuelLevel" },
		            { "data": "solarKw" },
		            { "data": "critical" },
		            { "data": "major" },
		            { "data": "minor" },
		            { "data": "age" },
		            { "data": "engineerName" } /* ,
		            { "data": "location" }, */
		        ],
		        initComplete: function () {
		            this.api().columns().every( function () {
		                var column = this;
		                var select = $('<select><option value=""></option></select>')
		                    .appendTo( $(column.footer()).empty() )
		                    .on( 'change', function () {
		                        var val = $.fn.dataTable.util.escapeRegex(
		                            $(this).val()
		                        );
		 
		                        column
		                            .search( val ? '^'+val+'$' : '', true, false )
		                            .draw();
		                    } );
		 
		                column.data().unique().sort().each( function ( d, j ) {
		                    select.append( '<option value="'+d+'">'+d+'</option>' )
		                } );
		            } );
		        }
		    } );
} );


function buildDataTableAjaxData()
{
	var obj = {
			"siteId" : $("#siteId").val(),
			"customers" : $("#customer").val(),
			"siteType" : $("#siteType").val(),
			"clusters" : $("#cluster-select").val(),
			"zones" : $("#zone-select").val(),
			"regions" : $("#region-select").val()			
	}
	console.log(JSON.stringify(obj));
	
	return obj;
	
}

function loadCustomers()
{
	$.ajax('dashboard/customer-master',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function
    	        $.each(data, function(index,jsonObject){
    	            $.each(jsonObject, function(key,val){    	                
    	                $("#customer").append('<option value="'+val+'">'+val+'</option>');
    	            });
    	        });    	        
    	        $("#customer").selectpicker("refresh");
    	        $("#customer").selectpicker("selectAll");
    	        registerLatestReportReload($("#customer"));
    	    }
    	});
}

function loadSiteIds()
{
	$.ajax('dashboard/site-code-master',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function
    	        $.each(data, function(index,jsonObject){
    	            $.each(jsonObject, function(key,val){
    	                
    	                $("#siteId").append('<option value="'+val+'">'+val+'</option>');
    	            });
    	        });    	        
    	        $("#siteId").selectpicker("refresh");
    	        $("#siteId").selectpicker("selectAll");    	        
    	        registerLatestReportReload($("#siteId"));
    	    }
    	});
}

function loadSiteTypes()
{
	$.ajax('dashboard/site-type-master',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function    	        	
	    	        $.each(data, function(index,jsonObject){
	    	        	$("#siteType").append('<option value="'+jsonObject.type+'">'+jsonObject.type+'</option>');    	            
	    	        });    	        
	    	        $("#siteType").selectpicker("refresh");
	    	        $("#siteType").selectpicker("selectAll");	    	        
	    	        registerLatestReportReload($("#siteType"));
    	    }
    	});
}

function loadClusters()
{
	$.ajax('dashboard/cluster-master',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function    	        	
	    	        $.each(data, function(index,jsonObject){
	    	        	$("#cluster-select").append('<option value="'+jsonObject.crName+'">'+jsonObject.crName+'</option>');    	            
	    	        });    	        
	    	        $("#cluster-select").selectpicker("refresh");
	    	        $("#cluster-select").selectpicker("selectAll");	    	        
	    	        registerLatestReportReload($("#cluster-select"));
    	    }
    	});
}

function loadZones()
{
	$.ajax('dashboard/zone-master',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function   
	    	        $.each(data, function(index,jsonObject){
	    	        	$("#zone-select").append('<option value="'+jsonObject.znZone+'">'+jsonObject.znZone+'</option>');    	            
	    	        });    	        
	    	        $("#zone-select").selectpicker("refresh");
	    	        $("#zone-select").selectpicker("selectAll");	    	        
	    	        registerLatestReportReload($("#zone-select"));
    	    }
    	});
}

function loadRegions()
{
	$.ajax('dashboard/region-master',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function    	        	
	    	        $.each(data, function(index,jsonObject){
	    	        	$("#region-select").append('<option value="'+jsonObject.rgRegion+'">'+jsonObject.rgRegion+'</option>');    	            
	    	        });    	        
	    	        $("#region-select").selectpicker("refresh");
	    	        $("#region-select").selectpicker("selectAll");
	    	        registerZoneChangeEvent($("#region-select"));
	    	        registerLatestReportReload($("#region-select"));
    	    }
    	});
}

function registerZoneChangeEvent(selectObj) {
	/* selectObj.on('change', function(){
	var thisObj = $(this);
    var isAllSelected = thisObj.find('option[value="All"]').prop('selected');
    var lastAllSelected = $(this).data('all');
    var selectedOptions = (thisObj.val())?thisObj.val():[];
    var allOptionsLength = thisObj.find('option[value!="All"]').length;
     
     
    var selectedOptionsLength = selectedOptions.length;
     
    if(isAllSelected == lastAllSelected){
    
    if($.inArray("All", selectedOptions) >= 0){
    	selectedOptionsLength -= 1;      
    }
        	
    if(allOptionsLength <= selectedOptionsLength){
    
    thisObj.find('option[value="All"]').prop('selected', true).parent().selectpicker('refresh');
    isAllSelected = true;
    }else{       
    	thisObj.find('option[value="All"]').prop('selected', false).parent().selectpicker('refresh');
       isAllSelected = false;
    }
      
    }else{   		
    	thisObj.find('option').prop('selected', isAllSelected).parent().selectpicker('refresh');
    }
   
	$(this).data('all', isAllSelected);
	
	$('#latestDataReportTable').DataTable().ajax.reload();
	}).trigger('change'); */
}

function registerLatestReportReload(selectObj){
	selectObj.on('changed.bs.select', function (e, clickedIndex, isSelected, previousValue) {
		var thisObj = $(this);
	    var isAllSelected = thisObj.find('option[value="All"]').prop('selected');
	    var lastAllSelected = $(this).data('all');
	    var selectedOptions = (thisObj.val())?thisObj.val():[];
	    var allOptionsLength = thisObj.find('option[value!="All"]').length;
	     
	     
	    var selectedOptionsLength = selectedOptions.length;
	     
	    if(isAllSelected == lastAllSelected){
	    
	    if($.inArray("All", selectedOptions) >= 0){
	    	selectedOptionsLength -= 1;      
	    }
	        	
	    if(allOptionsLength <= selectedOptionsLength){
	    
	    thisObj.find('option[value="All"]').prop('selected', true).parent().selectpicker('refresh');
	    isAllSelected = true;
	    }else{       
	    	thisObj.find('option[value="All"]').prop('selected', false).parent().selectpicker('refresh');
	       isAllSelected = false;
	    }
	      
	    }else{   		
	    	thisObj.find('option').prop('selected', isAllSelected).parent().selectpicker('refresh');
	    }
	   
		$(this).data('all', isAllSelected);
		
		$('#latestDataReportTable').DataTable().ajax.reload();
		
		//$('#latestDataReportTable').DataTable().ajax.reload();
	});

	
}

</script>
</html>