(function () {
	angular.module('camisetaModule')
	.directive('camisetaDirective', camisetaDirective);

	function camisetaDirective() {
		return {
			controller: 'camisetaController',
			controllerAs: 'camisetaCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/camiseta/camiseta.tpl.html'
		};
	}
})();