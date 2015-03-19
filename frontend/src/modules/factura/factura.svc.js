angular.module('facturaModule')
.service('servicioFactura', ['CRUDUtils', 'factura.context', function (CRUDUtils, context) {

	this.url = context;
	CRUDUtils.extendService(this);

}]);