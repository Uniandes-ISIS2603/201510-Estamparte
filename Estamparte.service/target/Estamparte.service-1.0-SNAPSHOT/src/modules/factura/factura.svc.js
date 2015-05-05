(function () {
	var app = angular.module('facturaModule');

	app.service('servicioFactura', ['CRUDUtils', 'factura.context', function (CRUDUtils, context) {

		// Configuracion de la URL.

		this.url = context;

		// Extension de los servicios del CRUD.

		CRUDUtils.extendService(this);

	}]);
})();