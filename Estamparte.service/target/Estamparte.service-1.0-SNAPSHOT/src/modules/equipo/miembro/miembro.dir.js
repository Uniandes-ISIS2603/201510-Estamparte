(function () {
	angular.module('miembroModule')
	.directive('miembroDirective', miembroDirective);

	function miembroDirective() {
		return {
			controller: 'miembroController',
			controllerAs: 'miembroCtrl',
			replace: true,
			scope: {
				miembro: '=miembroDirective'
			},
			templateUrl: 'src/modules/equipo/miembro/miembro.tpl.html'
		};
	}
})();