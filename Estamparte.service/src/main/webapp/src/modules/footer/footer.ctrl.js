(function () {
	var app = angular.module('footerModule');

	app.controller('footerCtrl', ['$scope', '$window', function ($scope, $window) {
		
		var w = angular.element($window);
		w.bind('resize', function() {
			alinearAltura();
		})

		alinearAltura();
		function alinearAltura() {
			var footer = angular.element('#footer');
			var altura = footer.height();

			var contenedor = angular.element('#footer .container');
			var padding = altura / 3;
			contenedor.css('padding-top', padding);
		}

	}]);
})();