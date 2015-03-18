angular.module('carritoModule')
.controller('carritoModule', ['$scope', 'servicioCarrito', 'servicioCamiseta', '$rootscope', function ($scope, servicioCarrito, servicioCamiseta, $rootscope) {

	// Extension de los servicion del CRUD.

	CRUDUtils.extendService(this);

	servicioCarrito.extendCtrl(this, $scope);
	this.url = context;

	this.darCarritoActual = function () {
		var respuesta = '';

		var data = $scope.datos;
		for (var i = 0; i < data.length; i++) {
			respuesta = respuesta +  'Camiseta ' + i+1 + data[i].nombre + '\n ';
		}

		return respuesta;
	}

}]);