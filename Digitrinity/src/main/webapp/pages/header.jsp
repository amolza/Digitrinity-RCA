<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="main_navbar">
	<a class="navbar-brand" href="#">Digi Trinity</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a class="nav-link" href="${contextPath}">Home <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Manage Details
				</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="${contextPath}/rca/view_rca_form">Add Details</a></li>
					<div class="dropdown-divider"></div>
					<li class="nav-item dropdown">
					<a class="dropdown-item dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown"	aria-haspopup="true" aria-expanded="false">
						Add Category Details
					</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown1">
						<li><a class="dropdown-item" href="${contextPath}/master_data/view_issuecategory_form">Add Issue Category</a></li>
						<li><a class="dropdown-item" href="${contextPath}/master_data/view_outageCategory_form">Add Outage Category</a></li>
						<li><a class="dropdown-item" href="${contextPath}/master_data/view_faultCategory_form">Add Fault Category</a></li>
						<div class="dropdown-divider"></div>
						<li class="nav-item dropdown">
							<a class="dropdown-item dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown"	aria-haspopup="true" aria-expanded="false">
								Dropdown
							</a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown2">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<div class="dropdown-divider"></div>
								<li></li><a class="dropdown-item" href="#">Something else here</a>
							</ul>
						</li>          
					</ul>
				</ul>
			</li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
		<ul class="navbar-nav ml-auto nav-flex-icons ">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-333" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Welcome ${pageContext.request.userPrincipal.name} <i class="fas fa-user ml-2"></i>
				</a>
				<div class="dropdown-menu dropdown-menu-right dropdown-default" aria-labelledby="navbarDropdownMenuLink-333">
					<a class="dropdown-item" href="#">Action</a>
					<a class="dropdown-item" href="#">Another action</a>
					<a class="dropdown-item" href="#">Something else here</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#" onclick="document.forms['logoutForm'].submit()"><i class="fa fa-power-off"></i> Logout</a>
				</div>
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</li>
		</ul>
	</div>
</nav>