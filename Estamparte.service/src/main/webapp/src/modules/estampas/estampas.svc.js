(function () {
	angular.module('estampasModule')
	.service('estampasService', estampasService);

	function estampasService(crudService) {

		var _this = this;

		// Here we extend our service.
        crudService.extendService(_this, 'estampas', null);
	}
})();