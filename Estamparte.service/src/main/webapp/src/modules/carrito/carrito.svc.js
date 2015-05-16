(function () {	
	angular.module('carritoModule')
	.service('carritoService', carritoService);

	function carritoService(crudService) {

		var _this = this;

		// Here we extend our service.
		crudService.extendService(_this, 'carrito', null);
	}
})();