(function () {
	var app = angular.module('facturaModule');

	app.controller('facturaCtrl', ['$scope','servicioFactura', 'servicioFormaPago', 'servicioCarrito', function ($scope, servicioFactura, servicioFormaPago, servicioCarrito) {

		// Extension de los servicion del CRUD
		servicioFactura.extendCtrl(this,$scope);
		
		this.editMode = false;
		this.camisetas = servicioCarrito.darCarritoActual();
		this.formaPago = servicioFormaPago.darFormaPagoActual();
					
		this.editar = function (dato) {
			this.editMode = true;
			this.editarDato(dato);
		}
		
		this.cancelar = function () {
			this.editMode = false;
			this.consultarDatos();
		}
		
		this.guardar = function () {
			this.editMode = false;
			this.guardarDato();
		}
	 
	 	this.crear = function () {
			this.editMode = true;
			this.crearDato();	 
	 	}

	}]);
})();