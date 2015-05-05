(function () {
	var app = angular.module('navbarModule');

	app.controller('navbarCtrl', ['$scope', function ($scope) {

		// Adicion de tooltip Bootstrap

		angular.element('[data-toggle="tooltip"]').tooltip();

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
			alert('Hasta lueguito dijo panchito y se fue en su carrito');
		}

		// Configuracion usada para el boton seleccionado actual.

		$scope.selActual = 'inicio';

		$scope.darSelActual = function () {
			return $scope.selActual;
		}

		$scope.cambiarSelActual = function (actual) {
			$scope.selActual = actual;

			angular.element('html, body').animate({
				scrollTop: angular.element('#' + actual).offset().top
			}, 700);

			var seOculta = angular.element('#misestampas').css('display') === 'none';
			if (actual === 'camiseta' && seOculta)
				$scope.verMisEstampas();
			else if (actual !== 'camiseta' && !seOculta)
				$scope.verMisEstampas();
		}

		// Configuracion usada para el carrito.

		$scope.verCarrito = function () {
			var misestampas = angular.element('#misestampas');
			if (misestampas.css('display') !== 'none')
				$scope.verMisEstampas();

			angular.element('#carrito').animate({width: 'toggle'});
		}

		// Configuracion usada para mis estampas.

		$scope.verMisEstampas = function () {
			var carrito = angular.element('#carrito');
			if (carrito.css('display') !== 'none')
				$scope.verCarrito();
			
			angular.element('#misestampas').animate({width: 'toggle'});
		}

		// Configuracion usada para nueva estampa.

		$scope.verNuevaEstampa = function () {
			angular.element('#nueva').animate({width: 'toggle'});
		}

		// Configuracion usada para forma pago.

		$scope.verFormaPago = function () {
			angular.element('#formapago').animate({width: 'toggle'});
		}

		// Configuracion usada para facturas.

		$scope.verFacturas = function () {
			angular.element('#factura').animate({width: 'toggle'});
		}

		// Configutacion inicial.

		$scope.irArriba = function () {
			angular.element('html, body').animate({
				scrollTop: 0
			}, 700);
		}
		$scope.irArriba();

	}]);
})();