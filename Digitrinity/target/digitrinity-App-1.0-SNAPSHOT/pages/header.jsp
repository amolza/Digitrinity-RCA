<div class="l-header__inner clearfix">
	<div class="c-header-icon js-hamburger">
		<div class="hamburger-toggle">
			<span class="bar-top"></span><span class="bar-mid"></span><span class="bar-bot"></span>
		</div>
	</div>
	<div class="c-header-icon has-dropdown">
		<span class="c-badge c-badge--header-icon animated shake">1</span><i class="fa fa-bell"></i>
		<div class="c-dropdown c-dropdown--notifications">
			<div class="c-dropdown__header"></div>
			<div class="c-dropdown__content"></div>
		</div>
	</div>
	<div class="c-search">
		<input class="c-search__input u-input" placeholder="Search..." type="text"/>
	</div>
	<div style="margin-left: auto;">
		Welcome ${pageContext.request.userPrincipal.name}
	</div>
	<div class="header-icons-group">
		<div class="c-header-icon logout" onclick="document.forms['logoutForm'].submit()"><i class="fa fa-power-off"></i></div>
		<form id="logoutForm" method="POST" action="${contextPath}/logout">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
</div>
