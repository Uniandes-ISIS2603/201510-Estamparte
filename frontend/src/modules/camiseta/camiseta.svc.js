(function () {	
	var app = angular.module('camisetaModule');

	app.service('servicioCamiseta', ['CRUDUtils', 'camiseta.context', function (CRUDUtils, context) {

		var _this = this;

		CRUDUtils.extendService(_this);

		_this.url = context;

		_this.estampas = [];

		_this.darEstampas = function () {
			return _this.estampas;
		}

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

		_this.existe = function (estampa) {
			return _this.posicion(estampa) !== -1;
		}

		_this.agregar = function (estampa) {
			var num = _this.estampas.length;
			var init_height = 70;


			var nuevo = {
				id: num,
				estampa: estampa,
				coordx: 0,
				coordy: 0,
				height: init_height
			};

			_this.estampas.push(nuevo);
		}

		_this.eliminar = function (estampa) {
			var posicion = _this.posicion(estampa);

			if (posicion !== -1) {
				_this.estampas.splice(posicion, 1);
			}
		}

		_this.eliminarTodas = function (estampa) {
			var posicion = _this.posicion(estampa);

			while (posicion !== -1) {
				_this.eliminar(estampa);
			}
		}
		
	}]);
})();