(function () {
	angular.module('facturaModule')
	.directive('facturaDirective', facturaDirective);

	function facturaDirective() {
		return {
			controller: 'facturaController',
			controllerAs: 'facturaCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/factura/factura.tpl.html'
		}
	}
})();