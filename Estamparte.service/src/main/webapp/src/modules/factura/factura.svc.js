(function () {
	angular.module('facturaModule')
	.service('facturaService', facturaService);

	function facturaService(crudService) {

		var _this = this;

		// Here we extend our service.
		crudService.extendService(_this, 'comprador', 'factura');
	}
})();