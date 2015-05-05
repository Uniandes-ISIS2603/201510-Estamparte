(function () {
	var app = angular.module('misestampasModule');

	app.controller('misestampasCtrl', ['$scope', 'servicioMisestampas', 'servicioCamiseta', function ($scope, servicioMisestampas, servicioCamiseta) {

		var _this = this;
		
		$scope.records = servicioMisestampas.darMisestampas();

		$scope.eliminar = function (estampa) {
			servicioMisestampas.eliminar(estampa);
		}

		$scope.acamisa = function (estampa) {
			servicioCamiseta.agregar(estampa);
			_this.ircamisa();
		}

		_this.ircamisa = function () {
			angular.element('html, body').animate({
				scrollTop: angular.element('#camiseta').offset().top
			}, 700);
		}

	}]);
})();