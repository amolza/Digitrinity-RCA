<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script src="${contextPath}/resources/js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src='${contextPath}/resources/bootstrap/js/bootstrap.min.js'></script>
<script src='${contextPath}/resources/bootstrap/js/bootstrap.bundle.min.js'></script>
<script src="${contextPath}/resources/bootstrap/js/jquery.datetimepicker.full.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/bootstrap/js/datatables.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/bootstrap/js/bootnavbar.js" type="text/javascript"></script>
<script src="${contextPath}/resources/bootstrap/js/all.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function () {
	    $('#main_navbar').bootnavbar();
	})
</script>