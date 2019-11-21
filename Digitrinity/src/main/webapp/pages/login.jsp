<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Log in with your account</title>
		<link href="${contextPath}/resources/css/login.css" rel="stylesheet" />
		<link href="${contextPath}/resources/bootstrap/css/all.css" rel="stylesheet" />
		<script src="${contextPath}/resources/bootstrap/js/all.js" type="text/javascript"></script>
	</head>
	<body class="bg-default">
		<div class="main-content">
			<div class="header bg-gradient-primary py-7 py-lg-8">
				<div class="container">
					<div class="header-body text-center mb-7">
						<div class="row justify-content-center">
							<div class="col-lg-5 col-md-6">
								<h1 class="text-white">Welcome!</h1>
								<p class="text-lead text-light">Use these awesome forms to login or create new account in your project for free.</p>
							</div>
						</div>
					</div>
				</div>
				<div class="separator separator-bottom separator-skew zindex-100">
					<svg x="0" y="0" viewBox="0 0 2560 100" preserveAspectRatio="none" version="1.1" xmlns="http://www.w3.org/2000/svg">
						<polygon class="fill-default" points="2560 0 2560 100 0 100"></polygon>
					</svg>
				</div>
			</div>
			<!-- Page content -->
			<div class="container mt--8 pb-5">
				<div class="row justify-content-center">
					<div class="col-lg-5 col-md-7">
						<div class="card bg-secondary shadow border-0">
							<div class="card-body px-lg-5 py-lg-5">
								<form role="form" method="POST" action="${contextPath}/login" >
									<span style="color: green;">${message}</span>
									<div class="form-group">
										<span style="color: red;">${error}</span>
									</div>
									<div class="form-group mb-3">
										<div class="input-group input-group-alternative">
											<div class="input-group-prepend">
												<span class="input-group-text"><i class="fas fa-user"></i></span>
											</div>
											<input class="form-control" placeholder="Username" type="text" name="username" />
										</div>
									</div>
									<div class="form-group">
										<div class="input-group input-group-alternative">
											<div class="input-group-prepend">
												<span class="input-group-text"><i class="fas fa-key"></i></span>
											</div>
											<input class="form-control" placeholder="Password" type="password" name="password" />
										</div>
									</div>
									<div class="custom-control custom-control-alternative custom-checkbox">
										<input class="custom-control-input" id=" customCheckLogin" type="checkbox">
										<label class="custom-control-label" for=" customCheckLogin">
											<span class="text-muted">Remember me</span>
										</label>
									</div>
									<div class="text-center">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<button type="submit" class="btn btn-primary my-4">Sign in</button>
									</div>
								</form>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-6">
								<span class="pull-left"><a href="#" class="text-light"><small>Forgot password?</small></a></span>
								<span class="pull-right float-right"><a href="${contextPath}/registration" class="text-light"><small>Create new account</small></a></span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>