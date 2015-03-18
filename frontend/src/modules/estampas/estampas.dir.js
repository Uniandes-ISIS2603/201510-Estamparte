angular.module('estampasModule')
.directive('estampasDir', function() {
	return {
		controller: 'estampasCtrl',
		replace: true,
		templateUrl: 'src/modules/estampas/estampas.tpl.html'
	};
});