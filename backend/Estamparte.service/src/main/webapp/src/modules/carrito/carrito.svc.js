(function () {	
	var app = angular.module('carritoModule');

	app.service('servicioCarrito', ['CRUDUtils', 'carrito.context', function (CRUDUtils, context) {

		// Variable que apunta a this.

		var _this = this;

		// Extension de los servicion del CRUD.

		_this.url = context;

		CRUDUtils.extendService(_this);

		// _this.darCarritoActual = function () {
		// 	var respuesta = '';

		// 	var data = $scope.datos;
		// 	for (var i = 0; i < data.length; i++) {
		// 		respuesta = respuesta +  'Camiseta ' + i+1 + data[i].nombre + '\n ';
		// 	}

		// 	return respuesta;
		// }

	}]);
})();
