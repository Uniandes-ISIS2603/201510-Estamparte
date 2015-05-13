(function () {
	angular.module('misestampasModule')
	.controller('misestampasController', misestampasController);

	function misestampasController(misestampasService) {

		var _this = this;
		
		// Holds misestampasService records.
		_this.misEstampasRecords = misestampasService.records;

		_this.removeMisEstampas = removeMisEstampas;
		_this.addCamiseta = addCamiseta;

		function removeMisEstampas(target) {
			misestampasService.removeMisEstampas(target);
		}

		function addCamiseta(target) {
			alert("Espera un poquito... un poquito mas (8)");
		}
	}
})();