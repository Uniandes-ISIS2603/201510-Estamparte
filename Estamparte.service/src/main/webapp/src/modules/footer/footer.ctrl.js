(function () {
	angular.module('footerModule')
	.controller('footerController', footerController);

	function footerController($window) {
		var w = angular.element($window);
		w.bind('resize', resize);

		resize();
		function resize() {
			var footer = angular.element('#footer');
			var height = footer.height();

			var container = angular.element('#footer .container');
			var padding = height / 3;
			container.css('padding-top', padding);
		}
	}
})();