<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<label class="" for="exportSelect">
    <strong>Export</strong>
</label>
<select id="exportSelect" name="exportSelect" title="Export" class="custom-select">
    <option value="" selected="selected"></option>
    <option value=0>Copy</option>
    <option value=1>CSV</option>
    <option value=2>Excel</option>
    <option value=3>Print</option>
</select>
