(function () {
	var app = angular.module('formaPagoModule');

	app.directive('formaPagoDir', function () {
		return {
			controller: 'formaPagoCtrl',
			replace: true,
			templateUrl: 'src/modules/formaPago/formaPago.tpl.html'
		}
	});
})();