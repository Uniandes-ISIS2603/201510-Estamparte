(function () {	
	var app = angular.module('compradorModule');

	app.directive('compradorDir', function () {
		return {
			controller: 'compradorCtrl',
			replace: true,
			templateUrl: 'src/modules/comprador/comprador.tpl.html'
		}
	});
})();