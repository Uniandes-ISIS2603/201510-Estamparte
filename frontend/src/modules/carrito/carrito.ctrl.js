(function () {	
	var app = angular.module('carritoModule');

	app.controller('carritoCtrl', ['$scope', 'servicioCarrito', 'servicioFormaPago', 'servicioCamiseta', 'servicioFactura', function ($scope, servicioCarrito, servicioFormaPago, servicioCamiseta, servicioFactura) {
		
		var _this = this;

		// Extension de los servicion del CRUD.

		servicioCarrito.extendCtrl(_this, $scope);

		// Lectura inicial de los datos.

		_this.fetchRecords();

		// Actualiza los records en caso de cambio.

		_this.actualizarCarrito = function () {
			_this.fetchRecords();
		}

		// Registra la funcion de actualizar al servicio.

		servicioCarrito.registrarEvento(_this.actualizarCarrito);

		// Guarda las formas de pago.

		$scope.formas = [];

		// Trae las formas de pago.

		formasPago();
		function formasPago() {
			servicioFormaPago.fetchRecords().then(function (data) {
				$scope.formas = data;
			})
		}

		// Registra la actualizacion de formas de pago.

		servicioFormaPago.registrarEvento(formasPago);

		// Mantiene la forma de pago seleccionada.

		$scope.pago = '';

		// Editar la camisa.

		$scope.acamisa = function (camisa) {
			servicioCamiseta.editar(camisa);
		}

		// Verifica la validez de la compra.

		$scope.compraInvalida = function () {
			return $scope.pago === '' || $scope.records.length === 0 || _this.hayNegativa();
		}

		// Verifica la cantidad positiva de camisas.

		_this.hayNegativa = function () {
			for (var i = 0; i < $scope.records.length; i++) {
				var actual = $scope.records[i];
				if (actual.cantidad <= 0)
					return true;
			}

			return false;
		}

		// Elimina la camisa del carrito.

		$scope.quitar = function (camisa) {
			_this.deleteRecord(camisa);
		}

		// Realiza la compra.

		$scope.comprar = function () {
			var factura = {
				pago: $scope.pago,
				camisetas: $scope.records
			}

			servicioCamiseta.reiniciar();

			servicioFactura.saveRecord(factura).then(function () {
				$scope.pago = '';
				_this.limpiarCarrito();
			});
		}

		// Limpia el carrito.

		_this.limpiarCarrito = function () {
			console.log($scope.records.length);
			if ($scope.records.length > 0) {
				var actual = $scope.records[0];
				_this.deleteRecord(actual).then(function () {
					_this.limpiarCarrito();
				})
			}
		}

		// Actualiza la cantidad de la camiseta.

		$scope.cambiarCantidad = function (camisa) {
			_this.editRecord(camisa);
			_this.saveRecord();
		}
					
		// _this.crearCamiseta = function () {
		// 	var camiseta = {
		// 		estilo: $scope.datoActual.selected.estilo,
		// 		talla:  $scope.datoActual.selected.talla,
		// 		color: $scope.datoActual.selected.color,
		// 		estampas: $scope.datoActual.estampasUsadas,
		// 		id: "C"+randomString(10),
		// 		nombre: $scope.datoActual.nombreCamiseta
		// 	};

		// 	servicioEstampa.guardarDato(camiseta);
		// 	servicioEstampa.consultarDatos();
		// 	$rootscope.datoActual = camiseta;
					
		// 	alert("Camiseta: " + camiseta.id + camiseta.nombre + camiseta.talla + camiseta.estilo + camiseta.color);				
		// };
					
		// _this.cancelarCrearCamiseta = function () {
		// 	_this.crearCamisetaTpl = false;
		// };
		
		// _this.popEditarCamiseta = function () {
		// 	_this.crearCamisetaTpl = false;
		// 	_this.editarCamiseta = true;
		// };
		
		// _this.buscarCamisetasPropias=function () {
		// 	servicioCamiseta.camisetasDeComprador().then(function (data) {
		// 		$scope.datos = [];

		// 		var r = '';
		// 		for(var i=0; i < data.length; i++) {
		// 		   r = r + 'Nombre de camiseta: ' + data[i].nombre + '\n ';
		// 		}

		// 		alert(r);
		//    });
		// };

	}]);
})();