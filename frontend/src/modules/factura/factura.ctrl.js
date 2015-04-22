(function () {
	var app = angular.module('facturaModule');

	app.controller('facturaCtrl', ['$scope', 'servicioFactura', function ($scope, servicioFactura) {

		// Variable que apunta a this.

		var _this = this;

		// Extension de los servicion del CRUD.

		servicioFactura.extendCtrl(_this,$ scope);
		
		// _this.editMode = false;
		// _this.camisetas = servicioCarrito.darCarritoActual();
		// _this.formaPago = servicioFormaPago.darFormaPagoActual();
					
		// _this.editar = function (dato) {
		// 	this.editMode = true;
		// 	this.editarDato(dato);
		// }
		
		// _this.cancelar = function () {
		// 	this.editMode = false;
		// 	this.consultarDatos();
		// }
		
		// _this.guardar = function () {
		// 	this.editMode = false;
		// 	this.guardarDato();
		// }
	 
	 // 	_this.crear = function () {
		// 	this.editMode = true;
		// 	this.crearDato();	 
	 // 	}

	 	_this.actualizarDatos = function () {
	 		_this.fetchRecords().then(function () {
	 			console.log($scope.records);
	 		});
	 	}

	 	servicioFactura.registrarEvento(_this.actualizarDatos);

	}]);
})();