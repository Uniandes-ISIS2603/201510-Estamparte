(function () {
	angular.module('equipoModule')
	.directive('equipoDirective', equipoDirective);

	function equipoDirective() {
		return {
			controller: 'equipoController',
			controllerAs: 'equipoCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/equipo/equipo.tpl.html'
		}
	}
})();