(function () {
	var app = angular.module('estampasModule');

	app.directive('estampasDir', function() {
		return {
			controller: 'estampasCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/estampas/estampas.tpl.html'
		};
	});
})();