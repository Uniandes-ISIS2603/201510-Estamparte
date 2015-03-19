(function () {
	var app = angular.module('equipoModule');

	app.directive('equipoDir', function () {
		return {
			controller: 'equipoCtrl',
			replace: true,
			templateUrl: 'src/modules/equipo/equipo.tpl.html'
		}
	});
})();