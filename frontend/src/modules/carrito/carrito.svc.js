angular.module('carritoModule')
.service('servicioCarrito', ['CRUDUtils', 'carrito.context', 'servicioCamiseta', function (CRUDUtils, context, servicioCamiseta) {

	// Extension de los servicion del CRUD.

	CRUDUtils.extendService(this);

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