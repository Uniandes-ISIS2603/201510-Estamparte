angular.module('camisetaModule')
.controller('camisetaCtrl', ['$scope', '$window', 'servicioCamiseta', function ($scope, $window, servicioCamiseta) {

	// Extension de servicios CRUD.

	servicioCamiseta.extendCtrl(this, $scope);

	// Configuracion visual.

	var w = angular.element($window);
	w.bind('resize', function() {
		alinearAltura();
	})

	alinearAltura();
	function alinearAltura() {
		var inicio = angular.element('#vistaprevia');
		var altura = Math.max(w.height() - 250, 480);
		inicio.height(altura);

		var contenedor = angular.element('#inicio .container');
		var padding = altura / 3;
		contenedor.css('padding-top', padding);
	}

	// $scope.datoActual.camiseta.estampasUsadas = [];
	// $scope.datoActual.camiseta.idCamiseta;
	// $scope.datoActual.camiseta.nombreCamiseta;

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

	// this.estampasSeleccionadas = function() {
	// 	return servicioEstampa.darEstampasSeleccionadas();
	// }

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

		//servicioCamiseta.agregarCamiseta($scope.datoActual.camiseta);
	}

}]);