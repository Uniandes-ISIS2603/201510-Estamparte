(function () {
	angular.module('estampasModule')
	.directive('estampasDirective', estampasDirective);

	function estampasDirective() {
		return {
			controller: 'estampasController',
			controllerAs: 'estampasCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/estampas/estampas.tpl.html'
		};
	}
})();