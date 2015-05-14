(function () {    
	angular.module('formaPagoModule')
	.service('formaPagoService', formaPagoService);

	function formaPagoService(crudService) {

		var _this = this;

		// Here we extend our service.
		crudService.extendService(_this, 'comprador', 'formaPago');
	}
})();