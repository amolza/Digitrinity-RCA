var rawDataReportDataTable;
$(document).ready(function() {
	
	loadRegions();
	loadZones();
	loadClusters();
	loadSiteTypes();
	loadSiteIds();
	loadDeviceType();
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
			"day": 1
		},
	}, function(start, end, label) {});
	//renderRawDataReportDataTable();
} );




function renderRawDataReportDataTable(){
	if ( $.fn.dataTable.isDataTable( '#rawDataReportDataTable' ) ) {
		rawDataReportDataTable = $('#rawDataReportDataTable').DataTable().ajax.reload();
	}
	else {
		rawDataReportDataTable = $('#rawDataReportDataTable').DataTable( {
			"processing": true,
			"bFilter": false,
			"serverSide": true,
			"pageLength": 50,
			dom: 'Bfrtip',
			buttons: [
				'copy',
				{
					extend: 'csvHtml5',
					title: 'Raw Data'
				},
				{
					extend: 'excelHtml5',
					title: 'Raw Data'
				},'print'
			],
			"ajax" : {
				"url":"../raw-report/raw-data",
				"type": "POST",
				"dataType": 'json',
				"contentType": "application/json",
				"data": function (d) {
					var form = {};
					$.each($("form").serializeArray(), function (i, field) {
						form[field.name] = field.value || "";
					});
					var info = (rawDataReportDataTable == null) ? { "start": 0, "length": 50, "page": 0 } : rawDataReportDataTable.page.info();
					$.extend(form, info);
					$.extend(form, d);
					$.extend(form, buildDataTableAjaxData());
					return JSON.stringify(form);
				},
				"error": function(){  // error handling code
					$("#rawDataReportDataTable_processing").css("display","none");
				}
			},
			"columns": [
				{"data":"cluster"},
				{"data":"siteId"},
				{"data":"updateDateTime"},
				{"data":"tranTime"},
				{"data":"alarm"},
				{"data":"status"},
				{"data":"communication"},
				{"data":"sysOutputLoadStatus"},
				{"data":"powerSource"},
				{"data":"siteBatteryVolt"},
				{"data":"batterySOC"},
				{"data":"opco1LoadCurrent"},
				{"data":"opco2LoadCurrent"},
				{"data":"opco3LoadCurrent"},
				{"data":"opco4LoadCurrent"},
				{"data":"opco1Energy"},
				{"data":"opco2Energy"},
				{"data":"opco3Energy"},
				{"data":"opco4Energy"},
				{"data":"battery1Temp"},
				{"data":"battery2Temp"},
				{"data":"battery3Temp"},
				{"data":"battery4Temp"},
				{"data":"fuelLevel"},
				{"data":"fuelLevelLtrs"},
				{"data":"mdgRVolt"},
				{"data":"mdgYVolt"},
				{"data":"mdgBVolt"},
				{"data":"mdgRAmp"},
				{"data":"mdgYAmp"},
				{"data":"mdgBAmp"},
				{"data":"mdgRPowerFactor"},
				{"data":"mdgYPowerFactor"},
				{"data":"mdgBPowerFactor"},
				{"data":"mdgRPower"},
				{"data":"mdgYPower"},
				{"data":"mdgBPower"},
				{"data":"mdgFrequency"},
				{"data":"dgRVolt"},
				{"data":"dgYVolt"},
				{"data":"dgBVolt"},
				{"data":"dgRAmp"},
				{"data":"dgYAmp"},
				{"data":"dgBAmp"},
				{"data":"dgRPowerFactor"},
				{"data":"dgYPowerFactor"},
				{"data":"dgBPowerFactor"},
				{"data":"dgRPower"},
				{"data":"dgYPower"},
				{"data":"dgBPower"},
				{"data":"dgFrequency"},
				{"data":"dgBatteryVoltage"},
				{"data":"dgTankCapacity"},
				{"data":"batterChargingCurrent"},
				{"data":"batterDisChargingCurrent"},
				{"data":"batteryCycleCount"},
				{"data":"batteryCapacityAH"},
				{"data":"batterNextFullChargeTime"},
				{"data":"numberOfBatteries"},
				{"data":"mdgRunHours"},
				{"data":"dgRunHours"},
				{"data":"batteryRunHours"},
				{"data":"mdgEnergy"},
				{"data":"dgEnergy"},
				{"data":"batteryDisEnergy"},
				{"data":"batteryChargingEnergy"},
				{"data":"rectInputRVoltage"},
				{"data":"rectInputYVoltage"},
				{"data":"rectInputBVoltage"},
				{"data":"rectInputRCurrent"},
				{"data":"rectInputYCurrent"},
				{"data":"rectInputBCurrent"},
				{"data":"rectOutputVoltage"},
				{"data":"numberOfRectfrs"},
				{"data":"totalRectOutputCurrent"},
				{"data":"totalDCLoadCurrent"},
				{"data":"totalDCLoadEnergy"},
				{"data":"inputVoltageSolarModule1"},
				{"data":"inputCurrentSolarModule1"},
				{"data":"inputPowerSolarModule1"},
				{"data":"outputVoltageSolarModule1"},
				{"data":"outputCurrentSolarModule1"},
				{"data":"outputPowerSolarModule1"},
				{"data":"solarModule1Status"},
				{"data":"inputVoltageSolarModule2"},
				{"data":"inputCurrentSolarModule2"},
				{"data":"inputPowerSolarModule2"},
				{"data":"outputVoltageSolarModule2"},
				{"data":"outputCurrentSolarModule2"},
				{"data":"outputPowerSolarModule2"},
				{"data":"solarModule2Status"},
				{"data":"inputVoltageSolarModule3"},
				{"data":"inputCurrentSolarModule3"},
				{"data":"inputPowerSolarModule3"},
				{"data":"outputVoltageSolarModule3"},
				{"data":"outputCurrentSolarModule3"},
				{"data":"outputPowerSolarModule3"},
				{"data":"solarModule3Status"},
				{"data":"inputVoltageSolarModule4"},
				{"data":"inputCurrentSolarModule4"},
				{"data":"inputPowerSolarModule4"},
				{"data":"outputVoltageSolarModule4"},
				{"data":"outputCurrentSolarModule4"},
				{"data":"outputPowerSolarModule4"},
				{"data":"solarModule4Status"},
				{"data":"inputVoltageSolarModule5"},
				{"data":"inputCurrentSolarModule5"},
				{"data":"inputPowerSolarModule5"},
				{"data":"outputVoltageSolarModule5"},
				{"data":"outputCurrentSolarModule5"},
				{"data":"outputPowerSolarModule5"},
				{"data":"solarModule5Status"},
				{"data":"inputVoltageSolarModule6"},
				{"data":"inputCurrentSolarModule6"},
				{"data":"inputPowerSolarModule6"},
				{"data":"outputVoltageSolarModule6"},
				{"data":"outputCurrentSolarModule6"},
				{"data":"outputPowerSolarModule6"},
				{"data":"solarModule6Status"},
				{"data":"inputVoltageSolarModule7"},
				{"data":"inputCurrentSolarModule7"},
				{"data":"inputPowerSolarModule7"},
				{"data":"outputVoltageSolarModule7"},
				{"data":"outputCurrentSolarModule7"},
				{"data":"outputPowerSolarModule7"},
				{"data":"solarModule7Status"},
				{"data":"inputVoltageSolarModule8"},
				{"data":"inputCurrentSolarModule8"},
				{"data":"inputPowerSolarModule8"},
				{"data":"outputVoltageSolarModule8"},
				{"data":"outputCurrentSolarModule8"},
				{"data":"outputPowerSolarModule8"},
				{"data":"solarModule8Status"},
				{"data":"inputVoltageSolarModule9"},
				{"data":"inputCurrentSolarModule9"},
				{"data":"inputPowerSolarModule9"},
				{"data":"outputVoltageSolarModule9"},
				{"data":"outputCurrentSolarModule9"},
				{"data":"outputPowerSolarModule9"},
				{"data":"solarModule9Status"},
				{"data":"inputVoltageSolarModule10"},
				{"data":"inputCurrentSolarModule10"},
				{"data":"inputPowerSolarModule10"},
				{"data":"outputVoltageSolarModule10"},
				{"data":"outputCurrentSolarModule10"},
				{"data":"outputPowerSolarModule10"},
				{"data":"solarModule10Status"},
				{"data":"inputVoltageSolarModule11"},
				{"data":"inputCurrentSolarModule11"},
				{"data":"inputPowerSolarModule11"},
				{"data":"outputVoltageSolarModule11"},
				{"data":"outputCurrentSolarModule11"},
				{"data":"outputPowerSolarModule11"},
				{"data":"solarModule11Status"},
				{"data":"inputVoltageSolarModule12"},
				{"data":"inputCurrentSolarModule12"},
				{"data":"inputPowerSolarModule12"},
				{"data":"outputVoltageSolarModule12"},
				{"data":"outputCurrentSolarModule12"},
				{"data":"outputPowerSolarModule12"},
				{"data":"solarModule12Status"},
				{"data":"inputVoltageSolarModule13"},
				{"data":"inputCurrentSolarModule13"},
				{"data":"outputVoltageSolarModule13"},
				{"data":"outputCurrentSolarModule13"},
				{"data":"solarModule13Status"},
				{"data":"inputVoltageSolarModule14"},
				{"data":"inputCurrentSolarModule14"},
				{"data":"outputVoltageSolarModule14"},
				{"data":"outputCurrentSolarModule14"},
				{"data":"solarModule14Status"},
				{"data":"inputVoltageSolarModule15"},
				{"data":"inputCurrentSolarModule15"},
				{"data":"outputVoltageSolarModule15"},
				{"data":"outputCurrentSolarModule15"},
				{"data":"solarModule15Status"},
				{"data":"inputVoltageSolarModule16"},
				{"data":"inputCurrentSolarModule16"},
				{"data":"outputVoltageSolarModule16"},
				{"data":"outputCurrentSolarModule16"},
				{"data":"solarModule16Status"},
				{"data":"inputVoltageSolarModule17"},
				{"data":"inputCurrentSolarModule17"},
				{"data":"outputVoltageSolarModule17"},
				{"data":"outputCurrentSolarModule17"},
				{"data":"solarModule17Status"},
				{"data":"inputVoltageSolarModule18"},
				{"data":"inputCurrentSolarModule18"},
				{"data":"outputVoltageSolarModule18"},
				{"data":"outputCurrentSolarModule18"},
				{"data":"solarModule18Status"},
				{"data":"inputVoltageSolarModule19"},
				{"data":"inputCurrentSolarModule19"},
				{"data":"outputVoltageSolarModule19"},
				{"data":"outputCurrentSolarModule19"},
				{"data":"solarModule19Status"},
				{"data":"inputVoltageSolarModule20"},
				{"data":"inputCurrentSolarModule20"},
				{"data":"outputVoltageSolarModule20"},
				{"data":"outputCurrentSolarModule20"},
				{"data":"solarModule20Status"},
				{"data":"inputVoltageSolarModule21"},
				{"data":"inputCurrentSolarModule21"},
				{"data":"outputVoltageSolarModule21"},
				{"data":"outputCurrentSolarModule21"},
				{"data":"solarModule21Status"},
				{"data":"inputVoltageSolarModule22"},
				{"data":"inputCurrentSolarModule22"},
				{"data":"outputVoltageSolarModule22"},
				{"data":"outputCurrentSolarModule22"},
				{"data":"solarModule22Status"},
				{"data":"inputVoltageSolarModule23"},
				{"data":"inputCurrentSolarModule23"},
				{"data":"outputVoltageSolarModule23"},
				{"data":"outputCurrentSolarModule23"},
				{"data":"solarModule23Status"},
				{"data":"inputVoltageSolarModule24"},
				{"data":"inputCurrentSolarModule24"},
				{"data":"outputVoltageSolarModule24"},
				{"data":"outputCurrentSolarModule24"},
				{"data":"solarModule24Status"},
				{"data":"numberOfSolarModule"},
				{"data":"solarInputEnergy"},
				{"data":"solarOutputEnergy"},
				{"data":"solarRunHours"},
				{"data":"solarMDGRunHours"},
				{"data":"solarDGRunHours"},
				{"data":"solarBatteryRunHours"},
				{"data":"solarTotalInputPower"},
				{"data":"solarTotalOutputPower"},
				{"data":"sysOutLoadStatus"},
				{"data":"mdgRunHour"},
				{"data":"teleRunHours"},
				{"data":"teleEnergy"},
				{"data":"communityLoadRVoltage"},
				{"data":"communityLoadYVoltage"},
				{"data":"communityLoadBVoltage"},
				{"data":"communityLoadRCurrent"},
				{"data":"communityLoadYCurrent"},
				{"data":"communityLoadBCurrent"},
				{"data":"communityLoadRPowerFactor"},
				{"data":"communityLoadYPowerFactor"},
				{"data":"communityLoadBPowerFactor"},
				{"data":"communityLoadRPower"},
				{"data":"communityLoadYPower"},
				{"data":"communityLoadBPower"},
				{"data":"communityLoadFrequency"},
				{"data":"communityLoadRunHours"},
				{"data":"communityLoadEnergy"},
				{"data":"inverterInputVoltage1"},
				{"data":"inverterInputCurrent1"},
				{"data":"inverterOutVoltage1"},
				{"data":"inverterOutputCurrent1"},
				{"data":"inverterOutputEnergy1"},
				{"data":"inverterTemp1"},
				{"data":"ineverterStatus1"},
				{"data":"inverterInputVoltage2"},
				{"data":"inverterInputCurrent2"},
				{"data":"inverterOutVoltage2"},
				{"data":"inverterOutputCurrent2"},
				{"data":"inverterOutputEnergy2"},
				{"data":"inverterTemp2"},
				{"data":"ineverterStatus2"},
				{"data":"inverterInputVoltage3"},
				{"data":"inverterInputCurrent3"},
				{"data":"inverterOutVoltage3"},
				{"data":"inverterOutputCurrent3"},
				{"data":"inverterOutputEnergy3"},
				{"data":"inverterTemp3"},
				{"data":"ineverterStatus3"},
				{"data":"inverterInputVoltage4"},
				{"data":"inverterInputCurrent4"},
				{"data":"inverterOutVoltage4"},
				{"data":"inverterOutputCurrent4"},
				{"data":"inverterOutputEnergy4"},
				{"data":"inverterTemp4"},
				{"data":"ineverterStatus4"},
				{"data":"inverterInputVoltage5"},
				{"data":"inverterInputCurrent5"},
				{"data":"inverterOutVoltage5"},
				{"data":"inverterOutputCurrent5"},
				{"data":"inverterOutputEnergy5"},
				{"data":"inverterTemp5"},
				{"data":"ineverterStatus5"},
				{"data":"inverterInputVoltage6"},
				{"data":"inverterInputCurrent6"},
				{"data":"inverterOutVoltage6"},
				{"data":"inverterOutputCurrent6"},
				{"data":"inverterOutputEnergy6"},
				{"data":"inverterTemp6"},
				{"data":"ineverterStatus6"},
				{"data":"inverterInputVoltage7"},
				{"data":"inverterInputCurrent7"},
				{"data":"inverterOutVoltage7"},
				{"data":"inverterOutputCurrent7"},
				{"data":"inverterOutputEnergy7"},
				{"data":"inverterTemp7"},
				{"data":"ineverterStatus7"},
				{"data":"inverterInputVoltage8"},
				{"data":"inverterInputCurrent8"},
				{"data":"inverterOutVoltage8"},
				{"data":"inverterOutputCurrent8"},
				{"data":"inverterOutputEnergy8"},
				{"data":"inverterTemp8"},
				{"data":"ineverterStatus8"},
				{"data":"inverterInputVoltage9"},
				{"data":"inverterInputCurrent9"},
				{"data":"inverterOutVoltage9"},
				{"data":"inverterOutputCurrent9"},
				{"data":"inverterOutputEnergy9"},
				{"data":"inverterTemp9"},
				{"data":"ineverterStatus9"},
				{"data":"inverterInputVoltage10"},
				{"data":"inverterInputCurrent10"},
				{"data":"inverterOutVoltage10"},
				{"data":"inverterOutputCurrent10"},
				{"data":"inverterOutputEnergy10"},
				{"data":"inverterTemp10"},
				{"data":"ineverterStatus10"},
				{"data":"inverterInputVoltage11"},
				{"data":"inverterInputCurrent11"},
				{"data":"inverterOutVoltage11"},
				{"data":"inverterOutputCurrent11"},
				{"data":"inverterOutputEnergy11"},
				{"data":"inverterTemp11"},
				{"data":"ineverterStatus11"},
				{"data":"inverterInputVoltage12"},
				{"data":"inverterInputCurrent12"},
				{"data":"inverterOutVoltage12"},
				{"data":"inverterOutputCurrent12"},
				{"data":"inverterOutputEnergy12"},
				{"data":"inverterTemp12"},
				{"data":"ineverterStatus12"},
				{"data":"numberOfInverter"},
				{"data":"inverterRunHours"},
				{"data":"inverterEnergy"},
				{"data":"inverterInputPower"},
				{"data":"inverterOutputPower"},
				{"data":"actelRVoltage"},
				{"data":"actelYVoltage"},
				{"data":"actelBVoltage"},
				{"data":"actelRCurrent"},
				{"data":"actelYCurrent"},
				{"data":"actelBCurrent"},
				{"data":"actelRPowerFactor"},
				{"data":"actelYPowerFactor"},
				{"data":"actelBPowerFactor"},
				{"data":"actelRPower"},
				{"data":"actelYPower"},
				{"data":"actelBPower"},
				{"data":"actelFrequency"}



			],
			"bLengthChange": false,
			/*"dom": "<'row'<'col-sm-6'B><'col-sm-6'f>>" +
			"<'row'<'col-sm-12'tr>>" +
			"<'row'<'col-sm-4'i><'col-sm-4 text-center'l><'col-sm-4'p>>"*/
		} );

	}

	 new $.fn.dataTable.FixedHeader( rawDataReportDataTable );
}

function loadZones()
{
	$.ajax('../dashboard/zone-master',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function   
	    	        $.each(data, function(index,jsonObject){
	    	        	$("#zone-select").append('<option value="'+jsonObject.znZone+'">'+jsonObject.znZone+'</option>');    	            
	    	        });    	        
	    	        $("#zone-select").selectpicker("refresh");
	    	        /*$("#zone-select").selectpicker("selectAll");*/
	    	      //  registerRawDataReload($("#zone-select"));
    	    }
    	});
}

function loadRegions()
{
	$.ajax('../dashboard/region-master',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function    	        	
	    	        $.each(data, function(index,jsonObject){
	    	        	$("#region-select").append('<option value="'+jsonObject.rgRegion+'">'+jsonObject.rgRegion+'</option>');    	            
	    	        });    	        
	    	        $("#region-select").selectpicker("refresh");
	    	       // $("#region-select").selectpicker("selectAll");
	    	       // registerRawDataReload($("#region-select"));
    	    }
    	});
}

function loadClusters()
{
	$.ajax('../dashboard/cluster-master',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function    	        	
	    	        $.each(data, function(index,jsonObject){
	    	        	$("#cluster-select").append('<option value="'+jsonObject.crName+'">'+jsonObject.crName+'</option>');    	            
	    	        });    	        
	    	        $("#cluster-select").selectpicker("refresh");
	    	      //  $("#cluster-select").selectpicker("selectAll");
	    	        //registerRawDataReload($("#cluster-select"));
    	    }
    	});
}

function loadSiteTypes()
{
	$.ajax('../dashboard/site-type-master',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function    	        	
	    	        $.each(data, function(index,jsonObject){
	    	        	$("#siteType").append('<option value="'+jsonObject.type+'">'+jsonObject.type+'</option>');
	    	        });    	        
	    	        $("#siteType").selectpicker("refresh");
	    	       // $("#siteType").selectpicker("selectAll");
	    	       // registerRawDataReload($("#siteType"));
    	    }
    	});
}

function loadSiteIds()
{
	$.ajax('../dashboard/site-code-master',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function
    	        $.each(data, function(index,jsonObject){
    	            $.each(jsonObject, function(key,val){
    	                
    	                $("#siteId").append('<option value="'+val+'">'+val+'</option>');
    	                
    	            });
    	        });    	        
    	        $("#siteId").selectpicker("refresh");
    	       // $("#siteId").selectpicker("selectAll");
    	      //  registerRawDataReload($("#siteId"));
    	    }
    	});
}

function loadDeviceType()
{
	$.ajax('../dashboard/device-type-master',   // request url
    	    {
    	        success: function (data, status, xhr) {// success callback function    	        	
	    	        $.each(data, function(index,jsonObject){
	    	        	$("#device-type-select").append('<option value="'+jsonObject.deviceType+'">'+jsonObject.deviceType+'</option>');    	            
	    	        });    	        
	    	        $("#device-type-select").selectpicker("refresh");
	    	       // $("#device-type-select").selectpicker("selectAll");
	    	        //registerRawDataReload($("#device-type-select"));
    	    }
    	});
}


function registerRawDataReload(selectObj){
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
		
		//$('#rawDataReportDataTable').DataTable().ajax.reload();
	});
}

function buildDataTableAjaxData()
{
	var obj = {
			"siteId" : $("#siteId").val(),
			"deviceType" : $("#device-type-select").val(),
			"siteType" : $("#siteType").val(),
			"clusters" : $("#cluster-select").val(),
			"zones" : $("#zone-select").val(),
			"regions" : $("#region-select").val(),
			"date": $("#datetimepicker").val()
	}
	return obj;
	
}
