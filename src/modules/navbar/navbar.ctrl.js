angular.module('navbarModule', [])
.controller('navbarCtrl', ['$scope', function($scope) {

	// Configuracion usada para el usuario actual.

	$scope.artista = {
		nombre: 'Juan el artista',
		tipo: 'artista'
	}

	$scope.comprador = {
		nombre: 'Martin el comprador',
		tipo: 'comprador'
	}

	$scope.usuario = $scope.comprador;

	$scope.cambiarUsuario = function (tipoUsuario) {
		if (tipoUsuario === 'artista')
			$scope.usuario = $scope.artista;
		else
			$scope.usuario = $scope.comprador;
	}

	$scope.cerrarSesion = function () {
		alert("Hasta lueguito dijo panchito y se fue en su carrito");
	}

	// Configuracion usada para el boton seleccionado actual.

	$scope.selActual = 'inicio';

	$scope.darSelActual = function () {
		return $scope.selActual;
	}

	$scope.cambiarSelActual = function (actual) {
		$scope.selActual = actual;

		$('html, body').animate({
			scrollTop: $("#" + actual).offset()
		}, 700);
	}

	// Configuracion usada para el carrito.

	$scope.verCarrito = function () {
		$('#carrito').animate({width: 'toggle'});
	}
}])
.directive('navbar', function() {
	return {
		templateUrl: 'src/modules/navbar/navbar.tpl.html'
	};
});