function $ID(id){
	return document.getElementById(id);
}
function $NAME(id){
	return document.getElementsByName(id);
}
function checkNullOrEmptyColl(value){
	if(value != null &&  value != 'undefined' && value!='null' && value.length>0){
		return true;
	}
	else{
		return false;
	}
}
function checkNullOrEmptyCollMap(value){
	if(value != null &&  value != 'undefined' && value!='null'){
		
		for(var prop in value) {
	        if(value.hasOwnProperty(prop))
	            return true;
	    }

	    return JSON.stringify(value) !== JSON.stringify({});
		
		
	}
	else{
		return false;
	}
}
function checkNullOrEmpty(value){
	if(value != null && value!= "" && value != 'undefined' && value!='null' && value!= " "){
		return true;
	}
	else{
		return false;
	}
}
function checkNullOrEmptyOrZero(value){
	if(value != null && value != "" && value != 'undefined' && value!='null' && value!= " " && value!="0"){
		return true;
	}
	else{
		return false;
	}
}
function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57))
       return false;
    return true;
}
function genericSearchKeyPress(evt){
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (charCode === 13){
    	var result = getSearchResult();
    	if(result){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    else{
    	return true;
    }
}
function restrictSpaceCot(evt){
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode === 32 || charCode === 34 || charCode === 39 || charCode === 46 || charCode === 47 || charCode === 59)
       return false;
    return true;
}
function restrictQuotes(evt){
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode === 34 || charCode === 39)
       return false;
    return true;
}
function restrictAndEnter(evt){
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode === 38 || charCode === 13)
       return false;
    return true;
}
function allowOnlyDashDotUnderScore(evt)
{
	var charCode = (evt.which) ? evt.which : evt.keyCode
	if(charCode == 32 || charCode == 8 ||  charCode == 9 || charCode == 11 || charCode == 48 || charCode == 46 || charCode == 45 || charCode == 95)
        return true;
    if(48 <= charCode && charCode <= 57)
        return true;
    if(65 <= charCode && charCode <= 90)
        return true;
    if(97 <= charCode && charCode <= 122)
        return true;
    return false;
}

function allowOnlyDashDotUnderScoreAlfabates(evt)
{
	var charCode = (evt.which) ? evt.which : evt.keyCode
	if(charCode == 32 || charCode == 8 ||  charCode == 9 || charCode == 11 || charCode == 46 || charCode == 45 || charCode == 95)
        return true;
    //if(48 <= charCode && charCode <= 57)
      //  return true;
    if(65 <= charCode && charCode <= 90)
        return true;
    if(97 <= charCode && charCode <= 122)
        return true;
    return false;
}
function allowOnlyAlphaNumric(event) {
	var regex = new RegExp("^[a-zA-Z0-9]+$");
	var key = String.fromCharCode(!event.charCode ? event.which
			: event.charCode);
	if (!regex.test(key)) {
		event.preventDefault();
		return false;
	}
}
function isNumberDecimalKey(evt){
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if(charCode>45 && charCode<58)
    	return true;
    return false;
}
function BlockUI() {
	$('#block-ui').removeClass('dis-none').addClass('dis-block');
	$('#block-ui-msg').removeClass('dis-none').addClass('dis-block');
}
function UnBlockUI() {
	$('#block-ui').removeClass('dis-block').addClass('dis-none');
	$('#block-ui-msg').removeClass('dis-block').addClass('dis-none');
}
function BlockUIRefresh() {
	$('#block-ui-refresh').removeClass('dis-none').addClass('dis-block');
	$('#block-ui-msg-refresh').removeClass('dis-none').addClass('dis-block');
}
function UnBlockUIRefresh() {
	$('#block-ui-refresh').removeClass('dis-block').addClass('dis-none');
	$('#block-ui-msg-refresh').removeClass('dis-block').addClass('dis-none');
}
function chkEmptyTxt(id) {
	var val = $ID(id).value;
	if (val != null && val != "" && val != 'undefined') {
		txtSuccess(id);
		return true;
	} else {
		txtError(id);
		return false;
	}
}
function txtError(txtId) {
	$('#' + txtId).addClass('cmn-error');
}
function txtSuccess(txtId) {
	$('#' + txtId).removeClass('cmn-error');
}
function validateURL(str) {
	return /^(https?|s?ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(str);
}
function validateEmailId(str)
{
	var re = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(str);
	if(re){
		return true;
	}
	else{
		return false;
	}
}
function checkSize(input) {
	var fileName = input.value;
	var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
	if (input.files && input.files[0].size > (2 * 1024 * 1024)) {
		alert("File too large. Max 2 Mb allowed.");
		input.value = null;
	}
	else if(ext != "txt" && ext != "doc" && ext != "docx" && ext != "xls" && ext != "xlsx" && ext != "pdf" && ext != "zip" && ext != "png" && ext != "jpg"){
		alert(ext+" File not allowed.");
		input.value = null;
	}
}
function checkFileSizeWithType(input) {
	var fileName = input.value;
	var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
	if (input.files && input.files[0].size > (2 * 1024 * 1024)) {
		//alert("File too large. Max 2 Mb allowed.");
		showScriptMessage("ERROR","File too large. Max 2 Mb allowed.");
		input.value = null;
	}
	else if(ext != "txt" && ext != "doc" && ext != "docx" && ext != "pdf" && ext != "png" && ext != "jpg" && ext != "jpeg" && ext != "PNG" && ext != "JPG" && ext != "JPEG"){
		//alert(ext+" File not allowed.");
		showScriptMessage("ERROR",ext+" File not allowed.");
		input.value = null;
	}
}
function showScriptMessage(messageType, message){
	if(checkNullOrEmpty(messageType) && messageType == "SUCCESS"){
		Command: toastr["success"](message)
	}
	else if(checkNullOrEmpty(messageType) && messageType == "ERROR"){
		Command: toastr["error"](message)
	}
	else if(checkNullOrEmpty(messageType) && messageType == "WARNING"){
		Command: toastr["warning"](message)
	}
	else if(checkNullOrEmpty(messageType) && messageType == "INFO"){
		Command: toastr["info"](message)
	}
}
$('#radioBtn a').on('click', function(){
    var sel = $(this).data('title');
    var tog = $(this).data('toggle');
    $('#'+tog).prop('value', sel);
    $('a[data-toggle="'+tog+'"]').not('[data-title="'+sel+'"]').removeClass('active').addClass('notActive');
    $('a[data-toggle="'+tog+'"][data-title="'+sel+'"]').removeClass('notActive').addClass('active');
});
$(function(){
	$(".full_screen").click(function(){
		$(".full").toggle();
		$("body").toggleClass("margin_zero");
		if($(this).val() == "Full Screen") {
			$("#main-page").removeClass("col-lg-10 col-md-10 col-sm-10 col-xs-12").addClass("col-lg-12 col-md-12 col-sm-12 col-xs-12");
			$(this).val("Small Screen");
		//	setCookie("ScreenSize","Small Screen",30);
		}
		else {
			$("#main-page").removeClass("col-lg-12 col-md-12 col-sm-12 col-xs-12").addClass("col-lg-10 col-md-10 col-sm-10 col-xs-12");
			$(this).val("Full Screen");
			//setCookie("ScreenSize","Full Screen",30);
		}  
	});
	
	$(document).on('show.bs.modal', '.modal', function (event) {
        var zIndex = 1040 + (10 * $('.modal:visible').length);
        $(this).css('z-index', zIndex);
        setTimeout(function() {
            $('.modal-backdrop').not('.modal-stack').css('z-index', zIndex - 1).addClass('modal-stack');
        }, 0);
    });
	
	/*var screenSizeCookieVal=getCookie('ScreenSize');
	if(screenSizeCookieVal == "Full Screen") {
		$(".full").toggle();
		$("body").toggleClass("margin_zero");
		$("#main-page").removeClass("col-lg-10 col-md-10 col-sm-10 col-xs-12").addClass("col-lg-12 col-md-12 col-sm-12 col-xs-12");
		$(this).val("Small Screen");
		setCookie("ScreenSize","Small Screen",30);
	}
	else {
		$(".full").toggle();
		$("body").toggleClass("margin_zero");
		$("#main-page").removeClass("col-lg-12 col-md-12 col-sm-12 col-xs-12").addClass("col-lg-10 col-md-10 col-sm-10 col-xs-12");
		$(this).val("Full Screen");
		setCookie("ScreenSize","Full Screen",30);
	}  */
	
	
});
/*

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}


function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length,c.length);
        }
    }
    return "";
}*/
/*@Am-- */
/*For Class Division selection*/
function loadClassDivisionBySBIdAYId(contextPath, loadingOption, classLinkYN){
	BlockUI();
	$ID("globalReq").value = loadingOption; 
	$ID("classLinkYN").value = classLinkYN; 
	var boardIdIdVar=$ID('schoolBoard').value ;
	var academicYearIdVar=$ID('schoolBoardAcademicYear').value ;
	var JSONObject = {"boardId":boardIdIdVar,"academicYearId":academicYearIdVar};
	var domainContexPath = contextPath;
	$.ajax({  
		type: "POST",
		url: domainContexPath +"/result/load_classes_divisions",
		contentType: "application/json",
		data : JSON.stringify(JSONObject),
		success: function(response){
			successLoadClassDivision(response);
		},  
		error: function(e){  
			fail(e)
		}  
	});
}
/*@Am-- */
/*For Class Division selection*/
function loadClassDivision(contextPath, loadingOption, classLinkYN){
	BlockUI();
	$ID("globalReq").value = loadingOption; 
	$ID("classLinkYN").value = classLinkYN; 
	var JSONObject = {"boardId":""};
	var domainContexPath = contextPath;
	$.ajax({  
		type: "POST",
		url: domainContexPath +"/result/load_classes_divisions",
		contentType: "application/json",
		data : JSON.stringify(JSONObject),
		success: function(response){
			successLoadClassDivision(response);
		},  
		error: function(e){  
			fail(e)
		}  
	});
}
function successLoadClassDivision(response){
	var loadingOption = $ID("globalReq").value; 
	var classLinkYN = $ID("classLinkYN").value; 
	UnBlockUI();
	this.body = [];
	var lookup = {};
	var distinctDiv = [];
	var acYearId;
	if(response.status != null && response.status != "" && response.status != 'undefined' && response.status === "SUCCESS"){
		var RUBIX_JSON =  response.result;
		for(var i=0; i<RUBIX_JSON.length; i++){
			for(var j=0; j<RUBIX_JSON[i].listSmDivision.length; j++){
				var name = RUBIX_JSON[i].listSmDivision[j].divisionName;
				if (!(name in lookup)){
					lookup[name] = 1;
					distinctDiv.push(name);
				}
			}
		}
		if(	$ID("schoolBoardAcademicYear")!= null )
		{
		$ID("schoolBoardAcademicYear").value=RUBIX_JSON[0].academicYearId;
		acYearId=RUBIX_JSON[0].academicYearId;
		}
		distinctDiv.sort();
		
		this.body.push('<tr>');
		if(loadingOption === 'CLASS_DIVISION'){
			this.body.push('<td>Div / Class</td>');
		}
		else{
			this.body.push('<td>Class</td>');
		}
		if(classLinkYN === 'NO'){
			for(var i=0; i<RUBIX_JSON.length; i++){
				this.body.push('<td id="'+RUBIX_JSON[i].classId+'_'+RUBIX_JSON[i].className+'">');
				this.body.push(''+RUBIX_JSON[i].className+'');
				this.body.push('</td>');
			}
		}
		else{
			for(var i=0; i<RUBIX_JSON.length; i++){
				this.body.push('<td id="'+RUBIX_JSON[i].classId+'_'+RUBIX_JSON[i].className+'">');
				this.body.push('<label class="link cursor-pointer" onclick="getDataByClassPopup('+RUBIX_JSON[i].classId+',\''+RUBIX_JSON[i].className+'\'); return false;">'+RUBIX_JSON[i].className+'</label>');
				this.body.push('</td>');
			}
		}
		this.body.push('</tr>');
		if(loadingOption === 'CLASS_DIVISION'){
			for(var i=0; i<distinctDiv.length; i++){
				this.body.push('<tr id="'+'index_row_'+distinctDiv[i]+'">');
				this.body.push('<td id="'+'row_'+distinctDiv[i]+'">');
				this.body.push(''+distinctDiv[i]+'');
				this.body.push('</td>');
				for(var j=0; j<RUBIX_JSON.length; j++){
					var temp = false;
					var tempClassDivId ="";
					for(var k=0; k<RUBIX_JSON[j].listSmDivision.length; k++){
						if(RUBIX_JSON[j].listSmDivision[k].divisionName == distinctDiv[i]){
							temp = true;
							tempClassDivId = RUBIX_JSON[j].listSmDivision[k].divisionId;
							break;
						}
					}
					if(temp){
						this.body.push('<td id="'+distinctDiv[i]+'_'+RUBIX_JSON[j].classId+'_'+tempClassDivId+'_'+RUBIX_JSON[j].className+'" class="avaibaleClassAndDiv min-width-popup-class-div"></td>');
					}
					else{
						this.body.push('<td id="'+distinctDiv[i]+'_'+RUBIX_JSON[j].classId+'"></td>');
					}
				}
				this.body.push('</tr>');
			}
		}
		$ID('globalModalForClassDivisionDiv').innerHTML = this.body.join("");
		$(document).ready(function () {
			$("td.avaibaleClassAndDiv").hover(
				function () {
					$(this).removeClass('avaibaleClassAndDiv');
					$(this).addClass('green-cell glyphicon-cell glyphicon-ok cell-position text-center');
				}, 
				function () {
					$(this).addClass('avaibaleClassAndDiv');
					$(this).removeClass("green-cell glyphicon-cell glyphicon-ok cell-position text-center");
				}
			);
			
			$('td.avaibaleClassAndDiv').click( function() {
				var recId = $(this).attr('id');
				var recIdArray = recId.trim().split("_");
				if(	$ID("selectedClassDivisionDisplay")!= null )
				$ID("selectedClassDivisionDisplay").innerHTML = recIdArray[3]+" ("+recIdArray[0]+") ";
				$ID("classId").value=recIdArray[1];
				$ID("divisionId").value=recIdArray[2];
				
				$("#globalModalForClassDivision").modal('hide');
				getDataByClassAndDivision(recIdArray[1],''+recIdArray[3]+'',recIdArray[2],''+recIdArray[0]+''); // Class Id, Class Name, Division Id, Division Name 
				getDataByClassAndDivisionAC(recIdArray[1],''+recIdArray[3]+'',recIdArray[2],''+recIdArray[0]+'',''+acYearId+'');
			});
		});
		$("#globalModalForClassDivision").modal();
		UnBlockUI();
	}
	else{
		showScriptMessage('ERROR',response.message);
		$("#globalModalForClassDivision").modal();
		UnBlockUI();
	}
}
function loadMultiSelectClassDivision(contextPath, loadingOption, classLinkYN){
	BlockUI();
	$ID("globalReq").value = loadingOption; 
	$ID("classLinkYN").value = classLinkYN; 
	var JSONObject = {"boardId":""};
	var domainContexPath = contextPath;
	$.ajax({  
		type: "POST",
		url: domainContexPath +"/result/load_classes_divisions",
		contentType: "application/json",
		data : JSON.stringify(JSONObject),
		success: function(response){
			successMultiSelectLoadClassDivision(response);
		},  
		error: function(e){  
			fail(e)
		}  
	});
}
function successMultiSelectLoadClassDivision(response){
	this.body = [];
	var lookup = {};
	var distinctDiv = [];
	if(response.status != null && response.status != "" && response.status != 'undefined' && response.status === "SUCCESS"){
		var RUBIX_JSON =  response.result;
		
		/*var selectedAcademicYearName = $ID('selectedAcademicYearName').value;
		$ID('selectedAcadYearDisplay').innerHTML = selectedAcademicYearName
		
		var RUBIX_JSON =  JSON.parse('${ClassDivisionResult}');*/
		
		for(var i=0; i<RUBIX_JSON.length; i++){
			for(var j=0; j<RUBIX_JSON[i].listSmDivision.length; j++){
				var name = RUBIX_JSON[i].listSmDivision[j].divisionName;
				if (!(name in lookup)){
					lookup[name] = 1;
					distinctDiv.push(name);
				}
			}
		}
		
		distinctDiv.sort();
		
		this.body.push('<tr>');
		this.body.push('<td>Div / Class<input type="checkbox" id="selectAllMultipleClassDivSelection" name="selectAllMultipleClassDivSelection" onchange="selectAllMultipleClassDivision(); return false;"/></td>');
		var count = 2;
		for(var i=0; i<RUBIX_JSON.length; i++){
			this.body.push('<td id="'+'old_col_'+RUBIX_JSON[i].classId+'_'+RUBIX_JSON[i].className+'">');
			// this.body.push('<span class="glyphicon glyphicon-remove div-chk-margin cursor-pointer" onclick="deleteColumn(\''+'old_col_'+RUBIX_JSON[i].classId+'_'+RUBIX_JSON[i].className+'\'); return false;"></span>');
			this.body.push('<input id="'+'old_chk_col_'+RUBIX_JSON[i].classId+'_'+RUBIX_JSON[i].className+'" class="div-chk-margin" type="checkbox" onchange="selectAllDivisionByClassInMultiSelect(\''+'old_chk_col_'+RUBIX_JSON[i].classId+'_'+RUBIX_JSON[i].className+'\', '+count+'); return false;">');
			this.body.push(''+RUBIX_JSON[i].className+'');
			this.body.push('<input type="hidden" id="class_'+RUBIX_JSON[i].classId+'" name="class_'+RUBIX_JSON[i].classId+'" value="'+RUBIX_JSON[i].className+'"/>');
			this.body.push('</td>');
			count++;
		}
		this.body.push('</tr>');
		
		for(var i=0; i<distinctDiv.length; i++){
			this.body.push('<tr id="'+'old_index_row_'+distinctDiv[i]+'">');
			this.body.push('<td id="'+'old_row_'+distinctDiv[i]+'">');
			//this.body.push('<span class="glyphicon glyphicon-remove div-chk-margin cursor-pointer" onclick="deleteRow(\''+'old_index_row_'+distinctDiv[i]+'\'); return false;"></span>');
			this.body.push('<input id="'+'chk_old_index_row_'+distinctDiv[i]+'" class="div-chk-margin" type="checkbox" onchange="selectAllClassesByDivisionInMultiSelect(\''+'old_index_row_'+distinctDiv[i]+'\'); return false;">');
			this.body.push(''+distinctDiv[i]+'');
			this.body.push('</td>');
			for(var j=0; j<RUBIX_JSON.length; j++){
				var temp = false;
				var tempClassDivId ="";
				for(var k=0; k<RUBIX_JSON[j].listSmDivision.length; k++){
					if(RUBIX_JSON[j].listSmDivision[k].divisionName == distinctDiv[i]){
						temp = true;
						tempClassDivId = RUBIX_JSON[j].listSmDivision[k].divisionId;
						break;
					}
				}
				if(temp){
					this.body.push('<td id="old_'+distinctDiv[i]+'_'+RUBIX_JSON[j].classId+'_'+tempClassDivId+'" class="avaibaleClassAndDiv min-width-popup-class-div"></td>');
				}
				else{
					this.body.push('<td id="'+distinctDiv[i]+'_'+RUBIX_JSON[j].classId+'"></td>');
				}
			}
			this.body.push('</tr>');
		}
		$ID('globalModalForMultiSelectClassDivisionDiv').innerHTML = this.body.join("");
		/*$("#globalModalForMultiSelectClassDivisionDiv").on("click", "td", function() {
			var row = $(this).parent().index('#mtable tbody tr');
			var col = ($(this).parent().children().index($(this)))+1;
			var existingClass = $(this).attr("class");
			if(checkNullOrEmpty(existingClass) && col != 1 && row != 0){
				if(existingClass.indexOf("avaibaleClassAndDiv") >= 0){
					$(this).toggleClass("green-cell glyphicon-cell glyphicon-ok cell-position text-center");
				}
			}	
		});*/
		$('#globalModalForMultiSelectClassDivisionDiv td').click(function(){
		    var colIndex = $(this).parent().children().index($(this));
		    var rowIndex = $(this).parent().parent().children().index($(this).parent());
		   // alert('Row: ' + rowIndex + ', Column: ' + colIndex);
		   // alert($(this).attr("class"));
		    var existingClass = $(this).attr("class");
			if(checkNullOrEmpty(existingClass) && parseInt(colIndex) != 0 && parseInt(rowIndex) != 0){
				if(existingClass.indexOf("avaibaleClassAndDiv") >= 0){
					$(this).toggleClass("green-cell glyphicon-cell glyphicon-ok cell-position text-center");
				}
			}	
		});
		/*$(document).ready(function (){
			$("td.avaibaleClassAndDiv").hover(
				function (){
					$(this).removeClass('avaibaleClassAndDiv');
					$(this).addClass('green-cell glyphicon-cell glyphicon-ok cell-position text-center');
				}, 
				function (){
					$(this).addClass('avaibaleClassAndDiv');
					$(this).removeClass("green-cell glyphicon-cell glyphicon-ok cell-position text-center");
				}
			);
		});*/
		$("#globalModalForMultiSelectClassDivision").modal();
		UnBlockUI();
	}
	else{
		UnBlockUI();
	}
}
function selectAllClassesByDivisionInMultiSelect(rowId){
	if($ID("chk_"+rowId).checked){
		for(var i=0; i<$('#' + rowId).find("td:gt(0)").length; i++){
			if(($('#' + rowId).find("td:gt(0)")[i].className).indexOf("avaibaleClassAndDiv") >= 0){
				$("#"+$('#' + rowId).find("td:gt(0)")[i].id).addClass("green-cell glyphicon-cell glyphicon-ok cell-position text-center");
			}
		}
		//$ID('#' + rowId).checked = true;
	}
	else{
		$('#' + rowId).find("td:gt(0)").removeClass("green-cell glyphicon-cell glyphicon-ok cell-position text-center");
		//$ID('#' + rowId).checked = false;
	}
}
function selectAllDivisionByClassInMultiSelect(colId, colIndex){
	//var colIndex = $('#'+colId).parent().index()+1;
	//alert($('#globalModalForMultiSelectClassDivisionDiv th:nth-child('+colIndex+'), table td:nth-child('+colIndex+')').slice(1).length);
	if($ID(colId).checked){
		for(var i=0; i<$('#globalModalForMultiSelectClassDivisionDiv th:nth-child('+colIndex+'), table td:nth-child('+colIndex+')').slice(1).length; i++){
			if(($('#globalModalForMultiSelectClassDivisionDiv th:nth-child('+colIndex+'), table td:nth-child('+colIndex+')').slice(1)[i].className).indexOf("avaibaleClassAndDiv") >= 0){
				$("#"+$('#globalModalForMultiSelectClassDivisionDiv th:nth-child('+colIndex+'), table td:nth-child('+colIndex+')').slice(1)[i].id).addClass('green-cell glyphicon-cell glyphicon-ok cell-position text-center');
			}
		}
		//alert($('#globalModalForMultiSelectClassDivisionDiv th:nth-child('+colIndex+'), table td:nth-child('+colIndex+')').slice(1));
		//$('#globalModalForMultiSelectClassDivisionDiv th:nth-child('+colIndex+'), table td:nth-child('+colIndex+')').slice(1).addClass('green-cell glyphicon-cell glyphicon-ok cell-position text-center');
		//$ID('#' + colId).checked = true;
	}
	else{
		$('#globalModalForMultiSelectClassDivisionDiv th:nth-child('+colIndex+'), table td:nth-child('+colIndex+')').removeClass('green-cell glyphicon-cell glyphicon-ok cell-position text-center');
		//$ID('#' + colId).checked = false;
	}
}
function selectAllMultipleClassDivision(){
	if($ID("selectAllMultipleClassDivSelection").checked){
		 $('.avaibaleClassAndDiv').addClass("green-cell glyphicon-cell glyphicon-ok cell-position text-center");
		 //$ID("#selectAllMultipleClassDivSelection").checked = true;
	}
	else{
		 $('.avaibaleClassAndDiv').removeClass("green-cell glyphicon-cell glyphicon-ok cell-position text-center");
		 //$ID("#selectAllMultipleClassDivSelection").checked = false;
	}
}
function getSelectedClassDivision(){
	var selectedClassDivision = [];
	$("#globalModalForMultiSelectClassDivisionDiv td").each(function() {
		var className = $(this).attr("class");
		var id = $(this).attr("id");
		if(checkNullOrEmpty(className)){
			if(className.indexOf("green-cell") >= 0){
				selectedClassDivision.push(id);
			}
		}
	});
	this.body = [];
	if(selectedClassDivision.length>0){
		this.body.push('[{');
		var mainItr = 0;
		var complClass = [];
		for(var i=0; i<selectedClassDivision.length; i++){
			var selectedId = selectedClassDivision[i];
			var arrSelectedId = selectedId.split('_');
			var classId = arrSelectedId[2];
			if(complClass.indexOf(classId)<0){
				if(mainItr > 0){
					this.body.push(',{');
				}
				complClass.push(classId);
				var hiddenClassName = $ID("class_"+classId).value;
				this.body.push('"classId":"'+classId+'",');
				this.body.push('"className":"'+hiddenClassName+'",');
				this.body.push('"division": [');
				this.body.push('{');
				var itrCount = 0;
				for(var j=0; j<selectedClassDivision.length; j++){
					mainItr++;
					var selectedTempId = selectedClassDivision[j];
					var arrSelectedTempId = selectedTempId.split('_');
					var tempDivisionName = arrSelectedTempId[1];
					var tempDivisionId = arrSelectedTempId[3];
					if(selectedTempId.indexOf(classId) >= 0){
						if(itrCount > 0){
							this.body.push('},{');
						}
						itrCount++;
						this.body.push('"divisionId": "'+tempDivisionId+'",');
						this.body.push('"divisionName": "'+tempDivisionName+'"');
					}
				}
				this.body.push('}]}');
			}
		}
		this.body.push(']');
		// console.log(this.body.join(""));
	}
	selectedMultipleClassAndDivisions(this.body.join(""));
}
function getDataByClassPopup(classId, className){
	$ID("selectedClassDivisionDisplay").innerHTML = className;
	$ID("classId").value = classId;
	$ID("divisionId").value = "";
	$("#globalModalForClassDivision").modal('hide');
	getDataByClass(classId, className);
}
$(function(){
	$("#chk_select_all").change(function(){ 
	    var status = this.checked;
	    $('.chkcheckbox').each(function(){
	        this.checked = status;
	    });
	});
	$('.chkcheckbox').change(function(){ 
	    if(this.checked == false){
	        $("#chk_select_all")[0].checked = false;
	    }
	    if ($('.chkcheckbox:checked').length == $('.chkcheckbox').length ){
	        $("#chk_select_all")[0].checked = true;
	    }
	});
});
function keyPressSchoolList(evt){
	 var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode === 13)
	    	getSchoolList();
	    return true;
}



function showCustomizedConfirmation(title, message, modalType, color, closeBtn, btn, btnFunction){
	var defaultFlag = false;
	var footerFlag = false;
	$('#modalCommonConfirmationTitle').text('');
	$('#modalCommonConfirmationDesc').text('');
	$('#modalCommonConfirmationLgSm').removeClass('modal-primary');
	$('#modalCommonConfirmationLgSm').removeClass('modal-info');
	$('#modalCommonConfirmationLgSm').removeClass('modal-warning');
	$('#modalCommonConfirmationLgSm').removeClass('modal-success');
	$('#modalCommonConfirmationLgSm').removeClass('modal-danger');
	$('#modalCommonConfirmationCloseBtn').addClass('dis-none');
	$('#modalCommonConfirmationCloseBtn').removeClass('btn-default').addClass('btn-outline');
	$('#modalCommonConfirmationFtr').removeClass('dis-none').addClass('dis-block-imp');
	
	if(checkNullOrEmpty(title)){
		$('#modalCommonConfirmationTitle').text(title);
		$('#modalCommonConfirmationHdr').removeClass('dis-none').addClass('dis-block-imp');
	}
	else{
		$('#modalCommonConfirmationHdr').removeClass('dis-block-imp').addClass('dis-none');
	}
	if(checkNullOrEmpty(message)){
		$('#modalCommonConfirmationDesc').text(message);
		$('#modalCommonConfirmationBody').removeClass('dis-none').addClass('dis-block-imp');
	}
	else{
		$('#modalCommonConfirmationBody').removeClass('dis-block-imp').addClass('dis-none');
	}
	if(checkNullOrEmpty(modalType) && modalType === 'LARGE'){
		$('#modalCommonConfirmationLgSm').addClass('modal-lg');
	}
	else{
		$('#modalCommonConfirmationLgSm').removeClass('modal-lg');
	}
	if(checkNullOrEmpty(color) && color === 'PRIMARY'){
		$('#modalCommonConfirmationLgSm').addClass('modal-primary');
	}
	else if(checkNullOrEmpty(color) && color === 'INFO'){
		$('#modalCommonConfirmationLgSm').addClass('modal-info');
	}
	else if(checkNullOrEmpty(color) && color === 'WARNING'){
		$('#modalCommonConfirmationLgSm').addClass('modal-warning');
	}
	else if(checkNullOrEmpty(color) && color === 'SUCCESS'){
		$('#modalCommonConfirmationLgSm').addClass('modal-success');
	}
	else if(checkNullOrEmpty(color) && color === 'ERROR'){
		$('#modalCommonConfirmationLgSm').addClass('modal-danger');
	}
	else{
		defaultFlag = true;
		$('#modalCommonConfirmationCloseBtn').removeClass('btn-outline').addClass('btn-default');
	}
	if(checkNullOrEmpty(closeBtn) && closeBtn === 'YES'){
		footerFlag = true;
		$('#modalCommonConfirmationCloseBtn').removeClass('dis-none').addClass('dis-inline');
	}
	this.body = [];
	if(checkNullOrEmpty(btn) && checkNullOrEmpty(btnFunction)){
		var btnNames =  btn.split(',');
		var arrFunction = btnFunction.split(',');
		for(var i=0; i<btnNames.length; i++){
			footerFlag = true;
			if(defaultFlag){
				this.body.push('<button type="button" class="btn btn-default" onclick="'+arrFunction[i]+'(); return false;">'+btnNames[i]+'</button>');
			}
			else{
				this.body.push('<button type="button" class="btn btn-outline" onclick="'+arrFunction[i]+'(); return false;">'+btnNames[i]+'</button>');
			}
		}
		if(checkNullOrEmpty(closeBtn) && closeBtn === 'YES'){
			if(defaultFlag){
				this.body.push('<button id="modalCommonConfirmationCloseBtn" type="button" class="btn btn-default" data-dismiss="modal">Close</button>');
			}
			else{
				this.body.push('<button id="modalCommonConfirmationCloseBtn" type="button" class="btn btn-outline" data-dismiss="modal">Close</button>');
			}
		}
		document.getElementById("modalCommonConfirmationFtr").innerHTML = this.body.join("");
	}
	if(!footerFlag){
		$('#modalCommonConfirmationFtr').removeClass('dis-block-imp').addClass('dis-none');
	}
	$('#modalCommonConfirmation').modal('show');
}
function validateCompulsoryFields(formObj){
	var submitStatus = true;
	$(formObj).find(':input[type=text]').each(function(){
		var disabled = $(this).prop("disabled");
		if(!disabled){
			var status = validateInputText(this);
			if(!status)
			{
				submitStatus=false;
			}
		}
	});
	$(formObj).find('select').each(function(){
		var selectDisabled = $(this).prop("disabled");
		if(!selectDisabled){
			var status = validateSelectBox(this);
			if(!status)
			{
				submitStatus=false;
			}
		}
	});
	return submitStatus;
}
function validateInputText(element) {
	var fieldValue=$(element).val();
	var isRequired=$(element).attr("required");
	var isSuccess = false;
	if(checkNullOrEmpty(fieldValue))
	{
		var pattern = $(element).attr("pattern");
		if(checkNullOrEmpty(pattern))
		{
			var isValidPattern = checkRegEx(element);
			if(isValidPattern)
			{
				removeWrongField(element);
				isSuccess = true;
			}
			else
			{
				showWrongField(element);
				isSuccess = false;
			}
		}
		else
		{
			removeWrongField(element);
			isSuccess = true;
		}
	}
	else if(isRequired === "required")
	{
		showWrongField(element);
		isSuccess =  false;
	}
	else
	{
		removeWrongField(element);
		isSuccess = true;
	}
	if(isSuccess){
		var minLength = $(element).attr("minlength");
		if(checkNullOrEmpty(fieldValue) && checkNullOrEmpty(minLength)){
			if(fieldValue.length < parseInt(minLength)){
				showWrongField(element);
				isSuccess = false;
			}
			else{
				removeWrongField(element);
				isSuccess = true;
			}
		}
	}
	if(isSuccess){
		var number = $(element).attr("number");
		if(checkNullOrEmpty(fieldValue) && checkNullOrEmpty(number) && number.toUpperCase() === 'YES'){
			if(Number.isInteger(parseInt(fieldValue)) && parseInt(fieldValue) > 0){
				removeWrongField(element);
				isSuccess = true;
			}
			else{
				showWrongField(element);
				isSuccess = false;
			}
		}
	}
	if(isSuccess){
		return true;
	}
	else{
		return false;
	}
}
function validateSelectBox(element){
	var isRequired=$(element).attr("required");
	var fieldValue=$(element).val();
	if(checkNullOrEmpty(fieldValue) && fieldValue !== '0')
	{
		removeWrongField(element);
		return true;
	}
	else if(isRequired=="required")
	{
		showWrongField(element);
		return false;
	}
	else
	{
		removeWrongField(element);
		return true;
	}
}
function checkRegEx(element)
{
	var pattern = $(element).attr("pattern");
	var fieldValue = $(element).val();
    var patternRegExp = new RegExp(pattern);
	if (patternRegExp.test(fieldValue)) 
	{
		return true;
	}
	else 
	{
		return false;
	}
}
function showWrongField(element)
{
	$(element).closest(".form-control").addClass("cmn-error");
}
function removeWrongField(element)
{
	$(element).closest(".form-control").removeClass("cmn-error");
}
function fail(e){
	UnBlockUI();
}
function showSelectedMultipleClassesAndDivisions(response){

	$ID("selectedMultipleClassesDisplay").innerHTML = "";
	$("#selectedMultipleClassesDisplayDiv").removeClass("dis-block-imp").addClass("dis-none");
	BlockUI();
	var classListId = 0;
	var divisionListId = 0;
	var classIdList = "";
	var divisionIdList = "";
	var selectedClassDivisionData = "";
	if(checkNullOrEmpty(response)){
		var jsonData = JSON.parse(response);
		if(jsonData.length > 0){
			for(var i=0; i<jsonData.length; i++){
				if(parseInt(classListId) === 0){
					classListId++;
					selectedClassDivisionData = jsonData[i].className;
					classIdList = jsonData[i].classId;
					for(var j=0; j<jsonData[i].division.length; j++){
						if(parseInt(divisionListId) === 0){
							divisionListId++;
							divisionIdList = jsonData[i].division[j].divisionId;
							selectedClassDivisionData = selectedClassDivisionData + " ("+jsonData[i].division[j].divisionName;
						}
						else{
							divisionIdList = divisionIdList+","+jsonData[i].division[j].divisionId;
							selectedClassDivisionData = selectedClassDivisionData + ", "+jsonData[i].division[j].divisionName;
						}
					}
					selectedClassDivisionData = selectedClassDivisionData + ")";
				}
				else{
					classIdList = classIdList +','+jsonData[i].classId;
					selectedClassDivisionData = selectedClassDivisionData +" <br/>"+ jsonData[i].className+" (";
					for(var j=0; j<jsonData[i].division.length; j++){
						if(j !== 0){
							selectedClassDivisionData = selectedClassDivisionData + ", ";
						}
						if(parseInt(divisionListId) === 0){
							divisionListId++;
							divisionIdList = jsonData[i].division[j].divisionId;
							selectedClassDivisionData = selectedClassDivisionData + "("+jsonData[i].division[j].divisionName;
						}
						else{
							divisionIdList = divisionIdList+", "+jsonData[i].division[j].divisionId;
							selectedClassDivisionData = selectedClassDivisionData + jsonData[i].division[j].divisionName;
						}
					}
					selectedClassDivisionData = selectedClassDivisionData + " )";
				}
			}
		}
		this.body = [];
		this.body.push('<div class="">');
		this.body.push('<ul class="list-unstyled">');
		this.body.push('<li>');
		this.body.push('<a class="btn btn-default" data-toggle="popover" role="button" data-container="body" data-trigger="focus" data-placement="right" type="button" data-html="true" href="#" id="login">Selected classes & divisions</a>');
		this.body.push('</li>');
		this.body.push('<div id="popover-content" class="hide">');
		this.body.push(''+selectedClassDivisionData+'');
		this.body.push('</div>');
		this.body.push('</ul>');
		this.body.push('</div>');	
		$ID("selectedMultipleClassesDisplay").innerHTML = this.body.join('');
		$("#selectedMultipleClassesDisplayDiv").removeClass("dis-none").addClass("dis-block-imp");
		$("[data-toggle=popover]").popover({
		    html: true, 
		    trigger : 'hover',
			content: function() {
	          return $('#popover-content').html();
	        }
		});
		$('#example').popover();
	}
	else{
		UnBlockUI();
		showScriptMessage("ERROR","Select at least one class or division.");
	}
	UnBlockUI();
}


function loadMultiSelectClass(contextPath,academicYearId,schoolBoardId,classIdList) {
	
var JSONObject = {"schoolBoardId":schoolBoardId,"academicYearId":academicYearId};
var domainContexPath = contextPath;
$.ajax({  
	type: "POST",
	url: domainContexPath +"/manage_class_subjects/load_classes",
	contentType: "application/json",
	data : JSON.stringify(JSONObject),
	success: function(response){
		successLoadMultiSelectClass(response,classIdList);
	},  
	error: function(e){  
		fail(e)
	}  
});
}

function successLoadMultiSelectClass(response,classIdList) {
	
	 var  str=[];
	$(".selectClass_div").empty();
	
	var objReceivedJSON=response.result;
	
	 if( objReceivedJSON!=null){
	 if( objReceivedJSON.length > 0  || objReceivedJSON!=null){
		
	str.push('<table class="table table-bordered table-striped" ');
	str.push('id="classTable">');
	
		 for(var i = 0; i < objReceivedJSON.length; i++) {
			     
			    str.push(' <td>');	
			    str.push('  <input type="checkbox" class="checkbox" id="'+objReceivedJSON[i].classId+'" name="classId" value="'+objReceivedJSON[i].classId+'_'+ objReceivedJSON[i].className+'"  onclick="onClickHandler();"> <label for="'+objReceivedJSON[i].classId +'">'+objReceivedJSON[i].className +'</label>');
			   
			    str.push(' </td>');	
			    
		 
		 }
		 str.push(' <tr>');	
		 str.push('</tr>');	
		 str.push(' </table>');	
		 str.push('<div class="row">');
		 str.push('<div align="right" class="col-lg-6 col-md-6 col-sm-6 col-xs-12">');
		 str.push('  <input type="checkbox"  id="allClass" name="allClass" onclick="selectAll();" value="All Class"> All Classes');
		 str.push('</div>');
		 str.push('</div>');
		 }
	 }
	 else{
		 str.push('<div class="row">');
		 str.push('<div align="right" class="col-lg-6 col-md-6 col-sm-6 col-xs-12">');
		 str.push(' you have to create classes first');
		 str.push('</div>');
		 str.push('</div>'); 
		 $("#btnSub").hide();	
		 
	 }
	
	
	$(".selectClass_div").append(str.join(''));
    $("#selectClass").modal();
	 
    checkedClass(classIdList);
	
}

function selectAll() {
	
	  var checkBoxAllClass = document.getElementById("allClass");
	     
	     if (checkBoxAllClass.checked == true){
	    	          
	    	 $('input[name=classId]').prop('checked', true);
	     }
	     if (checkBoxAllClass.checked == false){
	          
	    	 $('input[name=classId]').prop('checked', false);
	     }
}


function  onClickHandler() { 		
	if ($('.checkbox:checked').length != $('.checkbox').length ){ 
		 $('input[name=allClass]').prop('checked', false);
	}	
}


function selectClass() {
	var  str=[];

	 var selectedClassId = [];
	 var selectedClassName = [];

    	 $.each($("input[name='classId']:checked"), function(){     
    		 
    		
    		 var selectedClassArr = [];  
    		
    		  selectedClassArr =$(this).val().split('_');
        	 selectedClassId.push(selectedClassArr[0]);
        	 selectedClassName.push(selectedClassArr[1]);
        	 
         });
    	 
    	
    	 var classMap = new Map();
    	 classMap.set('classId', selectedClassId);
    	 classMap.set('className', selectedClassName.join());
    	 document.getElementById('classNameArrfield').value=selectedClassName.join();
    	 document.getElementById('classIdArrfield').value=selectedClassId;
    	  if( checkNullOrEmpty(selectedClassName) )   {
	    	   $("#selectClassmodal").show();
	    	                               $(".selectClassDiv").empty();
	    	                                 str.push('<div  class="col-lg-12 col-md-12 col-sm-12 col-xs-12">');
	    	                             str.push('<b> Selected Class/es : </b>'+selectedClassName);
	    	                             str.push('</div>'); 
	    	                             $(".selectClassDiv").append(str.join(''));    
	    	                            
	    	             				$("#btnSubmit").show();  
           } 
    	  else{
    		  if($('#selectClass').hasClass('in')){
     		
     				showScriptMessage("ERROR","Please select the class.");
     				
     	     }
    	  }
    	  
    	 
    	  if($('#selectClass').hasClass('in')){
    		  if( checkNullOrEmpty(selectedClassName) )   {
    			  $('#selectClass').modal('hide'); 
    		  }
    		  else{
    			  $('#selectClass').modal('show'); 
    		  }
    		  
    	  }
    	  else{
    		  
    			  $('#selectClass').modal('hide'); 
    	  }
    	 

	 
     return classMap;
}

function  checkedClass(classIdList) { 
	var classIdArr = [];
	var selectedClassId = [];
	 var selectedClassArr = [];  
	 var selectedArr = [];  

	 selectedArr =document.getElementById("classIdArrfield").value;
		
	if(selectedArr.length > 0)
		{
		
		classIdArr=selectedArr ;
		}
	
	 else{
	
		 classIdArr=classIdList ;
		
 }
	 if(classIdArr.length > 0){
			
		  selectedClassArr =classIdArr.split(',');
			 if( selectedClassArr.length > 0){
					
					
				 for (var index = 0; index < selectedClassArr.length; index++) { 
						
					 selectedClassArr[index] = selectedClassArr[index].replace(/[^0-9]/g, '');
					 $('input[id="'+selectedClassArr[index]+'"]').prop('checked', true);
				 
				} 
					
					  		 
				}  
		  
  		 
		}
	 
	 
		
}
function  closeClassSubject() {
	 var classIdArrMap = [];
	 classIdArrMap=document.getElementById("classNameArrfield").value;
	 if( classIdArrMap.length > 0){
			
		 var  str=[];
 	   $("#selectClassmodal").show();
 	                               $(".selectClassDiv").empty();
 	                                 str.push('<div  class="col-lg-12 col-md-12 col-sm-12 col-xs-12">');
 	                             str.push('<b> Selected Class/es : </b>'+classIdArrMap);
 	                             str.push('</div>'); 
 	                             $(".selectClassDiv").append(str.join(''));    
 	                            
 	             				$("#btnSubmit").show();  
    }
	  else
	   {
		  $('input[name=classId]').prop('checked', false);
			 $('input[name=allClass]').prop('checked', false);
		  
		  $("#classNameArrfield").val("");
		                 $("#selectClassmodal").hide();
		           }

	 
	  }
function checkUserNameAndPrimaryMobileNo(contextPath,username,primaryMobileNo,resourceId,flag)
{
	if(checkNullOrEmpty(username) || checkNullOrEmpty(primaryMobileNo))
		{
		var domainContexPath = contextPath;
		var JSONObject ={"username":""+username+"" ,"primaryMobileNo":""+primaryMobileNo+"" ,"resourceId":""+resourceId+"" };
			 $.ajax({  
					type: "POST",
					url: domainContexPath +"/data/checkUserNameAndPrimaryMobileNumber",
					data:JSON.stringify(JSONObject),
				    contentType: "application/json",
					success: function(response){
					
					success_checkUserNameAndPrimaryMobileNo(response,primaryMobileNo,username,flag);
					},  
					error: function(e){  
						fail(e) 
					}  
				});
		}
		
	
}

function success_checkUserNameAndPrimaryMobileNo(response,primaryMobileNo,username,flag){
	if (response.status === "ERROR") {
		
		showScriptMessage("ERROR",response.message);
		
		if(checkNullOrEmpty(primaryMobileNo))
		 document.getElementById("primaryMobileNo").value="";	
		
		
		 
		 if(flag=="save")
			 {
				if(checkNullOrEmpty(primaryMobileNo))
					
					{
					 document.getElementById("sUsername").value="";	 
					 document.getElementById("sPassword").value="";	
					}
			
			 
			 
			 if(checkNullOrEmpty(username))
				 document.getElementById("sUsername").value="";
			 }
		 else{
			 if(checkNullOrEmpty(username))
				 document.getElementById("username").value="";
		 }
		 
	}
	
if (response.status === "SUCCESS") {
		
	
	 
	 
	 
	 if(checkNullOrEmpty(primaryMobileNo))
		{
		 document.getElementById("primaryMobileNo").value=primaryMobileNo;
		 removeSpaces(primaryMobileNo);
		}
	
	 if(checkNullOrEmpty(username))
		{
		 document.getElementsByName("username").value=username;
		 removeSpaces(username);
		}
	}
}