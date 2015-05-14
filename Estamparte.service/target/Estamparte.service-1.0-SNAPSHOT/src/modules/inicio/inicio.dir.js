(function () {
	angular.module('inicioModule')
	.directive('inicioDirective', inicioDirective);
	
	function inicioDirective() {
		return {
			controller: 'inicioController',
			controllerAs: 'inicioCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/inicio/inicio.tpl.html'
		};
	}
})();