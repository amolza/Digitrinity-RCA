var barChart;
var latestReportTable;
$(document).ready(function() {
	loadCustomers();
 	loadSiteIds();
 	loadSiteTypes();
 	loadClusters();
 	loadZones();
 	loadRegions();
 	renderLatestReportDataTable();
 	loadLatestReportStatus();
 	loadDeviceType();
	loadSiteStatus();
 	jQuery('#datetimepicker').daterangepicker({
 	  opens: 'right',
 	  showDropdowns: true,
 	  timePicker: true,
 	  timePicker24Hour: true,
 	  locale: {
 	      format: 'YYYY/MM/DD'
 	   },
 	  startDate: moment().startOf('hour'),
 	  endDate: moment().startOf('hour').add(1, 'day'),
 	  maxSpan: {
 	       "hours": 24
 	  },
 	  }, function(start, end, label) {});
 	hourlyReportDateApply();
 	renderChart();

 	loadAlarmCategory();
 	//loadAlarmSeverity();
 	renderAlarmStatusDataTable();
 	registerLatestReportDataOnClickEvent();
} );


function renderLatestReportDataTable(){
	latestReportTable = $('#latestDataReportTable').DataTable( {
			"ajax" : {
				"url":"dashboard/latest-data1",
				"type": "POST",
				"dataType": 'json',
				"contentType": "application/json",
				"data": function ( d ) {
					return JSON.stringify(buildDataTableAjaxData())
				}
			},
		"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
			"dom": 'Bfrtip',
			"buttons": [
				'copy',
				{
					extend: 'csvHtml5',
					title: 'Latest Data'
				},
				{
					extend: 'excelHtml5',
					title: 'Latest Data'
				},'print'
			],
			"order": [[ 0, "desc" ]],
			"bLengthChange": false,
			"bFilter": false,
			"columns": [
            { "data": "lastUpdated" },
            { "data": "smSiteCode",
				"render": function(data, type, row, meta){
            	var ref = "site/details/"+data
					if(type === 'display'){
						data = '<a href="'+ref+'" >' + data + '</a>';
					}

					return data;
				} },
            { "data": "siteName"},
            { "data":"powerSource"},
            { "data": "customerName" },
            { "data" : "batterySOC"},
            { "data" : "dcLoad"},
            { "data": "dcVoltage" },
            { "data" : "dgPower" },
            { "data" : "fuelLevel"},
            { "data" : "solarKw"},
            { "data": "critical" },
            { "data": "major" },
            { "data" : "minor"},
            { "data": "age" },
            { "data" : "engineerName"},
            {"data" : "location"}


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
        },
        'createdRow': function(row, data, index){
            if(data.age > 4){
            	$('td', row).eq(14).addClass('highlight-red');
            }
            if(data.critical > 0){
            	$('td', row).eq(11).addClass('highlight-red');
            }
            if(data.major > 0){
            	$('td', row).eq(12).addClass('highlight-red');
            }
            if(parseFloat(data.dcVoltage) < 48.5){
            	$('td', row).eq(7).addClass('highlight-red-back');
            }


          },
          /*"dom": "<'row'<'col-sm-6'B><'col-sm-6'f>>" +
          "<'row'<'col-sm-12'tr>>" +
          "<'row'<'col-sm-4'i><'col-sm-4 text-center'l><'col-sm-4'p>>"*/
    } );

	 new $.fn.dataTable.FixedHeader( latestReportTable );
}


function renderAlarmStatusDataTable(){
	var alarmTable = $('#alarmTable').DataTable( {
		"bFilter": false,
		responsive: true,
		dom: 'Bfrtip',
		buttons: [
			'copy',
			{
				extend: 'csvHtml5',
				title: 'Alarms Data'
			},
			{
				extend: 'excelHtml5',
				title: 'Alarms Data'
			},'print'
			],
			"ajax" : {
				"url":"dashboard/alarm-status",
				"type": "POST",
				"dataType": 'json',
				"contentType": "application/json",
				"data": function ( d ) {
					return JSON.stringify(buildAlarmStatusDataTableAjaxData())
				}
			},
			"bLengthChange": false,
			"order": [[ 2, "desc" ]],
			"columns": [
            { "data": "smSiteCode" },
            { "data": "alName" },
            { "data": "alOpentime" },
            { "data": "age" }

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
        },
    } );
	 //new $.fn.dataTable.FixedHeader( alarmTable );
}

function buildDataTableAjaxData()
{
	var obj = {
			"siteId" : $("#siteId").val(),
			"customers" : $("#customer").val(),
			"siteType" : $("#siteType").val(),
			"clusters" : $("#cluster-select").val(),
			"zones" : $("#zone-select").val(),
			"regions" : $("#region-select").val(),
			"siteStatus" : $("#siteStatus").val()

	}
	return obj;

}

function buildAlarmStatusDataTableAjaxData()
{
	var obj = {
			"categories" : $("#alarm-category-select").val(),
			"siteId" : $("#alarm-site-id-select").val(),
			"severities" : $("#alarm-severity-select").val(),
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
	return JSON.stringify(obj);

}

function  loadSiteStatus() {
	$("#siteStatus").selectpicker("refresh");
	$("#siteStatus").selectpicker("selectAll");
	registerLatestReportReload($("#siteStatus"));
}
function loadLatestReportStatus()
{
	$.ajax('dashboard/latest-report-status',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function
    	        $("#totalSite").text(data.totalSite);
    	        $("#onlineSite").text(data.onlineSite);
    	        $("#offlineSite").text(data.offlineSite);

    	    }
    	});
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


function loadAlarmCategory()
{
	$.ajax('dashboard/alarm-category',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function
    	        $.each(data, function(index,jsonObject){
    	            $.each(jsonObject, function(key,val){
    	                $("#alarm-category-select").append('<option value="'+val+'">'+val+'</option>');
    	            });
    	        });
    	        $("#alarm-category-select").selectpicker("refresh");
    	        $("#alarm-category-select").selectpicker("selectAll");
    	        registerAlarmStatusReload($("#alarm-category-select"));
    	    }
    	});
}

function loadAlarmSeverity()
{
	$.ajax('dashboard/alarm-severity',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function
    	        $.each(data, function(index,jsonObject){
    	            $.each(jsonObject, function(key,val){
    	                $("#alarm-severity-select").append('<option value="'+val+'">'+val+'</option>');
    	            });
    	        });
    	        $("#alarm-severity-select").selectpicker("refresh");
    	        $("#alarm-severity-select").selectpicker("selectAll");
    	        registerAlarmStatusReload($("#alarm-severity-select"));
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
    	                $("#alarm-site-id-select").append('<option value="'+val+'">'+val+'</option>');

    	            });
    	        });
    	        $("#siteId").selectpicker("refresh");
    	        $("#siteId").selectpicker("selectAll");
    	        $("#hourly-site-id-select").selectpicker("refresh");
    	        $("#hourly-site-id-select").selectpicker("selectAll");

    	        $("#alarm-site-id-select").selectpicker("refresh");
    	        $("#alarm-site-id-select").selectpicker("selectAll");

    	        registerLatestReportReload($("#siteId"));
    	        registerHourlyReportReload($("#hourly-site-id-select"));

    	        registerAlarmStatusReload($("#alarm-site-id-select"));
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
						responsive: true,
    	        	    data: {
    	        	    	labels: data.labels,
    	        	        datasets: data.dataSets
    	        	    },
    	        	    options: {
    	        	      legend: { display: true,position: 'bottom' },
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



function registerAlarmStatusReload(selectObj){
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

		$('#alarmTable').DataTable().ajax.reload();

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

function registerLatestReportDataOnClickEvent(){
	$('#latestDataReportTable tbody').on( 'click', 'tr', function () {

	    /*if ( $(this).hasClass('selected') ) {
           // $(this).removeClass('selected');
        }
        else {
        	latestReportTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }*/
		latestReportTable.$('tr.selected').removeClass('selected');
        $(this).addClass('selected');

	    var siteId = latestReportTable.row( this ).data().smSiteCode;

	    $('#alarm-site-id-select').selectpicker('val', siteId);
	    $('#alarm-site-id-select').selectpicker('refresh')

	    $('#hourly-site-id-select').selectpicker('val', siteId);
	    $('#hourly-site-id-select').selectpicker('refresh')

	} );

}	