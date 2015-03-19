angular.module('misestampasModule')
.directive('misestampasDir', function () {
	return {
		controller: 'misestampasCtrl',
		replace: true,
		scope: {},
		templateUrl: 'src/modules/misestampas/misestampas.tpl.html'
	}
});