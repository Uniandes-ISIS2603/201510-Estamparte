angular.module('estampasModule', [])
.controller('estampasCtrl', ['$scope', function($scope) {}])
.directive('estampas', function() {
	return {
		templateUrl: 'src/modules/estampas/estampas.tpl.html'
	};
});