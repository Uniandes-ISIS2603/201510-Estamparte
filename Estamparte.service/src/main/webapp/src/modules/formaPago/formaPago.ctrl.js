(function () {
	var app = angular.module('formaPagoModule');

	app.controller('formaPagoCtrl', ['$scope', 'servicioFormaPago', function ($scope, servicioFormaPago) {

		// Variable que apunta a this.

		var _this = this;
		
		// Extension de servicios CRUD.

		servicioFormaPago.extendCtrl(_this, $scope);    

		// Datos para prueba.
		
		$scope.prueba = [
			{  
				tipo: 'Visa',
				numeroTarjeta: '1897423681279',
				fechaVencimiento: ('October 13, 2014 11:13:00')
			},
			{  
				tipo: 'Master Card',
				numeroTarjeta: '9123718272382',
				fechaVencimiento: ('December 31, 2020 11:11:11')
			}
		];

		// Revisa objeto vacio.

		$scope.estaCreando = false;

		// Agrega los datos de prueba.

		agregarPrueba();
		function agregarPrueba() {
			for (var i = 0; i < $scope.prueba.length; i++) {
				var actual = $scope.prueba[i];
				_this.editRecord(actual);
				_this.saveRecord();
			}
		}

		// Evento para acutalizacion de datos.

		_this.actualizarDatos = function () {
			_this.fetchRecords();
		}

		// Registra el evento.

		servicioFormaPago.registrarEvento(_this.actualizarDatos);

		// Quita la forma de pago en prueba.

		$scope.quitar = function (forma) {
			_this.deleteRecord(forma);
		}

		// Cierra la pensana.

		$scope.cerrar = function () {
			angular.element('#formapago').animate({width: 'toggle'});
		}

		// Crea una nueva forma de pago.

		$scope.crear = function () {
			$scope.estaCreando = true;
			_this.createRecord();
		}

		// Cierra la creacion de forma de pago.

		$scope.cerrarCrear = function () {
			$scope.estaCreando = false;
		}

		// Agrega la forma creada.

		$scope.agregar = function () {
			_this.saveRecord();
			$scope.estaCreando = false;
		}
		
	}]);
})();