angular.module('equipoModule')
.directive('equipoDir', function () {
	return {
		controller: 'equipoCtrl',
		replace: true,
		templateUrl: 'src/modules/equipo/equipo.tpl.html'
	}
});