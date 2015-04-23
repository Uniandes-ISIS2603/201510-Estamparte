(function () {
	var app = angular.module('inicioModule');

	app.controller('inicioCtrl', ['$scope', '$window', function ($scope, $window) {

		var w = angular.element($window);
		w.bind('resize', function() {
			alinearAltura();
		})

		alinearAltura();
		function alinearAltura() {
			var inicio = angular.element('#inicio');
			var altura = Math.max(w.height(), 480);
			inicio.height(altura);

			var contenedor = angular.element('#inicio .container');
			var padding = altura / 3;
			contenedor.css('padding-top', padding);
		}

	}]);
})();