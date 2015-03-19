(function () {
	var app = angular.module('facturaModule');

	app.service('servicioFactura', ['CRUDUtils', 'factura.context', function (CRUDUtils, context) {

		this.url = context;
		CRUDUtils.extendService(this);

	}]);
})();