<!DOCTYPE html>
<html lang="en" >
	<head>
			<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
		
		<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
		<%@page import="java.util.HashMap"%>
		<%@page import="java.util.Map"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

	    <meta charset="UTF-8">
	    <title>Welcome</title>
		<jsp:include page="include_hdr.jsp"></jsp:include>
	</head>
<body class="sidebar-is-reduced overflow-hidden">
		<header class="l-header">
			<jsp:include page="header.jsp"></jsp:include>
		</header>
		<div class="l-sidebar">
			<jsp:include page="sidebar.jsp"></jsp:include>
		</div>
	<main class="l-main">
	<div class="content-wrapper content-wrapper--with-bg"
		style="overflow-x: hidden; overflow-y: auto;">
		<div class="list-group">
			<form:form method="POST" modelAttribute="faultCategoryFormBean"
				name="faultCategoryFormBean">
				<input type="hidden" id="faultID" name="faultID"
					value="${faultCategoryFormBean.faultID}" />
				<div class="container">
					<div class="row">
						<div class='col-lg-4 col-md-4 col-sm-3 col-xs-3 text-right'>
							<span>Enter Fault Category Name</span>
						</div>
						<div class='col-lg-6 col-md-6 col-sm-3 col-xs-3'>
							<form:input class="form-control"
								placeholder="Enter Fault Category Name "
								id="faultCategory" path="faultCategory" name="faultCategory"
								required="required" pattern="(?!^ +$)^.+$" value="${faultCategoryFormBean.faultCategory}" 
								maxlength="100" />
						</div>
					</div>
					<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
									align="center">
									<button class="btn btn-primary" title="SUBMIT"
								onclick="submitFaultCategory(); return false;" type="button">SUBMIT</button>
								</div>
							</div>
					
					
					
					</div>
				</form:form>
					
					
					
					
					<div class="form-group">
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6 col-lg-12" align="right">
							<button type="button" class="btn btn-primary" id="btnExport" onclick="fnExcelReport();"> EXPORT to Excel </button>
							<button type="button" class="btn btn-primary" id="btnExport" onclick="exportTableToCSV('details.csv')"> EXPORT to CSV </button>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6 col-lg-12">
							<c:if test="${not empty faultCategoryMasterList}">
								<%
									int count = 1;
								%>

							<table id="categoryTable" class="table table-striped table-bordered nowrap">
									<thead>
										<tr>
														<th>Sr.No</th>
														<th>Fault Category Name</th>
														<th>Edit</th>
														<th>Delete</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="rcaReport" items="${faultCategoryMasterList}">
														<tr>
															<td align="center" class="width-3"><%=count%></td>
															<td align="center" class="width-5"><p>${rcaReport.faultCategory}</p></td>
															<td align="center" class="width-5"><img
																class="cursor-pointer" alt="EDIT"
																src="<c:url value="/resources/images/edit.png"/>"
																height="20px" width="20px" title="Click for edit"
																onclick="javascript:viewEditfaultCategoryForm('${rcaReport.faultID}');" /></td>

															<td align="center" class="width-5"><img
																alt="INACTIVE"
																src="<c:url value="/resources/images/wrong_tick.png"/>"
																height="20px" width="20px" title="Click for delete"
																onclick="javascript:deletefaultCategory('${rcaReport.faultID}');" /></td>

														</tr>
														<%
															count++;
														%>
													</c:forEach>
												</tbody>
											</table>
									</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="include_ftr.jsp"></jsp:include>
	</body>
	<script type="text/javascript">
		function submitFaultCategory() {
			document.faultCategoryFormBean.method = "POST";
			document.faultCategoryFormBean.action = "<c:url value='${contextPath}/master_data/fault_category'/>";
			document.faultCategoryFormBean.submit();
		}
		function viewEditfaultCategoryForm(faultID)
		{ 
			$("#faultID").val(faultID);
			document.faultCategoryFormBean.method = "POST";
			document.faultCategoryFormBean.action = "<c:url value='${contextPath}/master_data/get_faultCategory_details'/>";
			document.faultCategoryFormBean.submit();
		}
		function deletefaultCategory(faultID)
		{ 
			$("#faultID").val(faultID);
			document.faultCategoryFormBean.method = "POST";
			document.faultCategoryFormBean.action = "<c:url value='${contextPath}/master_data/delete_faultCategory_details'/>";
			document.faultCategoryFormBean.submit();
		}
		
		function downloadCSV(csv, filename) {
		    var csvFile;
		    var downloadLink;

		    // CSV file
		    csvFile = new Blob([csv], {type: "text/csv"});

		    // Download link
		    downloadLink = document.createElement("a");

		    // File name
		    downloadLink.download = filename;

		    // Create a link to the file
		    downloadLink.href = window.URL.createObjectURL(csvFile);

		    // Hide download link
		    downloadLink.style.display = "none";

		    // Add the link to DOM
		    document.body.appendChild(downloadLink);

		    // Click download link
		    downloadLink.click();
		}

		function exportTableToCSV(filename) {
		    var csv = [];
			var rows = document.getElementById("categoryTable").rows;
		    for (var i = 0; i < rows.length; i++) {
				var row = [], cols = rows[i].querySelectorAll("td, th");
		        for (var j = 0; j < cols.length; j++) 
		            row.push(cols[j].innerText);
					csv.push(row.join(","));		
			}

		    // Download CSV file
		    downloadCSV(csv.join("\n"), filename);
		}
		
		$(document).ready(function() {
		    var table = $('#categoryTable').DataTable( {
		        responsive: true
		    } );
		 
		    new $.fn.dataTable.FixedHeader( table );
		} );
	</script>
</html>
	
