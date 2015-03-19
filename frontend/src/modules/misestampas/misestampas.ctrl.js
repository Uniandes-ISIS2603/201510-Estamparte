angular.module('misestampasModule')
.controller('misestampasCtrl', ['$scope', 'servicioMisestampas', function ($scope, servicioMisestampas) {

	var _this = this;
	
	servicioMisestampas.extendCtrl(_this, $scope);

	_this.consultarDatos();

	// Debug line
	console.log('Mis estampas fueron cargadas con exito. Longitud: ' + $scope.datos.length);

}]);