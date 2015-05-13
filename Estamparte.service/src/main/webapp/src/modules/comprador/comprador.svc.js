(function () {	
	angular.module('compradorModule')
	.service('compradorService', compradorService);

	function compradorService(crudService) {

		var _this = this;

		// Here we extend our service.
		crudService.extendService(_this, 'comprador', null);

	}
})();