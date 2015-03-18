angular.module('estampaModule')
.directive('estampaDir', function () {
	return {
		controller: 'estampaCtrl',
		replace: true,
		scope: {
			estampa: '=estampaDir'
		},
		templateUrl: 'src/modules/estampas/estampa/estampa.tpl.html'
	};
});