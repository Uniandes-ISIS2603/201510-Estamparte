(function () {
	angular.module('misestampasModule')
	.controller('misestampasController', misestampasController);

	function misestampasController(misestampasService, usuarioService, camisetaService) {

		var _this = this;
		
		// Holds misestampasService records.
		_this.misEstampasRecords = misestampasService.records;

		_this.removeMisEstampas = removeMisEstampas;
		_this.addEstampaCamiseta = addEstampaCamiseta;

		function removeMisEstampas(target) {
			misestampasService.removeMisEstampas(target);
		}

		function addEstampaCamiseta(target) {
			camisetaService.addEstampaCamiseta(target);
		}
	}
})();