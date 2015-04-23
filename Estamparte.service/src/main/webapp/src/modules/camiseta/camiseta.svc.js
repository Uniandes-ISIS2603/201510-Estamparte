(function () {	
	var app = angular.module('camisetaModule');

	app.service('servicioCamiseta', function () {

		// Variable que apunta a this.

		var _this = this;

		// Mantiene las estampas.

		_this.estampas = [];

		// Devuelve las estampas.

		_this.darEstampas = function () {
			return _this.estampas;
		}

		// Devuelve la posicion de la estampa
		// entregada por parametro.

		_this.posicion = function (estampa) {
			var respuesta = -1;
			var encontrado = false;

			for (var i = 0; i < _this.estampas.length && !encontrado; i++) {
				var actual = _this.estampas[i];
				if (actual === estampa) {
					respuesta = i;
					encontrado = true;
				}
			}

			return respuesta;
		}

		// Retorna true o false dependiendo de
		// si existe o no la estampa dada por
		// parametro.

		_this.existe = function (estampa) {
			return _this.posicion(estampa) !== -1;
		}

		// Agrega la estampa dada por parametro
		// al arreglo de estampas de la camiseta.

		_this.agregar = function (estampa) {
			var init_height = 70;

			var nuevo = {
				estampa: estampa,
				coordx: 0,
				coordy: 0,
				height: init_height
			};

			_this.estampas.push(nuevo);
		}

		// Elimina la estampa dada por parametro
		// del arreglo de estampas de la camiseta.

		_this.eliminar = function (estampa) {
			var posicion = _this.posicion(estampa);

			if (posicion !== -1) {
				_this.estampas.splice(posicion, 1);
			}
		}

		// Asigna las estampas del dato a editar.

		_this.asignarEstampas = function () {
			_this.estampas.length = 0;

			if (_this.datoEditar.estampas) {
				for (var i = 0; i < _this.datoEditar.estampas.length; i++) {
					var actual = _this.datoEditar.estampas[i];
					_this.estampas.push(actual);
				}
			}
		}

		// Funcion para editar.

		_this.ahoraEditar;

		// Dato para editar.

		_this.datoEditar = {};

		// Edita la camisa enviada por parametro.

		_this.editar = function (camisa) {
			_this.datoEditar = camisa;
			_this.ahoraEditar();
		}

		// Funcion para reiniciar.

		_this.reiniciar;
		
	});
})();