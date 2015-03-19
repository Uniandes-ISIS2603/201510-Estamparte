angular.module('estampaModule')
.directive('estampaDir', function () {
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