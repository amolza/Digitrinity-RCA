<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<td>
    <label class='control-label mr-2' for="exportSelect">
        <strong>Export</strong>
    </label>
</td>
<td>
    <select id="exportSelect" name="exportSelect" title="Export"
            class="selectpicker" data-live-search="false"
            data-width="50px">
        <option value="" selected="selected"> </option>
        <option value=0>Copy</option>
        <option value=1>CSV</option>
        <option value=2>Excel</option>
        <option value=3>Print</option>
    </select>
</td>