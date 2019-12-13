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
		
	});

	
}