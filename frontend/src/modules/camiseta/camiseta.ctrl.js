angular.module('camisetaModule')
.controller('camisetaCtrl', ['$scope', 'servicioCamiseta', 'servicioEstampa', function ($scope, servicioCamiseta, servicioEstampa) {

	// Extension de servicios CRUD.

	servicioCamiseta.extendCtrl(this, $scope);

	$scope.datoActual.camiseta.estampasUsadas = [];
	$scope.datoActual.camiseta.idCamiseta;
	$scope.datoActual.camiseta.nombreCamiseta;

	this.contiene = function (id) {
		var respuesta = false;
		var estampasUsadas = $scope.datoActual.camiseta.estampasUsadas;

		for (var i = 0; i < estampasUsadas.length; i++) {
			if ($scope.datoActual.estampasUsadas[i] === id) {
				respuesta = true;
			}
		}

		return respuesta;
	}

	this.agregarEstampa = function (id) {
		$scope.datoActual.camiseta.estampasUsadas.push(id);
	}

	this.eliminarEstampa = function (id) {
		var encontrado = false;
		var estampasUsadas = $scope.datoActual.camiseta.estampasUsadas;

		for (var i = 0; i < estampasUsadas.length && !encontrado; i++) {
			if (estampasUsadas[i] === id) {
				estampasUsadas.splice(i, 1);
				encontrado = true
			}
		}
	}

	this.estampasSeleccionadas = function() {
		return servicioEstampa.darEstampasSeleccionadas();
	}

	this.cadenaAleatoria = function (longitud) {
		var numeros = '0123456789';
		var mayusculas = 'ABCDEFGHIJKLMNOPQRSTUVWXTZ';
		var minusculas = 'abcdefghiklmnopqrstuvwxyz';
		var caracteres = (numeros + mayusculas + minusculas).split('');

		if (longitud === null) {
			longitud = 0;
		}

		var respuesta = '';
		for (var i = 0; i < longitud; i++) {
			var index = Math.floor(Math.random() * chars.length);
			respuesta += caracteres[index];
		}

		return respuesta;
	}

	this.continuar = function () {
		$scope.datoActual.camiseta.idCamiseta = "C"+ this.randomString(10);

		var mensaje = "";
		var estampasUsadas = $scope.datoActual.camiseta.estampasUsadas;

		for (var i = 0; i < estampasUsadas.length; i++) {
			if (estampasUsadas[i]) {
				mensaje += (i + 1) + ")" + estampasUsadas[i].valueOf() + "\n\t";
			}
		}

		alert(mensaje);

		servicioCamiseta.agregarCamiseta($scope.datoActual.camiseta);
	}

}]);