(function () {
	var app = angular.module('facturaModule');

	app.directive('facturaDir', function () {
		return {
			controller: 'facturaCtrl',
			replace: true,
			templateUrl: 'src/modules/factura/factura.tpl.html'
		}
	});
})();