<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script src="${contextPath}/resources/js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/js/app_common.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src='${contextPath}/resources/bootstrap/js/bootstrap.min.js'></script>
<script src='${contextPath}/resources/bootstrap/js/bootstrap.bundle.min.js'></script>
<script src="${contextPath}/resources/bootstrap/js/jquery.datetimepicker.full.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/bootstrap/js/datatables.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/bootstrap/js/bootnavbar.js" type="text/javascript"></script>
<script src="${contextPath}/resources/bootstrap/js/all.min.js" type="text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>


<script type="text/javascript">
	$(function () {
	    $('#main_navbar').bootnavbar();
	})
</script>