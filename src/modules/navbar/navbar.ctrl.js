angular.module('navbarModule', [])
.controller('navbarCtrl', ['$scope', function($scope) {
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
}])
.directive('navbar', function() {
	return {
		templateUrl: 'src/modules/navbar/navbar.tpl.html'
	};
});