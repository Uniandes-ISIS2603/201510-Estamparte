(function () {
	angular.module('nuevaModule')
	.service('nuevaService', nuevaService);

	function nuevaService(crudService) {

		var _this = this;

		// Here we extend our service.
        crudService.extendService(_this, 'artistas', 'estampas');
	}
})();