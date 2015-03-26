(function () {
	var app = angular.module('formaPagoModule');

	app.directive('formaPagoDir', function () {
		return {
			controller: 'formaPagoCtrl',
			scope: {},
			replace: true,
			templateUrl: 'src/modules/formaPago/formaPago.tpl.html'
		}
	});
})();