(function () {
	var app = angular.module('estampaModule');

	app.directive('estampaDir', function () {
		return {
			controller: 'estampaCtrl',
			replace: true,
			scope: {
				agregar: '=',
				gusta: '=',
				estampa: '=estampaDir'
			},
			templateUrl: 'src/modules/estampas/estampa/estampa.tpl.html'
		};
	});
})();