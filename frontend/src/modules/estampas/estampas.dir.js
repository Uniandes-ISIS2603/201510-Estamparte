angular.module('estampasModule')
.directive('estampasDir', function() {
	return {
		controller: 'estampasCtrl',
		replace: true,
		scope: {},
		templateUrl: 'src/modules/estampas/estampas.tpl.html'
	};
});