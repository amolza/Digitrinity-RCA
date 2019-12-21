var barChart;
$(document).ready(function() { 
	loadCustomers();
 	loadSiteIds();
 	loadSiteTypes();
 	loadClusters(); 		
 	loadZones();
 	loadRegions(); 	
 	renderLatestReportDataTable();
 	loadDeviceType();
 	jQuery('#datetimepicker').daterangepicker({
 	  opens: 'right',
 	  showDropdowns: true,
 	  timePicker: true,
 	  timePicker24Hour: true,
 	  locale: {
 	      format: 'YYYY/MM/DD HH:MM:SS'
 	   },
 	  startDate: moment().startOf('hour'),
 	  endDate: moment().startOf('hour').add(8, 'hour'),
 	  maxSpan: {
 	       "hours": 8
 	  },
 	  }, function(start, end, label) {});
 	hourlyReportDateApply();
 	renderChart();
} );


function renderLatestReportDataTable(){
	var table = $('#latestDataReportTable').DataTable( {
		responsive: true,
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
}

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
	return obj;
	
}

function buildHourlyReportAjaxData()
{
	var obj = {
			"siteId" : $("#hourly-site-id-select").val(),
			"siteType" : $("#hourly-site-type-select").val(),
			"deviceType" : $("#hourly-device-type-select").val(),
			"date" : $("#datetimepicker").val()					
	}
	console.log(JSON.stringify(obj));
	return JSON.stringify(obj);
	
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
    	                $("#hourly-site-id-select").append('<option value="'+val+'">'+val+'</option>');
    	            });
    	        });    	        
    	        $("#siteId").selectpicker("refresh");
    	        $("#siteId").selectpicker("selectAll");
    	        $("#hourly-site-id-select").selectpicker("refresh");
    	        $("#hourly-site-id-select").selectpicker("selectAll");
    	        registerLatestReportReload($("#siteId"));
    	        registerHourlyReportReload($("#hourly-site-id-select"));
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
	    	        	$("#hourly-site-type-select").append('<option value="'+jsonObject.type+'">'+jsonObject.type+'</option>');
	    	        });    	        
	    	        $("#siteType").selectpicker("refresh");
	    	        $("#siteType").selectpicker("selectAll");
	    	        $("#hourly-site-type-select").selectpicker("refresh");
	    	        $("#hourly-site-type-select").selectpicker("selectAll");
	    	        registerLatestReportReload($("#siteType"));
	    	        registerHourlyReportReload($("#hourly-site-type-select"));
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
	    	        registerLatestReportReload($("#region-select"));
    	    }
    	});
}


function loadDeviceType()
{
	$.ajax('dashboard/device-type-master',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function    	        	
	    	        $.each(data, function(index,jsonObject){
	    	        	$("#hourly-device-type-select").append('<option value="'+jsonObject.deviceType+'">'+jsonObject.deviceType+'</option>');    	            
	    	        });    	        
	    	        $("#hourly-device-type-select").selectpicker("refresh");
	    	        $("#hourly-device-type-select").selectpicker("selectAll");	    	        
	    	        registerHourlyReportReload($("#hourly-device-type-select"));
    	    }
    	});
}


function renderChart(startDate, endDate) {	
	var hourlyData;
	$.ajax('dashboard/hourly-report',   // request url
    	    {
				type: "POST",
				dataType: 'json',
				contentType: "application/json",
				data:buildHourlyReportAjaxData(),
    	        success: function (data, status, xhr) {// success callback function
    	        	if(barChart)
	        	    {
    	        		barChart.destroy();
	        	    }
    	        	barChart = new Chart(document.getElementById("bar-chart"), {
    	        	    type: 'bar',
    	        	    data: {
    	        	    	labels: data.labels,
    	        	        datasets: data.dataSets
    	        	    },
    	        	    options: {
    	        	      legend: { display: true },
    	        	      title: {
    	        	        display: false,
    	        	        text: 'Predicted world population (millions) in 2050'
    	        	      }
    	        	    }
    	        	});   	        
	    	        
    	    }
    	});
}

var randomColorGenerator = function () { 
    return '#' + (Math.random().toString(16) + '0000000').slice(2, 8); 
};


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

function registerHourlyReportReload(selectObj){
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
		renderChart();
	});
}

function hourlyReportDateApply(){
	$('#datetimepicker').on('apply.daterangepicker', function(ev, picker) {
		renderChart();
	});
}