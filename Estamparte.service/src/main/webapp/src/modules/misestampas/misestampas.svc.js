(function () {
	var app = angular.module('misestampasModule');

	app.service('servicioMisestampas', function () {

		var _this = this;

		_this.misestampas = [];

		_this.darMisestampas = function () {
			return _this.misestampas;
		}

		_this.posicion = function (estampa) {
			var respuesta = -1;
			var encontrado = false;

			for (var i = 0; i < _this.misestampas.length && !encontrado; i++) {
				var actual = _this.misestampas[i];
				if (actual === estampa) {
					respuesta = i;
					encontrado = true;
				}
			}

			return respuesta;
		}

		_this.existe = function (estampa) {
			return _this.posicion(estampa) !== -1;
		}

		_this.agregar = function (estampa) {
			var existe = _this.existe(estampa);

			if (!existe) {
				_this.misestampas.push(estampa);
			}
		}

		_this.eliminar = function (estampa) {
			var posicion = _this.posicion(estampa);

			if (posicion !== -1) {
				_this.misestampas.splice(posicion, 1);
			}
		}

	});
})();	