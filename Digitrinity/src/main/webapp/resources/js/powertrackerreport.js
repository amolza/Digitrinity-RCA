var powerTrackerTable;
$(document).ready(function () {
    loadCustomers();
    loadSiteIds();
    loadSiteTypes();
    loadClusters();
    loadZones();
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
    }, function (start, end, label) {
    });
    loadSiteStatus();
    loadRegions();
    renderPowerTrackerTeeDataTable();
    registerLatestReportDataOnClickEvent();
});

function renderPowerTrackerTeeDataTable() {
    powerTrackerTable = $('#powerTrackerDataTable').DataTable({
        "ajax": {
            "url": "../power-tracker/tee",
            "type": "POST",
            "dataType": 'json',
            "contentType": "application/json",
            "data": function (d) {
                return JSON.stringify(buildDataTableAjaxData())
            }
        },
        "dom": 'frti<"plcontainer"lp>',
        "bFilter": false
    });
    //new $.fn.dataTable.FixedHeader(latestReportTable);
}


function buildDataTableAjaxData() {
    var obj = {
        "siteId": $("#siteId").val(),
        "customers": $("#customer").val(),
        "siteType": $("#siteType").val(),
        "clusters": $("#cluster-select").val(),
        "zones": $("#zone-select").val(),
        "regions": $("#region-select").val(),
        "deviceType": $("#device-type-select").val(),
        "powerSource": $("#powersource").val()
    }
    return obj;

}


function loadSiteStatus() {
    $("#siteStatus").selectpicker("refresh");
    $("#siteStatus").selectpicker("selectAll");
    registerLatestReportReload($("#siteStatus"));
}

function loadCustomers() {
    $.ajax('../dashboard/customer-master',   // request url
        {
            success: function (data, status, xhr) {// success callback function
                $.each(data, function (index, jsonObject) {
                    $.each(jsonObject, function (key, val) {
                        $("#customer").append('<option value="' + val + '">' + val + '</option>');
                    });
                });
                $("#customer").selectpicker("refresh");
                $("#customer").selectpicker("selectAll");
                registerLatestReportReload($("#customer"));
            }
        });
}


function loadSiteIds() {
    $.ajax('../dashboard/site-code-master',   // request url
        {
            success: function (data, status, xhr) {// success callback function
                $.each(data, function (index, jsonObject) {
                    $.each(jsonObject, function (key, val) {

                        $("#siteId").append('<option value="' + val + '">' + val + '</option>');
                    });
                });
                $("#siteId").selectpicker("refresh");
                $("#siteId").selectpicker("selectAll");

                registerLatestReportReload($("#siteId"));

            }
        });
}

function loadSiteTypes() {
    $.ajax('../dashboard/site-type-master',   // request url
        {
            success: function (data, status, xhr) {// success callback function
                $.each(data, function (index, jsonObject) {
                    $("#siteType").append('<option value="' + jsonObject.type + '">' + jsonObject.type + '</option>');
                });
                $("#siteType").selectpicker("refresh");
                $("#siteType").selectpicker("selectAll");
                registerLatestReportReload($("#siteType"));
            }
        });
}

function loadClusters() {
    $.ajax('../dashboard/cluster-master',   // request url
        {
            success: function (data, status, xhr) {// success callback function
                $.each(data, function (index, jsonObject) {
                    $("#cluster-select").append('<option value="' + jsonObject.crName + '">' + jsonObject.crName + '</option>');
                });
                $("#cluster-select").selectpicker("refresh");
                $("#cluster-select").selectpicker("selectAll");
                registerLatestReportReload($("#cluster-select"));
            }
        });
}

function loadZones() {
    $.ajax('../dashboard/zone-master',   // request url
        {
            success: function (data, status, xhr) {// success callback function
                $.each(data, function (index, jsonObject) {
                    $("#zone-select").append('<option value="' + jsonObject.znZone + '">' + jsonObject.znZone + '</option>');
                });
                $("#zone-select").selectpicker("refresh");
                $("#zone-select").selectpicker("selectAll");
                registerLatestReportReload($("#zone-select"));
            }
        });
}

function loadRegions() {
    $.ajax('../dashboard/region-master',   // request url
        {
            success: function (data, status, xhr) {// success callback function
                $.each(data, function (index, jsonObject) {
                    $("#region-select").append('<option value="' + jsonObject.rgRegion + '">' + jsonObject.rgRegion + '</option>');
                });
                $("#region-select").selectpicker("refresh");
                $("#region-select").selectpicker("selectAll");
                registerLatestReportReload($("#region-select"));
            }
        });
}


function loadDeviceType() {
    $.ajax('../dashboard/device-type-master',   // request url
        {
            success: function (data, status, xhr) {// success callback function
                $.each(data, function (index, jsonObject) {
                    $("#device-type-select").append('<option value="' + jsonObject.deviceType + '">' + jsonObject.deviceType + '</option>');
                });
                $("#device-type-select").selectpicker("refresh");
                $("#device-type-select").selectpicker("selectAll");
            }
        });
}

var randomColorGenerator = function () {
    return '#' + (Math.random().toString(16) + '0000000').slice(2, 8);
};


function registerLatestReportReload(selectObj) {
    selectObj.on('changed.bs.select', function (e, clickedIndex, isSelected, previousValue) {
        var thisObj = $(this);
        var isAllSelected = thisObj.find('option[value="All"]').prop('selected');
        var lastAllSelected = $(this).data('all');
        var selectedOptions = (thisObj.val()) ? thisObj.val() : [];
        var allOptionsLength = thisObj.find('option[value!="All"]').length;


        var selectedOptionsLength = selectedOptions.length;

        if (isAllSelected == lastAllSelected) {

            if ($.inArray("All", selectedOptions) >= 0) {
                selectedOptionsLength -= 1;
            }

            if (allOptionsLength <= selectedOptionsLength) {

                thisObj.find('option[value="All"]').prop('selected', true).parent().selectpicker('refresh');
                isAllSelected = true;
            } else {
                thisObj.find('option[value="All"]').prop('selected', false).parent().selectpicker('refresh');
                isAllSelected = false;
            }

        } else {
            thisObj.find('option').prop('selected', isAllSelected).parent().selectpicker('refresh');
        }

        $(this).data('all', isAllSelected);

        $('#latestDataReportTable').DataTable().ajax.reload();
    });
}

function registerLatestReportDataOnClickEvent() {
    $('#latestDataReportTable tbody').on('click', 'tr', function () {

        /*if ( $(this).hasClass('selected') ) {
           // $(this).removeClass('selected');
        }
        else {
            latestReportTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }*/
        latestReportTable.$('tr.selected').removeClass('selected');
        $(this).addClass('selected');

        var siteId = latestReportTable.row(this).data().smSiteCode;
    });

}

function loadExportSelect(context, datatable) {
    var tableExportSelect = context + " #exportSelect"
    $(tableExportSelect).on('change', function (event) {
        var target = event.target.value;
        switch (target) {
            case "0":
                datatable && datatable.button('.buttons-copy').trigger();
                break;
            case "1":
                datatable && datatable.button('.buttons-csv').trigger();
                break;
            case "2":
                datatable && datatable.button('.buttons-excel').trigger();
                break;
            case "3":
                datatable && datatable.button('.buttons-print').trigger();
                break;
            default:
                // do nothing
                break;
        }
    });
}