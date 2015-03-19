angular.module('formaPagoModule')
.directive('formaPagoDir', function () {
	return {
		controller: 'formaPagoCtrl',
		replace: true,
		templateUrl: 'src/modules/formaPago/formaPago.tpl.html'
	}
});