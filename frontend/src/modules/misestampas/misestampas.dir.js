(function () {
	var app = angular.module('misestampasModule');

	app.directive('misestampasDir', function () {
		return {
			controller: 'misestampasCtrl',
			replace: true,
			scope: {},
			templateUrl: 'src/modules/misestampas/misestampas.tpl.html'
		}
	});
})();