(function () {
	angular.module('inicioModule')
	.controller('inicioController', inicioController);
	
	function inicioController($window) {
		var w = angular.element($window);
		w.bind('resize', resize);

		resize();
		function resize() {
			var div = angular.element('#inicio');
			var height = Math.max(w.height(), 480);
			div.height(height);

			var container = angular.element('#inicio .container');
			var padding = height / 3;
			container.css('padding-top', padding);
		}
	}
})();