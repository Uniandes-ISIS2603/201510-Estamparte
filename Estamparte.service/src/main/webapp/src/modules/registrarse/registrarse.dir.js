(function () {
	angular.module('registrarseModule')
	.directive('registrarseDirective', registrarseDirective);

	function registrarseDirective() {
		return {
			controller: 'registrarseController',
			controllerAs: 'registrarseCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/registrarse/registrarse.tpl.html'
		}
	}
})();