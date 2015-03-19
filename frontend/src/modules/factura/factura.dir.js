angular.module('facturaModule')
.directive('facturaDir', function () {
	return {
		controller: 'facturaCtrl',
		replace: true,
		templateUrl: 'src/modules/factura/factura.tpl.html'
	}
});