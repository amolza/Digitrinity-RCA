<!DOCTYPE html>
<html lang="en" >
	<head>
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
		<jsp:include page="include_ftr.jsp"></jsp:include>
	</body>
	<script type="text/javascript">
		$('#tabHome').addClass('is-active');
	</script>
</html>