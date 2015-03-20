(function () {
	var app = angular.module('misestampasModule');

	app.controller('misestampasCtrl', ['$scope', 'servicioMisestampas', function ($scope, servicioMisestampas) {

		var _this = this;
		
		$scope.records = servicioMisestampas.darMisestampas();

		$scope.eliminar = function (estampa) {
			servicioMisestampas.eliminar(estampa);
		}

	}]);
})();