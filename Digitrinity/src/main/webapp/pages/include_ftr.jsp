<script src="${contextPath}/resources/js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src='${contextPath}/resources/bootstrap/js/bootstrap.min.js'></script>
<script src="${contextPath}/resources/bootstrap/js/jquery.datetimepicker.full.min.js" type="text/javascript"></script>
<script src="https://kit.fontawesome.com/f9b25981d1.js" crossorigin="anonymous"></script>
<script type="text/javascript">
var Dashboard = function () {
	var global = {
		tooltipOptions: {
			placement: "right"
		},
		menuClass: ".c-menu"
	};

	var menuChangeActive = function menuChangeActive(el) {
		var hasSubmenu = $(el).hasClass("has-submenu");
		$(global.menuClass + " .is-active").removeClass("is-active");
		$(el).addClass("is-active");

		// if (hasSubmenu) {
		// 	$(el).find("ul").slideDown();
		// }
	};

	var sidebarChangeWidth = function sidebarChangeWidth() {
		var $menuItemsTitle = $("li .menu-item__title");

		$("body").toggleClass("sidebar-is-reduced sidebar-is-expanded");
		$(".hamburger-toggle").toggleClass("is-opened");

		if ($("body").hasClass("sidebar-is-expanded")) {
			$('[data-toggle="tooltip"]').tooltip("destroy");
		} else {
			$('[data-toggle="tooltip"]').tooltip(global.tooltipOptions);
		}
	};

	return {
		init: function init() {
			$(".js-hamburger").on("click", sidebarChangeWidth);

			$(".js-menu li").on("click", function (e) {
				menuChangeActive(e.currentTarget);
			});

			$('[data-toggle="tooltip"]').tooltip(global.tooltipOptions);
		}
	};
}();
Dashboard.init();
function changeTab(location){
	window.location.replace(location);
}
</script>