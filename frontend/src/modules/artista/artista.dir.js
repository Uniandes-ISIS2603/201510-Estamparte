(function () {	
	var app = angular.module('artistaModule');

	app.directive('artistaDir', function () {
		return {
			controller: 'artistaCtrl',
			replace: true,
			templateUrl: 'src/modules/artista/artista.tpl.html'
		}
	});
})();