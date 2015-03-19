angular.module('compradorModule')
.directive('compradorDir', function () {
	return {
		controller: 'compradorCtrl',
		replace: true,
		templateUrl: 'src/modules/comprador/comprador.tpl.html'
	}
});