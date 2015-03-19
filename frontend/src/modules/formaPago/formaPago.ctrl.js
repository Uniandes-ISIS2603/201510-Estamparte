(function () {
	var app = angular.module('formaPagoModule');

	app.controller('formaPagoCtrl', ['$scope', 'servicioFormaPago', function ($scope, servicioFormaPago) {
		
		// Extension de servicios CRUD.
		servicioFormaPago.extendCtrl(this, $scope);    
		
		datos = [
			{  
				tipo: "Visa",
				numeroTarjeta: 1897423681279,
				fechaVencimiento: ("October 13, 2014 11:13:00"),
			}
		];
		
	}]);
})();