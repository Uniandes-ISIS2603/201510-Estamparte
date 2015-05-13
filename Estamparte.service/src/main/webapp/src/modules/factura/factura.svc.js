(function () {
	angular.module('facturaModule')
	.service('servicioFactura', servicioFactura)

	function servicioFactura($rootScope, crudService) {

		var _this = this;

		// Here we extend our service.
		crudService.extendService(_this, 'comprador', null);

		// Here we add a user for test purposes.
		test();
		function test() {
			var testPayment = {
				nombre: 'Visa',
				comprador: $rootScope.usuario.id,
				numeroTarjeta: '124178274182',
				fechaVencimiento: 'Noviembre 12, 2015',
				codigoSeguridad: '182',
				direccionCorrespondencia: 'Carrera 8h # 91 - 12'
			}
			_this.postCustom(testPayment);
		}

	};
})();