(function () {
	angular.module('misestampasModule')
	.directive('misestampasDirective', misestampasDirective);

	function misestampasDirective() {
		return {
			controller: 'misestampasController',
			controllerAs: 'misestampasCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/misestampas/misestampas.tpl.html'
		}
	}
})();