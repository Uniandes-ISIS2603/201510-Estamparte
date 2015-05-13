(function () {
	var app = angular.module('miembroModule');

	app.directive('miembroDir', function () {
		return {
			controller: 'miembroCtrl',
			replace: true,
			scope: {
				miembro: '=miembroDir'
			},
			templateUrl: 'src/modules/equipo/miembro/miembro.tpl.html'
		};
	});
})();