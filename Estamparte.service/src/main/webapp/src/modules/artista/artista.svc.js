(function () {	
	angular.module('artistaModule')
	.service('artistaService', artistaService);

	function artistaService(crudService) {

		var _this = this;

		// Here we extend our service.
		crudService.extendService(_this, 'artista', null);

	}
})();