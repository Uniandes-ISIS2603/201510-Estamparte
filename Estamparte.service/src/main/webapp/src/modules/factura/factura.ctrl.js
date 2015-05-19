(function () {
	angular.module('facturaModule')
	.controller('facturaController', facturaController);

	function facturaController(facturaService) {

		var _this = this;

		_this.facturaRecords = facturaService.records;
	}
})();