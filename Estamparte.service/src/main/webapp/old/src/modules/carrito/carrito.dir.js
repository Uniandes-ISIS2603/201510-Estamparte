(function () {
	var app = angular.module('carritoModule');

	app.directive('carritoDir', function () {
		return {
			controller: 'carritoCtrl',
			replace: true,
			templateUrl: 'src/modules/carrito/carrito.tpl.html'
		}
	});
})();