(function () {
	angular.module('nuevaModule')
	.directive('nuevaDirective', nuevaDirective);

	function nuevaDirective() {
		return {
			controller: 'nuevaController',
			controllerAs: 'nuevaCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/estampas/nueva/nueva.tpl.html'
		};
	}
})();