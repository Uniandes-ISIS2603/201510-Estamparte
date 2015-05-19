(function () {
	angular.module('nuevaModule')
	.controller('nuevaController', nuevaController)

	function nuevaController(nuevaService, usuarioService, estampasService) {

		var _this = this;

		// Holds the new object.
		_this.nueva = {};

		_this.addNueva = addNueva;
		_this.clean = clean;

		// Adds the object
		function addNueva() {

			var id = usuarioService.getUser().id;

			// Adds some extra data.
			_this.nueva.idArtista = id;
			_this.nueva.usuarioArtista = usuarioService.getName();
			_this.nueva.siGusta = 0;
			_this.nueva.noGusta = 0;
			_this.nueva.altura = 1;
			_this.nueva.ancho = 1;
			_this.nueva.imagen = "src/assets/img/estampa.jpg";

			// Save it!.
			nuevaService.postCustom(_this.nueva, id).then(clean);
		}

		function clean() {
			_this.nueva = {};
			angular.element('#nueva').animate({width: 'toggle'});
			estampasService.getBasic();
		}
	}
})();