(function () {
	angular.module('carritoModule')
	.directive('carritoDirective', carritoDirective);

	function carritoDirective() {
		return {
			controller: 'carritoController',
			controllerAs: 'carritoCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/carrito/carrito.tpl.html'
		}
	}
})();