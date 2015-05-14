(function () {
	var app = angular.module('nuevaModule');

	app.directive('nuevaDir', function () {
		return {
			controller: 'nuevaCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/estampas/nueva/nueva.tpl.html'
		};
	});
})();