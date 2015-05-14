(function () {
	angular.module('formaPagoModule')
	.directive('formaPagoDirective', formaPagoDirective);

	function formaPagoDirective() {
		return {
			controller: 'formaPagoController',
			controllerAs: 'formaPagoCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/formaPago/formaPago.tpl.html'
		}
	}
})();