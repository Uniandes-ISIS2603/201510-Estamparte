(function () {	
	angular.module('camisetaModule')
	.service('camisetaService', camisetaService);

	function camisetaService(crudService) {

		var _this = this;

		// Here we extend our service.
        crudService.extendService(_this, 'comprador', 'camiseta');	
	}
})();