(function () {
	angular.module('estampaModule')
	.directive('estampaDirective', estampaDirective);

	function estampaDirective() {
		return {
			controller: 'estampaController',
			controllerAs: 'estampaCtrl',
			replace: true,
			scope: {
				target: '=target'
			},
			templateUrl: 'src/modules/estampas/estampa/estampa.tpl.html'
		};
	}
})();